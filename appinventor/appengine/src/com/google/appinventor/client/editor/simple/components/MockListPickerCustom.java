// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2016-2020 AppyBuilder.com, All Rights Reserved - Info@AppyBuilder.com
// https://www.gnu.org/licenses/gpl-3.0.en.html

// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client.editor.simple.components;

import com.google.appinventor.client.editor.simple.SimpleEditor;

/**
 * Mock ListPickerCustom component.
 *
 * @author sharon@google.com (Sharon Perl)
 */
public final class MockListPickerCustom extends MockButtonBase {

  /**
   * Component type name.
   */
  public static final String TYPE = "ListPickerCustom";

  /**
   * Creates a new MockListPicker component.
   *
   * @param editor  editor of source file the component belongs to
   */
  public MockListPickerCustom(SimpleEditor editor) {
    super(editor, TYPE, images.listpickercustom());
  }
}
