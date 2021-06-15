package com.google.appinventor.client.editor.simple.components;

import com.google.appinventor.client.editor.simple.SimpleEditor;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Mock Slider component.
 *
 */
public final class MockCustomProgress extends MockVisibleComponent {
  private final Image largeImage = new Image(images.CustomProgressbig());

  /**
   * Component type name.
   */
  public static final String TYPE = "CustomProgress";

  private static final int DEFAULT_WIDTH = 70;

  // Widget for showing the mock slider
  private final SimplePanel widget;

  /**
   * Creates a new component.
   *
   * @param editor editor of source file the component belongs to
   */
  public MockCustomProgress(SimpleEditor editor) {
    super(editor, TYPE, images.CustomProgress());

    // Initialize mock slider UI
    widget = new SimplePanel();
    widget.setStylePrimaryName("ode-SimpleMockComponent");

//    widget.setWidget(getIconImage());
    widget.setWidget(largeImage);

    initComponent(widget);
  }


  @Override
  protected boolean isPropertyVisible(String propertyName) {
    //We don't want to allow user to change the slider height. S/he can only change the
    //slider width
    /*if (propertyName.equals(PROPERTY_NAME_HEIGHT)) {
      return false;
    }*/
    return super.isPropertyVisible(propertyName);
  }

  @Override
  public int getPreferredWidth() {
    // The superclass uses getOffsetWidth, which won't work for us.
    return DEFAULT_WIDTH;
  }

  // PropertyChangeListener implementation
  @Override
  public void onPropertyChange(String propertyName, String newValue) {
    super.onPropertyChange(propertyName, newValue);
    refreshForm();
  }
}
