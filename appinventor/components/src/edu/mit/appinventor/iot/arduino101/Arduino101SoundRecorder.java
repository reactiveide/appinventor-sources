// -*- mode: java; c-basic-offset: 2; -*-
// Copyright © 2017 Massachusetts Institute of Technology, All rights reserved.

package edu.mit.appinventor.iot.arduino101;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.Form;

import java.util.ArrayList;
import java.util.List;

/**
 * Extension to programmatically interact with the Grove Sound Recorder attached to an Arduino 101.
 *
 * @author ewpatton@mit.edu (Evan W. Patton)
 */
@DesignerComponent(version = 1,
    description = "The Arduino 101 Sound Recorder extension lets users control a sound recorder " +
        "and playback device connected to a Grove Shield.<br>\n\n<strong>More Links</strong><ul>" +
        "<li>Download a <a " +
        "href='http://iot.appinventor.mit.edu/assets/samples/Arduino101SoundRecorder.aia' " +
        "target='_blank'>sample project</a>.</li><li>Vew the <a " +
        "href='http://iot.appinventor.mit.edu/assets/howtos/MIT_App_Inventor_IoT_Sound_Recorder.pdf' " +
        "target='_blank'>how to instructions</a> for the Arduino 101 Sound Recorder.</li></ul>",
    category = ComponentCategory.EXTENSION,
    helpUrl = "http://iot.appinventor.mit.edu/#/arduino101/arduinosoundrecorder",
    nonVisible = true,
    iconName = "https://cdn.reactiveide.com/arduino.png")
@SimpleObject(external = true)
public class Arduino101SoundRecorder extends Arduino101ExtensionWithSerialTTL {
  private static final String SOUND_RECORDER_SERVICE = "E95D0D00-251D-470A-A062-FA1922DFA9A7";
  private static final String SOUND_RECORDER_PINS_CHARACTERISTIC = "E95D0D01-251D-470A-A062-FA1922DFA9A7";
  private static final String SOUND_RECORDER_RECORD_CHARACTERISTIC = "E95D0D02-251D-470A-A062-FA1922DFA9A7";
  private static final String SOUND_RECORDER_PLAYBACK_CHARACTERISTIC = "E95D0D03-251D-470A-A062-FA1922DFA9A7";

  public Arduino101SoundRecorder(Form form) {
    super(form);
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
      defaultValue = "0")
  @SimpleProperty
  public void RecordPin(int pin) {
    setPin1(pin);
  }

  @SimpleProperty(description = "The digital pin used to trigger the recording. If using the Grove " +
      "connector, this is one number higher than the digital pin port (D4 becomes 5).")
  public int RecordPin() {
    return getPin1();
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_NON_NEGATIVE_INTEGER,
      defaultValue = "0")
  @SimpleProperty
  public void PlayPin(int pin) {
    setPin2(pin);
  }

  @SimpleProperty(description = "The digital pin used to trigger playback. If using the Grove " +
      "connector, this is the same number as the digital pin port (D4 becomes 4).")
  public int PlayPin() {
    return getPin2();
  }

  /**
   * Start recording sound using the Sound Recorder's microphone.
   */
  @SimpleFunction
  public void StartRecording() {
    if (bleConnection != null) {
      List<Integer> values = new ArrayList<Integer>();
      values.add(RecordPin());
      values.add(1);
      bleConnection.ExWriteByteValues(SOUND_RECORDER_SERVICE, SOUND_RECORDER_RECORD_CHARACTERISTIC,
          false, values);
    }
  }

  /**
   * Stop recording sound. The recording is limited to about 80 seconds of audio. If this limit is
   * reached recording will automatically cease.
   */
  @SimpleFunction
  public void StopRecording() {
    if (bleConnection != null) {
      List<Integer> values = new ArrayList<Integer>();
      values.add(RecordPin());
      values.add(0);
      bleConnection.ExWriteByteValues(SOUND_RECORDER_SERVICE, SOUND_RECORDER_RECORD_CHARACTERISTIC,
          false, values);
    }
  }

  /**
   * Trigger playback of the recorded sound.
   */
  @SimpleFunction
  public void PlayRecordedSound() {
    if (bleConnection != null) {
      List<Integer> message = new ArrayList<Integer>(2);
      message.add(PlayPin());
      message.add(1);
      bleConnection.ExWriteByteValues(SOUND_RECORDER_SERVICE,
          SOUND_RECORDER_PLAYBACK_CHARACTERISTIC, false, message);
    }
  }

  @Override
  public String getPinServiceUuid() {
    return SOUND_RECORDER_SERVICE;
  }

  @Override
  public String getPinCharacteristicUuid() {
    return SOUND_RECORDER_PINS_CHARACTERISTIC;
  }
}
