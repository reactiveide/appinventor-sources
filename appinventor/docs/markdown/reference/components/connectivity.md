---
layout: documentation
title: Connectivity
---

[&laquo; Back to index](index.html)
# Connectivity

Table of Contents:

* [ActivityStarter](#ActivityStarter)
* [BluetoothClient](#BluetoothClient)
* [BluetoothLE](#BluetoothLE)
* [BluetoothServer](#BluetoothServer)
* [Serial](#Serial)
* [Web](#Web)

## ActivityStarter  {#ActivityStarter}

A component that can launch an activity using the StartActivity method.

 Activities that can be launched include:

 * Starting another App Inventor for Android app. To do so, first find out the class of the other
   application by downloading the source code and using a file explorer or unzip utility to find
   a file named "youngandroidproject/project.properties". The first line of the file will start
   with "main=" and be followed by the class name; for example,
   `main=com.gmail.Bitdiddle.Ben.HelloPurr.Screen1`. (The first components indicate that it was
   created by Ben.Bitdiddle@gmail.com.) To make your `ActivityStarter` launch this application,
   set the following properties:
   * `ActivityPackage` to the class name, dropping the last component (for example,
     `com.gmail.Bitdiddle.Ben.HelloPurr`)
   * `ActivityClass` to the entire class name (for example,
     `com.gmail.Bitdiddle.Ben.HelloPurr.Screen1`)
 * Starting the camera application by setting the following properties:
   * `Action`: `android.intent.action.MAIN`
   * `ActivityPackage`: `com.android.camera`
   * `ActivityClass`: `com.android.camera.Camera`
 * Performing web search. Assuming the term you want to search for is "vampire" (feel free to substitute your own choice), set the properties to:
   * `Action`: `android.intent.action.WEB_SEARCH`
   * `ExtraKey`: `query`
   * `ExtraValue`: `vampire`
   * `ActivityPackage`: `com.google.android.providers.enhancedgooglesearch`
   * `ActivityClass`: `com.google.android.providers.enhancedgooglesearch.Launcher`
 * Opening a browser to a specified web page. Assuming the page you want to go to is "www.facebook.com" (feel free to substitute your own choice), set the properties to:
   * `Action`: `android.intent.action.VIEW`
   * `DataUri`: `http://www.facebook.com`



### Properties  {#ActivityStarter-Properties}

{:.properties}

{:id="ActivityStarter.Action" .text} *Action*
: Specifies the action that will be used to start the activity.

{:id="ActivityStarter.ActivityClass" .text} *ActivityClass*
: Specifies the class part of the specific component that will be started.

{:id="ActivityStarter.ActivityPackage" .text} *ActivityPackage*
: Specifies the package part of the specific component that will be started.

{:id="ActivityStarter.DataType" .text} *DataType*
: Specifies the MIME type to pass to the activity.

{:id="ActivityStarter.DataUri" .text} *DataUri*
: Specifies the data URI that will be used to start the activity.

{:id="ActivityStarter.ExtraKey" .text} *ExtraKey*
: Specifies the extra key that will be passed to the activity.
 Obsolete. Should use Extras instead

{:id="ActivityStarter.ExtraValue" .text} *ExtraValue*
: Specifies the extra value that will be passed to the activity.
 Obsolete. Should use Extras instead

{:id="ActivityStarter.Extras" .list .bo} *Extras*
: Returns the list of key-value pairs that will be passed as extra data to the activity.

{:id="ActivityStarter.Result" .text .ro .bo} *Result*
: Returns the result from the activity.

{:id="ActivityStarter.ResultName" .text} *ResultName*
: Specifies the name that will be used to retrieve a result from the
 activity.

{:id="ActivityStarter.ResultType" .text .ro .bo} *ResultType*
: Returns the MIME type from the activity.

{:id="ActivityStarter.ResultUri" .text .ro .bo} *ResultUri*
: Returns the URI from the activity.

### Events  {#ActivityStarter-Events}

{:.events}

{:id="ActivityStarter.ActivityCanceled"} ActivityCanceled()
: Event raised if this `ActivityStarter returns because the activity was canceled.

{:id="ActivityStarter.AfterActivity"} AfterActivity(*result*{:.text})
: Event raised after this `ActivityStarter` returns.

### Methods  {#ActivityStarter-Methods}

{:.methods}

{:id="ActivityStarter.ResolveActivity" class="method returns text"} <i/> ResolveActivity()
: Returns the name of the activity that corresponds to this `ActivityStarter`,
 or an empty string if no corresponding activity can be found.

{:id="ActivityStarter.StartActivity" class="method"} <i/> StartActivity()
: Start the activity corresponding to this `ActivityStarter`.

## BluetoothClient  {#BluetoothClient}

Use `BluetoothClient` to connect your device to other devices using Bluetooth. This component
 uses the Serial Port Profile (SPP) for communication. If you are interested in using Bluetooth
 low energy, please see the
 [BluetoothLE](http://iot.appinventor.mit.edu/#/bluetoothle/bluetoothleintro) extension.



### Properties  {#BluetoothClient-Properties}

{:.properties}

{:id="BluetoothClient.AddressesAndNames" .list .ro .bo} *AddressesAndNames*
: Returns the list of paired Bluetooth devices. Each element of the returned
 list is a String consisting of the device's address, a space, and the
 device's name.

{:id="BluetoothClient.Available" .boolean .ro .bo} *Available*
: Returns `true`{:.logic.block} if Bluetooth is available on the device,
 `false`{:.logic.block} otherwise.

{:id="BluetoothClient.CharacterEncoding" .text} *CharacterEncoding*
: Returns the character encoding to use when sending and receiving text.

{:id="BluetoothClient.DelimiterByte" .number} *DelimiterByte*
: Returns the delimiter byte to use when passing a negative number for the
 numberOfBytes parameter when calling ReceiveText, ReceiveSignedBytes, or
 ReceiveUnsignedBytes.

{:id="BluetoothClient.DisconnectOnError" .boolean} *DisconnectOnError*
: Specifies whether BluetoothClient/BluetoothServer should be disconnected automatically when an error occurs.

{:id="BluetoothClient.Enabled" .boolean .ro .bo} *Enabled*
: Returns `true`{:.logic.block} if Bluetooth is enabled, `false`{:.logic.block} otherwise.

{:id="BluetoothClient.HighByteFirst" .boolean} *HighByteFirst*
: Specifies whether numbers are sent and received with the most significant
 byte first.

{:id="BluetoothClient.IsConnected" .boolean .ro .bo} *IsConnected*
: Returns `frue`{:.logic.block} if a connection to a Bluetooth device has been made.

{:id="BluetoothClient.Secure" .boolean} *Secure*
: Specifies whether a secure connection should be used.

### Events  {#BluetoothClient-Events}

{:.events}
None


### Methods  {#BluetoothClient-Methods}

{:.methods}

{:id="BluetoothClient.BytesAvailableToReceive" class="method returns number"} <i/> BytesAvailableToReceive()
: Returns number of bytes available from the input stream.

{:id="BluetoothClient.Connect" class="method returns boolean"} <i/> Connect(*address*{:.text})
: Connect to a Bluetooth device with the given address.

{:id="BluetoothClient.ConnectWithUUID" class="method returns boolean"} <i/> ConnectWithUUID(*address*{:.text},*uuid*{:.text})
: Connect to a Bluetooth device with the given address and a specific UUID.

{:id="BluetoothClient.Disconnect" class="method"} <i/> Disconnect()
: Disconnects from the connected Bluetooth device.

{:id="BluetoothClient.IsDevicePaired" class="method returns boolean"} <i/> IsDevicePaired(*address*{:.text})
: Checks whether the Bluetooth device with the given address is paired.

{:id="BluetoothClient.ReceiveSigned1ByteNumber" class="method returns number"} <i/> ReceiveSigned1ByteNumber()
: Reads a signed 1-byte number.

{:id="BluetoothClient.ReceiveSigned2ByteNumber" class="method returns number"} <i/> ReceiveSigned2ByteNumber()
: Reads a signed 2-byte number.

{:id="BluetoothClient.ReceiveSigned4ByteNumber" class="method returns number"} <i/> ReceiveSigned4ByteNumber()
: Reads a signed 4-byte number.

{:id="BluetoothClient.ReceiveSignedBytes" class="method returns list"} <i/> ReceiveSignedBytes(*numberOfBytes*{:.number})
: Reads a number of signed bytes from the input stream and returns them as
 a List.

   If numberOfBytes is negative, this method reads until a delimiter byte
 value is read. The delimiter byte value is included in the returned list.

{:id="BluetoothClient.ReceiveText" class="method returns text"} <i/> ReceiveText(*numberOfBytes*{:.number})
: Reads a number of bytes from the input stream and converts them to text.

   If numberOfBytes is negative, read until a delimiter byte value is read.

{:id="BluetoothClient.ReceiveUnsigned1ByteNumber" class="method returns number"} <i/> ReceiveUnsigned1ByteNumber()
: Reads an unsigned 1-byte number.

{:id="BluetoothClient.ReceiveUnsigned2ByteNumber" class="method returns number"} <i/> ReceiveUnsigned2ByteNumber()
: Reads an unsigned 2-byte number.

{:id="BluetoothClient.ReceiveUnsigned4ByteNumber" class="method returns number"} <i/> ReceiveUnsigned4ByteNumber()
: Reads an unsigned 4-byte number.

{:id="BluetoothClient.ReceiveUnsignedBytes" class="method returns list"} <i/> ReceiveUnsignedBytes(*numberOfBytes*{:.number})
: Reads a number of unsigned bytes from the input stream and returns them as
 a List.

   If numberOfBytes is negative, this method reads until a delimiter byte
 value is read. The delimiter byte value is included in the returned list.

{:id="BluetoothClient.Send1ByteNumber" class="method"} <i/> Send1ByteNumber(*number*{:.text})
: Decodes the given number String to an integer and writes it as one byte
 to the output stream.

   If the number could not be decoded to an integer, or the integer would not
 fit in one byte, then the Form's ErrorOccurred event is triggered and this
 method returns without writing any bytes to the output stream.

{:id="BluetoothClient.Send2ByteNumber" class="method"} <i/> Send2ByteNumber(*number*{:.text})
: Decodes the given number String to an integer and writes it as two bytes
 to the output stream.

   If the number could not be decoded to an integer, or the integer would not
 fit in two bytes, then the Form's ErrorOccurred event is triggered and this
 method returns without writing any bytes to the output stream.

{:id="BluetoothClient.Send4ByteNumber" class="method"} <i/> Send4ByteNumber(*number*{:.text})
: Decodes the given number String to an integer and writes it as four bytes
 to the output stream.

   If the number could not be decoded to an integer, or the integer would not
 fit in four bytes, then the Form's ErrorOccurred event is triggered and this
 method returns without writing any bytes to the output stream.

{:id="BluetoothClient.SendBytes" class="method"} <i/> SendBytes(*list*{:.list})
: Takes each element from the given list, converts it to a String, decodes
 the String to an integer, and writes it as one byte to the output stream.

   If an element could not be decoded to an integer, or the integer would not
 fit in one byte, then the Form's ErrorOccurred event is triggered and this
 method returns without writing any bytes to the output stream.

{:id="BluetoothClient.SendText" class="method"} <i/> SendText(*text*{:.text})
: Converts the given text to bytes and writes them to the output stream.

## BluetoothLE  {#BluetoothLE}

Bluetooth Low Energy, also referred to as Bluetooth LE or simply BLE, is a new communication protocol similar to classic Bluetooth except that it is designed to consume less power while maintaining comparable functionality. For this reason, Bluetooth LE is the preferred choice of communication with IoT devices that have limited power resources. Starting with Android 4.3, Google introduced built-in support for Bluetooth Low Energy. The BluetoothLE extension requires Android 5.0 or higher to avoid known issues with Google's Bluetooth LE support prior to Android 5.0.



### Properties  {#BluetoothLE-Properties}

{:.properties}

{:id="BluetoothLE.AdvertisementScanPeriod" .number .ro .bo} *AdvertisementScanPeriod*
: Returns the value of ScanPeriod.

{:id="BluetoothLE.AdvertiserAddresses" .list .ro .bo} *AdvertiserAddresses*
: Returns a list of the addresses of devices found during Advertisement scanning.

{:id="BluetoothLE.AdvertiserNames" .list .ro .bo} *AdvertiserNames*
: Returns a list of the names of the devices found during Advertisment scanning.

{:id="BluetoothLE.AutoReconnect" .boolean} *AutoReconnect*
: If true, the application will attempt to reestablish a lost connection to a device due to link loss (e.g., moving out of range). This will not apply to connections that are disconnected by a call to the <a href='#Disconnect'><code>Disconnect</code></a> method. Such disconnects will need to be reconnected via a call to <a href='#Connect'><code>Connect</code></a> or <a href='#ConnectWithAddress'><code>ConnectWithAddress</code></a>.

{:id="BluetoothLE.BatteryValue" .text .ro .bo} *BatteryValue*
: Returns the battery level.

{:id="BluetoothLE.ConnectedDeviceName" .text .ro .bo} *ConnectedDeviceName*
: The advertised name of the connected device. If no device is connected or Bluetooth low energy
 is not supported, this will return the empty string.

{:id="BluetoothLE.ConnectedDeviceRssi" .number .ro .bo} *ConnectedDeviceRssi*
: Returns the RSSI (Received Signal Strength Indicator) of connected device.

{:id="BluetoothLE.ConnectionTimeout" .number} *ConnectionTimeout*
: The amount of time, in seconds, that the BluetoothLE component will wait for a connection to be established with a device after a call to <a href='#Connect'><code>Connect</code></a> or <a href='#ConnectWithAddress'><code>ConnectWithAddress</code></a>. If a connection is not established in the given amount of time, the attempt will be aborted and the <a href='#ConnectionFailed'><code>ConnectionFailed</code></a> event will be run.

{:id="BluetoothLE.DeviceCharacteristics" .list .ro .bo} *DeviceCharacteristics*
: A list of triples indicating a service UUID, a characteristic UUID, and the characteristic's
 name, if known. The format of the list will be
 ((service1 characteristic1 name1) (service2 characteristic2 name2) ...). If no device is
 connected or Bluetooth low energy is not supported, then an empty list will be returned.

{:id="BluetoothLE.DeviceList" .text .ro .bo} *DeviceList*
: Returns a sorted list of BluetoothLE devices as a String.

{:id="BluetoothLE.DeviceServices" .list .ro .bo} *DeviceServices*
: A list of pairs indicating a service UUID and its name, if known. The format of the list will
 be ((uuid1 name1) (uuid2 name2) ...). If no device is connected or Bluetooth low energy is not
 supported, then an empty list will be returned.

{:id="BluetoothLE.IsDeviceAdvertising" .boolean .ro .bo} *IsDeviceAdvertising*
: Returns true if the device is currently advertising, false otherwise.

{:id="BluetoothLE.IsDeviceConnected" .boolean .ro .bo} *IsDeviceConnected*
: Returns true if a BluetoothLE device is connected; Otherwise, returns false.

{:id="BluetoothLE.Scanning" .boolean .ro .bo} *Scanning*
: The scanning state of the Bluetooth low energy component.

{:id="BluetoothLE.TxPower" .number .ro .bo} *TxPower*
: Returns the transmission power.

### Events  {#BluetoothLE-Events}

{:.events}

{:id="BluetoothLE.BytesReceived"} BytesReceived(*serviceUuid*{:.text},*characteristicUuid*{:.text},*byteValues*{:.list})
: The <code>BytesReceived</code> event is run when one or more byte values are received from a
 connected Bluetooth device. Depending on the <code>sign</code> parameter of the last call to
 <a href="#ReadBytes"><code>ReadBytes</code></a> or
 <a href="#RegisterForBytes"><code>RegisterForBytes</code></a> for the given
 <code>serviceUuid</code> and <code>characteristicUuid</code>, the <code>byteValues</code> list
 will contain numbers ranging from -128 to 127 (<code>signed = true</code>)
 or 0 to 255 (<code>signed = false</code>).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>byteValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/listsU.html#makealist">_list_</a>) &mdash;
       A list of values read from the device. The range of each value will depend on the <code>sign</code> flag previously specified in the call to read or register.

{:id="BluetoothLE.BytesWritten"} BytesWritten(*serviceUuid*{:.text},*characteristicUuid*{:.text},*byteValues*{:.list})
: The <code>BytesWritten</code> event is run when one or more byte values are written to a
 connected Bluetooth device. <code>byteValues</code> will be a list of values actually written
 to the device. This may be different if the original input was too long to fit into a single
 transmission unit (typically 23 bytes).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>byteValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values written to the device.

{:id="BluetoothLE.Connected"} Connected()
: The <code>Connected</code> event is run after the application successfully connects to a
 Bluetooth low energy device. This can be the result of a call to
 <a href='#Connect'><code>Connect</code></a> or
 <a href='#ConnectWithAddress'><code>ConnectWithAddress</code></a>, or as a result of an
 automatic reconnect if the <a href='#AutoReconnect'><code>AutoReconnect</code></a> property
 was true at the time a connection was requested.

{:id="BluetoothLE.ConnectionFailed"} ConnectionFailed(*reason*{:.text})
: The <code>ConnectionFailed</code> event is run when an attempt to connect to a device does not
 succeed. If a reason is provided by the Bluetooth low energy stack it will be reported via the
 <code>reason</code> parameter.

 __Parameters__:

     * <code>reason</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The reason the connection failed, if known.

{:id="BluetoothLE.DeviceFound"} DeviceFound()
: The <code>DeviceFound</code> event is run when a new Bluetooth low energy device is found.

{:id="BluetoothLE.Disconnected"} Disconnected()
: The <code>Disconnected</code> event is run when a Bluetooth low energy device is disconnected.
 This can be caused by a call to <a href="#Disconnect"><code>Disconnect</code></a> or
 <a href="#DisconnectWithAddress"><code>DisconnectWithAddress</code></a>, or after a device
 is moved away or reset such that a loss of connection occurs.

{:id="BluetoothLE.FloatsReceived"} FloatsReceived(*serviceUuid*{:.text},*characteristicUuid*{:.text},*floatValues*{:.list})
: The <code>FloatsReceived</code> event is run when one or more IEEE 754 floating point values are received from a
 connected Bluetooth device. Depending on the <code>shortFloat</code> parameter of the last call to
 <a href="#ReadFloats"><code>ReadFloats</code></a> or
 <a href="#RegisterForFloats"><code>RegisterForFloats</code></a> for the given
 <code>serviceUuid</code> and <code>characteristicUuid</code>, the <code>floatValues</code> list
 will contain numbers ranging from -65504.0 to 65504.0 (<code>shortFloat = true</code>)
 or -3.402823466E38 to 3.402823466E38 (<code>shortFloat = false</code>).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>floatValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values read from the device. The range of each value will depend on the <code>sign</code> flag previously specified in the call to read or register.

{:id="BluetoothLE.FloatsWritten"} FloatsWritten(*serviceUuid*{:.text},*characteristicUuid*{:.text},*floatValues*{:.list})
: The <code>FloatsWritten</code> event is run when one or more IEEE 754 floating point values are written to a
 connected Bluetooth device. <code>floatValues</code> will be a list of values actually written
 to the device. This may be different if the original input was too long to fit into a single
 transmission unit (typically 11 short floats or 5 regular floats).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>floatValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values written to the device.

{:id="BluetoothLE.IntegersReceived"} IntegersReceived(*serviceUuid*{:.text},*characteristicUuid*{:.text},*intValues*{:.list})
: The <code>IntegersReceived</code> event is run when one or more 32-bit integer values are received from a
 connected Bluetooth device. Depending on the <code>sign</code> parameter of the last call to
 <a href="#ReadIntegers"><code>ReadIntegers</code></a> or
 <a href="#RegisterForIntegers"><code>RegisterForIntegers</code></a> for the given
 <code>serviceUuid</code> and <code>characteristicUuid</code>, the <code>intValues</code> list
 will contain numbers ranging from -2147483648 to 2147483647 (<code>signed = true</code>)
 or 0 to 4294967296 (<code>signed = false</code>).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>intValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values read from the device. The range of each value will depend on the <code>sign</code> flag previously specified in the call to read or register.

{:id="BluetoothLE.IntegersWritten"} IntegersWritten(*serviceUuid*{:.text},*characteristicUuid*{:.text},*intValues*{:.list})
: The <code>IntegersWritten</code> event is run when one or more 32-bit integers values are written to a
 connected Bluetooth device. <code>intValues</code> will be a list of values actually written
 to the device. This may be different if the original input was too long to fit into a single
 transmission unit (typically 5 integers).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>intValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values written to the device.

{:id="BluetoothLE.RssiChanged"} RssiChanged(*rssi*{:.number})
: The <code>RssiChanged</code> event is run when the Received Signal Strength Indicator (RSSI) of
 a discovered Bluetooth low energy device changes.

 __Parameters__:

     * <code>rssi</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The strength of the received signal, in dBm, from -100 to 0.

{:id="BluetoothLE.ShortsReceived"} ShortsReceived(*serviceUuid*{:.text},*characteristicUuid*{:.text},*shortValues*{:.list})
: The <code>ShortsReceived</code> event is run when one or more short integer values are received from a
 connected Bluetooth device. Depending on the <code>sign</code> parameter of the last call to
 <a href="#ReadShorts"><code>ReadShorts</code></a> or
 <a href="#RegisterForShorts"><code>RegisterForShorts</code></a> for the given
 <code>serviceUuid</code> and <code>characteristicUuid</code>, the <code>shortValues</code> list
 will contain numbers ranging from -32768 to 32767 (<code>signed = true</code>)
 or 0 to 65535 (<code>signed = false</code>).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>shortValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values read from the device. The range of each value will depend on the <code>sign</code> flag previously specified in the call to read or register.

{:id="BluetoothLE.ShortsWritten"} ShortsWritten(*serviceUuid*{:.text},*characteristicUuid*{:.text},*shortValues*{:.list})
: The <code>ShortsWritten</code> event is run when one or more short integers values are written to a
 connected Bluetooth device. <code>shortValues</code> will be a list of values actually written
 to the device. This may be different if the original input was too long to fit into a single
 transmission unit (typically 11 shorts).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>shortValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values written to the device.

{:id="BluetoothLE.StringsReceived"} StringsReceived(*serviceUuid*{:.text},*characteristicUuid*{:.text},*stringValues*{:.list})
: The <code>StringsReceived</code> event is run when one or more strings are received from a
 connected Bluetooth device. Depending on the <code>utf16</code> parameter of the last call to
 <a href="#ReadStrings"><code>ReadStrings</code></a> or
 <a href="#RegisterForStrings"><code>RegisterForStrings</code></a> for the given
 <code>serviceUuid</code> and <code>characteristicUuid</code>, the <code>stringValues</code> list
 will contain either a UTF-16 little endian decoded (<code>utf16 = true</code>) or UTF-8
 decoded (<code>utf16 = false</code>) strings. The string length is limited by the maximum
 transmission unit (MTU) of the Bluetooth device, which is typically 23 bytes.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>stringValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values read from the device. The strings will be decoded as UTF-16 or UTF-8 based on the <code>utf16</code> flag previously specified in the call to read or register.

{:id="BluetoothLE.StringsWritten"} StringsWritten(*serviceUuid*{:.text},*characteristicUuid*{:.text},*stringValues*{:.list})
: The <code>StringsWritten</code> event is run when one or more strings are written to a
 connected Bluetooth device. <code>stringValues</code> will be a list of values actually written
 to the device. This may be different if the original input was too long to fit into a single
 transmission unit (typically 22 bytes).

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>stringValues</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values written to the device.

### Methods  {#BluetoothLE-Methods}

{:.methods}

{:id="BluetoothLE.AdvertisementData" class="method returns text"} <i/> AdvertisementData(*deviceAddress*{:.text},*serviceUuid*{:.text})
: Returns the advertisement data associated with the specified device address.

 __Parameters__:

     * <code>deviceAddress</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The Media Access Control (MAC) address of the target Bluetooth low energy device.
     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the advertised service.

{:id="BluetoothLE.AdvertiserAddress" class="method returns text"} <i/> AdvertiserAddress(*deviceName*{:.text})
: Returns the address of the device with the name specified.

 __Parameters__:

     * <code>deviceName</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The advertised name of the target Bluetooth low energy device.

{:id="BluetoothLE.AdvertiserServiceUuids" class="method returns list"} <i/> AdvertiserServiceUuids(*deviceAddress*{:.text})
: Returns the list of services available on the advertising device.

 __Parameters__:

     * <code>deviceAddress</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The Media Access Control (MAC) address of the target Bluetooth low energy device.

{:id="BluetoothLE.CharacteristicByIndex" class="method returns text"} <i/> CharacteristicByIndex(*index*{:.number})
: Returns Unique ID of selected characteristic with index. Index specified by list
 of supported characteristics for a connected device, starting from 1.

 __Parameters__:

     * <code>index</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The index of the desired characteristic, which must be between 1 and the length of the characteristic list.

{:id="BluetoothLE.Connect" class="method"} <i/> Connect(*index*{:.number})
: Use the <code>Connect</code> method to connect to a Bluetooth low energy device at the given
 index in the device list.

 __Parameters__:

     * <code>index</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The index of the target device, which must be between 1 and the length of the list.

{:id="BluetoothLE.ConnectWithAddress" class="method"} <i/> ConnectWithAddress(*address*{:.text})
: Use the <code>ConnectWithAddress</code> method to connect to a specific Bluetooth low energy
 device if its Media Access Control (MAC) address is known. If none of the devices in the device
 list matches the given address, the <a href="#ConnectionFailed"><code>ConnectionFailed</code></a>
 event will be run. Otherwise, if a connection is successful the
 <a href="#Connected"><code>Connected</code></a> event will be run.

 __Parameters__:

     * <code>address</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The MAC address of the target device, of the form "12:34:56:78:90:ab"

{:id="BluetoothLE.Disconnect" class="method"} <i/> Disconnect()
: Disconnects from the currently connected BluetoothLE device if a device is connected.

{:id="BluetoothLE.DisconnectWithAddress" class="method"} <i/> DisconnectWithAddress(*address*{:.text})
: Disconnects from a connected BluetoothLE device with the given address.

 __Parameters__:

     * <code>address</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string" target="_blank">_text_</a>) &mdash;
       The Media Access Control (MAC) address of the device to disconnect, of the form "12:34:56:78:90:ab"

{:id="BluetoothLE.FoundDeviceAddress" class="method returns text"} <i/> FoundDeviceAddress(*index*{:.number})
: Gets the Media Access Control (MAC) address of the found device at the given index in the
 device list. Index specifies the position in the BluetoothLE device list, starting from 1.

 __Parameter__:

     * <code>index</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The index of the desired device, which must be between 1 and the length of the device list.

{:id="BluetoothLE.FoundDeviceName" class="method returns text"} <i/> FoundDeviceName(*index*{:.number})
: Gets the name of the found device at the given index in the device list.

 __Parameter__:

     * <code>index</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The index of the desired device, which must be between 1 and the length of the device list.

{:id="BluetoothLE.FoundDeviceRssi" class="method returns number"} <i/> FoundDeviceRssi(*index*{:.number})
: Gets the Received Signal Strength Indicator (RSSI) of the found device at the given index.
 The returned value will be between -100 and 0 indicating the strength of the connection.

 __Parameter__:

     * <code>index</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The index of the desired device, which must be between 1 and the length of the device list.

{:id="BluetoothLE.GetCharacteristicsForService" class="method returns list"} <i/> GetCharacteristicsForService(*serviceUuid*{:.text})
: Returns the list of supported characteristics for the given service. The list will contain
 (UUID, name) pairs for each characteristic provided by the service UUID.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.

{:id="BluetoothLE.ReadBytes" class="method"} <i/> ReadBytes(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean})
: Reads one or more 8-bit integer values from a connected BluetoothLE device. Service Unique ID
 and Characteristic UniqueID are required. The <code>signed</code> parameter indicates whether
 the bytes should be interpreted as signed values or not when being converted into App Inventor
 numbers. After the bytes are read, the <a href="#BytesReceived"><code>BytesReceived</code></a>
 event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the bytes as signed (true) or unsigned (false).

{:id="BluetoothLE.ReadFloats" class="method"} <i/> ReadFloats(*serviceUuid*{:.text},*characteristicUuid*{:.text},*shortFloat*{:.boolean})
: Reads one or more IEEE 754 floating point numbers from a connected BluetoothLE device. Service Unique ID
 and Characteristic UniqueID are required. The <code>shortFloat</code> parameter indicates whether
 the floats are either 16-bit half-precision floating point or 32-bit single precision floating point
 numbers. After the floats are read, the <a href="#FloatsReceived"><code>FloatsReceived</code></a>
 event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>shortFloat</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the floats as 16-bit half-precision (true) or 32-bit single-precision (false).

{:id="BluetoothLE.ReadIntegers" class="method"} <i/> ReadIntegers(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean})
: Reads one or more 32-bit integer values from a connected BluetoothLE device. Service Unique ID
 and Characteristic UniqueID are required. The <code>signed</code> parameter indicates whether
 the integers should be interpreted as signed values or not when being converted into App Inventor
 numbers. After the integers are read, the
 <a href="#IntegersReceived"><code>IntegersReceived</code></a> event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the integers as signed (true) or unsigned (false).

{:id="BluetoothLE.ReadShorts" class="method"} <i/> ReadShorts(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean})
: Reads one or more 16-bit integer values from a connected BluetoothLE device. Service Unique ID
 and Characteristic UniqueID are required. The <code>signed</code> parameter indicates whether
 the shorts should be interpreted as signed values or not when being converted into App Inventor
 numbers. After the shorts are read, the <a href="#ShortsReceived"><code>ShortsReceived</code></a>
 event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the shorts as signed (true) or unsigned (false).

{:id="BluetoothLE.ReadStrings" class="method"} <i/> ReadStrings(*serviceUuid*{:.text},*characteristicUuid*{:.text},*utf16*{:.boolean})
: Reads one or more null-terminated strings from a connected BluetoothLE device. Service Unique ID
 and Characteristic Unique ID are required. The <code>utf16</code> parameter indicates whether
 the content should be decoded as UTF-16 (true) or UTF-8 (false) code points when converting to
 App Inventor strings. After the strings are read, the
 <a href="#StringsReceived"><code>StringsReceived</code></a> event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>utf16</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the string content as UTF-16 (true) or UTF-8 (false) code points.

{:id="BluetoothLE.RegisterForBytes" class="method"} <i/> RegisterForBytes(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean})
: Registers to receive updates when one or more 8-bit integer values from a connected BluetoothLE
 device are changed. Service Unique ID and Characteristic Unique ID are required. The
 <code>signed</code> parameter indicates whether the bytes should be interpreted as signed
 values or not when being converted into App Inventor numbers. Whenever a change is received,
 the <a href="#BytesReceived"><code>BytesReceived</code></a> event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the bytes as signed (true) or unsigned (false).

{:id="BluetoothLE.RegisterForFloats" class="method"} <i/> RegisterForFloats(*serviceUuid*{:.text},*characteristicUuid*{:.text},*shortFloat*{:.boolean})
: Registers to receive updates when one or more IEEE 754 floating point numbers from a connected
 BluetoothLE device are changed. Service Unique ID and Characteristic Unique ID are required. The
 <code>shortFloat</code> parameter indicates whether the floats are either 16-bit half-precision
 floating point or 32-bit single precision floating point numbers. Whenever a change is received,
 the <a href="#FloatsReceived"><code>FloatsReceived</code></a> event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>shortFloat</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the floats as 16-bit half-precision (true) or 32-bit single-precision (false).

{:id="BluetoothLE.RegisterForIntegers" class="method"} <i/> RegisterForIntegers(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean})
: Registers to receive updates when one or more 32-bit integer values from a connected BluetoothLE
 device are changed. Service Unique ID and Characteristic Unique ID are required. The
 <code>signed</code> parameter indicates whether the integers should be interpreted as signed
 values or not when being converted into App Inventor numbers. Whenever a change is received,
 the <a href="#IntegersReceived"><code>IntegersReceived</code></a> event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the integers as signed (true) or unsigned (false).

{:id="BluetoothLE.RegisterForShorts" class="method"} <i/> RegisterForShorts(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean})
: Registers to receive updates when one or more 16-bit integer values from a connected BluetoothLE
 device are changed. Service Unique ID and Characteristic Unique ID are required. The
 <code>signed</code> parameter indicates whether the shorts should be interpreted as signed
 values or not when being converted into App Inventor numbers. Whenever a change is received,
 the <a href="#ShortsReceived"><code>ShortsReceived</code></a> event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the shorts as signed (true) or unsigned (false).

{:id="BluetoothLE.RegisterForStrings" class="method"} <i/> RegisterForStrings(*serviceUuid*{:.text},*characteristicUuid*{:.text},*utf16*{:.boolean})
: Registers to receive updates when one or more null-terminated strings from a connected
 BluetoothLE device are changed. Service Unique ID and Characteristic Unique ID are required. The
 <code>utf16</code> parameter indicates whether the content should be decoded as UTF-16 (true)
 or UTF-8 (false) code points when converting to App Inventor strings. Whenever a change is
 received, the <a href="#StringsReceived"><code>StringsReceived</code></a> event will be run.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>utf16</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the string content as UTF-16 (true) or UTF-8 (false) code points.

{:id="BluetoothLE.ScanAdvertisements" class="method"} <i/> ScanAdvertisements(*scanPeriod*{:.number})
: Scans for advertising Bluetooth low energy devices.

 __Parameter__:

     * <code>scanPeriod</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The amount of time to spend scanning, in milliseconds.

{:id="BluetoothLE.ServiceByIndex" class="method returns text"} <i/> ServiceByIndex(*index*{:.number})
: Returns the Unique ID of the service at the given index in the service list.

 __Parameters__:

     * <code>index</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/math.html#number">_number_</a>) &mdash;
       The index of the desired service, which must be between 1 and the length of the service list.

{:id="BluetoothLE.StartAdvertising" class="method"} <i/> StartAdvertising(*inData*{:.text},*serviceUuid*{:.text})
: Creates and publishes a Bluetooth low energy advertisement.

 __Parameters__:

     * <code>inData</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The data to be included in the service advertisement.
     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.

{:id="BluetoothLE.StartScanning" class="method"} <i/> StartScanning()
: Starts scanning for Bluetooth low energy devices.

{:id="BluetoothLE.StopAdvertising" class="method"} <i/> StopAdvertising()
: Stops Bluetooth low energy advertisement from a previous call to
 <a href="#StartAdvertising"><code>StartAdvertising</code></a>.

{:id="BluetoothLE.StopScanning" class="method"} <i/> StopScanning()
: Stops scanning for Bluetooth low energy devices.

{:id="BluetoothLE.StopScanningAdvertisements" class="method"} <i/> StopScanningAdvertisements()
: Stops scanning for Bluetooth low energy advertisements.

{:id="BluetoothLE.SupportedCharacteristics" class="method returns text"} <i/> SupportedCharacteristics()
: Returns a list of supported characteristic for the connected device as a string.

{:id="BluetoothLE.SupportedServices" class="method returns text"} <i/> SupportedServices()
: Returns the list of supported service for the connected device as a string.

{:id="BluetoothLE.UnregisterForValues" class="method"} <i/> UnregisterForValues(*service_uuid*{:.text},*characteristic_uuid*{:.text})
: Unregisters for updates from the given service and characteristic.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.

{:id="BluetoothLE.WriteBytes" class="method"} <i/> WriteBytes(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean},*values*{:.any})
: Writes one or more 8-bit integer values to a connected BluetoothLE device. Service Unique ID
 and Characteristic Unique ID are required. The values parameter can either be a single numeric
 value or a list of values. If <code>signed</code> is true, the acceptable values are
 between -128 and 127. If <code>signed</code> is false, the acceptable values are
 between 0 and 255.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the bytes as signed (true) or unsigned (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteBytesWithResponse" class="method"} <i/> WriteBytesWithResponse(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean},*values*{:.any})
: Writes one or more 8-bit integer values to a connected BluetoothLE device and waits for an
 acknowledgement via the <a href="#BytesWritten"><code>BytesWritten</code></a> event.
 Service Unique ID and Characteristic Unique ID are required. The values parameter can either
 be a single numeric value or a list of values. If <code>signed</code> is true, the acceptable
 values are between -128 and 127. If <code>signed</code> is false, the acceptable values are
 between 0 and 255.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the bytes as signed (true) or unsigned (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteFloats" class="method"} <i/> WriteFloats(*serviceUuid*{:.text},*characteristicUuid*{:.text},*shortFloat*{:.boolean},*values*{:.any})
: Writes one or more IEEE 754 floating point numbers to a connected BluetoothLE device. Service Unique ID
 and Characteristic Unique ID are required. The values parameter can either be a single numeric
 value or a list of values. If <code>shortFloat</code> is true, then each numeric value will be
 compressed to fit into a 16-bit half-precision floating point value. If <code>shortFloat</code>
 is false, then each numeric value will be sent as a 32-bit single precision floating point value.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>shortFloat</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the floats as 16-bit half-precision (true) or 32-bit single-precision (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteFloatsWithResponse" class="method"} <i/> WriteFloatsWithResponse(*serviceUuid*{:.text},*characteristicUuid*{:.text},*shortFloat*{:.boolean},*values*{:.any})
: Writes one or more IEEE 754 floating point values to a connected BluetoothLE device and waits for an
 acknowledgement via the <a href="#FloatsWritten"><code>FloatsWritten</code></a> event.
 Service Unique ID and Characteristic Unique ID are required. The values parameter can either
 be a single numeric value or a list of values. If <code>shortFloat</code> is false,
 then each numeric value will be sent as a 32-bit single precision floating point value.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>shortFloat</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the floats as 16-bit half-precision (true) or 32-bit single-precision (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteIntegers" class="method"} <i/> WriteIntegers(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean},*values*{:.any})
: Writes one or more 32-bit integer values to a connected BluetoothLE device. Service Unique ID
 and Characteristic Unique ID are required. The values parameter can either be a single numeric
 value or a list of values. If <code>signed</code> is true, the acceptable values are
 between -2147483648 and 2147483647. If <code>signed</code> is false, the acceptable values are
 between 0 and 4294967295.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the integers as signed (true) or unsigned (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteIntegersWithResponse" class="method"} <i/> WriteIntegersWithResponse(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean},*values*{:.any})
: Writes one or more 32-bit integer values to a connected BluetoothLE device and waits for an
 acknowledgement via the <a href="#IntegersWritten"><code>IntegersWritten</code></a> event.
 Service Unique ID and Characteristic Unique ID are required. The values parameter can either
 be a single numeric value or a list of values. If <code>signed</code> is true, the acceptable
 values are between -2147483648 and 2147483647. If <code>signed</code> is false, the acceptable
 values are between 0 and 4294967295.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the integers as signed (true) or unsigned (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteShorts" class="method"} <i/> WriteShorts(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean},*values*{:.any})
: Writes one or more 16-bit integer values to a connected BluetoothLE device. Service Unique ID
 and Characteristic Unique ID are required. The values parameter can either be a single numeric
 value or a list of values. If <code>signed</code> is true, the acceptable values are
 between -32768 and 32767. If <code>signed</code> is false, the acceptable values are
 between 0 and 65535.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the shorts as signed (true) or unsigned (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteShortsWithResponse" class="method"} <i/> WriteShortsWithResponse(*serviceUuid*{:.text},*characteristicUuid*{:.text},*signed*{:.boolean},*values*{:.any})
: Writes one or more 16-bit integer values to a connected BluetoothLE device and waits for an
 acknowledgement via the <a href="#ShortsWritten"><code>ShortsWritten</code></a> event.
 Service Unique ID and Characteristic Unique ID are required. The values parameter can either
 be a single numeric value or a list of values. If <code>signed</code> is true, the acceptable
 values are between -32768 and 32767. If <code>signed</code> is false, the acceptable values
 are between 0 and 65535.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>signed</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Interpret the shorts as signed (true) or unsigned (false).
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteStrings" class="method"} <i/> WriteStrings(*serviceUuid*{:.text},*characteristicUuid*{:.text},*utf16*{:.boolean},*values*{:.any})
: Writes one or more strings to a connected BluetoothLE device. Service Unique ID and
 Characteristic Unique ID are required. The values parameter can either be a single string or a
 list of strings. If <code>utf16</code> is true, the string(s) will be sent using UTF-16 little
 endian encoding. If <code>utf16</code> is false, the string(s) will be sent using UTF-8
 encoding.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>utf16</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Send the string encoded as UTF-16 little endian (true) or UTF-8 (false) code points.
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

{:id="BluetoothLE.WriteStringsWithResponse" class="method"} <i/> WriteStringsWithResponse(*serviceUuid*{:.text},*characteristicUuid*{:.text},*utf16*{:.boolean},*values*{:.any})
: Writes one or more strings to a connected BluetoothLE device and waits for an acknowledgement
 via the <a href="#StringsWritten"><code>StringsWritten</code></a> event. Service Unique ID and
 Characteristic Unique ID are required. The values parameter can either be a single string or a
 list of values. If <code>utf16</code> is true, the string(s) will be sent using UTF-16 little
 endian encoding. If <code>utf16</code> is false, the string(s) will be sent using UTF-8
 encoding.

 __Parameters__:

     * <code>serviceUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the service passed in the read or register call.
     * <code>characteristicUuid</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/text.html#string">_text_</a>) &mdash;
       The unique identifier of the characteristic in the read or register call.
     * <code>utf16</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/logic.html#true" target="_blank">_boolean_</a>)
       Send the string encoded as UTF-16 little endian (true) or UTF-8 (false) code points.
     * <code>values</code> (<a href="http://appinventor.mit.edu/explore/ai2/support/blocks/lists.html#makealist">_list_</a>) &mdash;
       A list of values to write to the device.

## BluetoothServer  {#BluetoothServer}

Use the `BluetoothServer` component to turn your device into a server that receive connections
 from other apps that use the `BluetoothClient` component.



### Properties  {#BluetoothServer-Properties}

{:.properties}

{:id="BluetoothServer.Available" .boolean .ro .bo} *Available*
: Returns `true`{:.logic.block} if Bluetooth is available on the device,
 `false`{:.logic.block} otherwise.

{:id="BluetoothServer.CharacterEncoding" .text} *CharacterEncoding*
: Returns the character encoding to use when sending and receiving text.

{:id="BluetoothServer.DelimiterByte" .number} *DelimiterByte*
: Returns the delimiter byte to use when passing a negative number for the
 numberOfBytes parameter when calling ReceiveText, ReceiveSignedBytes, or
 ReceiveUnsignedBytes.

{:id="BluetoothServer.Enabled" .boolean .ro .bo} *Enabled*
: Returns `true`{:.logic.block} if Bluetooth is enabled, `false`{:.logic.block} otherwise.

{:id="BluetoothServer.HighByteFirst" .boolean} *HighByteFirst*
: Specifies whether numbers are sent and received with the most significant
 byte first.

{:id="BluetoothServer.IsAccepting" .boolean .ro .bo} *IsAccepting*
: Returns true if this BluetoothServer component is accepting an
 incoming connection.

{:id="BluetoothServer.IsConnected" .boolean .ro .bo} *IsConnected*
: Returns `frue`{:.logic.block} if a connection to a Bluetooth device has been made.

{:id="BluetoothServer.Secure" .boolean} *Secure*
: Specifies whether a secure connection should be used.

### Events  {#BluetoothServer-Events}

{:.events}

{:id="BluetoothServer.ConnectionAccepted"} ConnectionAccepted()
: Indicates that a bluetooth connection has been accepted.

### Methods  {#BluetoothServer-Methods}

{:.methods}

{:id="BluetoothServer.AcceptConnection" class="method"} <i/> AcceptConnection(*serviceName*{:.text})
: Accept an incoming connection with the Serial Port Profile (SPP).

{:id="BluetoothServer.AcceptConnectionWithUUID" class="method"} <i/> AcceptConnectionWithUUID(*serviceName*{:.text},*uuid*{:.text})
: Accept an incoming connection with a specific UUID.

{:id="BluetoothServer.BytesAvailableToReceive" class="method returns number"} <i/> BytesAvailableToReceive()
: Returns number of bytes available from the input stream.

{:id="BluetoothServer.Disconnect" class="method"} <i/> Disconnect()
: Disconnects from the connected Bluetooth device.

{:id="BluetoothServer.ReceiveSigned1ByteNumber" class="method returns number"} <i/> ReceiveSigned1ByteNumber()
: Reads a signed 1-byte number.

{:id="BluetoothServer.ReceiveSigned2ByteNumber" class="method returns number"} <i/> ReceiveSigned2ByteNumber()
: Reads a signed 2-byte number.

{:id="BluetoothServer.ReceiveSigned4ByteNumber" class="method returns number"} <i/> ReceiveSigned4ByteNumber()
: Reads a signed 4-byte number.

{:id="BluetoothServer.ReceiveSignedBytes" class="method returns list"} <i/> ReceiveSignedBytes(*numberOfBytes*{:.number})
: Reads a number of signed bytes from the input stream and returns them as
 a List.

   If numberOfBytes is negative, this method reads until a delimiter byte
 value is read. The delimiter byte value is included in the returned list.

{:id="BluetoothServer.ReceiveText" class="method returns text"} <i/> ReceiveText(*numberOfBytes*{:.number})
: Reads a number of bytes from the input stream and converts them to text.

   If numberOfBytes is negative, read until a delimiter byte value is read.

{:id="BluetoothServer.ReceiveUnsigned1ByteNumber" class="method returns number"} <i/> ReceiveUnsigned1ByteNumber()
: Reads an unsigned 1-byte number.

{:id="BluetoothServer.ReceiveUnsigned2ByteNumber" class="method returns number"} <i/> ReceiveUnsigned2ByteNumber()
: Reads an unsigned 2-byte number.

{:id="BluetoothServer.ReceiveUnsigned4ByteNumber" class="method returns number"} <i/> ReceiveUnsigned4ByteNumber()
: Reads an unsigned 4-byte number.

{:id="BluetoothServer.ReceiveUnsignedBytes" class="method returns list"} <i/> ReceiveUnsignedBytes(*numberOfBytes*{:.number})
: Reads a number of unsigned bytes from the input stream and returns them as
 a List.

   If numberOfBytes is negative, this method reads until a delimiter byte
 value is read. The delimiter byte value is included in the returned list.

{:id="BluetoothServer.Send1ByteNumber" class="method"} <i/> Send1ByteNumber(*number*{:.text})
: Decodes the given number String to an integer and writes it as one byte
 to the output stream.

   If the number could not be decoded to an integer, or the integer would not
 fit in one byte, then the Form's ErrorOccurred event is triggered and this
 method returns without writing any bytes to the output stream.

{:id="BluetoothServer.Send2ByteNumber" class="method"} <i/> Send2ByteNumber(*number*{:.text})
: Decodes the given number String to an integer and writes it as two bytes
 to the output stream.

   If the number could not be decoded to an integer, or the integer would not
 fit in two bytes, then the Form's ErrorOccurred event is triggered and this
 method returns without writing any bytes to the output stream.

{:id="BluetoothServer.Send4ByteNumber" class="method"} <i/> Send4ByteNumber(*number*{:.text})
: Decodes the given number String to an integer and writes it as four bytes
 to the output stream.

   If the number could not be decoded to an integer, or the integer would not
 fit in four bytes, then the Form's ErrorOccurred event is triggered and this
 method returns without writing any bytes to the output stream.

{:id="BluetoothServer.SendBytes" class="method"} <i/> SendBytes(*list*{:.list})
: Takes each element from the given list, converts it to a String, decodes
 the String to an integer, and writes it as one byte to the output stream.

   If an element could not be decoded to an integer, or the integer would not
 fit in one byte, then the Form's ErrorOccurred event is triggered and this
 method returns without writing any bytes to the output stream.

{:id="BluetoothServer.SendText" class="method"} <i/> SendText(*text*{:.text})
: Converts the given text to bytes and writes them to the output stream.

{:id="BluetoothServer.StopAccepting" class="method"} <i/> StopAccepting()
: Stop accepting an incoming connection.

## Serial  {#Serial}

Component for Serial



### Properties  {#Serial-Properties}

{:.properties}

{:id="Serial.BaudRate" .number} *BaudRate*
: Returns the current baud rate

{:id="Serial.BufferSize" .number} *BufferSize*
: Returns the buffer size in bytes

{:id="Serial.IsInitialized" .boolean .ro .bo} *IsInitialized*
: Returns true when the Serial has been initialized.

{:id="Serial.IsOpen" .boolean .ro .bo} *IsOpen*
: Returns true when the Serial connection is open.

### Events  {#Serial-Events}

{:.events}
None


### Methods  {#Serial-Methods}

{:.methods}

{:id="Serial.CloseSerial" class="method returns boolean"} <i/> CloseSerial()
: Closes serial connection. Returns true when closed.

{:id="Serial.InitializeSerial" class="method"} <i/> InitializeSerial()
: Initializes serial connection.

{:id="Serial.OpenSerial" class="method returns boolean"} <i/> OpenSerial()
: Opens serial connection. Returns true when opened.

{:id="Serial.PrintSerial" class="method"} <i/> PrintSerial(*data*{:.text})
: Writes given data to serial, and appends a new line at the end.

{:id="Serial.ReadSerial" class="method returns text"} <i/> ReadSerial()
: Reads data from serial.

{:id="Serial.WriteSerial" class="method"} <i/> WriteSerial(*data*{:.text})
: Writes given data to serial.

## Web  {#Web}

Non-visible component that provides functions for HTTP GET, POST, PUT, and DELETE requests.



### Properties  {#Web-Properties}

{:.properties}

{:id="Web.AllowCookies" .boolean} *AllowCookies*
: Specifies whether cookies should be allowed

{:id="Web.RequestHeaders" .list .bo} *RequestHeaders*
: Sets the request headers.

{:id="Web.ResponseFileName" .text} *ResponseFileName*
: Specifies the name of the file where the response should be saved.
 If SaveResponse is true and ResponseFileName is empty, then a new file
 name will be generated.

{:id="Web.SaveResponse" .boolean} *SaveResponse*
: Specifies whether the response should be saved in a file.

{:id="Web.Timeout" .number} *Timeout*
: Returns the number of milliseconds that each request will wait for a response before they time out.
 If set to 0, then the request will wait for a response indefinitely.

{:id="Web.Url" .text} *Url*
: Specifies the URL.

### Events  {#Web-Events}

{:.events}

{:id="Web.GotFile"} GotFile(*url*{:.text},*responseCode*{:.number},*responseType*{:.text},*fileName*{:.text})
: Event indicating that a request has finished.

{:id="Web.GotText"} GotText(*url*{:.text},*responseCode*{:.number},*responseType*{:.text},*responseContent*{:.text})
: Event indicating that a request has finished.

{:id="Web.TimedOut"} TimedOut(*url*{:.text})
: Event indicating that a request has timed out.

### Methods  {#Web-Methods}

{:.methods}

{:id="Web.BuildRequestData" class="method returns text"} <i/> BuildRequestData(*list*{:.list})
: Converts a list of two-element sublists, representing name and value pairs, to a
 string formatted as application/x-www-form-urlencoded media type, suitable to pass to
 PostText.

{:id="Web.ClearCookies" class="method"} <i/> ClearCookies()
: Clears all cookies for this Web component.

{:id="Web.Delete" class="method"} <i/> Delete()
: Performs an HTTP DELETE request using the Url property and retrieves the
 response.

   If the SaveResponse property is true, the response will be saved in a file
 and the GotFile event will be triggered. The ResponseFileName property
 can be used to specify the name of the file.

   If the SaveResponse property is false, the GotText event will be
 triggered.

{:id="Web.Get" class="method"} <i/> Get()
: Performs an HTTP GET request using the Url property and retrieves the
 response.

   If the SaveResponse property is true, the response will be saved in a file
 and the GotFile event will be triggered. The ResponseFileName property
 can be used to specify the name of the file.

   If the SaveResponse property is false, the GotText event will be
 triggered.

{:id="Web.HtmlTextDecode" class="method returns text"} <i/> HtmlTextDecode(*htmlText*{:.text})
: Decodes the given HTML text value.

   HTML Character Entities such as `&amp;`, `&lt;`, `&gt;`, `&apos;`, and `&quot;` are
 changed to `&`, `<`, `>`, `'`, and `"`.
 Entities such as `&#xhhhh;`, and `&#nnnn;` are changed to the appropriate characters.

{:id="Web.JsonObjectEncode" class="method returns text"} <i/> JsonObjectEncode(*jsonObject*{:.any})
: Returns the value of a built-in type (i.e., boolean, number, text, list, dictionary)
 in its JavaScript Object Notation representation. If the value cannot be
 represented as JSON, the Screen's ErrorOccurred event will be run, if any,
 and the Web component will return the empty string.

{:id="Web.JsonTextDecode" class="method returns any"} <i/> JsonTextDecode(*jsonText*{:.text})
: Decodes the given JSON encoded value to produce a corresponding AppInventor value.
 A JSON list `[x, y, z]` decodes to a list `(x y z)`,  A JSON object with key A and value B,
 (denoted as `{A:B}`) decodes to a list `((A B))`, that is, a list containing the two-element
 list `(A B)`.

   Use the method [JsonTextDecodeWithDictionaries](#Web.JsonTextDecodeWithDictionaries) if you
 would prefer to get back dictionary objects rather than lists-of-lists in the result.

{:id="Web.JsonTextDecodeWithDictionaries" class="method returns any"} <i/> JsonTextDecodeWithDictionaries(*jsonText*{:.text})
: Decodes the given JSON encoded value to produce a corresponding App Inventor value.
 A JSON list [x, y, z] decodes to a list (x y z). A JSON Object with name A and value B,
 denoted as \{a: b\} decodes to a dictionary with the key a and value b.

{:id="Web.PostFile" class="method"} <i/> PostFile(*path*{:.text})
: Performs an HTTP POST request using the Url property and data from the specified file.

   If the SaveResponse property is true, the response will be saved in a file
 and the GotFile event will be triggered. The ResponseFileName property can be
 used to specify the name of the file.

   If the SaveResponse property is false, the GotText event will be triggered.

{:id="Web.PostText" class="method"} <i/> PostText(*text*{:.text})
: Performs an HTTP POST request using the Url property and the specified text.

   The characters of the text are encoded using UTF-8 encoding.

   If the SaveResponse property is true, the response will be saved in a
 file and the GotFile event will be triggered. The responseFileName property
 can be used to specify the name of the file.

   If the SaveResponse property is false, the GotText event will be triggered.

{:id="Web.PostTextWithEncoding" class="method"} <i/> PostTextWithEncoding(*text*{:.text},*encoding*{:.text})
: Performs an HTTP POST request using the Url property and the specified text.

   The characters of the text are encoded using the given encoding.

   If the SaveResponse property is true, the response will be saved in a
 file and the GotFile event will be triggered. The ResponseFileName property
 can be used to specify the name of the file.

   If the SaveResponse property is false, the GotText event will be triggered.

{:id="Web.PutFile" class="method"} <i/> PutFile(*path*{:.text})
: Performs an HTTP PUT request using the Url property and data from the specified file.

   If the SaveResponse property is true, the response will be saved in a file
 and the GotFile event will be triggered. The ResponseFileName property can be
 used to specify the name of the file.

   If the SaveResponse property is false, the GotText event will be triggered.

{:id="Web.PutText" class="method"} <i/> PutText(*text*{:.text})
: Performs an HTTP PUT request using the Url property and the specified text.

   The characters of the text are encoded using UTF-8 encoding.

   If the SaveResponse property is true, the response will be saved in a
 file and the GotFile event will be triggered. The responseFileName property
 can be used to specify the name of the file.

   If the SaveResponse property is false, the GotText event will be triggered.

{:id="Web.PutTextWithEncoding" class="method"} <i/> PutTextWithEncoding(*text*{:.text},*encoding*{:.text})
: Performs an HTTP PUT request using the Url property and the specified text.

   The characters of the text are encoded using the given encoding.

   If the SaveResponse property is true, the response will be saved in a
 file and the GotFile event will be triggered. The ResponseFileName property
 can be used to specify the name of the file.

   If the SaveResponse property is false, the GotText event will be triggered.

{:id="Web.UriDecode" class="method returns text"} <i/> UriDecode(*text*{:.text})
: Decodes the encoded text value so that the values aren't URL encoded anymore.

{:id="Web.UriEncode" class="method returns text"} <i/> UriEncode(*text*{:.text})
: Encodes the given text value so that it can be used in a URL.

{:id="Web.XMLTextDecode" class="method returns any"} <i/> XMLTextDecode(*XmlText*{:.text})
: Decodes the given XML string to produce a list structure. `<tag>string</tag>` decodes to
 a list that contains a pair of tag and string.  More generally, if obj1, obj2, ...
 are tag-delimited XML strings, then `<tag>obj1 obj2 ...</tag>` decodes to a list
 that contains a pair whose first element is tag and whose second element is the
 list of the decoded obj's, ordered alphabetically by tags.

   Examples:
   * `<foo><123/foo>` decodes to a one-item list containing the pair `(foo 123)`
   * `<foo>1 2 3</foo>` decodes to a one-item list containing the pair `(foo "1 2 3")`
   * `<a><foo>1 2 3</foo><bar>456</bar></a>` decodes to a list containing the pair `(a X)`
     where X is a 2-item list that contains the pair `(bar 123)` and the pair `(foo "1 2 3")`.

   If the sequence of obj's mixes tag-delimited and non-tag-delimited items, then the
 non-tag-delimited items are pulled out of the sequence and wrapped with a "content" tag.
 For example, decoding `<a><bar>456</bar>many<foo>1 2 3</foo>apples<a></code>`
 is similar to above, except that the list X is a 3-item list that contains the additional pair
 whose first item is the string "content", and whose second item is the list (many, apples).
 This method signals an error and returns the empty list if the result is not well-formed XML.

{:id="Web.XMLTextDecodeAsDictionary" class="method returns any"} <i/> XMLTextDecodeAsDictionary(*XmlText*{:.text})
: Decodes the given XML string to produce a dictionary structure. The dictionary includes the
 special keys `$tag`, `$localName`, `$namespace`, `$namespaceUri`, `$attributes`, and `$content`,
 as well as a key for each unique tag for every node, which points to a list of elements of
 the same structure as described here.

   The `$tag` key is the full tag name, e.g., foo:bar. The `$localName` is the local portion of
 the name (everything after the colon `:` character). If a namespace is given (everything before
 the colon `:` character), it is provided in `$namespace` and the corresponding URI is given
 in `$namespaceUri`. The attributes are stored in a dictionary in `$attributes` and the
 child nodes are given as a list under `$content`.

   **More Information on Special Keys**

   Consider the following XML document:

   ```xml
     <ex:Book xmlns:ex="http://example.com/">
       <ex:title xml:lang="en">On the Origin of Species</ex:title>
       <ex:author>Charles Darwin</ex:author>
     </ex:Book>
   ```

   When parsed, the `$tag` key will be `"ex:Book"`, the `$localName` key will be `"Book"`, the
 `$namespace` key will be `"ex"`, `$namespaceUri` will be `"http://example.com/"`, the
 `$attributes` key will be a dictionary `{}` (xmlns is removed for the namespace), and the
 `$content` will be a list of two items representing the decoded `<ex:title>` and `<ex:author>`
 elements. The first item, which corresponds to the `<ex:title>` element, will have an
 `$attributes` key containing the dictionary `{"xml:lang": "en"}`. For each `name=value`
 attribute on an element, a key-value pair mapping `name` to `value` will exist in the
 `$attributes` dictionary. In addition to these special keys, there will also be `"ex:title"`
 and `"ex:author"` to allow lookups faster than having to traverse the `$content` list.
