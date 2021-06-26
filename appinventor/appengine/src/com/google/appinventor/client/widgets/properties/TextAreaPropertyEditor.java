// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2018 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client.widgets.properties;

import com.google.gwt.user.client.ui.TextBox;

/**
 * Property editor for long text.  Now same with Text.
 */
public class TextAreaPropertyEditor extends TextPropertyEditorBase {

  public TextAreaPropertyEditor() {
   super(new TextBox());
   textEdit.getElement().setPropertyString("type", "");
   textEdit.getElement().setPropertyString("placeholder", " ");
  }
}
