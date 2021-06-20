// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client;

import com.google.appinventor.client.boxes.MotdBox;

import com.google.appinventor.client.explorer.commands.ChainableCommand;
import com.google.appinventor.client.explorer.commands.SaveAllEditorsCommand;

import com.google.appinventor.client.tracking.Tracking;

import com.google.appinventor.client.widgets.DropDownButton.DropDownItem;
import com.google.appinventor.client.widgets.DropDownButton;
import com.google.appinventor.client.widgets.TextButton;
import com.google.appinventor.shared.rpc.project.ProjectRootNode;
import com.google.appinventor.shared.rpc.user.Config;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.appinventor.common.version.GitBuildId;
import com.google.appinventor.components.common.YaVersion;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import com.google.gwt.http.client.UrlBuilder;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;


import java.util.List;
import java.util.MissingResourceException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import static com.google.appinventor.client.Ode.MESSAGES;

/**
 * The top panel, which contains the main menu, various links plus ads.
 *
 */
public class TopPanel extends Composite {
  // Strings for links and dropdown menus:
  private final DropDownButton accountButton;
  public DropDownButton languageDropDown;
  
  private static final String WIDGET_NAME_AUTOLOAD = "Autoload Last Project";
  private static final String WIDGET_NAME_DYSLEXIC_FONT = "DyslexicFont";

  private final String WIDGET_NAME_SIGN_OUT = "Signout";
  private final String WIDGET_NAME_USER = "User";
  private static final String WIDGET_NAME_LANGUAGE = "Language";
  private static final String WIDGET_NAME_DARKMODE = "DarkMode";

  private static final String WIDGET_NAME_ABOUT = "About";

  private static final String SIGNOUT_URL = "/ode/_logout";
  private static final String LANGUAGES_IMAGE_URL = "/static/images/languages.svg";
  private static final String LOGO_IMAGE_URL = "/static/images/codi_long.png";

  private static final String WINDOW_OPEN_FEATURES = "menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=yes";
  private static final String WINDOW_OPEN_LOCATION = "_ai2";

  private final VerticalPanel rightPanel;  // remember this so we can add MOTD later if needed

  final Ode ode = Ode.getInstance();

  interface Translations extends ClientBundle {
    Translations INSTANCE = GWT.create(Translations.class);

    @Source("languages.json")
    TextResource languages();
  }

  static {
    loadLanguages(Translations.INSTANCE.languages().getText());
    LANGUAGES = Dictionary.getDictionary("LANGUAGES");
  }

  private static native void loadLanguages(String resource)/*-{
    $wnd['LANGUAGES'] = JSON.parse(resource);
  }-*/;

  private static final Dictionary LANGUAGES;

  /**
   * Initializes and assembles all UI elements shown in the top panel.
   */
  public TopPanel() {
    /*
     * The layout of the top panel is as follows:
     *
     *  +-- topPanel ------------------------------------+
     *  |+-- logo --++-----tools-----++--links/account--+|
     *  ||          ||               ||                 ||
     *  |+----------++---------------++-----------------+|
     *  +------------------------------------------------+
     */
    HorizontalPanel topPanel = new HorizontalPanel();
    topPanel.setVerticalAlignment(HorizontalPanel.ALIGN_MIDDLE);

    // Create the Tools
    TopToolbar tools = new TopToolbar();
    ode.setTopToolbar(tools);

    // Create the Links
    HorizontalPanel links = new HorizontalPanel();
    links.setStyleName("ode-TopPanelLinks");
    links.setVerticalAlignment(HorizontalPanel.ALIGN_MIDDLE);

    if (Ode.getInstance().isReadOnly()) {
      Label readOnly = new Label(MESSAGES.readOnlyMode());
      readOnly.setStyleName("ode-TopPanelWarningLabel");
      links.add(readOnly);
    }

    Config config = ode.getSystemConfig();
    String guideUrl = config.getGuideUrl();
    if (!Strings.isNullOrEmpty(guideUrl)) {

      Image communityLogo = new Image("https://cdn.reactiveide.com/face.png");
      communityLogo.setTitle("Community");
      communityLogo.setSize("24px", "24px");
      communityLogo.setStyleName("ode-Community");

      TextButton guideLink = new TextButton(communityLogo);
      guideLink.addClickHandler(new WindowOpenClickHandler(guideUrl));
      guideLink.setStyleName("ode-TopPanelButton");
      links.add(guideLink);
    }

    // Create the Account Information
    rightPanel = new VerticalPanel();
    rightPanel.setHeight("100%");
    rightPanel.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);

    HorizontalPanel account = new HorizontalPanel();
    account.setStyleName("ode-TopPanelAccount");

