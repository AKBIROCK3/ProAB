// Copyright 2016-2020 AppyBuilder.com, All Rights Reserved - Info@AppyBuilder.com
// https://www.gnu.org/licenses/gpl-3.0.en.html
package com.google.appinventor.components.runtime;


import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.common.YaVersion;
import com.google.appinventor.components.runtime.util.TextViewUtil;

//import com.google.appinventor.components.runtime.util.MediaUtil;
//import com.google.appinventor.components.runtime.util.TextViewUtil;
//import com.google.appinventor.components.runtime.util.ViewUtil;


/**
 * This class is used to display a ToggleButton.
 * <p>A ToggleButton Displays checked/unchecked states as a button with a 'light' indicator and by default
 * accompanied with the text 'ON' or 'OFF'.
 *
 */
@DesignerComponent(version = YaVersion.TOGGLER_COMPONENT_VERSION,
    description = "A Toggler Displays checked/unchecked states as a button with a 'light' indicator and " +
            "by default accompanied with the text 'ON' or 'OFF'. ",
    category = ComponentCategory.USERINTERFACE)
@SimpleObject
public class Toggler extends AndroidViewComponent implements CompoundButton.OnCheckedChangeListener {
  private final static String LOG_TAG = "Toggler";
  private String DEFAULT_TEXT_ON = "On";
  private String DEFAULT_TEXT_OFF = "Off";
  private ToggleButton view;
    private int textColor;

    /**
   * Creates a new Toggler component.
   *
   * @param container container that the component will be placed in
   */
  public Toggler(ComponentContainer container) {
      super(container);
      view = new ToggleButton(container.$context());
      container.$add(this);

      view.setOnCheckedChangeListener(this);

      TextOn(DEFAULT_TEXT_ON);
      TextOff(DEFAULT_TEXT_OFF);
//      BackgroundColor(Component.COLOR_LTGRAY);
      TextColor(Component.COLOR_WHITE);
      FontSize(Component.FONT_DEFAULT_SIZE);


  }

  @Override
  public View getView() {
    return view;
  }

    /**
     * Returns the text for TextOn
     * @return  returns the text for TextOn
     */
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String TextOn() {
        return String.valueOf(view.getTextOn());
    }

    /**
     * The text for the button when it is checked
     * @param text  The text for the button when it is checked
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING, defaultValue = "On")
    @SimpleProperty(description = "Specify the text to be displayed when Toggler is selected")
    public void TextOn(String text) {
        view.setTextOn(text);
        view.invalidate();
    }

    /**
     * Returns the text for TextOff
     * @return  returns the text for TextOff
     */
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public String TextOff() {
        return String.valueOf(view.getTextOff());
    }

    /**
     * The text for the button when it is checked
     * @param text  The text for the button when it is checked
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_STRING, defaultValue = "Off")
    @SimpleProperty(description = "Specify the text to be displayed when Toggler is selected")
    public void TextOff(String text) {
        view.setTextOff(text);
        view.invalidate();
    }

    /**
     * Returns true if the toggler is enabled.
     *
     * @return  {@code true} indicates toggler is enabled or not
     */
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public boolean Enabled() {
        return view.isEnabled();
    }


    /**
     * enables or disables the toggler
     *
     * @param enabled
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN, defaultValue = "True")
    @SimpleProperty(description = "Enables or disables the component")
    public void Enabled(boolean enabled) {
       view.setEnabled(enabled);
    }

    /**
     * Returns true if the toggler is on.
     *
     * @return  {@code true} indicates toggler is in ON state, {@code false} OFF state
     */
    @SimpleProperty(category = PropertyCategory.BEHAVIOR)
    public boolean Checked() {
        return view.isChecked();
    }


    /**
     * Specifies whether the toggler should be in ON state or OFF state
     *
     * @param enabled
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN, defaultValue = "True")
    @SimpleProperty(description = "Sets state to checked or unchecked")
    public void Checked(boolean enabled) {
       view.setChecked(enabled);
    }

    /**
     * Default Changed event handler.
     */
    @SimpleEvent
    public void Click() {
        EventDispatcher.dispatchEvent(this, "Click");
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean enabled) {
        view.setChecked(enabled);
        Click();
    }

//    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR,
//            defaultValue = Component.DEFAULT_VALUE_COLOR_LTGRAY)
//    @SimpleProperty(description = "Specifies the component's background color. ")
//    public void BackgroundColor(int argb) {
//        backgroundColor = argb;
//        view.setBackgroundColor(argb);
//    }
//
//    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Returns the component's background color")
//    public int BackgroundColor() {
//        return backgroundColor;
//    }

    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COLOR,
            defaultValue = Component.DEFAULT_VALUE_COLOR_WHITE)
    @SimpleProperty(description = "Sets the component's text color")
    public void TextColor(int argb) {
        textColor = argb;
        view.setTextColor(argb);
    }

    /**
     * Returns the button's text color as an alpha-red-green-blue
     * integer.
     *
     * @return  text RGB color with alpha
     */
    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Color for component text")
    public int TextColor() {
        return textColor;
    }

    /**
     * Returns the button's text's font size, measured in sp(scale-independent pixels).
     *
     * @return  font size in sp(scale-independent pixels).
     */
    @SimpleProperty(
            category = PropertyCategory.APPEARANCE,
            description = "Point size for button text.")
    public float FontSize() {
        return TextViewUtil.getFontSize(view, container.$context());
    }

    /**
     * Specifies the button's text's font size, measured in sp(scale-independent pixels).
     *
     * @param size  font size in sp(scale-independent pixels)
     */
    @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_FLOAT,
            defaultValue = Component.FONT_DEFAULT_SIZE + "")
    @SimpleProperty(category = PropertyCategory.APPEARANCE, description = "Sets the font size of the component")
    public void FontSize(float size) {
        TextViewUtil.setFontSize(view, size);
    }
}
