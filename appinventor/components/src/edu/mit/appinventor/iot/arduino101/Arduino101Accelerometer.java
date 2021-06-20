// -*- mode: java; c-basic-offset: 2; -*-
// Copyright © 2017 Massachusetts Institute of Technology, All rights reserved.

package edu.mit.appinventor.iot.arduino101;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import edu.mit.appinventor.ble.BluetoothLE;

import java.util.List;

/**
 * Accelerometer implementation for Arduino 101 over BLE.
 *
 * @author ewpatton@mit.edu (Evan W. Patton)
 */
@DesignerComponent(version = 1,
    description = "The Arduino101Accelerometer component lets users configure the Arduino 101's " +
        "on-board accelerometer and receive one or more accelerometer samples via the " +
        "appropriate methods.<br>\n\n<strong>More links:</strong><ul><li>Download a <a " +
        "href='http://iot.appinventor.mit.edu/assets/samples/Arduino101Accelerometer.aia' " +
        "target='_blank'>sample project</a> for the Arduino 101 Accelerometer.</li><li>View the " +
        "<a href='http://iot.appinventor.mit.edu/assets/howtos/MIT_App_Inventor_IoT_Accelerometer.pdf' " +
        "target='_blank'>how to instructions</a> for the Arduino 101 Accelerometer.</li></ul>",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "https://cdn.reactiveide.com/arduino.png")
@SimpleObject(external = true)
public class Arduino101Accelerometer extends Arduino101ExtensionBase {
  private static final String ACCELEROMETER_SERVICE_UUID = "E95D0100-251D-470A-A062-FA1922DFA9A7";
  private static final String ACCELEROMETER_DATA_CHARACTERISTIC_UUID = "E95D0101-251D-470A-A062-FA1922DFA9A7";

  private final BluetoothLE.BLEResponseHandler<Float> accelerometerDataHandler =
      new BluetoothLE.BLEResponseHandler<Float>() {
        @Override
        public void onReceive(String serviceUuid, String characteristicUuid, List<Float> values) {
          AccelerometerDataReceived(values.get(0), values.get(1), values.get(2));
        }
      };

  public Arduino101Accelerometer(Form form) {
    super(form);
  }

  /**
   * Check whether the accelerometer is currently available for the device connected via the
   * <code>BluetoothDevice</code> property. If no device is currently connected, this method will
   * always return false.
   * @return true if the connected device is advertising the service represented by the extension,
   * otherwise false.
   */
  @Override
  @SimpleFunction
  public boolean IsSupported() {
    return bleConnection != null &&
        bleConnection.isCharacteristicPublished(ACCELEROMETER_SERVICE_UUID,
            ACCELEROMETER_DATA_CHARACTERISTIC_UUID);
  }

  /**
   * Read a single sample of accelerometer data from the Arduino. On successful read, the
   * <a href="#AccelerometerDataReceived"><code>AccelerometerDataReceived</code></a>
   * event will be run.
   */
  @SimpleFunction
  public void ReadAccelerometerData() {
    if (bleConnection != null) {
      bleConnection.ExReadFloatValues(ACCELEROMETER_SERVICE_UUID,
          ACCELEROMETER_DATA_CHARACTERISTIC_UUID, false, accelerometerDataHandler);
    }
  }

  /**
   * Request notifications of changes in the Arduino's accelerometer. Accelerometer data will be
   * reported through the
   * <a href="#AccelerometerDataReceived"><code>AccelerometerDataReceived</code></a> event.
   */
  @SimpleFunction
  public void RequestAccelerometerDataUpdates() {
    if (bleConnection != null) {
      bleConnection.ExRegisterForFloatValues(ACCELEROMETER_SERVICE_UUID,
          ACCELEROMETER_DATA_CHARACTERISTIC_UUID, false, accelerometerDataHandler);
    }
  }

  /**
   * Stop receiving updates from the Arduino's accelerometer. Note that there may be pending
   * messages from the device that will still be reported through the
   * <a href="#AccelerometerDataReceived"><code>AccelerometerDataReceived</code></a> event.
   */
  @SimpleFunction
  public void StopAccelerometerDataUpdates() {
    if (bleConnection != null) {
      bleConnection.ExUnregisterForValues(ACCELEROMETER_SERVICE_UUID,
          ACCELEROMETER_DATA_CHARACTERISTIC_UUID, accelerometerDataHandler);
    }
  }

  /**
   * The <code>AccelerometerDataReceived</code> event is run whenever accelerometer samples are
   * received from the Arduino 101. This is usually a result of performing a
   * <a href="#ReadAccelerometerData">read</a> or
   * <a href="#RequestAccelerometerDataUpdates">request</a> operation.
   * The X, Y, and Z values are in multiples of 1 Earth gravity (G=-9.8 m/s<sup>2</sup>).
   *
   * __Parameters__:
   *
   *    + <code>Accelerometer_X</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The X value of the accelerometer, in G.
   *    + <code>Accelerometer_Y</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The Y value of the accelerometer, in G.
   *    + <code>Accelerometer_Z</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The Z value of the accelerometer, in G.
   *
   * @param Accelerometer_X The X value of the accelerometer, in G.
   * @param Accelerometer_Y The Y value of the accelerometer, in G.
   * @param Accelerometer_Z The Z value of the accelerometer, in G.
   */
  @SimpleEvent
  public void AccelerometerDataReceived(final float Accelerometer_X, final float Accelerometer_Y,
                                        final float Accelerometer_Z) {
    EventDispatcher.dispatchEvent(this, "AccelerometerDataReceived", Accelerometer_X,
        Accelerometer_Y, Accelerometer_Z);
  }
}
