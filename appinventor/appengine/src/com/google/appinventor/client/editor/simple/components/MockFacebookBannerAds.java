package com.google.appinventor.client.editor.simple.components;

import com.google.appinventor.client.editor.simple.SimpleEditor;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

public class MockFacebookBannerAds extends MockVisibleComponent {

  private final Image largeImage = new Image(images.Lottiebig());
  private SimplePanel widget;
  /**
   * Component type name.
   */
  public static final String TYPE = "FacebookBannerAds";

//  private Label labelWidget;
  /**
   * Creates a new Mock component.
   *
   * @param editor  editor of source file the component belongs to
   */
  public MockFacebookBannerAds(SimpleEditor editor) {
    super(editor, TYPE, images.Lottie());

//    labelWidget = new Label();
//    MockComponentsUtil.setWidgetBackgroundColor(labelWidget, "&ff0000");
    // Initialize mock UI
    widget = new SimplePanel();
    widget.setStylePrimaryName("ode-SimpleMockContainer");
    widget.addStyleDependentName("centerContents");
//    widget.setWidget(labelWidget);
    initComponent(widget);
  }
  
  @Override
  public int getPreferredWidth() {
    return largeImage.getWidth();
  }

  // we override this to get the image height
  @Override
  public int getPreferredHeight() {
    return largeImage.getHeight();
  }
  
  @Override
  public void onPropertyChange(String propertyName, String newValue) {
    super.onPropertyChange(propertyName, newValue);

  }

}