    // Account Drop Down Button
    List<DropDownItem> userItems = Lists.newArrayList();

    // Enabling DarkMode
    userItems.add(new DropDownItem(WIDGET_NAME_DARKMODE,MESSAGES.enableDarkModeOption(), new DarkModeAction()));

    // Setting and Help Menus
    if (Ode.getUserAutoloadProject()) {
      userItems.add(new DropDownItem(WIDGET_NAME_AUTOLOAD, MESSAGES.disableAutoload(), new DisableAutoloadAction()));
    } else {
      userItems.add(new DropDownItem(WIDGET_NAME_AUTOLOAD, MESSAGES.enableAutoload(), new EnableAutoloadAction()));
    }
    if (Ode.getUserDyslexicFont()) {
      userItems.add(new DropDownItem(WIDGET_NAME_DYSLEXIC_FONT, MESSAGES.disableOpenDyslexic(), new SetFontRegularAction()));
    } else {
      userItems.add(new DropDownItem(WIDGET_NAME_DYSLEXIC_FONT,  MESSAGES.enableOpenDyslexic(), new SetFontDyslexicAction()));
    }

    // Sign Out
    userItems.add(new DropDownItem(WIDGET_NAME_SIGN_OUT, MESSAGES.signOutLink(), new SignOutAction()));
    
    // About ReactiveIDE
    userItems.add(new DropDownItem(WIDGET_NAME_ABOUT, MESSAGES.aboutMenuItem(), new AboutAction()));

    Image accountLogo = new Image("https://cdn.reactiveide.com/account_circle.png");
    accountLogo.setTitle("My Account");
    accountLogo.setSize("24px", "24px");
    accountLogo.setStyleName("ode-Account");

    accountButton = new DropDownButton(WIDGET_NAME_USER, accountLogo, userItems, true);
    accountButton.setStyleName("ode-TopPanelButton");

    // Language
    List<DropDownItem> languageItems = Lists.newArrayList();
    String[] localeNames = LocaleInfo.getAvailableLocaleNames();
    String nativeName;
    for (String localeName : localeNames) {
      if (!localeName.equals("default")) {
        SelectLanguage lang = new SelectLanguage();
        lang.setLocale(localeName);
        nativeName = getDisplayName(localeName);
        languageItems.add(new DropDownItem(WIDGET_NAME_LANGUAGE, nativeName, lang));
      }
    }
    String currentLang = LocaleInfo.getCurrentLocale().getLocaleName();
    String nativeDisplayName = getDisplayName(currentLang);

    Image languageLogo = new Image("https://cdn.reactiveide.com/language.png");
    languageLogo.setTitle("Language");
    languageLogo.setSize("24px", "24px");
    languageLogo.setStyleName("ode-Language");

    languageDropDown = new DropDownButton(WIDGET_NAME_LANGUAGE, languageLogo, languageItems, true);
    languageDropDown.setStyleName("ode-TopPanelButton");

