---
layout: documentation
title: IoT
---

[&laquo; Back to index](index.html)
# IoT

Table of Contents:

* [Ev3ColorSensor](#Ev3ColorSensor)
* [Ev3Commands](#Ev3Commands)
* [Ev3GyroSensor](#Ev3GyroSensor)
* [Ev3Motors](#Ev3Motors)
* [Ev3Sound](#Ev3Sound)
* [Ev3TouchSensor](#Ev3TouchSensor)
* [Ev3UI](#Ev3UI)
* [Ev3UltrasonicSensor](#Ev3UltrasonicSensor)
* [Microbit](#Microbit)
* [NxtColorSensor](#NxtColorSensor)
* [NxtDirectCommands](#NxtDirectCommands)
* [NxtDrive](#NxtDrive)
* [NxtLightSensor](#NxtLightSensor)
* [NxtSoundSensor](#NxtSoundSensor)
* [NxtTouchSensor](#NxtTouchSensor)
* [NxtUltrasonicSensor](#NxtUltrasonicSensor)

## Ev3ColorSensor  {#Ev3ColorSensor}

![EV3 component icon](images/legoMindstormsEv3.png)

 A component that provides a high-level interface to a color sensor on a
 LEGO MINDSTORMS EV3 robot.



### Properties  {#Ev3ColorSensor-Properties}

{:.properties}

{:id="Ev3ColorSensor.AboveRangeEventEnabled" .boolean} *AboveRangeEventEnabled*
: Specifies whether the AboveRange event should fire when the light level
 goes above the TopOfRange.

{:id="Ev3ColorSensor.BelowRangeEventEnabled" .boolean} *BelowRangeEventEnabled*
: Specifies whether the BelowRange event should fire when the light level
 goes below the BottomOfRange.

{:id="Ev3ColorSensor.BluetoothClient" .component} *BluetoothClient*
: Specifies the BluetoothClient component that should be used for communication.
 **Must be set in the Designer**.

{:id="Ev3ColorSensor.BottomOfRange" .number} *BottomOfRange*
: Specifies the bottom of the range used for the BelowRange, WithinRange,
 and AboveRange events.

{:id="Ev3ColorSensor.ColorChangedEventEnabled" .boolean} *ColorChangedEventEnabled*
: Specifies whether the ColorChanged event should fire when the DetectColor
 property is set to True and the detected color changes

{:id="Ev3ColorSensor.Mode" .text} *Mode*
: The current mode of the sensor. One of:
     Reflected: Senses the current light level including light reflected by the sensor.
     Ambient: Senses the current light level *not* including light reflected by the sensor.
     Color: Senses the color the sensor is pointing at.

{:id="Ev3ColorSensor.SensorPort" .text .do} *SensorPort*
: Specifies the sensor port that the sensor is connected to.
 **Must be set in the Designer.**

{:id="Ev3ColorSensor.TopOfRange" .number} *TopOfRange*
: Specifies the top of the range used for the BelowRange, WithinRange, and
 AboveRange events.

{:id="Ev3ColorSensor.WithinRangeEventEnabled" .boolean} *WithinRangeEventEnabled*
: Specifies whether the WithinRange event should fire when the light level
 goes between the BottomOfRange and the TopOfRange.

### Events  {#Ev3ColorSensor-Events}

{:.events}

{:id="Ev3ColorSensor.AboveRange"} AboveRange()
: Light level has gone above the range.

{:id="Ev3ColorSensor.BelowRange"} BelowRange()
: Light level has gone below the range.

{:id="Ev3ColorSensor.ColorChanged"} ColorChanged(*colorCode*{:.number},*colorName*{:.text})
: Called when the detected color has changed.

{:id="Ev3ColorSensor.WithinRange"} WithinRange()
: Light level has gone within the range.

### Methods  {#Ev3ColorSensor-Methods}

{:.methods}

{:id="Ev3ColorSensor.GetColorCode" class="method returns number"} <i/> GetColorCode()
: It returns the color code for the detected color.

{:id="Ev3ColorSensor.GetColorName" class="method returns text"} <i/> GetColorName()
: Returns the name of the detected color.

{:id="Ev3ColorSensor.GetLightLevel" class="method returns number"} <i/> GetLightLevel()
: It returns the light level in percentage.

## Ev3Commands  {#Ev3Commands}

![EV3 component icon](images/legoMindstormsEv3.png)

 A component that provides a low-level interface to a LEGO MINDSTORMS EV3
 robot, with functions to send system or direct commands to EV3 robots.



### Properties  {#Ev3Commands-Properties}

{:.properties}

{:id="Ev3Commands.BluetoothClient" .component} *BluetoothClient*
: Specifies the BluetoothClient component that should be used for communication.
 **Must be set in the Designer**.

### Events  {#Ev3Commands-Events}

{:.events}
None


### Methods  {#Ev3Commands-Methods}

{:.methods}

{:id="Ev3Commands.GetBatteryCurrent" class="method returns number"} <i/> GetBatteryCurrent()
: Get the battery current.

{:id="Ev3Commands.GetBatteryVoltage" class="method returns number"} <i/> GetBatteryVoltage()
: Get the battery voltage.

{:id="Ev3Commands.GetFirmwareBuild" class="method returns text"} <i/> GetFirmwareBuild()
: Get the firmware build on EV3.

{:id="Ev3Commands.GetFirmwareVersion" class="method returns text"} <i/> GetFirmwareVersion()
: Get the firmware version on EV3.

{:id="Ev3Commands.GetHardwareVersion" class="method returns text"} <i/> GetHardwareVersion()
: Get the hardware version of EV3.

{:id="Ev3Commands.GetOSBuild" class="method returns text"} <i/> GetOSBuild()
: Get the OS build on EV3.

{:id="Ev3Commands.GetOSVersion" class="method returns text"} <i/> GetOSVersion()
: Get the OS version on EV3.

{:id="Ev3Commands.KeepAlive" class="method"} <i/> KeepAlive(*minutes*{:.number})
: Keep the EV3 brick from shutdown for a period of time.

## Ev3GyroSensor  {#Ev3GyroSensor}

![EV3 component icon](images/legoMindstormsEv3.png)

 A component that provides a high-level interface to a gyro sensor on a LEGO
 MINDSTORMS EV3 robot.



### Properties  {#Ev3GyroSensor-Properties}

{:.properties}

{:id="Ev3GyroSensor.BluetoothClient" .component} *BluetoothClient*
: Specifies the BluetoothClient component that should be used for communication.
 **Must be set in the Designer**.

{:id="Ev3GyroSensor.Mode" .text} *Mode*
: Returns the mode of the sensor.

{:id="Ev3GyroSensor.SensorPort" .text .do} *SensorPort*
: Specifies the sensor port that the sensor is connected to.
 **Must be set in the Designer.**

{:id="Ev3GyroSensor.SensorValueChangedEventEnabled" .boolean} *SensorValueChangedEventEnabled*
: Returns whether the SensorValueChanged event should fire when the sensor value changed.

### Events  {#Ev3GyroSensor-Events}

{:.events}

{:id="Ev3GyroSensor.SensorValueChanged"} SensorValueChanged(*sensorValue*{:.number})
: Called then the sensor value changed.

### Methods  {#Ev3GyroSensor-Methods}

{:.methods}

{:id="Ev3GyroSensor.GetSensorValue" class="method returns number"} <i/> GetSensorValue()
: Returns the current angle or rotation speed based on current mode,
 or -1 if the value cannot be read from sensor.

## Ev3Motors  {#Ev3Motors}

![EV3 component icon](images/legoMindstormsEv3.png)

 A component that provides both high- and low-level interfaces to
 control the motors on LEGO MINDSTORMS EV3.



### Properties  {#Ev3Motors-Properties}

{:.properties}

{:id="Ev3Motors.BluetoothClient" .component} *BluetoothClient*
: Specifies the BluetoothClient component that should be used for communication.
 **Must be set in the Designer**.

{:id="Ev3Motors.EnableSpeedRegulation" .boolean} *EnableSpeedRegulation*
: Returns whether to keep motor rotation at constant speed.

{:id="Ev3Motors.MotorPorts" .text .do} *MotorPorts*
: Specifies the motor port.

{:id="Ev3Motors.ReverseDirection" .boolean} *ReverseDirection*
: Returns if the direction of the motors is reversed.

{:id="Ev3Motors.StopBeforeDisconnect" .boolean} *StopBeforeDisconnect*
: Specifies whether to stop the drive motors before disconnecting.

{:id="Ev3Motors.TachoCountChangedEventEnabled" .boolean} *TachoCountChangedEventEnabled*
: Returns whether the TachoCountChanged event should fire when the motor angle is increaing.

{:id="Ev3Motors.WheelDiameter" .number .do} *WheelDiameter*
: Returns the diameter of the wheels attached on motors.

### Events  {#Ev3Motors-Events}

{:.events}

{:id="Ev3Motors.TachoCountChanged"} TachoCountChanged(*tachoCount*{:.number})
: Called when the tacho count has changed.

### Methods  {#Ev3Motors-Methods}

{:.methods}

{:id="Ev3Motors.GetTachoCount" class="method returns number"} <i/> GetTachoCount()
: Get the current tacho count.

{:id="Ev3Motors.ResetTachoCount" class="method"} <i/> ResetTachoCount()
: Set the current tacho count to zero.

{:id="Ev3Motors.RotateInDistance" class="method"} <i/> RotateInDistance(*power*{:.number},*distance*{:.number},*useBrake*{:.boolean})
: Rotate the motors in a distance.

{:id="Ev3Motors.RotateInDuration" class="method"} <i/> RotateInDuration(*power*{:.number},*milliseconds*{:.number},*useBrake*{:.boolean})
: Rotate the motors in a period of time.

{:id="Ev3Motors.RotateInTachoCounts" class="method"} <i/> RotateInTachoCounts(*power*{:.number},*tachoCounts*{:.number},*useBrake*{:.boolean})
: Rotate the motors in a number of tacho counts.

{:id="Ev3Motors.RotateIndefinitely" class="method"} <i/> RotateIndefinitely(*power*{:.number})
: Start to rotate the motors.

{:id="Ev3Motors.RotateSyncInDistance" class="method"} <i/> RotateSyncInDistance(*power*{:.number},*distance*{:.number},*turnRatio*{:.number},*useBrake*{:.boolean})
: Rotate the motors at the same speed for a distance in cm.

{:id="Ev3Motors.RotateSyncInDuration" class="method"} <i/> RotateSyncInDuration(*power*{:.number},*milliseconds*{:.number},*turnRatio*{:.number},*useBrake*{:.boolean})
: Rotate the motors at the same speed in a period of time.

{:id="Ev3Motors.RotateSyncInTachoCounts" class="method"} <i/> RotateSyncInTachoCounts(*power*{:.number},*tachoCounts*{:.number},*turnRatio*{:.number},*useBrake*{:.boolean})
: Rotate the motors at the same speed in a number of tacho counts.

{:id="Ev3Motors.RotateSyncIndefinitely" class="method"} <i/> RotateSyncIndefinitely(*power*{:.number},*turnRatio*{:.number})
: Start to rotate the motors at the same speed.

{:id="Ev3Motors.Stop" class="method"} <i/> Stop(*useBrake*{:.boolean})
: Stop the motors of the robot.

{:id="Ev3Motors.ToggleDirection" class="method"} <i/> ToggleDirection()
: Toggle the direction of motors.

## Ev3Sound  {#Ev3Sound}

![EV3 component icon](images/legoMindstormsEv3.png)

 A component that provides a high-level interface to a LEGO MINDSTORMS EV3
 robot, which provides sound functionalities.



### Properties  {#Ev3Sound-Properties}

{:.properties}

{:id="Ev3Sound.BluetoothClient" .component} *BluetoothClient*
: Specifies the BluetoothClient component that should be used for communication.
 **Must be set in the Designer**.

### Events  {#Ev3Sound-Events}

{:.events}
None


### Methods  {#Ev3Sound-Methods}

{:.methods}

{:id="Ev3Sound.PlayTone" class="method"} <i/> PlayTone(*volume*{:.number},*frequency*{:.number},*milliseconds*{:.number})
: Make the robot play a tone.

{:id="Ev3Sound.StopSound" class="method"} <i/> StopSound()
: Stop any sound on the robot.

## Ev3TouchSensor  {#Ev3TouchSensor}

![EV3 component icon](images/legoMindstormsEv3.png)

 A component that provides a high-level interface to a touch sensor on a LEGO
 MINDSTORMS EV3 robot.



### Properties  {#Ev3TouchSensor-Properties}

{:.properties}

{:id="Ev3TouchSensor.BluetoothClient" .component} *BluetoothClient*
: Specifies the BluetoothClient component that should be used for communication.
 **Must be set in the Designer**.

{:id="Ev3TouchSensor.PressedEventEnabled" .boolean} *PressedEventEnabled*
: Returns whether the Pressed event should fire when the touch sensor is
 pressed.

{:id="Ev3TouchSensor.ReleasedEventEnabled" .boolean} *ReleasedEventEnabled*
: Specifies whether the Released event should fire when the touch sensor is
 released.

{:id="Ev3TouchSensor.SensorPort" .text .do} *SensorPort*
: Specifies the sensor port that the sensor is connected to.
 **Must be set in the Designer.**

### Events  {#Ev3TouchSensor-Events}

{:.events}

{:id="Ev3TouchSensor.Pressed"} Pressed()
: Called when the touch sensor is pressed.

{:id="Ev3TouchSensor.Released"} Released()
: Called when the touch sensor is pressed.

### Methods  {#Ev3TouchSensor-Methods}

{:.methods}

{:id="Ev3TouchSensor.IsPressed" class="method returns boolean"} <i/> IsPressed()
: Returns true if the touch sensor is pressed.

## Ev3UI  {#Ev3UI}

![EV3 component icon](images/legoMindstormsEv3.png)

 A component that provides a high-level interface to a LEGO MINDSTORMS EV3
 robot, which provides graphic functionalities.



### Properties  {#Ev3UI-Properties}

{:.properties}

{:id="Ev3UI.BluetoothClient" .component} *BluetoothClient*
: Specifies the BluetoothClient component that should be used for communication.
 **Must be set in the Designer**.

### Events  {#Ev3UI-Events}

{:.events}
None


### Methods  {#Ev3UI-Methods}

{:.methods}

{:id="Ev3UI.DrawCircle" class="method"} <i/> DrawCircle(*color*{:.number},*x*{:.number},*y*{:.number},*radius*{:.number},*fill*{:.boolean})
: Draw a circle on the screen.

{:id="Ev3UI.DrawIcon" class="method"} <i/> DrawIcon(*color*{:.number},*x*{:.number},*y*{:.number},*type*{:.number},*no*{:.number})
: Draw a built-in icon on screen.

{:id="Ev3UI.DrawLine" class="method"} <i/> DrawLine(*color*{:.number},*x1*{:.number},*y1*{:.number},*x2*{:.number},*y2*{:.number})
: Draw a line on the screen.

{:id="Ev3UI.DrawPoint" class="method"} <i/> DrawPoint(*color*{:.number},*x*{:.number},*y*{:.number})
: Draw a point on the screen.

{:id="Ev3UI.DrawRect" class="method"} <i/> DrawRect(*color*{:.number},*x*{:.number},*y*{:.number},*width*{:.number},*height*{:.number},*fill*{:.boolean})
: Draw a rectangle on the screen.

{:id="Ev3UI.FillScreen" class="method"} <i/> FillScreen(*color*{:.number})
: Fill the screen with a color.

## Ev3UltrasonicSensor  {#Ev3UltrasonicSensor}

![EV3 component icon](images/legoMindstormsEv3.png)

 A component that provides a high-level interface to an ultrasonic sensor on a LEGO
 MINDSTORMS EV3 robot.



### Properties  {#Ev3UltrasonicSensor-Properties}

{:.properties}

{:id="Ev3UltrasonicSensor.AboveRangeEventEnabled" .boolean} *AboveRangeEventEnabled*
: Specifies whether the AboveRange event should fire when the distance
 goes above the TopOfRange.

{:id="Ev3UltrasonicSensor.BelowRangeEventEnabled" .boolean} *BelowRangeEventEnabled*
: Specifies whether the BelowRange event should fire when the distance
 goes below the BottomOfRange.

{:id="Ev3UltrasonicSensor.BluetoothClient" .component} *BluetoothClient*
: Specifies the BluetoothClient component that should be used for communication.
 **Must be set in the Designer**.

{:id="Ev3UltrasonicSensor.BottomOfRange" .number} *BottomOfRange*
: Specifies the bottom of the range used for the BelowRange, WithinRange,
 and AboveRange events.

{:id="Ev3UltrasonicSensor.SensorPort" .text .do} *SensorPort*
: Specifies the sensor port that the sensor is connected to.
 **Must be set in the Designer.**

{:id="Ev3UltrasonicSensor.TopOfRange" .number} *TopOfRange*
: Specifies the top of the range used for the BelowRange, WithinRange, and
 AboveRange events.

{:id="Ev3UltrasonicSensor.Unit" .text} *Unit*
: Returns the unit of distance.

{:id="Ev3UltrasonicSensor.WithinRangeEventEnabled" .boolean} *WithinRangeEventEnabled*
: Specifies whether the WithinRange event should fire when the distance
 goes between the BottomOfRange and the TopOfRange.

### Events  {#Ev3UltrasonicSensor-Events}

{:.events}

{:id="Ev3UltrasonicSensor.AboveRange"} AboveRange()
: Called when the detected distance has gone above the range.

{:id="Ev3UltrasonicSensor.BelowRange"} BelowRange()
: Called when the detected distance has gone below the range.

{:id="Ev3UltrasonicSensor.WithinRange"} WithinRange()
: Called when the detected distance has gone within the range.

### Methods  {#Ev3UltrasonicSensor-Methods}

{:.methods}

{:id="Ev3UltrasonicSensor.GetDistance" class="method returns number"} <i/> GetDistance()
: Returns the current distance in centimeters as a value between 0 and 254, or -1 if the distance can not be read.

## Microbit  {#Microbit}

Component for Microbit



### Properties  {#Microbit-Properties}

{:.properties}

{:id="Microbit.BluetoothDevice" .component} *BluetoothDevice*
: The BluetoothLE component connected to the micro:bit device.

### Events  {#Microbit-Events}

{:.events}

{:id="Microbit.AccelerometerDataReceived"} AccelerometerDataReceived(*Accelerometer_X_*{:.number},*Accelerometer_Y*{:.number},*Accelerometer_Z*{:.number})
: Event for AccelerometerDataReceived

{:id="Microbit.AccelerometerPeriodReceived"} AccelerometerPeriodReceived(*Accelerometer_Period*{:.number})
: Event for AccelerometerPeriodReceived

{:id="Microbit.AppearanceReceived"} AppearanceReceived(*Category*{:.number})
: Event for AppearanceReceived

{:id="Microbit.ButtonAStateReceived"} ButtonAStateReceived(*Button_State_Value*{:.number})
: Event for ButtonAStateReceived

{:id="Microbit.ButtonBStateReceived"} ButtonBStateReceived(*Button_State_Value*{:.number})
: Event for ButtonBStateReceived

{:id="Microbit.DFUControlReceived"} DFUControlReceived(*dfu_control*{:.number})
: Event for DFUControlReceived

{:id="Microbit.DeviceNameReceived"} DeviceNameReceived(*Name*{:.text})
: Event for DeviceNameReceived

{:id="Microbit.FirmwareRevisionStringReceived"} FirmwareRevisionStringReceived(*Firmware_Revision*{:.text})
: Event for FirmwareRevisionStringReceived

{:id="Microbit.HardwareRevisionStringReceived"} HardwareRevisionStringReceived(*Hardware_Revision*{:.text})
: Event for HardwareRevisionStringReceived

{:id="Microbit.LEDMatrixStateReceived"} LEDMatrixStateReceived(*LED_Matrix_State*{:.list})
: Event for LEDMatrixStateReceived

{:id="Microbit.MagnetometerBearingReceived"} MagnetometerBearingReceived(*bearing_value*{:.number})
: Event for MagnetometerBearingReceived

{:id="Microbit.MagnetometerDataReceived"} MagnetometerDataReceived(*Magnetometer_X*{:.number},*Magnetometer_Y*{:.number},*Magnetometer_Z*{:.number})
: Event for MagnetometerDataReceived

{:id="Microbit.MagnetometerPeriodReceived"} MagnetometerPeriodReceived(*Magnetometer_Period*{:.number})
: Event for MagnetometerPeriodReceived

{:id="Microbit.ManufacturerNameStringReceived"} ManufacturerNameStringReceived(*Manufacturer_Name*{:.text})
: Event for ManufacturerNameStringReceived

{:id="Microbit.MicroBitEventReceived"} MicroBitEventReceived(*Event_Type_And_Value*{:.number})
: Event for MicroBitEventReceived

{:id="Microbit.MicroBitRequirementsReceived"} MicroBitRequirementsReceived(*microbit_reqs_value*{:.number})
: Event for MicroBitRequirementsReceived

{:id="Microbit.ModelNumberStringReceived"} ModelNumberStringReceived(*Model_Number*{:.text})
: Event for ModelNumberStringReceived

{:id="Microbit.PeripheralPreferredConnectionParametersReceived"} PeripheralPreferredConnectionParametersReceived(*Minimum_Connection_Interval*{:.number},*Maximum_Connection_Interval*{:.number},*Slave_Latency*{:.number},*Connection_Supervision_Timeout_Multiplier*{:.number})
: Event for PeripheralPreferredConnectionParametersReceived

{:id="Microbit.PinADConfigurationReceived"} PinADConfigurationReceived(*Pin_AD_Config_Value*{:.list})
: Event for PinADConfigurationReceived

{:id="Microbit.PinDataReceived"} PinDataReceived(*IO_Pin_Data*{:.list})
: Event for PinDataReceived

{:id="Microbit.PinIOConfigurationReceived"} PinIOConfigurationReceived(*Pin_IO_Config_Value*{:.list})
: Event for PinIOConfigurationReceived

{:id="Microbit.ScrollingDelayReceived"} ScrollingDelayReceived(*Scrolling_Delay_Value*{:.number})
: Event for ScrollingDelayReceived

{:id="Microbit.SerialNumberStringReceived"} SerialNumberStringReceived(*Serial_Number*{:.text})
: Event for SerialNumberStringReceived

{:id="Microbit.TXCharacteristicReceived"} TXCharacteristicReceived(*UART_TX_Field*{:.list})
: Event for TXCharacteristicReceived

{:id="Microbit.TemperaturePeriodReceived"} TemperaturePeriodReceived(*temperature_period_value*{:.number})
: Event for TemperaturePeriodReceived

{:id="Microbit.TemperatureReceived"} TemperatureReceived(*temperature_value*{:.number})
: Event for TemperatureReceived

{:id="Microbit.WroteAccelerometerPeriod"} WroteAccelerometerPeriod(*Accelerometer_Period*{:.number})
: Event for WroteAccelerometerPeriod

{:id="Microbit.WroteClientEvent"} WroteClientEvent(*Event_Types_And_Values*{:.number})
: Event for WroteClientEvent

{:id="Microbit.WroteClientRequirements"} WroteClientRequirements(*Client_Requirements_Value*{:.number})
: Event for WroteClientRequirements

{:id="Microbit.WroteDFUControl"} WroteDFUControl(*dfu_control*{:.number})
: Event for WroteDFUControl

{:id="Microbit.WroteDeviceName"} WroteDeviceName(*Name*{:.text})
: Event for WroteDeviceName

{:id="Microbit.WroteLEDMatrixState"} WroteLEDMatrixState(*LED_Matrix_State*{:.list})
: Event for WroteLEDMatrixState

{:id="Microbit.WroteLEDText"} WroteLEDText(*LED_Text_Value*{:.text})
: Event for WroteLEDText

{:id="Microbit.WroteMagnetometerPeriod"} WroteMagnetometerPeriod(*Magnetometer_Period*{:.number})
: Event for WroteMagnetometerPeriod

{:id="Microbit.WrotePWMControl"} WrotePWMControl(*PWM_Control_Field*{:.list})
: Event for WrotePWMControl

{:id="Microbit.WrotePinADConfiguration"} WrotePinADConfiguration(*Pin_AD_Config_Value*{:.list})
: Event for WrotePinADConfiguration

{:id="Microbit.WrotePinData"} WrotePinData(*IO_Pin_Data*{:.list})
: Event for WrotePinData

{:id="Microbit.WrotePinIOConfiguration"} WrotePinIOConfiguration(*Pin_IO_Config_Value*{:.list})
: Event for WrotePinIOConfiguration

{:id="Microbit.WroteRXCharacteristic"} WroteRXCharacteristic(*UART_TX_Field*{:.list})
: Event for WroteRXCharacteristic

{:id="Microbit.WroteScrollingDelay"} WroteScrollingDelay(*Scrolling_Delay_Value*{:.number})
: Event for WroteScrollingDelay

{:id="Microbit.WroteTemperaturePeriod"} WroteTemperaturePeriod(*temperature_period_value*{:.number})
: Event for WroteTemperaturePeriod

### Methods  {#Microbit-Methods}

{:.methods}

{:id="Microbit.ReadAccelerometerData" class="method"} <i/> ReadAccelerometerData()
: Method for ReadAccelerometerData

{:id="Microbit.ReadAccelerometerPeriod" class="method"} <i/> ReadAccelerometerPeriod()
: Method for ReadAccelerometerPeriod

{:id="Microbit.ReadAppearance" class="method"} <i/> ReadAppearance()
: Method for ReadAppearance

{:id="Microbit.ReadButtonAState" class="method"} <i/> ReadButtonAState()
: Method for ReadButtonAState

{:id="Microbit.ReadButtonBState" class="method"} <i/> ReadButtonBState()
: Method for ReadButtonBState

{:id="Microbit.ReadDFUControl" class="method"} <i/> ReadDFUControl()
: Method for ReadDFUControl

{:id="Microbit.ReadDeviceName" class="method"} <i/> ReadDeviceName()
: Method for ReadDeviceName

{:id="Microbit.ReadFirmwareRevisionString" class="method"} <i/> ReadFirmwareRevisionString()
: Method for ReadFirmwareRevisionString

{:id="Microbit.ReadHardwareRevisionString" class="method"} <i/> ReadHardwareRevisionString()
: Method for ReadHardwareRevisionString

{:id="Microbit.ReadLEDMatrixState" class="method"} <i/> ReadLEDMatrixState()
: Method for ReadLEDMatrixState

{:id="Microbit.ReadMagnetometerBearing" class="method"} <i/> ReadMagnetometerBearing()
: Method for ReadMagnetometerBearing

{:id="Microbit.ReadMagnetometerData" class="method"} <i/> ReadMagnetometerData()
: Method for ReadMagnetometerData

{:id="Microbit.ReadMagnetometerPeriod" class="method"} <i/> ReadMagnetometerPeriod()
: Method for ReadMagnetometerPeriod

{:id="Microbit.ReadManufacturerNameString" class="method"} <i/> ReadManufacturerNameString()
: Method for ReadManufacturerNameString

{:id="Microbit.ReadMicroBitEvent" class="method"} <i/> ReadMicroBitEvent()
: Method for ReadMicroBitEvent

{:id="Microbit.ReadMicroBitRequirements" class="method"} <i/> ReadMicroBitRequirements()
: Method for ReadMicroBitRequirements

{:id="Microbit.ReadModelNumberString" class="method"} <i/> ReadModelNumberString()
: Method for ReadModelNumberString

{:id="Microbit.ReadPeripheralPreferredConnectionParameters" class="method"} <i/> ReadPeripheralPreferredConnectionParameters()
: Method for ReadPeripheralPreferredConnectionParameters

{:id="Microbit.ReadPinADConfiguration" class="method"} <i/> ReadPinADConfiguration()
: Method for ReadPinADConfiguration

{:id="Microbit.ReadPinData" class="method"} <i/> ReadPinData()
: Method for ReadPinData

{:id="Microbit.ReadPinIOConfiguration" class="method"} <i/> ReadPinIOConfiguration()
: Method for ReadPinIOConfiguration

{:id="Microbit.ReadScrollingDelay" class="method"} <i/> ReadScrollingDelay()
: Method for ReadScrollingDelay

{:id="Microbit.ReadSerialNumberString" class="method"} <i/> ReadSerialNumberString()
: Method for ReadSerialNumberString

{:id="Microbit.ReadTemperature" class="method"} <i/> ReadTemperature()
: Method for ReadTemperature

{:id="Microbit.ReadTemperaturePeriod" class="method"} <i/> ReadTemperaturePeriod()
: Method for ReadTemperaturePeriod

{:id="Microbit.RequestAccelerometerDataUpdates" class="method"} <i/> RequestAccelerometerDataUpdates()
: Method for RequestAccelerometerDataUpdates

{:id="Microbit.RequestButtonAStateUpdates" class="method"} <i/> RequestButtonAStateUpdates()
: Method for RequestButtonAStateUpdates

{:id="Microbit.RequestButtonBStateUpdates" class="method"} <i/> RequestButtonBStateUpdates()
: Method for RequestButtonBStateUpdates

{:id="Microbit.RequestMagnetometerBearingUpdates" class="method"} <i/> RequestMagnetometerBearingUpdates()
: Method for RequestMagnetometerBearingUpdates

{:id="Microbit.RequestMagnetometerDataUpdates" class="method"} <i/> RequestMagnetometerDataUpdates()
: Method for RequestMagnetometerDataUpdates

{:id="Microbit.RequestMicroBitEventUpdates" class="method"} <i/> RequestMicroBitEventUpdates()
: Method for RequestMicroBitEventUpdates

{:id="Microbit.RequestMicroBitRequirementsUpdates" class="method"} <i/> RequestMicroBitRequirementsUpdates()
: Method for RequestMicroBitRequirementsUpdates

{:id="Microbit.RequestPinDataUpdates" class="method"} <i/> RequestPinDataUpdates()
: Method for RequestPinDataUpdates

{:id="Microbit.RequestTXCharacteristic" class="method"} <i/> RequestTXCharacteristic()
: Method for RequestTXCharacteristic

{:id="Microbit.RequestTemperatureUpdates" class="method"} <i/> RequestTemperatureUpdates()
: Method for RequestTemperatureUpdates

{:id="Microbit.StopAccelerometerDataUpdates" class="method"} <i/> StopAccelerometerDataUpdates()
: Method for StopAccelerometerDataUpdates

{:id="Microbit.StopButtonAStateUpdates" class="method"} <i/> StopButtonAStateUpdates()
: Method for StopButtonAStateUpdates

{:id="Microbit.StopButtonBStateUpdates" class="method"} <i/> StopButtonBStateUpdates()
: Method for StopButtonBStateUpdates

{:id="Microbit.StopMagnetometerBearingUpdates" class="method"} <i/> StopMagnetometerBearingUpdates()
: Method for StopMagnetometerBearingUpdates

{:id="Microbit.StopMagnetometerDataUpdates" class="method"} <i/> StopMagnetometerDataUpdates()
: Method for StopMagnetometerDataUpdates

{:id="Microbit.StopMicroBitEventUpdates" class="method"} <i/> StopMicroBitEventUpdates()
: Method for StopMicroBitEventUpdates

{:id="Microbit.StopMicroBitRequirementsUpdates" class="method"} <i/> StopMicroBitRequirementsUpdates()
: Method for StopMicroBitRequirementsUpdates

{:id="Microbit.StopPinDataUpdates" class="method"} <i/> StopPinDataUpdates()
: Method for StopPinDataUpdates

{:id="Microbit.StopTXCharacteristicUpdates" class="method"} <i/> StopTXCharacteristicUpdates()
: Method for StopTXCharacteristicUpdates

{:id="Microbit.StopTemperatureUpdates" class="method"} <i/> StopTemperatureUpdates()
: Method for StopTemperatureUpdates

{:id="Microbit.WriteAccelerometerPeriod" class="method"} <i/> WriteAccelerometerPeriod(*value*{:.number})
: Method for WriteAccelerometerPeriod

{:id="Microbit.WriteClientEvent" class="method"} <i/> WriteClientEvent(*Event_Types_And_Values*{:.any})
: Method for WriteClientEvent

{:id="Microbit.WriteClientRequirements" class="method"} <i/> WriteClientRequirements(*client_requirements_value*{:.any})
: Method for WriteClientRequirements

{:id="Microbit.WriteDFUControl" class="method"} <i/> WriteDFUControl(*dfu_control*{:.number})
: Method for WriteDFUControl

{:id="Microbit.WriteDeviceName" class="method"} <i/> WriteDeviceName(*name*{:.text})
: Method for WriteDeviceName

{:id="Microbit.WriteLEDMatrixState" class="method"} <i/> WriteLEDMatrixState(*LED_Matrix_State*{:.any})
: Method for WriteLEDMatrixState

{:id="Microbit.WriteLEDText" class="method"} <i/> WriteLEDText(*LED_Text_Value*{:.text})
: Method for WriteLEDText

{:id="Microbit.WriteMagnetometerPeriod" class="method"} <i/> WriteMagnetometerPeriod(*Magnetometer_Period*{:.number})
: Method for WriteMagnetometerPeriod

{:id="Microbit.WritePWMControl" class="method"} <i/> WritePWMControl(*PWM_Control_Field*{:.any})
: Method for WritePWMControl

{:id="Microbit.WritePinADConfiguration" class="method"} <i/> WritePinADConfiguration(*Pin_AD_Config_Value*{:.any})
: Method for WritePinADConfiguration

{:id="Microbit.WritePinData" class="method"} <i/> WritePinData(*IO_Pin_Data*{:.any})
: Method for WritePinData

{:id="Microbit.WritePinIOConfiguration" class="method"} <i/> WritePinIOConfiguration(*Pin_IO_Config_Value*{:.any})
: Method for WritePinIOConfiguration

{:id="Microbit.WriteRXCharacteristic" class="method"} <i/> WriteRXCharacteristic(*UART_TX*{:.any})
: Method for WriteRXCharacteristic

{:id="Microbit.WriteScrollingDelay" class="method"} <i/> WriteScrollingDelay(*Scrolling_Delay_Value*{:.number})
: Method for WriteScrollingDelay

{:id="Microbit.WriteTemperaturePeriod" class="method"} <i/> WriteTemperaturePeriod(*value*{:.number})
: Method for WriteTemperaturePeriod

## NxtColorSensor  {#NxtColorSensor}

![NXT component icon](images/legoMindstormsNxt.png)

 A component that provides a high-level interface to a color sensor on a LEGO
 MINDSTORMS NXT robot.



### Properties  {#NxtColorSensor-Properties}

{:.properties}

{:id="NxtColorSensor.AboveRangeEventEnabled" .boolean} *AboveRangeEventEnabled*
: Specifies whether the AboveRange event should fire when the DetectColor
 property is set to False and the light level goes above the TopOfRange.

{:id="NxtColorSensor.BelowRangeEventEnabled" .boolean} *BelowRangeEventEnabled*
: Specifies whether the BelowRange event should fire when the DetectColor
 property is set to False and the light level goes below the BottomOfRange.

{:id="NxtColorSensor.BluetoothClient" .component .do} *BluetoothClient*
: Specifies the BluetoothClient component that should be used for communication.
 **Must be set in the Designer.**

{:id="NxtColorSensor.BottomOfRange" .number} *BottomOfRange*
: Specifies the bottom of the range used for the BelowRange, WithinRange,
 and AboveRange events.

{:id="NxtColorSensor.ColorChangedEventEnabled" .boolean} *ColorChangedEventEnabled*
: Specifies whether the ColorChanged event should fire when the DetectColor
 property is set to True and the detected color changes

{:id="NxtColorSensor.DetectColor" .boolean} *DetectColor*
: Specifies whether the sensor should detect color light. True indicates
 that the sensor should detect color; False indicates that the sensor
 should detect light.

{:id="NxtColorSensor.GenerateColor" .number} *GenerateColor*
: Specifies the color that should generated by the sensor.
 Only None, Red, Green, or Blue are valid values.
 The sensor will not generate color when the DetectColor property is set to
 True.

{:id="NxtColorSensor.SensorPort" .text .do} *SensorPort*
: Specifies the sensor port that the sensor is connected to.
 **Must be set in the Designer.**

{:id="NxtColorSensor.TopOfRange" .number} *TopOfRange*
: Specifies the top of the range used for the BelowRange, WithinRange, and
 AboveRange events.

{:id="NxtColorSensor.WithinRangeEventEnabled" .boolean} *WithinRangeEventEnabled*
: Specifies whether the WithinRange event should fire when the DetectColor
 property is set to False and the light level goes between the
 BottomOfRange and the TopOfRange.

### Events  {#NxtColorSensor-Events}

{:.events}

{:id="NxtColorSensor.AboveRange"} AboveRange()
: Light level has gone above the range. The AboveRange event will not occur if the DetectColor property is set to True or if the AboveRangeEventEnabled property is set to False.

{:id="NxtColorSensor.BelowRange"} BelowRange()
: Light level has gone below the range. The BelowRange event will not occur if the DetectColor property is set to True or if the BelowRangeEventEnabled property is set to False.

{:id="NxtColorSensor.ColorChanged"} ColorChanged(*color*{:.number})
: Detected color has changed. The ColorChanged event will not occur if the DetectColor property is set to False or if the ColorChangedEventEnabled property is set to False.

{:id="NxtColorSensor.WithinRange"} WithinRange()
: Light level has gone within the range. The WithinRange event will not occur if the DetectColor property is set to True or if the WithinRangeEventEnabled property is set to False.

### Methods  {#NxtColorSensor-Methods}

{:.methods}

{:id="NxtColorSensor.GetColor" class="method returns number"} <i/> GetColor()
: Returns the current detected color, or the color None if the color can not be read or if the DetectColor property is set to False.

{:id="NxtColorSensor.GetLightLevel" class="method returns number"} <i/> GetLightLevel()
: Returns the current light level as a value between 0 and 1023, or -1 if the light level can not be read or if the DetectColor property is set to True.

## NxtDirectCommands  {#NxtDirectCommands}

![NXT component icon](images/legoMindstormsNxt.png)

 A component that provides a low-level interface to a LEGO MINDSTORMS NXT
 robot, with functions to send NXT Direct Commands.



### Properties  {#NxtDirectCommands-Properties}

{:.properties}

{:id="NxtDirectCommands.BluetoothClient" .component .do} *BluetoothClient*
: Specifies the BluetoothClient component that should be used for communication.
 **Must be set in the Designer.**

### Events  {#NxtDirectCommands-Events}

{:.events}
None


### Methods  {#NxtDirectCommands-Methods}

{:.methods}

{:id="NxtDirectCommands.DeleteFile" class="method"} <i/> DeleteFile(*fileName*{:.text})
: Delete a file on the robot.

{:id="NxtDirectCommands.DownloadFile" class="method"} <i/> DownloadFile(*source*{:.text},*destination*{:.text})
: Download a file to the robot.

 <p/>See [`MediaUtil`'s `determineMediaSource`](#MediaUtil.determineMediaSource) for information about what
 a path can be.

{:id="NxtDirectCommands.GetBatteryLevel" class="method returns number"} <i/> GetBatteryLevel()
: Get the battery level for the robot. Returns the voltage in millivolts.

{:id="NxtDirectCommands.GetBrickName" class="method returns text"} <i/> GetBrickName()
: Get the brick name of the robot.

{:id="NxtDirectCommands.GetCurrentProgramName" class="method returns text"} <i/> GetCurrentProgramName()
: Get the name of currently running program on the robot.

{:id="NxtDirectCommands.GetFirmwareVersion" class="method returns list"} <i/> GetFirmwareVersion()
: Get the firmware and protocol version numbers for the robot as a list where the first element is the firmware version number and the second element is the protocol version number.

{:id="NxtDirectCommands.GetInputValues" class="method returns list"} <i/> GetInputValues(*sensorPortLetter*{:.text})
: Reads the values of an input sensor on the robot. Assumes sensor type has been configured via SetInputMode.

{:id="NxtDirectCommands.GetOutputState" class="method returns list"} <i/> GetOutputState(*motorPortLetter*{:.text})
: Reads the output state of a motor on the robot.

{:id="NxtDirectCommands.KeepAlive" class="method returns number"} <i/> KeepAlive()
: Keep Alive. Returns the current sleep time limit in milliseconds.

{:id="NxtDirectCommands.ListFiles" class="method returns list"} <i/> ListFiles(*wildcard*{:.text})
: Returns a list containing the names of matching files found on the robot.

{:id="NxtDirectCommands.LsGetStatus" class="method returns number"} <i/> LsGetStatus(*sensorPortLetter*{:.text})
: Returns the count of available bytes to read.

{:id="NxtDirectCommands.LsRead" class="method returns list"} <i/> LsRead(*sensorPortLetter*{:.text})
: Reads unsigned low speed data from an input sensor on the robot. Assumes sensor type has been configured via SetInputMode.

{:id="NxtDirectCommands.LsWrite" class="method"} <i/> LsWrite(*sensorPortLetter*{:.text},*list*{:.list},*rxDataLength*{:.number})
: Writes low speed data to an input sensor on the robot. Assumes sensor type has been configured via SetInputMode.

{:id="NxtDirectCommands.MessageRead" class="method returns text"} <i/> MessageRead(*mailbox*{:.number})
: Read a message from a mailbox (1-10) on the robot.

{:id="NxtDirectCommands.MessageWrite" class="method"} <i/> MessageWrite(*mailbox*{:.number},*message*{:.text})
: Write a message to a mailbox (1-10) on the robot.

{:id="NxtDirectCommands.PlaySoundFile" class="method"} <i/> PlaySoundFile(*fileName*{:.text})
: Play a sound file on the robot.

{:id="NxtDirectCommands.PlayTone" class="method"} <i/> PlayTone(*frequencyHz*{:.number},*durationMs*{:.number})
: Make the robot play a tone.

{:id="NxtDirectCommands.ResetInputScaledValue" class="method"} <i/> ResetInputScaledValue(*sensorPortLetter*{:.text})
: Reset the scaled value of an input sensor on the robot.

{:id="NxtDirectCommands.ResetMotorPosition" class="method"} <i/> ResetMotorPosition(*motorPortLetter*{:.text},*relative*{:.boolean})
: Reset motor position.

{:id="NxtDirectCommands.SetBrickName" class="method"} <i/> SetBrickName(*name*{:.text})
: Set the brick name of the robot.

{:id="NxtDirectCommands.SetInputMode" class="method"} <i/> SetInputMode(*sensorPortLetter*{:.text},*sensorType*{:.number},*sensorMode*{:.number})
: Configure an input sensor on the robot.

{:id="NxtDirectCommands.SetOutputState" class="method"} <i/> SetOutputState(*motorPortLetter*{:.text},*power*{:.number},*mode*{:.number},*regulationMode*{:.number},*turnRatio*{:.number},*runState*{:.number},*tachoLimit*{:.number})
: Sets the output state of a motor on the robot.

{:id="NxtDirectCommands.StartProgram" class="method"} <i/> StartProgram(*programName*{:.text})
: Start execution of a previously downloaded program on the robot.

{:id="NxtDirectCommands.StopProgram" class="method"} <i/> StopProgram()
: Stop execution of the currently running program on the robot.

{:id="NxtDirectCommands.StopSoundPlayback" class="method"} <i/> StopSoundPlayback()
: Stop sound playback.

## NxtDrive  {#NxtDrive}

![NXT component icon](images/legoMindstormsNxt.png)

 A component that provides a high-level interface to a LEGO MINDSTORMS NXT
 robot, with functions that can move and turn the robot.



### Properties  {#NxtDrive-Properties}

{:.properties}

{:id="NxtDrive.BluetoothClient" .component .do} *BluetoothClient*
: Specifies the BluetoothClient component that should be used for communication.
 **Must be set in the Designer.**

{:id="NxtDrive.DriveMotors" .text .do} *DriveMotors*
: Specifies the motor ports that are used for driving.

{:id="NxtDrive.StopBeforeDisconnect" .boolean} *StopBeforeDisconnect*
: Specifies whether to stop the drive motors before disconnecting.

{:id="NxtDrive.WheelDiameter" .number .do} *WheelDiameter*
: Returns the diameter of the wheels used for driving.

### Events  {#NxtDrive-Events}

{:.events}
None


### Methods  {#NxtDrive-Methods}

{:.methods}

{:id="NxtDrive.MoveBackward" class="method"} <i/> MoveBackward(*power*{:.number},*distance*{:.number})
: Move the robot backward the given distance, with the specified percentage of maximum power, by powering both drive motors backward.

{:id="NxtDrive.MoveBackwardIndefinitely" class="method"} <i/> MoveBackwardIndefinitely(*power*{:.number})
: Move the robot backward indefinitely, with the specified percentage of maximum power, by powering both drive motors backward.

{:id="NxtDrive.MoveForward" class="method"} <i/> MoveForward(*power*{:.number},*distance*{:.number})
: Move the robot forward the given distance, with the specified percentage of maximum power, by powering both drive motors forward.

{:id="NxtDrive.MoveForwardIndefinitely" class="method"} <i/> MoveForwardIndefinitely(*power*{:.number})
: Move the robot forward indefinitely, with the specified percentage of maximum power, by powering both drive motors forward.

{:id="NxtDrive.Stop" class="method"} <i/> Stop()
: Stop the drive motors of the robot.

{:id="NxtDrive.TurnClockwiseIndefinitely" class="method"} <i/> TurnClockwiseIndefinitely(*power*{:.number})
: Turn the robot clockwise indefinitely, with the specified percentage of maximum power, by powering the left drive motor forward and the right drive motor backward.

{:id="NxtDrive.TurnCounterClockwiseIndefinitely" class="method"} <i/> TurnCounterClockwiseIndefinitely(*power*{:.number})
: Turn the robot counterclockwise indefinitely, with the specified percentage of maximum power, by powering the right drive motor forward and the left drive motor backward.

## NxtLightSensor  {#NxtLightSensor}

![NXT component icon](images/legoMindstormsNxt.png)

 A component that provides a high-level interface to a light sensor on a LEGO
 MINDSTORMS NXT robot.



### Properties  {#NxtLightSensor-Properties}

{:.properties}

{:id="NxtLightSensor.AboveRangeEventEnabled" .boolean} *AboveRangeEventEnabled*
: Specifies whether the AboveRange event should fire when the light level
 goes above the TopOfRange.

{:id="NxtLightSensor.BelowRangeEventEnabled" .boolean} *BelowRangeEventEnabled*
: Specifies whether the BelowRange event should fire when the light level
 goes below the BottomOfRange.

{:id="NxtLightSensor.BluetoothClient" .component .do} *BluetoothClient*
: Specifies the BluetoothClient component that should be used for communication.
 **Must be set in the Designer.**

{:id="NxtLightSensor.BottomOfRange" .number} *BottomOfRange*
: Specifies the bottom of the range used for the BelowRange, WithinRange,
 and AboveRange events.

{:id="NxtLightSensor.GenerateLight" .boolean} *GenerateLight*
: Specifies whether the light sensor should generate light.

{:id="NxtLightSensor.SensorPort" .text .do} *SensorPort*
: Specifies the sensor port that the sensor is connected to.
 **Must be specified in the Designer.**

{:id="NxtLightSensor.TopOfRange" .number} *TopOfRange*
: Specifies the top of the range used for the BelowRange, WithinRange, and
 AboveRange events.

{:id="NxtLightSensor.WithinRangeEventEnabled" .boolean} *WithinRangeEventEnabled*
: Specifies whether the WithinRange event should fire when the light level
 goes between the BottomOfRange and the TopOfRange.

### Events  {#NxtLightSensor-Events}

{:.events}

{:id="NxtLightSensor.AboveRange"} AboveRange()
: Light level has gone above the range.

{:id="NxtLightSensor.BelowRange"} BelowRange()
: Light level has gone below the range.

{:id="NxtLightSensor.WithinRange"} WithinRange()
: Light level has gone within the range.

### Methods  {#NxtLightSensor-Methods}

{:.methods}

{:id="NxtLightSensor.GetLightLevel" class="method returns number"} <i/> GetLightLevel()
: Returns the current light level as a value between 0 and 1023, or -1 if the light level can not be read.

## NxtSoundSensor  {#NxtSoundSensor}

![NXT component icon](images/legoMindstormsNxt.png)

 A component that provides a high-level interface to a sound sensor on a LEGO
 MINDSTORMS NXT robot.



### Properties  {#NxtSoundSensor-Properties}

{:.properties}

{:id="NxtSoundSensor.AboveRangeEventEnabled" .boolean} *AboveRangeEventEnabled*
: Specifies whether the AboveRange event should fire when the sound level
 goes above the TopOfRange.

{:id="NxtSoundSensor.BelowRangeEventEnabled" .boolean} *BelowRangeEventEnabled*
: Specifies whether the BelowRange event should fire when the sound level
 goes below the BottomOfRange.

{:id="NxtSoundSensor.BluetoothClient" .component .do} *BluetoothClient*
: Specifies the BluetoothClient component that should be used for communication.
 **Must be set in the Designer.**

{:id="NxtSoundSensor.BottomOfRange" .number} *BottomOfRange*
: Specifies the bottom of the range used for the BelowRange, WithinRange,
 and AboveRange events.

{:id="NxtSoundSensor.SensorPort" .text .do} *SensorPort*
: Specifies the sensor port that the sensor is connected to.
 **Must be set in the Designer.**

{:id="NxtSoundSensor.TopOfRange" .number} *TopOfRange*
: Specifies the top of the range used for the BelowRange, WithinRange, and
 AboveRange events.

{:id="NxtSoundSensor.WithinRangeEventEnabled" .boolean} *WithinRangeEventEnabled*
: Specifies whether the WithinRange event should fire when the sound level
 goes between the BottomOfRange and the TopOfRange.

### Events  {#NxtSoundSensor-Events}

{:.events}

{:id="NxtSoundSensor.AboveRange"} AboveRange()
: Sound level has gone above the range.

{:id="NxtSoundSensor.BelowRange"} BelowRange()
: Sound level has gone below the range.

{:id="NxtSoundSensor.WithinRange"} WithinRange()
: Sound level has gone within the range.

### Methods  {#NxtSoundSensor-Methods}

{:.methods}

{:id="NxtSoundSensor.GetSoundLevel" class="method returns number"} <i/> GetSoundLevel()
: Returns the current sound level as a value between 0 and 1023, or -1 if the sound level can not be read.

## NxtTouchSensor  {#NxtTouchSensor}

![NXT component icon](images/legoMindstormsNxt.png)

 A component that provides a high-level interface to a touch sensor on a LEGO
 MINDSTORMS NXT robot.



### Properties  {#NxtTouchSensor-Properties}

{:.properties}

{:id="NxtTouchSensor.BluetoothClient" .component .do} *BluetoothClient*
: Specifies the BluetoothClient component that should be used for communication.
 **Must be set in the Designer.**

{:id="NxtTouchSensor.PressedEventEnabled" .boolean} *PressedEventEnabled*
: Specifies whether the Pressed event should fire when the touch sensor is
 pressed.

{:id="NxtTouchSensor.ReleasedEventEnabled" .boolean} *ReleasedEventEnabled*
: Specifies whether the Released event should fire when the touch sensor is
 released.

{:id="NxtTouchSensor.SensorPort" .text .do} *SensorPort*
: Specifies the sensor port that the sensor is connected to.
 **Must be set in the Designer.**

### Events  {#NxtTouchSensor-Events}

{:.events}

{:id="NxtTouchSensor.Pressed"} Pressed()
: Touch sensor has been pressed.

{:id="NxtTouchSensor.Released"} Released()
: Touch sensor has been released.

### Methods  {#NxtTouchSensor-Methods}

{:.methods}

{:id="NxtTouchSensor.IsPressed" class="method returns boolean"} <i/> IsPressed()
: Returns true if the touch sensor is pressed.

## NxtUltrasonicSensor  {#NxtUltrasonicSensor}

![NXT component icon](images/legoMindstormsNxt.png)

 A component that provides a high-level interface to an ultrasonic sensor on a LEGO
 MINDSTORMS NXT robot.



### Properties  {#NxtUltrasonicSensor-Properties}

{:.properties}

{:id="NxtUltrasonicSensor.AboveRangeEventEnabled" .boolean} *AboveRangeEventEnabled*
: Specifies whether the AboveRange event should fire when the distance
 goes above the TopOfRange.

{:id="NxtUltrasonicSensor.BelowRangeEventEnabled" .boolean} *BelowRangeEventEnabled*
: Specifies whether the BelowRange event should fire when the distance
 goes below the BottomOfRange.

{:id="NxtUltrasonicSensor.BluetoothClient" .component .do} *BluetoothClient*
: Specifies the BluetoothClient component that should be used for communication.
 **Must be set in the Designer.**

{:id="NxtUltrasonicSensor.BottomOfRange" .number} *BottomOfRange*
: Specifies the bottom of the range used for the BelowRange, WithinRange,
 and AboveRange events.

{:id="NxtUltrasonicSensor.SensorPort" .text .do} *SensorPort*
: Specifies the sensor port that the sensor is connected to.
 **Must be set in the Designer.**

{:id="NxtUltrasonicSensor.TopOfRange" .number} *TopOfRange*
: Specifies the top of the range used for the BelowRange, WithinRange, and
 AboveRange events.

{:id="NxtUltrasonicSensor.WithinRangeEventEnabled" .boolean} *WithinRangeEventEnabled*
: Specifies whether the WithinRange event should fire when the distance
 goes between the BottomOfRange and the TopOfRange.

### Events  {#NxtUltrasonicSensor-Events}

{:.events}

{:id="NxtUltrasonicSensor.AboveRange"} AboveRange()
: Distance has gone above the range.

{:id="NxtUltrasonicSensor.BelowRange"} BelowRange()
: Distance has gone below the range.

{:id="NxtUltrasonicSensor.WithinRange"} WithinRange()
: Distance has gone within the range.

### Methods  {#NxtUltrasonicSensor-Methods}

{:.methods}

{:id="NxtUltrasonicSensor.GetDistance" class="method returns number"} <i/> GetDistance()
: Returns the current distance in centimeters as a value between 0 and 254, or -1 if the distance can not be read.
