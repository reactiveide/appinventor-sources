// -*- mode: java; c-basic-offset: 2; -*-
// Copyright © 2017 Massachusetts Institute of Technology, All rights reserved.

package edu.mit.appinventor.iot.arduino101;

import android.util.Log;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.Form;
import edu.mit.appinventor.ble.BluetoothLE;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Extension base class for peripherals that communicate with the Arduino 101 using a TTL serial
 * connection.
 *
 * @author ewpatton@mit.edu (Evan W. Patton)
 */
@SimpleObject
public abstract class Arduino101ExtensionWithSerialTTL extends Arduino101ExtensionBase {
  private int pin1;
  private int pin2;

  private static final Map<Class<?>, Map<BluetoothLE, ActiveTTLPinSet<Arduino101ExtensionWithSerialTTL>>> pinSets =
      new WeakHashMap<Class<?>, Map<BluetoothLE, ActiveTTLPinSet<Arduino101ExtensionWithSerialTTL>>>();

  public Arduino101ExtensionWithSerialTTL(Form form) {
    super(form);
    Map<BluetoothLE, ActiveTTLPinSet<Arduino101ExtensionWithSerialTTL>> connectionMap = pinSets.get(getClass());
    if (connectionMap == null) {
      pinSets.put(getClass(), new WeakHashMap<BluetoothLE, ActiveTTLPinSet<Arduino101ExtensionWithSerialTTL>>());
    }
  }

  public void setPin1(int pin) {
    if (this.pin1 != pin) {
      int oldPin = this.pin1;
      this.pin1 = pin;
      if (bleConnection != null) {
        ActiveTTLPinSet<Arduino101ExtensionWithSerialTTL> pinSet = pinSets.get(this.getClass()).get(bleConnection);
        if (pinSet == null) {
          pinSet = new ActiveTTLPinSet<Arduino101ExtensionWithSerialTTL>(bleConnection, this);
          pinSets.get(getClass()).put(bleConnection, pinSet);
        } else {
          pinSet.updatePin1(this, oldPin);
        }
      }
    }
  }

  public int getPin1() {
    return pin1;
  }

  public void setPin2(int pin) {
    if (this.pin2 != pin) {
      int oldPin = this.pin2;
      this.pin2 = pin;
      if (bleConnection != null) {
        ActiveTTLPinSet<Arduino101ExtensionWithSerialTTL> pinSet = pinSets.get(this.getClass()).get(bleConnection);
        if (pinSet == null) {
          pinSet = new ActiveTTLPinSet<Arduino101ExtensionWithSerialTTL>(bleConnection, this);
          pinSets.get(getClass()).put(bleConnection, pinSet);
        } else {
          pinSet.updatePin2(this, oldPin);
        }
      }
    }
  }

  public int getPin2() {
    return pin2;
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_COMPONENT +
      ":edu.mit.appinventor.ble.BluetoothLE")
  @SimpleProperty
  public void BluetoothDevice(BluetoothLE bluetoothLE) {
    Log.d("Arduino101ExtensionWithPin", "BluetoothDevice");
    if (bleConnection != null) {
      ActiveTTLPinSet pinSet = pinSets.get(getClass()).get(bluetoothLE);
      if (pinSet != null) {
        pinSet.remove(this);
      }
    }
    bleConnection = bluetoothLE;
    if (bleConnection != null) {
      ActiveTTLPinSet<Arduino101ExtensionWithSerialTTL> pinSet = pinSets.get(getClass()).get(bluetoothLE);
      if (pinSet == null) {
        pinSet = new ActiveTTLPinSet<Arduino101ExtensionWithSerialTTL>(bluetoothLE, this);
        pinSets.get(getClass()).put(bluetoothLE, pinSet);
      } else {
        pinSet.add(this);
      }
    }
  }

  @SimpleProperty
  public BluetoothLE BluetoothDevice() {
    return bleConnection;
  }

  /**
   * Tests whether the Bluetooth low energy device is broadcasting support for the service. If true,
   * calls to TurnOn and TurnOff should work correctly. Otherwise an error will be reported through
   * the Screen's ErrorOccurred event.
   */
  @Override
  @SimpleFunction
  public boolean IsSupported() {
    return bleConnection != null && bleConnection.isCharacteristicPublished(getPinServiceUuid(),
        getPinCharacteristicUuid());
  }

  public abstract String getPinServiceUuid();
  public abstract String getPinCharacteristicUuid();
}