    account.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);
    account.add(links);
    account.add(languageDropDown);
    account.add(accountButton);

    rightPanel.add(account);

    // Add the Logo, Tools, Links to the TopPanel
    addLogo(topPanel);
    topPanel.add(tools);
    topPanel.add(rightPanel);
    topPanel.setCellVerticalAlignment(rightPanel, HorizontalPanel.ALIGN_MIDDLE);
    rightPanel.setCellHorizontalAlignment(account, HorizontalPanel.ALIGN_RIGHT);
    topPanel.setCellHorizontalAlignment(rightPanel, HorizontalPanel.ALIGN_RIGHT);

    initWidget(topPanel);

    setStyleName("ode-TopPanel");
    setWidth("100%");
  }

  private String getDisplayName(String localeName){
    String nativeName=LocaleInfo.getLocaleNativeDisplayName(localeName);
    try {
      return LANGUAGES.get(localeName);
    } catch (MissingResourceException e) {
      return nativeName;
    }
  }

  private void addLogo(HorizontalPanel panel) {
    // Logo is a link to App Inv homepage. Add timestamp to logo url
    // to get around browsers that agressively cache the image! This
    // same trick is used in StorageUtil.getFilePath().
    Image logo = new Image(LOGO_IMAGE_URL + "?t=" + System.currentTimeMillis());
    logo.setSize("180px", "40px");
    logo.setStyleName("ode-Logo");
    String logoUrl = ode.getSystemConfig().getLogoUrl();
    if (!Strings.isNullOrEmpty(logoUrl)) {
      logo.addClickHandler(new WindowOpenClickHandler(logoUrl));
    }
    panel.add(logo);
    panel.setCellWidth(logo, "230px");
    panel.setCellHorizontalAlignment(logo, HorizontalPanel.ALIGN_LEFT);
    panel.setCellVerticalAlignment(logo, HorizontalPanel.ALIGN_MIDDLE);
  }

  private void addMotd(VerticalPanel panel) {
    MotdBox motdBox = MotdBox.getMotdBox();
    panel.add(motdBox);
    panel.setCellHorizontalAlignment(motdBox, HorizontalPanel.ALIGN_RIGHT);
    panel.setCellVerticalAlignment(motdBox, HorizontalPanel.ALIGN_BOTTOM);
  }

  /**
   * Adds the MOTD box to the right panel. This should only be called once.
   */
  public void showMotd() {
    addMotd(rightPanel);
  }

  // Move Settings function here
    private class EnableAutoloadAction implements Command {
    @Override
    public void execute() {
      Ode.getInstance().setUserAutoloadProject(true);
    }
  }

  private class DisableAutoloadAction implements Command {
    @Override
    public void execute() {
      Ode.getInstance().setUserAutoloadProject(false);
    }
  }

  // About Dialog
    private static class AboutAction implements Command {
    @Override
    public void execute() {
      final DialogBox db = new DialogBox(false, true);
      db.setText("About ReactiveIDE");
      db.setStyleName("ode-DialogBox");
      db.setHeight("200px");
      db.setWidth("400px");
      db.setGlassEnabled(true);
      db.setAnimationEnabled(true);
      db.center();

      VerticalPanel DialogBoxContents = new VerticalPanel();
      String html = MESSAGES.gitBuildId(GitBuildId.getDate(), GitBuildId.getVersion()) +
          "<BR/>" + MESSAGES.useCompanion(YaVersion.PREFERRED_COMPANION, YaVersion.PREFERRED_COMPANION + "u") +
          "<BR/>" + MESSAGES.targetSdkVersion(YaVersion.TARGET_SDK_VERSION, YaVersion.TARGET_ANDROID_VERSION);
      Config config = Ode.getInstance().getSystemConfig();
      HTML message = new HTML(html);

      SimplePanel holder = new SimplePanel();
      Button ok = new Button("Close");
      ok.addClickListener(new ClickListener() {
        public void onClick(Widget sender) {
          db.hide();
        }
      });
      holder.add(ok);
      DialogBoxContents.add(message);
      DialogBoxContents.add(holder);
      db.setWidget(DialogBoxContents);
      db.show();
    }
  }

  //Dark mode
    private class DarkModeAction implements Command {
    @Override
    public void execute() {

    }
  }

  private static class SetFontDyslexicAction implements Command {
    @Override
    public void execute() {
      Ode.getInstance().setUserDyslexicFont(true);
      // Window.Location.reload();
      // Note: We used to reload here, but this causes
      // a race condition with the saving of the user
      // settings. So we now reload in the callback to
      // saveSettings (in Ode.java)
    }
  }

  private static class SetFontRegularAction implements Command {
    @Override
    public void execute() {
      Ode.getInstance().setUserDyslexicFont(false);
      // Window.Location.reload();
      // Not: See above comment
    }
  }

  private static class WindowOpenClickHandler implements ClickHandler {
    private final String url;

    WindowOpenClickHandler(String url) {
      this.url = url;
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
      Window.open(url, WINDOW_OPEN_LOCATION, WINDOW_OPEN_FEATURES);
    }
  }

  private static class SignOutAction implements Command {
    @Override
    public void execute() {
      // Maybe take a screenshot
      Ode.getInstance().screenShotMaybe(new Runnable() {
          @Override
          public void run() {
            Window.Location.replace(SIGNOUT_URL);
          }
        }, true);               // Wait for i/o
    }
  }

  private class SelectLanguage implements Command {

    private String localeName;

    @Override
    public void execute() {
      final String queryParam = LocaleInfo.getLocaleQueryParam();
      Command savecmd = new SaveAction();
      savecmd.execute();
      if (queryParam != null) {
        UrlBuilder builder = Window.Location.createUrlBuilder().setParameter(
            queryParam, localeName);
        Window.Location.replace(builder.buildString());
      } else {
        // If we are using only cookies, just reload
        Window.Location.reload();
      }
    }

    public void setLocale(String nativeName) {
      localeName = nativeName;
    }

  }

  private class SaveAction implements Command {
    @Override
    public void execute() {
      ProjectRootNode projectRootNode = Ode.getInstance().getCurrentYoungAndroidProjectRootNode();
      if (projectRootNode != null) {
        ChainableCommand cmd = new SaveAllEditorsCommand(null);
        cmd.startExecuteChain(Tracking.PROJECT_ACTION_SAVE_YA, projectRootNode);
      }
    }
  }

}

