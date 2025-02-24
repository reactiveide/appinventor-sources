// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client.widgets.properties;

import com.google.gwt.user.client.ui.TextBox;

/**
 * Property editor for short text.  Appears as a one-line box.
 *
 */
public class TextPropertyEditor extends TextPropertyEditorBase{

  public TextPropertyEditor() {
   super(new TextBox());
   textEdit.getElement().setPropertyString("type", "");
   textEdit.getElement().setPropertyString("placeholder", " ");
  }
}
