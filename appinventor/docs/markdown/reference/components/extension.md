---
layout: documentation
title: Extension
---

[&laquo; Back to index](index.html)
# Extension

Table of Contents:

* [Arduino101Accelerometer](#Arduino101Accelerometer)
* [Arduino101Button](#Arduino101Button)
* [Arduino101Gyroscope](#Arduino101Gyroscope)
* [Arduino101Humidity](#Arduino101Humidity)
* [Arduino101Led](#Arduino101Led)
* [Arduino101LightSensor](#Arduino101LightSensor)
* [Arduino101Moisture](#Arduino101Moisture)
* [Arduino101PWMMotor](#Arduino101PWMMotor)
* [Arduino101Pins](#Arduino101Pins)
* [Arduino101ProximitySensor](#Arduino101ProximitySensor)
* [Arduino101RgbLcd](#Arduino101RgbLcd)
* [Arduino101Servo](#Arduino101Servo)
* [Arduino101SoundRecorder](#Arduino101SoundRecorder)
* [Microbit_Accelerometer](#Microbit_Accelerometer)
* [Microbit_Button](#Microbit_Button)
* [Microbit_Device_Information](#Microbit_Device_Information)
* [Microbit_Dfu_Control](#Microbit_Dfu_Control)
* [Microbit_Event](#Microbit_Event)
* [Microbit_Generic_Access](#Microbit_Generic_Access)
* [Microbit_Generic_Attribute](#Microbit_Generic_Attribute)
* [Microbit_Io_Pin](#Microbit_Io_Pin)
* [Microbit_Led](#Microbit_Led)
* [Microbit_Magnetometer](#Microbit_Magnetometer)
* [Microbit_Temperature](#Microbit_Temperature)
* [Microbit_Uart](#Microbit_Uart)

## Arduino101Accelerometer  {#Arduino101Accelerometer}

Accelerometer implementation for Arduino 101 over BLE.



### Properties  {#Arduino101Accelerometer-Properties}

{:.properties}

{:id="Arduino101Accelerometer.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component with a connection to the Arduino 101 (getter).

### Events  {#Arduino101Accelerometer-Events}

{:.events}

{:id="Arduino101Accelerometer.AccelerometerDataReceived"} AccelerometerDataReceived(*Accelerometer_X*{:.number},*Accelerometer_Y*{:.number},*Accelerometer_Z*{:.number})
: The <code>AccelerometerDataReceived</code> event is run whenever accelerometer samples are
 received from the Arduino 101. This is usually a result of performing a
 <a href="#ReadAccelerometerData">read</a> or
 <a href="#RequestAccelerometerDataUpdates">request</a> operation.
 The X, Y, and Z values are in multiples of 1 Earth gravity (G=-9.8 m/s<sup>2</sup>).

 __Parameters__:

    + <code>Accelerometer_X</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The X value of the accelerometer, in G.
    + <code>Accelerometer_Y</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The Y value of the accelerometer, in G.
    + <code>Accelerometer_Z</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The Z value of the accelerometer, in G.

### Methods  {#Arduino101Accelerometer-Methods}

{:.methods}

{:id="Arduino101Accelerometer.IsSupported" class="method returns boolean"} <i/> IsSupported()
: Check whether the accelerometer is currently available for the device connected via the
 <code>BluetoothDevice</code> property. If no device is currently connected, this method will
 always return false.

{:id="Arduino101Accelerometer.ReadAccelerometerData" class="method"} <i/> ReadAccelerometerData()
: Read a single sample of accelerometer data from the Arduino. On successful read, the
 <a href="#AccelerometerDataReceived"><code>AccelerometerDataReceived</code></a>
 event will be run.

{:id="Arduino101Accelerometer.RequestAccelerometerDataUpdates" class="method"} <i/> RequestAccelerometerDataUpdates()
: Request notifications of changes in the Arduino's accelerometer. Accelerometer data will be
 reported through the
 <a href="#AccelerometerDataReceived"><code>AccelerometerDataReceived</code></a> event.

{:id="Arduino101Accelerometer.StopAccelerometerDataUpdates" class="method"} <i/> StopAccelerometerDataUpdates()
: Stop receiving updates from the Arduino's accelerometer. Note that there may be pending
 messages from the device that will still be reported through the
 <a href="#AccelerometerDataReceived"><code>AccelerometerDataReceived</code></a> event.

## Arduino101Button  {#Arduino101Button}

An extension for the Arduino 101 to interact with buttons attached to digital pins.



### Properties  {#Arduino101Button-Properties}

{:.properties}

{:id="Arduino101Button.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component with a connection to the Arduino 101 (getter).

{:id="Arduino101Button.Pin" .number} *Pin*
: The Pin on the Arduino board that the device is wired in to.

### Events  {#Arduino101Button-Events}

{:.events}

{:id="Arduino101Button.ButtonStateReceived"} ButtonStateReceived(*Button_State*{:.number})
: The <code>ButtonStateReceived</code> event is run when any button state is received by the
 Bluetooth low energy component from the Arduino. This state value may be the same for
 extended periods of time if the button switch is left in an open or closed state.

 __Parameter__:

     * <code>Button_State</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The button state: 0 if released, 1 if pressed.

{:id="Arduino101Button.Pressed"} Pressed()
: The <code>Pressed</code> event is run when a button state is observed to go from a low signal
 to a high signal, indicating that the button switch has been pressed and the circuit is closed.

{:id="Arduino101Button.Released"} Released()
: The <code>Released</code> event is run when a button state is observed to go from a high signal
 to a low signal, indicating that the button switch has been released and the circuit is open.

### Methods  {#Arduino101Button-Methods}

{:.methods}

{:id="Arduino101Button.IsSupported" class="method returns boolean"} <i/> IsSupported()
: Tests whether the Bluetooth low energy device is broadcasting support for the service. If true,
 calls to TurnOn and TurnOff should work correctly. Otherwise an error will be reported through
 the Screen's ErrorOccurred event.

{:id="Arduino101Button.ReadButtonState" class="method"} <i/> ReadButtonState()
: Read the current state of the button as reported by the Arduino. On success, the
 <a href="#ButtonStateReceived"><code>ButtonStateReceived</code></a> event will be run. If the
 state of the button has changed, the <a href="#Pressed"><code>Pressed</code></a> or
 <a href="#Released"><code>Released</code></a> events will be run as well.

{:id="Arduino101Button.RequestButtonStateUpdates" class="method"} <i/> RequestButtonStateUpdates()
: Request notifications from the Arduino for changes in the button state. The <a
 href="#ButtonStateReceived"><code>ButtonStateReceived</code></a> event will be run after
 every sample is received, even if no change occurs. If a change in the state occurs, either
 the <a href="#Pressed"><code>Pressed</code></a> or the <a
 href="#Released"><code>Released</code></a> event will be run.

{:id="Arduino101Button.StopButtonStateUpdates" class="method"} <i/> StopButtonStateUpdates()
: Stop listening for notifications of button states from the Arduino. This only has an effect
 if there was a previous call to <a
 href="#RequestButtonStateUpdates"><code>RequestButtonStateUpdates</code></a>. There may be
 additional pending messages that will be processed after this call, so if accuracy in the
 data delivery are important an additional variable should be used to track the state of
 event processing.

## Arduino101Gyroscope  {#Arduino101Gyroscope}

Extension to access gyroscopic data from the App Inventor Companion Sketch for Arduino 101.



### Properties  {#Arduino101Gyroscope-Properties}

{:.properties}

{:id="Arduino101Gyroscope.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component with a connection to the Arduino 101 (getter).

### Events  {#Arduino101Gyroscope-Events}

{:.events}

{:id="Arduino101Gyroscope.GyroscopeDataReceived"} GyroscopeDataReceived(*X_Angle*{:.number},*Y_Angle*{:.number})
: The <code>GyroscopeDataReceived</code> event is run whenever gyroscope samples are received
 from the Arduino 101. This is usually a result of performing a
 <a href="#ReadGyroscopeData">read</a> or <a href="#RequestGyroscopeDataUpdates">request</a>
 operation. The X and Y angles are reported in degrees.

 __Parameters__:

     * <code>X_Angle</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The rotation of the device around its X axis, in degrees.
     * <code>Y_Angle</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The rotation of the device around its Y axis, in degrees.

### Methods  {#Arduino101Gyroscope-Methods}

{:.methods}

{:id="Arduino101Gyroscope.IsSupported" class="method returns boolean"} <i/> IsSupported()
: Check whether the feature is currently available for the device connected via the
 <a href="#BluetoothDevice"><code>BluetoothDevice</code></a> property. If no device is currently
 connected, this method will always return false.

{:id="Arduino101Gyroscope.ReadGyroscopeData" class="method"} <i/> ReadGyroscopeData()
: Read a single sample of gyroscope data from the Arduino. On successful read, the
 <a href="#GyroscopeDataReceived"><code>GyroscopeDataReceived</code></a> event will be run.

{:id="Arduino101Gyroscope.RequestGyroscopeDataUpdates" class="method"} <i/> RequestGyroscopeDataUpdates()
: Request notifications of changes in the Arduino's gyroscope. Gyroscope data will be reported
 through the <a href="#GyroscopeDataReceived"><code>GyroscopeDataReceived</code></a> event.

{:id="Arduino101Gyroscope.StopGyroscopeDataUpdates" class="method"} <i/> StopGyroscopeDataUpdates()
: Stop receiving updates from the Arduino's gyroscope. Note that there may be pending messages
 from the device that will still be reported through the
 <a href="#GryoscopeDataReceived"><code>GyroscopeDataReceived</code></a> event. This method
 has no effect if <a href="#RequestGyroscopeDataUpdates"><code>RequestGyroscopeDataUpdates</code></a>
 has not been previously called.

## Arduino101Humidity  {#Arduino101Humidity}

Extension to read humidity and temperature data from a DHT sensor attached to an Arduino 101
 running the App Inventor Companion Sketch.



### Properties  {#Arduino101Humidity-Properties}

{:.properties}

{:id="Arduino101Humidity.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component with a connection to the Arduino 101 (getter).

{:id="Arduino101Humidity.Pin" .number} *Pin*
: The Pin on the Arduino board that the device is wired in to.

### Events  {#Arduino101Humidity-Events}

{:.events}

{:id="Arduino101Humidity.HumidityReceived"} HumidityReceived(*humidity*{:.number})
: The <code>HumidityReceived</code> event is run whenever humidity samples are received from the
 Arduino. This is usually a result of performing a <a href="#ReadHumidity">read</a> or
 <a href="#RequestHumidityUpdates">request</a> operation. The humidity value is a relative
 humidity between 0-100%.

 __Parameters__:

     * <code>humidity</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The relative humidity, in percent.

{:id="Arduino101Humidity.TemperatureReceived"} TemperatureReceived(*temperature*{:.number})
: The <code>TemperatureReceived</code> event is run whenever temperature samples are received
 from the Arduino. This is usually a result of performing a <a href="#ReadTemperature>read</a>
 or <a href="#RequestTemperatureUpdates">request</a> operation. The temperature value is
 measured in degrees Celsius.

 __Parameters__:

     * <code>temperature</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The temperature, in degrees Celsius.

### Methods  {#Arduino101Humidity-Methods}

{:.methods}

{:id="Arduino101Humidity.IsSupported" class="method returns boolean"} <i/> IsSupported()
: Tests whether the Bluetooth low energy device is broadcasting support for the service. If true,
 calls to TurnOn and TurnOff should work correctly. Otherwise an error will be reported through
 the Screen's ErrorOccurred event.

{:id="Arduino101Humidity.ReadHumidity" class="method"} <i/> ReadHumidity()
: Read the current humidity from the attached sensor. On success, the <a
 href="#HumidityReceived"><code>HumidityReceived</code></a> event will be run with the
 received humidity measurement.

{:id="Arduino101Humidity.ReadTemperature" class="method"} <i/> ReadTemperature()
: Read the current temperature from the attached sensor. On success, the <a
 href="#TemperatureReceived"><code>TemperatureReceived</code></a> event will be run with the
 received temperature measurement.

{:id="Arduino101Humidity.RequestHumidityUpdates" class="method"} <i/> RequestHumidityUpdates()
: Request notifications from the Arduino for changes in the humidity sensor reading. The <a
 href="#HumidityReceived"><code>HumidityReceived</code></a> event will be run as samples
 are received from the Arduino.

{:id="Arduino101Humidity.RequestTemperatureUpdates" class="method"} <i/> RequestTemperatureUpdates()
: Request notifications from the Arduino for changes in the temperature sensor reading. The <a
 href="#TemperatureReceived"><code>TemperatureReceived</code></a> event will be run as samples
 are received from the Arduino.

{:id="Arduino101Humidity.StopHumidityUpdates" class="method"} <i/> StopHumidityUpdates()
: Stop listening for notifications of changes in the humidity sensor reading. This only has an
 effect if there was a previous call to <a
 href="#RequestHumidityUpdates"><code>RequestHumidityUpdates</code></a>. There may be additional
 pending messages that will be processed by running <a
 href="#HumidityReceived"><code>HumidityReceived</code></a>.

{:id="Arduino101Humidity.StopTemperatureUpdates" class="method"} <i/> StopTemperatureUpdates()
: Stop listening for notifications of changes in the temperature sensor reading. This only has
 an effect if there was a previous call to <a
 href="#RequestTemperatureUpdates"><code>RequestTemperatureUpdates</code></a>. There may be
 additional pending messages that will be processed by running <a
 href="#TemperatureReceived"><code>TemperatureReceived</code></a>.

## Arduino101Led  {#Arduino101Led}

Extension for Arduino 101 that allows the user to manipulate attached LEDs.



### Properties  {#Arduino101Led-Properties}

{:.properties}

{:id="Arduino101Led.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component with a connection to the Arduino 101 (getter).

{:id="Arduino101Led.Intensity" .number} *Intensity*
: The Intensity of the LED valued from 1-100. Intensity will only affect the brightness of the LED if it is plugged into a pin supporting pulse width modulation (PWM). For the Arduino 101, the PWM pins are 3, 5, 6, and 9. For all other pins the LED will either turn on or off with no change in intensity.

{:id="Arduino101Led.On" .boolean .ro .bo} *On*
: Get whether the device attached to the Arduino 101 is turned on. This is a best guess approximation given the connected state of the Bluetooth low energy component and previous calls to TurnOn and TurnOff.

{:id="Arduino101Led.Pin" .number} *Pin*
: The Pin on the Arduino board that the device is wired in to.

### Events  {#Arduino101Led-Events}

{:.events}
None


### Methods  {#Arduino101Led-Methods}

{:.methods}

{:id="Arduino101Led.IsSupported" class="method returns boolean"} <i/> IsSupported()
: Tests whether the Bluetooth low energy device is broadcasting support for the service. If true,
 calls to TurnOn and TurnOff should work correctly. Otherwise an error will be reported through
 the Screen's ErrorOccurred event.

{:id="Arduino101Led.TurnOff" class="method"} <i/> TurnOff()
: Turn off the connected device.

{:id="Arduino101Led.TurnOn" class="method"} <i/> TurnOn()
: Turn on the connected device.

## Arduino101LightSensor  {#Arduino101LightSensor}

Extension to interpret light sensor data from the Arduino 101.



### Properties  {#Arduino101LightSensor-Properties}

{:.properties}

{:id="Arduino101LightSensor.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component with a connection to the Arduino 101 (getter).

{:id="Arduino101LightSensor.Pin" .number} *Pin*
: The Pin on the Arduino board that the device is wired in to.

### Events  {#Arduino101LightSensor-Events}

{:.events}

{:id="Arduino101LightSensor.LightSensorDataReceived"} LightSensorDataReceived(*intensity*{:.number})
: The <code>LightSensorDataReceived</code> event is run when a sample is received from the light
 sensor attached to the Arduino 101.

 __Parameters__:

     * <code>intensity</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The intensity of the light received from the sensor, linear in the voltage provided by the light sensor.

### Methods  {#Arduino101LightSensor-Methods}

{:.methods}

{:id="Arduino101LightSensor.IsSupported" class="method returns boolean"} <i/> IsSupported()
: Tests whether the Bluetooth low energy device is broadcasting support for the service. If true,
 calls to TurnOn and TurnOff should work correctly. Otherwise an error will be reported through
 the Screen's ErrorOccurred event.

{:id="Arduino101LightSensor.ReadLightSensor" class="method"} <i/> ReadLightSensor()
: Obtain the most recent reading from the light sensor as reported by the Arduino. On success,
 the <a href="#LightSensorDataReceived"><code>LightSensorDataReceived</code></a> event will be
 run.

{:id="Arduino101LightSensor.RequestLightSensorUpdates" class="method"} <i/> RequestLightSensorUpdates()
: Request notification of updates for the light sensor attached to the Arduino 101. The <a
 href="#LightSensorDataReceived"><code>LightSensorDataReceived</code></a> event will be run as
 light sensor readings are received from the Arduino.

{:id="Arduino101LightSensor.StopLightSensorUpdates" class="method"} <i/> StopLightSensorUpdates()
: Stop listening for notifications of light sensor readings from the Arduino. This only has an
 effect if there was a previous call to <a
 href="#RequestLightSensorUpdates"><code>RequestLightSensorUpdates</code></a>. There may be
 additional pending messages that will be processed after this call.

## Arduino101Moisture  {#Arduino101Moisture}

Extension to interface with a moisture sensor attached ot an Arduino 101 running the
 App Inventor Companion Sketch.



### Properties  {#Arduino101Moisture-Properties}

{:.properties}

{:id="Arduino101Moisture.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component with a connection to the Arduino 101 (getter).

{:id="Arduino101Moisture.Pin" .number} *Pin*
: The Pin on the Arduino board that the device is wired in to.

### Events  {#Arduino101Moisture-Events}

{:.events}

{:id="Arduino101Moisture.MoistureReceived"} MoistureReceived(*moisture*{:.number})
: The <code>MoistureReceived</code> event is run when a moisture measurement is received from
 the moisture sensor attached to the Arduino 101.

 __Parameters__:

     * <code>moisture</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The moisture level measured, between 0 and 100.

### Methods  {#Arduino101Moisture-Methods}

{:.methods}

{:id="Arduino101Moisture.IsSupported" class="method returns boolean"} <i/> IsSupported()
: Tests whether the Bluetooth low energy device is broadcasting support for the service. If true,
 calls to TurnOn and TurnOff should work correctly. Otherwise an error will be reported through
 the Screen's ErrorOccurred event.

{:id="Arduino101Moisture.ReadMoisture" class="method"} <i/> ReadMoisture()
: Obtain the most recent reading from the moisture sensor as reported by the Arduino. On success,
 the <a href="#MoistureReceived"><code>MoistureReceived</code></a> event will be run.

{:id="Arduino101Moisture.RequestMoistureUpdates" class="method"} <i/> RequestMoistureUpdates()
: Request notification of updates for the moisture sensor attached to the Arduino 101. The <a
 href="#MoistureReceived"><code>MoistureReceived</code></a> event will be run as moisture
 sensor readings are received from the Arduino.

{:id="Arduino101Moisture.StopMoistureUpdates" class="method"} <i/> StopMoistureUpdates()
: Stop listening for notifications of moisture sensor readings from the ARduino. This only has
 an effect if there was a previous call to <a
 href="#RequestMoistureUpdates"><code>RequestMoistureUpdates</code></a>. There may be
 additional pending messages that will be processed after this call.

## Arduino101PWMMotor  {#Arduino101PWMMotor}

Extension for Arduino 101 that allows the user to manipulate attached motors.



### Properties  {#Arduino101PWMMotor-Properties}

{:.properties}

{:id="Arduino101PWMMotor.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component with a connection to the Arduino 101 (getter).

{:id="Arduino101PWMMotor.On" .boolean .ro .bo} *On*
: Get whether the device attached to the Arduino 101 is turned on. This is a best guess approximation given the connected state of the Bluetooth low energy component and previous calls to TurnOn and TurnOff.

{:id="Arduino101PWMMotor.Pin" .number} *Pin*
: The Pin on the Arduino board that the device is wired in to.

{:id="Arduino101PWMMotor.Speed" .number} *Speed*
: The rate of pulse width modulation as a percentage of time. A value of 0 indicates an always-off state, 50 would result in the device being powered for half of each time unit, and 100 results in an always-on state. Default: 100.

### Events  {#Arduino101PWMMotor-Events}

{:.events}
None


### Methods  {#Arduino101PWMMotor-Methods}

{:.methods}

{:id="Arduino101PWMMotor.IsSupported" class="method returns boolean"} <i/> IsSupported()
: Tests whether the Bluetooth low energy device is broadcasting support for the service. If true,
 calls to TurnOn and TurnOff should work correctly. Otherwise an error will be reported through
 the Screen's ErrorOccurred event.

{:id="Arduino101PWMMotor.TurnOff" class="method"} <i/> TurnOff()
: Turn off the connected device.

{:id="Arduino101PWMMotor.TurnOn" class="method"} <i/> TurnOn()
: Turn on the connected device.

## Arduino101Pins  {#Arduino101Pins}

The Arduino101Pins extension provides a general purpose interface to any hardware connected
 to the digital or analog I/O pins.



### Properties  {#Arduino101Pins-Properties}

{:.properties}

{:id="Arduino101Pins.Analog" .boolean} *Analog*
: Set or get whether the pin is an analog pin (true) or digital pin (false). Default: digital (false).

{:id="Arduino101Pins.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component with a connection to the Arduino 101 (getter).

{:id="Arduino101Pins.Output" .boolean} *Output*
: Set or get whether the pin is an input or output pin. This only applies to digital pins. Analog pins are read-only. See the <a href="#/component/arduinopwm">Arduino 101 PWM</a> extension for treating digital pins as 'analog' outputs. Default: input (false).

{:id="Arduino101Pins.Pin" .number} *Pin*
: The Arduino pin to read or write. Default: 0.

### Events  {#Arduino101Pins-Events}

{:.events}

{:id="Arduino101Pins.PinStateReceived"} PinStateReceived(*value*{:.number})
: After the pin is read or an update is received, the <code>PinStateReceived</code> event will
 be run to inform the app about the state of the pin. The value parameter will indicate the
 pin state. For digital pins, it will be either 0 for off or 1 for on. For analog pins, it will
 be an integer in the range [0, 1023].

 __Parameters__:

     * <code>value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The value of the pin read from the Arduino. Valid values depend on whether the pin
       is digital or analog. For digital pins, a 0 indicates LOW and 1 indicates HIGH.
       For analog, an integer in the range of [0, 1023] will be returned.

{:id="Arduino101Pins.PinStateWritten"} PinStateWritten(*value*{:.number})
: After the pin is written, the <code>PinStateWritten</code> event will be run to indicate a
 successful operation. The value parameter will indicate the value written to the Arduino from
 the App Inventor app, not necessarily the value passed by the caller to
 <code>WritePinState</code>. For example, in the case of the analog pins the value will be
 truncated to fit within the range of [0, 1023].

 __Parameters__:

     * <code>value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The value written to the Arduino. Valid values depend on whether the pin is
       digital or analog. This value is the value written after any transformation by
       the extension to fit the range appropriate to the pin type.

### Methods  {#Arduino101Pins-Methods}

{:.methods}

{:id="Arduino101Pins.IsSupported" class="method returns boolean"} <i/> IsSupported()
: Check whether the feature is currently available for the device connected via the
 <a href="#BluetoothDevice"><code>BluetoothDevice</code></a> property. If no device is currently
 connected, this method will always return false.

{:id="Arduino101Pins.ReadPinState" class="method"} <i/> ReadPinState()
: Read the current state of the pin. After the value is read, it will be reported through the
 <code><a href="#PinStateReceived">PinStateReceived</a></code> event.

{:id="Arduino101Pins.RequestPinStateUpdates" class="method"} <i/> RequestPinStateUpdates()
: Request updates to the state of the pin. New values will be reported by the
 <code><a href="#PinStateReceived">PinStateReceived</a></code>
 event.

{:id="Arduino101Pins.UnregisterForUpdates" class="method"} <i/> UnregisterForUpdates()
: Stop receiving updates for the pin. Note that there still may be pending notifications to the
 <code>PinStateReceived</code> event that will need to be processed after this call.

{:id="Arduino101Pins.WritePinState" class="method"} <i/> WritePinState(*value*{:.number})
: Write a new value for the pin. This is only a valid operation if the Output property is set
 to true. For digital pins, a non zero value will be converted to 1 (HIGH) and a zero value will
 be converted to 0 (LOW). For analog pins, the value must be between 0 and 1023, inclusive. Any
 values outside of this range will be truncated. To write analog outputs to digital pins using
 pulse width modulation, see the <a href="#/arduino101/arduinopwm">Arduino101PWM</a> extension.

 __Parameters__:

     * <code>value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The value to write to the pin. Valid values depend on whether the pin is digital or analog.

## Arduino101ProximitySensor  {#Arduino101ProximitySensor}

Extension to interface with a proximity sensor attached to an Arduino 101 running the
 App Inventor Companion Sketch.



### Properties  {#Arduino101ProximitySensor-Properties}

{:.properties}

{:id="Arduino101ProximitySensor.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component with a connection to the Arduino 101 (getter).

{:id="Arduino101ProximitySensor.Pin" .number} *Pin*
: The Pin on the Arduino board that the device is wired in to.

### Events  {#Arduino101ProximitySensor-Events}

{:.events}

{:id="Arduino101ProximitySensor.ProximityReceived"} ProximityReceived(*proximity*{:.number})
: The <codeProximityReceived</code> event is run when a proximity measurement is received from
 the proximity sensor attached to the Arduino 101.

 __Parameters__:

     * <code>proximity</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The proximity of an object from the sensor. Due to physical and mathematical
       limitations, this value will range from 6 to 80 cm.

### Methods  {#Arduino101ProximitySensor-Methods}

{:.methods}

{:id="Arduino101ProximitySensor.IsSupported" class="method returns boolean"} <i/> IsSupported()
: Tests whether the Bluetooth low energy device is broadcasting support for the service. If true,
 calls to TurnOn and TurnOff should work correctly. Otherwise an error will be reported through
 the Screen's ErrorOccurred event.

{:id="Arduino101ProximitySensor.ReadProximity" class="method"} <i/> ReadProximity()
: Obtain the most recent reading from the proximity sensor as reported by the Arduino. On
 success, the <a href="#ProximityReceived"><code>ProximityReceived</code></a> event will be run.

{:id="Arduino101ProximitySensor.RequestProximityUpdates" class="method"} <i/> RequestProximityUpdates()
: Request notification of updates for the proximity sensor attached to the Arduino 101. The <a
 href="#ProximityReceived"><code>ProximityReceived</code></a> event will be run as proximity
 sensor readings are received from the Arduino.

{:id="Arduino101ProximitySensor.StopProximityUpdates" class="method"} <i/> StopProximityUpdates()
: Stop listening for notifications of proximity sensor readings from the Arduino. This only has
 an effect if there was a previous call to <a
 href="RequestProximityUpdates"><code>RequestProximityUpdates</code></a>. There may be
 additional pending messages that will be processed after this call.

## Arduino101RgbLcd  {#Arduino101RgbLcd}

Extension to interface with the Grove RGB LCD peripheral connected to an Arduino 101
 running the App Inventor Companion Sketch.



### Properties  {#Arduino101RgbLcd-Properties}

{:.properties}

{:id="Arduino101RgbLcd.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component with a connection to the Arduino 101 (getter).

### Events  {#Arduino101RgbLcd-Events}

{:.events}

{:id="Arduino101RgbLcd.BackgroundColorReceived"} BackgroundColorReceived(*color*{:.number})
: The <code>BackgroundColorReceived</code> event is run when the background color information is
 successfully received from the Arduino 101.

 __Parameters__:

     * <code>color</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/colors.html#basic">_color_</a>) &mdash;
       The current color of the background.

{:id="Arduino101RgbLcd.TextReceived"} TextReceived(*text*{:.text})
: The <code>TextReceived</code> event is run when the text currently displayed on the RGB LCD is
 received from the Arduino 101 in response to a call to
 <a href="#GetText"><code>GetText</code></a>.

 __Parameters__:

     * <code>text</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The text currently being shown on the RGB LCD. Note that this may not match the
       characters being shown due to a limited range of Unicode support for the LCD.

### Methods  {#Arduino101RgbLcd-Methods}

{:.methods}

{:id="Arduino101RgbLcd.GetBackgroundColor" class="method"} <i/> GetBackgroundColor()
: Request the current background color from the device. The color will be returned through the
 <a href='#BackgroundColorReceived"><code>BackgroundColorReceived</code></a> event.

{:id="Arduino101RgbLcd.GetText" class="method"} <i/> GetText()
: Get the text currently shown on the screen. The text will be returned through the <a
 href="#TextReceived"><code>TextReceived</code></a> event.

{:id="Arduino101RgbLcd.IsSupported" class="method returns boolean"} <i/> IsSupported()
: Tests whether the Bluetooth low energy device is broadcasting support for the service. If true,
 calls to TurnOn and TurnOff should work correctly. Otherwise an error will be reported through
 the Screen's ErrorOccurred event.

{:id="Arduino101RgbLcd.SetBackgroundColor" class="method"} <i/> SetBackgroundColor(*color*{:.number})
: Set the background color of the RGB LCD connected to the Arduino 101. This method can take
 any of the color blocks or a color composed using the <a
 href="http://appinventor.mit.edu/explore/ai2/support/blocks/colors.html#make">make a color</a>
 block. The RGB LCD does not have the same range of colors as a computer screen, so you may not
 observe changes between similar colors.

 __Parameters__:

     * <code>color</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/colors.html#basic">_color_</a>) &mdash;
       The color to change the background color to.

{:id="Arduino101RgbLcd.SetText" class="method"} <i/> SetText(*text*{:.text})
: Set the text of the display. Text is limited to string with not more than 2 lines of 16
 characters each. If a line is longer than 16 characters, it will be truncated.

 __Parameters__:

     * <code>text</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The text to show on the LCD. This is limited to two 16-character strings separated by a newline "\n"

## Arduino101Servo  {#Arduino101Servo}

An extension to interface with a servo connected to an Arduino 101 running the App Inventor
 Companion Sketch.



### Properties  {#Arduino101Servo-Properties}

{:.properties}

{:id="Arduino101Servo.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component with a connection to the Arduino 101 (getter).

{:id="Arduino101Servo.Pin" .number} *Pin*
: The Pin on the Arduino board that the device is wired in to.

### Events  {#Arduino101Servo-Events}

{:.events}

{:id="Arduino101Servo.PositionWritten"} PositionWritten(*position*{:.number})
: The <code>PositionWritten</code> event is run after a successful write to the servo's position.
 The meaning of the <code>position</code> parameter depends on whether position update was
 triggered by a <a href="#SetPosition"><code>SetPosition</code></a> call or a
 <a href="#SetPositionMicros"><code>SetPositionMicros</code></a> call.

 __Parameters__:

     * <code>position</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The new position of the servo. If the call was positional, this will be in degrees. If the call was rotational, it will be in microseconds.

### Methods  {#Arduino101Servo-Methods}

{:.methods}

{:id="Arduino101Servo.IsSupported" class="method returns boolean"} <i/> IsSupported()
: Tests whether the Bluetooth low energy device is broadcasting support for the service. If true,
 calls to TurnOn and TurnOff should work correctly. Otherwise an error will be reported through
 the Screen's ErrorOccurred event.

{:id="Arduino101Servo.SetPosition" class="method"} <i/> SetPosition(*position*{:.number})
: Set the rotation of a positional servo. Valid values are 0-180 degrees.

 __Parameters__:

     * <code>position</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The new position of the servo in degrees. Valid values are 0-180.

{:id="Arduino101Servo.SetPositionMicros" class="method"} <i/> SetPositionMicros(*position*{:.number})
: Set the time per revolution in microseconds of a continuous rotation servo. For a standard
 servo, 1000 is fully counterclockwise and 2000 is fully clockwise.

 __Parameters__:

     * <code>position</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The new rotational speed for a continuous rotational servo.

## Arduino101SoundRecorder  {#Arduino101SoundRecorder}

Extension to programmatically interact with the Grove Sound Recorder attached to an Arduino 101.



### Properties  {#Arduino101SoundRecorder-Properties}

{:.properties}

{:id="Arduino101SoundRecorder.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component with a connection to the Arduino 101 (getter).

{:id="Arduino101SoundRecorder.PlayPin" .number} *PlayPin*
: The digital pin used to trigger playback. If using the Grove connector, this is the same number as the digital pin port (D4 becomes 4).

{:id="Arduino101SoundRecorder.RecordPin" .number} *RecordPin*
: The digital pin used to trigger the recording. If using the Grove connector, this is one number higher than the digital pin port (D4 becomes 5).

### Events  {#Arduino101SoundRecorder-Events}

{:.events}
None


### Methods  {#Arduino101SoundRecorder-Methods}

{:.methods}

{:id="Arduino101SoundRecorder.IsSupported" class="method returns boolean"} <i/> IsSupported()
: Tests whether the Bluetooth low energy device is broadcasting support for the service. If true,
 calls to TurnOn and TurnOff should work correctly. Otherwise an error will be reported through
 the Screen's ErrorOccurred event.

{:id="Arduino101SoundRecorder.PlayRecordedSound" class="method"} <i/> PlayRecordedSound()
: Trigger playback of the recorded sound.

{:id="Arduino101SoundRecorder.StartRecording" class="method"} <i/> StartRecording()
: Start recording sound using the Sound Recorder's microphone.

{:id="Arduino101SoundRecorder.StopRecording" class="method"} <i/> StopRecording()
: Stop recording sound. The recording is limited to about 80 seconds of audio. If this limit is
 reached recording will automatically cease.

## Microbit_Accelerometer  {#Microbit_Accelerometer}

Component for Microbit_Accelerometer



### Properties  {#Microbit_Accelerometer-Properties}

{:.properties}

{:id="Microbit_Accelerometer.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device (getter).

### Events  {#Microbit_Accelerometer-Events}

{:.events}

{:id="Microbit_Accelerometer.AccelerometerDataReceived"} AccelerometerDataReceived(*Accelerometer_X*{:.number},*Accelerometer_Y*{:.number},*Accelerometer_Z*{:.number})
: The <code>AccelerometerDataReceived</code> event is run whenever accelerometer samples are
 received from the micro:bit. This is usually a result of performing a
 <a href="#ReadAccelerometerData">read</a> or
 <a href="#RequestAccelerometerDataUpdates">request</a> operation.
 The X, Y, and Z values are in thousands of 1 Earth gravity (G=-9.8 m/s<sup>2</sup>), and so
 should be scaled by 1/1000.

 __Parameters__:

    + <code>Accelerometer_X</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The X value of the accelerometer, in milliG.
    + <code>Accelerometer_Y</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The Y value of the accelerometer, in milliG.
    + <code>Accelerometer_Z</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The Z value of the accelerometer, in milliG.

{:id="Microbit_Accelerometer.AccelerometerPeriodReceived"} AccelerometerPeriodReceived(*Accelerometer_Period*{:.number})
: The <code>AccelerometerPeriodReceived</code> event is run after the micro:bit's accelerometer
 period is read from the device.

 __Parameters__:

    + <code>Accelerometer_Period</code> (_number_) &mdash; The current reporting interval for the micro:bit's accelerometer, in milliseconds.

{:id="Microbit_Accelerometer.WroteAccelerometerPeriod"} WroteAccelerometerPeriod(*Accelerometer_Period*{:.number})
: The <code>WroteAccelerometerPeriod</code> event is run after the micro:bit reports its period
 as requested by an earlier call to the
 <a href="#ReadAccelerometerPeriod"><code>ReadAccelerometerPeriod</code></a> method.

 __Parameters__:

    + <code>Accelerometer_Period</code> (_number_) &mdash; The reporting period for the micro:bit's accelerometer, in milliseconds.

### Methods  {#Microbit_Accelerometer-Methods}

{:.methods}

{:id="Microbit_Accelerometer.ReadAccelerometerData" class="method"} <i/> ReadAccelerometerData()
: Read a single sample of accelerometer data from the micro:bit. On successful read, the
 <a href="#AccelerometerDataReceived"><code>AccelerometerDataReceived</code></a>
 event will be run.

{:id="Microbit_Accelerometer.ReadAccelerometerPeriod" class="method"} <i/> ReadAccelerometerPeriod()
: Read the current report rate for the micro:bit accelerometer. After the period is read, it will
 be received by the
 <a href="#AccelerometerPeriodReceived"><code>AccelerometerPeriodReceived</code></a> event.

{:id="Microbit_Accelerometer.RequestAccelerometerDataUpdates" class="method"} <i/> RequestAccelerometerDataUpdates()
: Request notifications of changes in the micro:bit's accelerometer. Changes in the accelerometer
 will be reported at a rate determined by the last period value set by a call to
 <a href="#WriteAccelerometerPeriod"><code>WriteAccelerometerPeriod</code></a>. Accelerometer
 data will be reported through the
 <a href="#AccelerometerDataReceived"><code>AccelerometerDataReceived</code></a> event.

{:id="Microbit_Accelerometer.StopAccelerometerDataUpdates" class="method"} <i/> StopAccelerometerDataUpdates()
: Stop receiving updates from the micro:bit's accelerometer. Note that there may be pending
 messages from the device that will still be reported through the
 <a href="#AccelerometerDataReceived"><code>AccelerometerDataReceived</code></a> event.

{:id="Microbit_Accelerometer.WriteAccelerometerPeriod" class="method"} <i/> WriteAccelerometerPeriod(*period*{:.number})
: Use the <code>WriteAccelerometerPeriod</code> method to change how frequently the micro:bit
 sends accelerometer data to App Inventor. The period is measured in milliseconds. According to
 the micro:bit specification, valid values are 1, 2, 5, 10, 20, 80, 160, and 640 milliseconds.

 __Parameters__:

    + <code>period</code> (_number_) &mdash; The new accelerometer reporting period, in milliseconds.

## Microbit_Button  {#Microbit_Button}

Component for Microbit_Button



### Properties  {#Microbit_Button-Properties}

{:.properties}

{:id="Microbit_Button.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device (getter).

### Events  {#Microbit_Button-Events}

{:.events}

{:id="Microbit_Button.ButtonAStateReceived"} ButtonAStateReceived(*Button_State_Value*{:.number})
: After performing a <a href="#ReadButtonAState">read</a> or
 <a href="#RequestButtonAStateUpdates">request for updates</a>, the
 <code>ButtonAStateReceived</code> event will be run with information about the button state.

 __Parameters__:

   + <code>Button_State_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The state of the micro:bit's A button; 0 for released, 1 for pressed, 2 for long-pressed.

{:id="Microbit_Button.ButtonBStateReceived"} ButtonBStateReceived(*Button_State_Value*{:.number})
: After performing a <a href="#ReadButtonBState">read</a> or
 <a href="#RequestButtonBStateUpdates">request for updates</a>, the
 <code>ButtonBStateReceived</code> event will be run with information about the button state.

 __Parameters__:

   + <code>Button_State_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The state of the micro:bit's B button; 0 for released, 1 for pressed, 2 for long-pressed.

### Methods  {#Microbit_Button-Methods}

{:.methods}

{:id="Microbit_Button.ReadButtonAState" class="method"} <i/> ReadButtonAState()
: Read the current state of the micro:bit's A button. After a successful read, the
 <a href="#ButtonAStateReceived"><code>ButtonAStateReceived</code></a> event will be run.

{:id="Microbit_Button.ReadButtonBState" class="method"} <i/> ReadButtonBState()
: Read the current state of the micro:bit's B button. After a successful read, the
 <a href="#ButtonBStateReceived"><code>ButtonBStateReceived</code></a> event will be run.

{:id="Microbit_Button.RequestButtonAStateUpdates" class="method"} <i/> RequestButtonAStateUpdates()
: Request updates to the state of the micro:bit's A button. After requesting updates, the
 <a href="#ButtonAStateReceived"><code>ButtonAStateReceived</code></a> will be run whenever
 the micro:bit reports a button state change to the app. Pressing and holding the button
 will result in a second event with the value 2 to indicate a long press.

{:id="Microbit_Button.RequestButtonBStateUpdates" class="method"} <i/> RequestButtonBStateUpdates()
: Request updates to the state of the micro:bit's B button. After requesting updates, the
 <a href="#ButtonBStateReceived"><code>ButtonBStateReceived</code></a> will be run whenever
 the micro:bit reports a button state change to the app. Pressing and holding the button will
 result in a second event with the value 2 to indicate a long press.

{:id="Microbit_Button.StopButtonAStateUpdates" class="method"} <i/> StopButtonAStateUpdates()
: Stop receiving updates about the state of the micro:bit's A button. Note that there may
 be pending updates that have not been processed that will result in
 <a href="#ButtonAStateReceived"><code>ButtonAStateReceived</code></a>

{:id="Microbit_Button.StopButtonBStateUpdates" class="method"} <i/> StopButtonBStateUpdates()
: Stop receiving updates about the state of the micro:bit's B button. Note that there may be
 pending updates that have not been processed that will result in
 <a href="#ButtonBStateReceived"><code>ButtonBStateReceived</code></a>.

## Microbit_Device_Information  {#Microbit_Device_Information}

Component for Microbit_Device_Information



### Properties  {#Microbit_Device_Information-Properties}

{:.properties}

{:id="Microbit_Device_Information.BluetoothDevice" .component} *BluetoothDevice*
: Property for BluetoothDevice

### Events  {#Microbit_Device_Information-Events}

{:.events}

{:id="Microbit_Device_Information.FirmwareRevisionStringReceived"} FirmwareRevisionStringReceived(*Firmware_Revision_String*{:.text})
: Event for FirmwareRevisionStringReceived

{:id="Microbit_Device_Information.HardwareRevisionStringReceived"} HardwareRevisionStringReceived(*Hardware_Revision_String*{:.text})
: Event for HardwareRevisionStringReceived

{:id="Microbit_Device_Information.ManufacturerNameStringReceived"} ManufacturerNameStringReceived(*Manufacturer_Name_String*{:.text})
: Event for ManufacturerNameStringReceived

{:id="Microbit_Device_Information.ModelNumberStringReceived"} ModelNumberStringReceived(*Model_Number_String*{:.text})
: Event for ModelNumberStringReceived

{:id="Microbit_Device_Information.SerialNumberStringReceived"} SerialNumberStringReceived(*Serial_Number_String*{:.text})
: Event for SerialNumberStringReceived

### Methods  {#Microbit_Device_Information-Methods}

{:.methods}

{:id="Microbit_Device_Information.ReadFirmwareRevisionString" class="method"} <i/> ReadFirmwareRevisionString()
: Method for ReadFirmwareRevisionString

{:id="Microbit_Device_Information.ReadHardwareRevisionString" class="method"} <i/> ReadHardwareRevisionString()
: Method for ReadHardwareRevisionString

{:id="Microbit_Device_Information.ReadManufacturerNameString" class="method"} <i/> ReadManufacturerNameString()
: Method for ReadManufacturerNameString

{:id="Microbit_Device_Information.ReadModelNumberString" class="method"} <i/> ReadModelNumberString()
: Method for ReadModelNumberString

{:id="Microbit_Device_Information.ReadSerialNumberString" class="method"} <i/> ReadSerialNumberString()
: Method for ReadSerialNumberString

## Microbit_Dfu_Control  {#Microbit_Dfu_Control}

Component for Microbit_Dfu_Control



### Properties  {#Microbit_Dfu_Control-Properties}

{:.properties}

{:id="Microbit_Dfu_Control.BluetoothDevice" .component} *BluetoothDevice*
: Property for BluetoothDevice

### Events  {#Microbit_Dfu_Control-Events}

{:.events}

{:id="Microbit_Dfu_Control.DFUControlReceived"} DFUControlReceived(*dfu_control*{:.number})
: Event for DFUControlReceived

{:id="Microbit_Dfu_Control.WroteDFUControl"} WroteDFUControl(*dfu_control*{:.number})
: Event for WroteDFUControl

### Methods  {#Microbit_Dfu_Control-Methods}

{:.methods}

{:id="Microbit_Dfu_Control.ReadDFUControl" class="method"} <i/> ReadDFUControl()
: Method for ReadDFUControl

{:id="Microbit_Dfu_Control.WriteDFUControl" class="method"} <i/> WriteDFUControl(*DFU_Control*{:.number})
: Method for WriteDFUControl

## Microbit_Event  {#Microbit_Event}

Component for Microbit_Event



### Properties  {#Microbit_Event-Properties}

{:.properties}

{:id="Microbit_Event.BluetoothDevice" .component} *BluetoothDevice*
: Property for BluetoothDevice

### Events  {#Microbit_Event-Events}

{:.events}

{:id="Microbit_Event.MicroBitEventReceived"} MicroBitEventReceived(*Event_Type_And_Value*{:.number})
: Event for MicroBitEventReceived

{:id="Microbit_Event.MicroBitRequirementsReceived"} MicroBitRequirementsReceived(*microbit_reqs_value*{:.number})
: Event for MicroBitRequirementsReceived

{:id="Microbit_Event.WroteClientEvent"} WroteClientEvent(*Event_Types_And_Values*{:.list})
: Event for WroteClientEvent

{:id="Microbit_Event.WroteClientRequirements"} WroteClientRequirements(*Client_Requirements_Value*{:.list})
: Event for WroteClientRequirements

### Methods  {#Microbit_Event-Methods}

{:.methods}

{:id="Microbit_Event.ReadMicroBitEvent" class="method"} <i/> ReadMicroBitEvent()
: Method for ReadMicroBitEvent

{:id="Microbit_Event.ReadMicroBitRequirements" class="method"} <i/> ReadMicroBitRequirements()
: Method for ReadMicroBitRequirements

{:id="Microbit_Event.RequestMicroBitEventUpdates" class="method"} <i/> RequestMicroBitEventUpdates()
: Method for RequestMicroBitEventUpdates

{:id="Microbit_Event.RequestMicroBitRequirementsUpdates" class="method"} <i/> RequestMicroBitRequirementsUpdates()
: Method for RequestMicroBitRequirementsUpdates

{:id="Microbit_Event.StopMicroBitEventUpdates" class="method"} <i/> StopMicroBitEventUpdates()
: Method for StopMicroBitEventUpdates

{:id="Microbit_Event.StopMicroBitRequirementsUpdates" class="method"} <i/> StopMicroBitRequirementsUpdates()
: Method for StopMicroBitRequirementsUpdates

{:id="Microbit_Event.WriteClientEvent" class="method"} <i/> WriteClientEvent(*Event_Types_And_Values*{:.list})
: Method for WriteClientEvent

{:id="Microbit_Event.WriteClientRequirements" class="method"} <i/> WriteClientRequirements(*Client_Requirements_Value*{:.list})
: Method for WriteClientRequirements

## Microbit_Generic_Access  {#Microbit_Generic_Access}

Component for Microbit_Generic_Access



### Properties  {#Microbit_Generic_Access-Properties}

{:.properties}

{:id="Microbit_Generic_Access.BluetoothDevice" .component} *BluetoothDevice*
: Property for BluetoothDevice

### Events  {#Microbit_Generic_Access-Events}

{:.events}

{:id="Microbit_Generic_Access.AppearanceReceived"} AppearanceReceived(*Category*{:.number})
: Event for AppearanceReceived

{:id="Microbit_Generic_Access.DeviceNameReceived"} DeviceNameReceived(*Name*{:.text})
: Event for DeviceNameReceived

{:id="Microbit_Generic_Access.PeripheralPreferredConnectionParametersReceived"} PeripheralPreferredConnectionParametersReceived(*Minimum_Connection_interval*{:.number},*Maximum_Connection_Interval*{:.number},*Slave_Latency*{:.number},*Connection_Supervision_Timeout_Multiplier*{:.number})
: Event for PeripheralPreferredConnectionParametersReceived

{:id="Microbit_Generic_Access.WroteDeviceName"} WroteDeviceName(*Name*{:.text})
: Event for WroteDeviceName

### Methods  {#Microbit_Generic_Access-Methods}

{:.methods}

{:id="Microbit_Generic_Access.ReadAppearance" class="method"} <i/> ReadAppearance()
: Method for ReadAppearance

{:id="Microbit_Generic_Access.ReadDeviceName" class="method"} <i/> ReadDeviceName()
: Method for ReadDeviceName

{:id="Microbit_Generic_Access.ReadPeripheralPreferredConnectionParameters" class="method"} <i/> ReadPeripheralPreferredConnectionParameters()
: Method for ReadPeripheralPreferredConnectionParameters

{:id="Microbit_Generic_Access.WriteDeviceName" class="method"} <i/> WriteDeviceName(*Name*{:.text})
: Method for WriteDeviceName

## Microbit_Generic_Attribute  {#Microbit_Generic_Attribute}

Component for Microbit_Generic_Attribute



### Properties  {#Microbit_Generic_Attribute-Properties}

{:.properties}

{:id="Microbit_Generic_Attribute.BluetoothDevice" .component} *BluetoothDevice*
: Property for BluetoothDevice

### Events  {#Microbit_Generic_Attribute-Events}

{:.events}
None


### Methods  {#Microbit_Generic_Attribute-Methods}

{:.methods}
None


## Microbit_Io_Pin  {#Microbit_Io_Pin}

Component for Microbit_Io_Pin



### Properties  {#Microbit_Io_Pin-Properties}

{:.properties}

{:id="Microbit_Io_Pin.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device (getter).

### Events  {#Microbit_Io_Pin-Events}

{:.events}

{:id="Microbit_Io_Pin.PinADConfigurationReceived"} PinADConfigurationReceived(*Pin_AD_Config_Value*{:.list})
: The <code>PinADConfigurationReceived</code> event is run after a successful call to the
 <a href="#ReadPinADConfiguration"><code>ReadPinADConfiguration</code></a> method is returned
 by the micro:bit.

 __Parameters__:

     * <code>Pin\_AD\_Config\_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       A list of analog/digital pin states configured on the micro:bit.

{:id="Microbit_Io_Pin.PinDataReceived"} PinDataReceived(*IO_Pin_Data*{:.number})
: The <code>PinDataReceived</code> event will be run after the micro:bit sends the status of its
 input pins. This will typically follow calls to
 <a href="#ReadPinData"><code>ReadPinData</code></a> or
 <a href="#RequestPinData"><code>RequestPinData</code></a>.

 __Parameters__:

     * <code>IO_Pin_Data</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       The state of the micro:bit's input pins. Pins not configured for input will have 0 value.

{:id="Microbit_Io_Pin.PinIOConfigurationReceived"} PinIOConfigurationReceived(*Pin_IO_Config_Value*{:.list})
: The <code>PinIOConfigurationReceived</code> event will be run after the micro:bit's pins'
 input/output configuration is read. <code>Pin\_IO\_Config\_Value</code> will be a list of three
 bytes valued from 0-255 composing a 19-bit mask indicating the input or output state of each
 of the 19 pins provided by the micro:bit. A 0 bit indicates output and a 1 bit indicates input.

 __Parameters__:

     * <code>Pin\_IO\_Config\_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       A list of 8-bit values that are composed into a 19-bit mask, one bit per pin on the micro:bit.

{:id="Microbit_Io_Pin.WrotePWMControl"} WrotePWMControl(*PWM_Control_Field*{:.list})
: The <code>WrotePWMControl</code> event is run after a successful write to the micro:bit's
 pulse-width modulation control service. The value of the control field that was written will
 be passed as the <code>PWM\_Control\_Field</code>.

 __Parameters__:

     * <code>PWM\_Control\_Field</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       The control information written to the micro:bit.

{:id="Microbit_Io_Pin.WrotePinADConfiguration"} WrotePinADConfiguration(*Pin_AD_Config_Value*{:.list})
: The <code>WrotePinADConfiguration</code> event is run after a successful write to the
 micro:bit's configuration server for analog and digital pins. <code>Pin\_AD\_Config\_Value</code>
 will be the list of bytes that were written as part of the last call to the service.

 __Parameters__:

     * <code>Pin\_AD\_Config\_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       A list of 8-bit values that are composed into a 19-bit mask, one bit per pin on the micro:bit.

{:id="Microbit_Io_Pin.WrotePinData"} WrotePinData(*IO_Pin_Data*{:.list})
: The <code>WrotePinData</code> event will be run after the micro:bit's output pins are
 successfully written by a call to the <a href="#WritePinData"><code>WritePinData</code></a>
 method.

 __Parameters__:

     * <code>IO\_Pin\_Data</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash; A list of up to 19 values from 0-255 that were written to the micro:bit's
       pins from the last call to <a href="#WritePinData"><code>WritePinData</code></a>.

{:id="Microbit_Io_Pin.WrotePinIOConfiguration"} WrotePinIOConfiguration(*Pin_IO_Config_Value*{:.list})
: The <code>WrotePinIOConfiguration</code> event will run after a successful update of the
 micro:bit's input/output pin configuration. <code>Pin\_IO\_Config\_Value</code> that was sent to
 the device will be passed as a parameter to the event.

 __Parameters__:

     * <code>Pin\_IO\_Config\_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       A list of 8-bit values that are composed into a 19-bit mask, one bit per pin on the micro:bit.

### Methods  {#Microbit_Io_Pin-Methods}

{:.methods}

{:id="Microbit_Io_Pin.ReadPinADConfiguration" class="method"} <i/> ReadPinADConfiguration()
: Read the state of the micro:bit's pin configuration, specifically whether each pin is
 configured as digital (0 or 1) or analog (0 to 255). After a successful read, the
 <a href="#PinADConfigurationReceived"><code>PinADConfigurationReceived</code></a> event will
 be run.

{:id="Microbit_Io_Pin.ReadPinData" class="method"} <i/> ReadPinData()
: Read a single sample of the pin states from the micro:bit. On successful read, the
 <a href="#PinDataReceived"><code>PinDataReceived</code></a> event will be run. Prior to reading
 the pins, one should configure the pins for input using the <a
 href="#WritePinIOConfiguration"><code>WritePinIOConfiguration</code></a> method.

{:id="Microbit_Io_Pin.ReadPinIOConfiguration" class="method"} <i/> ReadPinIOConfiguration()
: Read the current input/output configuration of the micro:bit's pins. After a successful read,
 the <a href="#PinIOConfigurationReceived"><code>PinIOConfigurationReceived</code></a> event
 will be run.

{:id="Microbit_Io_Pin.RequestPinDataUpdates" class="method"} <i/> RequestPinDataUpdates()
: Request updates to any micro:bit pins configured as input pins. After requesting updates, the
 <a href="#PinDataReceived"><code>PinDataReceived</code></a> will be run whenever the micro:bit
 reports changes to its input pins.

{:id="Microbit_Io_Pin.StopPinDataUpdates" class="method"} <i/> StopPinDataUpdates()
: Stop receiving updates about the state of the micro:bit's I/O pins. Note that there may be
 pending updates that have not been processed that will result in additional
 <a href="#PinDataReceived"><code>PinDataReceived</code></a> events.

{:id="Microbit_Io_Pin.WritePWMControl" class="method"} <i/> WritePWMControl(*PWM_Control_Field*{:.list})
: Writes the PWM control field on the micro:bit. The PWM control field is a variable length
 array of one or two instances of a data structure containing a 1-byte pin field (range 0-19),
 a 2-byte value field (range 0-1024), and a 4-byte period field (in milliseconds).

 __Parameters__:

     * <code>PWM\_Control\_Field</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       The PWM control field data as defined in the WritePWMControl method description.

{:id="Microbit_Io_Pin.WritePinADConfiguration" class="method"} <i/> WritePinADConfiguration(*Pin_AD_Config_Value*{:.list})
: The <code>WritePinADConfiguration</code> is used to configure whether pins on the micro:bit
 are analog or digital. The <code>Pin\_AD\_Config\_Value</code> is composed of three bytes that
 represent 19 bits, one for each pin on the micro:bit. A 0 bit indicates a digital pin and a
 1 bit indicates an analog pin. The
 <a href="#WrotePinADConfiguration"><code>WrotePinADConfiguration</code></a> event will be run
 after successfully writing a new pin configuration.

 __Parameters__:

     * <code>Pin\_AD\_Config\_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       A list of 8-bit values that are composed into a 19-bit mask, one bit per pin on the micro:bit.

{:id="Microbit_Io_Pin.WritePinData" class="method"} <i/> WritePinData(*IO_Pin_Data*{:.list})
: The <code>WritePinData</code> is used to set the output values of the micro:bit's pins if
 configured as output pins using the
 <a href="#WritePinIOConfiguration"><code>WritePinIOConfiguration</code></a> method. After the
 pins are written, the <a href="#WrotePinData"><code>WrotePinData</code></a> event will be run.

 __Parameters__:

     * <code>IO\_Pin\_Data</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash; A list of up to 19 values from 0-255 to be output to the micro:bit's pins.

{:id="Microbit_Io_Pin.WritePinIOConfiguration" class="method"} <i/> WritePinIOConfiguration(*Pin_IO_Config_Value*{:.list})
: The <code>WritePinIOConfiguration</code> method is used to configure the micro:bit's pins for
 input or output. The <code>Pin\_IO\_Config\_Value</code> parameter should be a 3-element list
 where each element is a number from 0-255 composing a 19-bit bitmask. A 0-bit indicates an
 output and a 1-bit indicates an input.

 __Parameters__:

     * <code>Pin_IO_Config_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#emptylist">_list_</a>) &mdash;
       A list of 8-bit values that are composed into a 19-bit mask, one bit per pin on the micro:bit.

## Microbit_Led  {#Microbit_Led}

Component for Microbit_Led



### Properties  {#Microbit_Led-Properties}

{:.properties}

{:id="Microbit_Led.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device (getter).

### Events  {#Microbit_Led-Events}

{:.events}

{:id="Microbit_Led.LEDMatrixStateReceived"} LEDMatrixStateReceived(*LED_Matrix_State*{:.list})
: The <code>LEDMatrixStateReceived</code> event is run when the state of the micro:bit's LED
 matrix is read from the device. The <code>LED_Matrix_State</code> is a list of 5 values, one
 for each row of the matrix. Each value is an number from 0-31. From left to right, the LEDs
 are valued 16, 8, 4, 2, 1.<br>\n\n

 __Parameters__:

    + <code>LED_Matrix_State</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash; A list of 5 values, one for each row, with
      each value being between 0-31 to indicate which LEDs in that row are on.

{:id="Microbit_Led.ScrollingDelayReceived"} ScrollingDelayReceived(*Scrolling_Delay_Value*{:.number})
: The <code>Scrolling_Delay_Value</code> event will be run after requesting the scrolling delay
 for the micro:bit's LED matrix through the
 <a href="#ReadScrollingDelay><code>ReadScrollingDelay</code></a> method.

 __Parameters__:

     * <code>Scrolling_Delay_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The delay between characters on the LED matrix, in milliseconds.

{:id="Microbit_Led.WroteLEDMatrixState"} WroteLEDMatrixState(*LED_Matrix_State*{:.list})
: The <code>WriteLEDMatrixState</code> event will be run after the micro:bit's LED matrix is
 written due to a call to <a href="#WriteLEDMatrixState"><code>WriteLEDMatrixState</code></a>.
 The LED_Matrix_State will be the same as in the call to <code>WriteLEDMatrixState</code> to
 differentiate the response to potentially many calls to write the LED matrix.

 __Parameters__:

     * <code>LED_Matrix_State</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash; The values written to the LED matrix as specified in the previous call
       to [`WriteLEDMatrixState`](#Microbit_Led.WriteLEDMatrixState) that resulted in this event.

{:id="Microbit_Led.WroteLEDText"} WroteLEDText(*LED_Text_Value*{:.text})
: The <code>WroteLEDText</code> event will be run after text is written to the micro:bit's LED
 matrix through a call to <a href="#WriteLEDText"><code>WriteLEDText</code></a>. The value of
 the written text will be given by the <code>LED_Text_Value</code> parameter.

 __Parameters__:

     * <code>LED_Text_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash; The text to write to the LED matrix.

{:id="Microbit_Led.WroteScrollingDelay"} WroteScrollingDelay(*Scrolling_Delay_Value*{:.number})
: The <code>WroteScrollingDelay</code> event will be run after the micro:bit's scrolling delay
 is successfully read after a call to the
 <a href="#WriteScrollingDelay"><code>WriteScrollingDelay</code></a> method.

 __Parameters__:

     * <code>Scrolling_Delay_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The delay between characters on the LED matrix, in milliseconds.

### Methods  {#Microbit_Led-Methods}

{:.methods}

{:id="Microbit_Led.ReadLEDMatrixState" class="method"} <i/> ReadLEDMatrixState()
: Read the current state of the LED matrix from the micro:bit. The LED matrix state will be
 reported through the <a href="#LEDMatrixStateReceived"><code>LEDMatrixStateReceived</code></a>
 event.

{:id="Microbit_Led.ReadScrollingDelay" class="method"} <i/> ReadScrollingDelay()
: Read the current scroll delay for the micro:bit's LED matrix. After a successful read, the
 <a href="#ScrollingDelayReceived"><code>ScrollingDelayReceived</code></a> event will be run.

{:id="Microbit_Led.WriteLEDMatrixState" class="method"} <i/> WriteLEDMatrixState(*LED_Matrix_State*{:.list})
: Write the state of the micro:bit's LED matrix. <code>LED_Matrix_State</code> should be a list
 of 5 numbers from 0-31 to indicate which LEDs should be turned on in each of the 5 rows of the
 LED matrix. From left to right, the values of the LEDs are 16, 8, 4, 2, 1. For example, if you
 want to turn on the LEDs in one row such that power states were 10011, you would send the value
 (16 + 2 + 1) or 19 for the row. After the write operation completes, the
 <a href="#WroteLEDMatrixState"><code>WroteLEDMatrixState</code></a> event will be run.

 __Parameters__:

     * <code>LED_Matrix_State</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash; A list of 5 numbers, one for each row of the LED matrix, where each
       value is the integer value of the bit array for the nth row of the LED matrix.

{:id="Microbit_Led.WriteLEDText" class="method"} <i/> WriteLEDText(*LED_Text_Value*{:.text})
: Write text to the micro:bit's LED matrix. The rate at which each character appears on the
 micro:bit's display depends on the last scroll value written by
 <a href="#WriteScrollDelay"><code>WriteScrollDelay</code></a>. Due to the allowable length of
 Bluetooth low energy packets, the strings sent are restricted to 20 or more UTF-8 octets.
 Attempts to write strings longer than 20 octets will result in truncated messages.

 __Parameters__:

    + <code>LED_Text_Value</code> (_string_) &mdash; The text to write. Strings are limited to
      a length of 20 UTF-8 octets.

{:id="Microbit_Led.WriteScrollingDelay" class="method"} <i/> WriteScrollingDelay(*Scrolling_Delay_Value*{:.number})
: Set the delay between characters displayed on the micro:bit's LED matrix, in milliseconds.
 After writing the value, the
 <a href="#WroteScrollingDelay"><code>WriteScrollingDelay</code></a> will be called.

 __Parameters__:

     * <code>Scrolling_Delay_Value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The delay between characters on the LED matrix, in milliseconds.

## Microbit_Magnetometer  {#Microbit_Magnetometer}

Component for Microbit_Magnetometer



### Properties  {#Microbit_Magnetometer-Properties}

{:.properties}

{:id="Microbit_Magnetometer.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device (getter).

### Events  {#Microbit_Magnetometer-Events}

{:.events}

{:id="Microbit_Magnetometer.MagnetometerBearingReceived"} MagnetometerBearingReceived(*bearing_value*{:.number})
: The <code>MagnetometerBearingReceived</code> event is run whenever bearing samples are
 received from the micro:bit. This is usually a result of performing a
 <a href="#ReadMagnetometerBearing">read</a> or
 <a href="#RequestMagnetometerBearingUpdates">request</a> operation. The bearing value is
 reported as degrees relative to North.

 __Parameters__:

     * <code>bearing_value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The bearing from North, in degrees.

{:id="Microbit_Magnetometer.MagnetometerDataReceived"} MagnetometerDataReceived(*Magnetometer_X*{:.number},*Magnetometer_Y*{:.number},*Magnetometer_Z*{:.number})
: The <code>MagnetometerDataReceived</code> event is run whenever magnetometer samples are
 received from the micro:bit. This is usually a result of performing a
 <a href="#ReadMagnetometerData">read</a> or
 <a href="#RequestMagnetometerDataUpdates">request</a> operation. The X, Y, and Z values are in
 milli-teslas, and so should be scaled by 1/1000.

 __Parameters__:

    + <code>Magnetometer_X</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The X value of the magnetometer, in milliT.
    + <code>Magnetometer_Y</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The Y value of the magnetometer, in milliT.
    + <code>Magnetometer_Z</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash; The Z value of the magnetometer, in milliT.

{:id="Microbit_Magnetometer.MagnetometerPeriodReceived"} MagnetometerPeriodReceived(*Magnetometer_Period*{:.number})
: The <code>MagnetometerPeriodReceived</code> event is run after the micro:bit's magnetometer
 period is read from the device.

 __Parameters__:

     * <code>Magnetometer_Period</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The current reporting interval for the micro:bit's magnetometer, in milliseconds.

{:id="Microbit_Magnetometer.WroteMagnetometerPeriod"} WroteMagnetometerPeriod(*Magnetometer_Period*{:.number})
: The <code>WroteMagnetometerPeriod</code> event is run after the micro:bit reports its period
 as requested by an earlier call to the
 <a href="#ReadMagnetometerPeriod"><code>ReadAccelerometerPeriod</code></a> method.

 __Parameters__:

     * <code>Magnetometer_Period</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The reporting periodf or the micro:bit's magnetometer, in milliseconds.

### Methods  {#Microbit_Magnetometer-Methods}

{:.methods}

{:id="Microbit_Magnetometer.ReadMagnetometerBearing" class="method"} <i/> ReadMagnetometerBearing()
: Read a single bearing sample from the micro:bit. On successful read, the
 <a href="#MagnetometerBearingReceived"><code>MagnetometerBearingReceived</code></a> event
 will be run.

{:id="Microbit_Magnetometer.ReadMagnetometerData" class="method"} <i/> ReadMagnetometerData()
: Read a single sample of magnetometer data from the micro:bit. On successful read, the
 <a href="#MagnetometerDataReceived"><code>MagnetometerDataReceived</code></a> event will be
 run.

{:id="Microbit_Magnetometer.ReadMagnetometerPeriod" class="method"} <i/> ReadMagnetometerPeriod()
: Read the current report rate for the micro:bit magnetometer. After the period is read, it will
 be received by the
 <a href="#MagnetometerPeriodReceived"><code>MagnetometerPeriodReceived</code></a> event.

{:id="Microbit_Magnetometer.RequestMagnetometerBearingUpdates" class="method"} <i/> RequestMagnetometerBearingUpdates()
: Request notifications of changes in the micro:bit's bearing. Changes in the bearing will be
 reported at a rate determined by the last period value set by a call to
 <a href="#WriteMagnetometerPeriod"><code>WriteMagnetometerPeriod</code></a>. Bearing data
 will be reported through the
 <a href="#MagnetometerBearingReceived"><code>MagnetometerBearingReceived</code></a> event.

{:id="Microbit_Magnetometer.RequestMagnetometerDataUpdates" class="method"} <i/> RequestMagnetometerDataUpdates()
: Request notifications of changes in the micro:bit's magnetometer. Changes in the magnetometer
 will be reported at a rate determined by the last period value set by a call to
 <a href="#WriteMagnetometerPeriod"><code>WriteMagnetometerPeriod</code></a>. Magnetometer
 data will be reported through the
 <a href="#MagnetometerDataReceived"><code>MagnetometerDataReceived</code></a> event.

{:id="Microbit_Magnetometer.StopMagnetometerBearingUpdates" class="method"} <i/> StopMagnetometerBearingUpdates()
: Stop receiving updates from the micro:bit's magnetometer. Note that there may be pending
 messages from the device that will still be reported through the
 <a href="#MagnetometerBearingReceived"><code>MagnetometerBearingReceived</code></a> event.

{:id="Microbit_Magnetometer.StopMagnetometerDataUpdates" class="method"} <i/> StopMagnetometerDataUpdates()
: Stop receiving updates from the micro:bit's magnetometer. Note that there may be pending
 messages from the device that will still be reported through the
 <a href="#MagnetometerDataReceived"><code>MagnetometerDataReceived</code></a> event.

{:id="Microbit_Magnetometer.WriteMagnetometerPeriod" class="method"} <i/> WriteMagnetometerPeriod(*Magnetometer_Period*{:.number})
: Use the <code>WriteMagnetometerPeriod</code> method to change how frequently the micro:bit
 sends magnetometer data to App Inventor. The period is measured in milliseconds. According to
 the micro:bit specification, valid values are 1, 2, 5, 10, 20, 80, 160 and 640 milliseconds.

 __Parameters__:

     * <code>Magnetometer_Period</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The new magnetometer reporting period, in milliseconds.

## Microbit_Temperature  {#Microbit_Temperature}

Component for Microbit_Temperature



### Properties  {#Microbit_Temperature-Properties}

{:.properties}

{:id="Microbit_Temperature.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device (getter).

### Events  {#Microbit_Temperature-Events}

{:.events}

{:id="Microbit_Temperature.TemperaturePeriodReceived"} TemperaturePeriodReceived(*temperature_period_value*{:.number})
: The <code>TemperaturePeriodReceived</code> event is run after the micro:bit's temperature
 reporting period is read from the device.

 __Parameters__:

     * <code>temperature_period_value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The current reporting interval for the micro:bit's temperature sensor.

{:id="Microbit_Temperature.TemperatureReceived"} TemperatureReceived(*temperature_value*{:.number})
: The <code>TemperatureReceived</code> event is run whenever temperature samples are received
 from the micro:bit. This is usually a result of performing a
 <a href="#ReadTemperature">read</a> or <a href="#RequestTemperatureUpdates">request updates</a>
 operation. The temperature value is measured in degrees Celsius.

 __Parameters__:

     * <code>temperature_value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The temperature measured by the micro:bit, in degrees Celsius

{:id="Microbit_Temperature.WroteTemperaturePeriod"} WroteTemperaturePeriod(*temperature_period_value*{:.number})
: The <code>WroteTemperaturePeriod</code> event is run after the micro:bit's temperature
 reporting period is written to the device.

 __Parameters__:

     * <code>temperature_period_value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The new reporting interval for the micro:bit's temperature sensor.

### Methods  {#Microbit_Temperature-Methods}

{:.methods}

{:id="Microbit_Temperature.ReadTemperature" class="method"} <i/> ReadTemperature()
: Read a single sample of temperature data from the micro:bit. On successful read, the
 <a href="#TemperatureDataReceived"><code>TemperatureDataReceived</code></a> event will be run.

{:id="Microbit_Temperature.ReadTemperaturePeriod" class="method"} <i/> ReadTemperaturePeriod()
: Read the current report rate for the micro:bit's temperature sensor. After the period is read,
 it will be received by the
 <a href="#TemperaturePeriodReceived"><code>TemperaturePeriodReceived</code></a> event.

{:id="Microbit_Temperature.RequestTemperatureUpdates" class="method"} <i/> RequestTemperatureUpdates()
: Request notifications of changes in the micro:bit's temperature sensor. Changes in the
 temperature will be reported at a rate determined by the last period value set by a call to
 <a href="#WriteTemperaturePeriod"><code>WriteTemperaturePeriod</code></a>. Temperature data
 will be reported through the
 <a href="#TemperatureDataReceived"><code>TemperatureDataReceived</code></a> event.

{:id="Microbit_Temperature.StopTemperatureUpdates" class="method"} <i/> StopTemperatureUpdates()
: Stop receiving updates from the micro:bit's temperature sensor. Note that there may be
 pending messages from the device that will still be reported through the
 <a href="#TemperatureDataReceived"><code>TemperatureDataReceived</code></a> event.

{:id="Microbit_Temperature.WriteTemperaturePeriod" class="method"} <i/> WriteTemperaturePeriod(*temperature_period_value*{:.number})
: Use the <code>WriteTemperaturePeriod</code> method to change how frequently the micro:bit sends
 temperature data to App Inventor. The period is measured in milliseconds.

 __Parameters__:

     * <code>temperature_period_value</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The new reporting period for the micro:bit's temperature sensor.

## Microbit_Uart  {#Microbit_Uart}

Component for Microbit_Uart



### Properties  {#Microbit_Uart-Properties}

{:.properties}

{:id="Microbit_Uart.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device (getter).

### Events  {#Microbit_Uart-Events}

{:.events}

{:id="Microbit_Uart.TXCharacteristicReceived"} TXCharacteristicReceived(*UART_TX_Field*{:.list})
: The <code>TXCharacteristicReceived</code> event is run whenever messages are received over the
 micro:bit's serial UART protocol.

 __Parameters__:

     * <code>UART_TX_FIELD</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/listsU.html#makealist">_list_</a>) &mdash;
       A list of unsigned byte values read from the device.

{:id="Microbit_Uart.WroteRXCharacteristic"} WroteRXCharacteristic(*UART_TX_Field*{:.list})
: The <code>WroteRXCharacteristic</code> event is run after a message is written to the micro:bit
 via its serial UART.

 __Parameters__:

     * <code>UART_TX_FIELD</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/listsU.html#makealist">_list_</a>) &mdash;
       A list of unsigned byte values written to the device.

### Methods  {#Microbit_Uart-Methods}

{:.methods}

{:id="Microbit_Uart.RequestTXCharacteristic" class="method"} <i/> RequestTXCharacteristic()
: Requests notifications of messages received from the micro:bit's serial UART. New messages will
 be received through the
 <a href='#TXCharacteristicReceived'><code>TXCharacteristicReceived</code></a>
 event.

{:id="Microbit_Uart.StopTXCharacteristicUpdates" class="method"} <i/> StopTXCharacteristicUpdates()
: Stops receiving updates from the micro:bit's serial UART. Note that there may be pending
 messages from the device that will still be reported through the
 <a href='#TXCharacteristicReceived'><code>TXCharacteristicReceived</code></a> event.

{:id="Microbit_Uart.WriteRXCharacteristic" class="method"} <i/> WriteRXCharacteristic(*UART_TX*{:.any})
: Writes the given value <code>UART_TX</code> to the micro:bit. The size of the message will
 depend on the value of <code>UART_TX</code>. Numbers will be converted to integers and sent
 as 32-bit integer values. Strings will be encoded using UTF-8. Lists of objects will be
 sent as a sequence of bytes using the aforementioned rules for numbers and strings.

 __Parameters__:

     * <code>UART_TX</code> (_any_) &mdash;
       The value to transmit to the RX "pin" of the micro:bit. Strings will be encoded as UTF-8,
       numbers will be sent as 32-bit integers. Lists of values will be converted into be
       converted into a sequence of bytes depending on the type of each value in the list.
