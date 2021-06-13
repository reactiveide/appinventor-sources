---
layout: documentation
title: Main
---

[&laquo; Back to index](index.html)
# Main

Table of Contents:

* [Clipboard](#Clipboard)
* [DeviceInfo](#DeviceInfo)
* [Screenshot](#Screenshot)

## Clipboard  {#Clipboard}

Component for Clipboard



### Properties  {#Clipboard-Properties}

{:.properties}

{:id="Clipboard.SuppressToast" .boolean} *SuppressToast*
: Specifies whether Success Toast should be suppressed

### Events  {#Clipboard-Events}

{:.events}
None


### Methods  {#Clipboard-Methods}

{:.methods}

{:id="Clipboard.Copy" class="method"} <i/> Copy(*text*{:.text})
: The Copy method
 http://stackoverflow.com/a/19253877/1545993 and http://stackoverflow.com/a/28780585/1545993

{:id="Clipboard.Paste" class="method returns text"} <i/> Paste()
: The Paste method
 http://stackoverflow.com/a/19253877/1545993

## DeviceInfo  {#DeviceInfo}

Component for DeviceInfo



### Properties  {#DeviceInfo-Properties}

{:.properties}
None


### Events  {#DeviceInfo-Events}

{:.events}
None


### Methods  {#DeviceInfo-Methods}

{:.methods}

{:id="DeviceInfo.AboutThisExtension" class="method"} <i/> AboutThisExtension()
: About this Extension

{:id="DeviceInfo.AndroidVersion" class="method returns text"} <i/> AndroidVersion()
: Get device Android Version.

{:id="DeviceInfo.Board" class="method returns text"} <i/> Board()
: Get Board Info.

{:id="DeviceInfo.Bootloader_Version" class="method returns text"} <i/> Bootloader_Version()
: Get system Bootloader Version.

{:id="DeviceInfo.Brand" class="method returns text"} <i/> Brand()
: Get device Brand.

{:id="DeviceInfo.BuildNumber" class="method returns text"} <i/> BuildNumber()
: Get device Software Build Number.

{:id="DeviceInfo.DeviceCountry" class="method returns text"} <i/> DeviceCountry()
: Get device Country Code.

{:id="DeviceInfo.DeviceLanguage" class="method returns text"} <i/> DeviceLanguage()
: Get device Language Code.

{:id="DeviceInfo.DeviceName" class="method returns text"} <i/> DeviceName()
: Get device Name.

{:id="DeviceInfo.DeviceTimeZone" class="method returns text"} <i/> DeviceTimeZone()
: Get Device Time Zone.

{:id="DeviceInfo.ExternalStorageAvailable" class="method returns number"} <i/> ExternalStorageAvailable()
: Returns available size of external storage in Gigabytes

{:id="DeviceInfo.ExternalStorageTotal" class="method returns number"} <i/> ExternalStorageTotal()
: Returns total external storage size in Gigabytes

{:id="DeviceInfo.ExternalStorageUsed" class="method returns number"} <i/> ExternalStorageUsed()
: Returns size of used-external-storage in Gigabytes

{:id="DeviceInfo.Fingerprint" class="method returns text"} <i/> Fingerprint()
: A string that uniquely identifies this build.

{:id="DeviceInfo.GetCarrierName" class="method returns text"} <i/> GetCarrierName()
: Get device Carrier Name

{:id="DeviceInfo.GetDeviceID" class="method returns text"} <i/> GetDeviceID()
: Get device ID / IMEI

{:id="DeviceInfo.GetDeviceSoftwareVersion" class="method returns text"} <i/> GetDeviceSoftwareVersion()
: Returns the software version number for the device, for example, the IMEI/SV for GSM phones.

{:id="DeviceInfo.GetIPAddress" class="method returns text"} <i/> GetIPAddress()
: Get Wifi IP address

{:id="DeviceInfo.GetMacAddress" class="method returns text"} <i/> GetMacAddress()
: Get Wifi MAC address

{:id="DeviceInfo.GetPhoneNumber" class="method returns text"} <i/> GetPhoneNumber()
: Get Device Phone Number (Line 1 Number)

{:id="DeviceInfo.GetWifiBSSID" class="method returns text"} <i/> GetWifiBSSID()
: Get Wifi BSSID

{:id="DeviceInfo.GetWifiFrequency" class="method returns number"} <i/> GetWifiFrequency()
: Get Wifi Frequency

{:id="DeviceInfo.GetWifiLinkSpeed" class="method returns number"} <i/> GetWifiLinkSpeed()
: Get Wifi LinkSpeed

{:id="DeviceInfo.GetWifiSSID" class="method returns text"} <i/> GetWifiSSID()
: Get Wifi SSID

{:id="DeviceInfo.GoHome" class="method"} <i/> GoHome()
: Go to Home page of your device without quiting app.

{:id="DeviceInfo.Hardware" class="method returns text"} <i/> Hardware()
: Get device Hardware Name.

{:id="DeviceInfo.Id" class="method returns text"} <i/> Id()
: Get device Build ID.

{:id="DeviceInfo.InternalStorageAvailable" class="method returns number"} <i/> InternalStorageAvailable()
: Returns size of available internal storage in Gigabytes

{:id="DeviceInfo.InternalStorageTotal" class="method returns number"} <i/> InternalStorageTotal()
: Returns total size of internal storage in Gigabytes

{:id="DeviceInfo.InternalStorageUsed" class="method returns number"} <i/> InternalStorageUsed()
: Returns size of used-internal-storage in Gigabytes

{:id="DeviceInfo.LaunchApp" class="method"} <i/> LaunchApp(*packageName*{:.text})
: Launch App

{:id="DeviceInfo.Manufacturer" class="method returns text"} <i/> Manufacturer()
: Get device manufacturer.

{:id="DeviceInfo.MemoryFree" class="method returns number"} <i/> MemoryFree()
: Total free RAM size in Gigabytes

{:id="DeviceInfo.MemoryTotal" class="method returns number"} <i/> MemoryTotal()
: Total RAM size in Gigabytes

{:id="DeviceInfo.MemoryUsed" class="method returns number"} <i/> MemoryUsed()
: Returns size of used-memory in Gigabytes

{:id="DeviceInfo.ModelName" class="method returns text"} <i/> ModelName()
: Get device Model Name.

{:id="DeviceInfo.Product" class="method returns text"} <i/> Product()
: Get device Product Name.

{:id="DeviceInfo.SDK_Version" class="method returns number"} <i/> SDK_Version()
: Get device SDK Version.

{:id="DeviceInfo.ShowAlert" class="method"} <i/> ShowAlert(*message*{:.text})
: Show An Alert

{:id="DeviceInfo.SysLang" class="method returns text"} <i/> SysLang()
: Get System default language

{:id="DeviceInfo.SysLangIsEn" class="method returns boolean"} <i/> SysLangIsEn()
: Return if system default language is english

{:id="DeviceInfo.SysLangIsZh" class="method returns boolean"} <i/> SysLangIsZh()
: Return if system default language is chinese

{:id="DeviceInfo.Type" class="method returns text"} <i/> Type()
: Get device build type.

{:id="DeviceInfo.containNotch" class="method returns boolean"} <i/> containNotch()
: Detect if your device contains notch (This is coming soon, all devices on Android API 28 or newer will return true currently)

{:id="DeviceInfo.getSimCountryIso" class="method returns text"} <i/> getSimCountryIso()
: Returns the ISO country code equivalent for the SIM provider's country code.

{:id="DeviceInfo.getSimOperator" class="method returns text"} <i/> getSimOperator()
: Returns the MCC+MNC (mobile country code + mobile network code) of the provider of the SIM.

{:id="DeviceInfo.getSimOperatorName" class="method returns text"} <i/> getSimOperatorName()
: Returns the Service Provider Name (SPN).

{:id="DeviceInfo.getSimSerialNumber" class="method returns text"} <i/> getSimSerialNumber()
: Returns the serial number of the SIM

{:id="DeviceInfo.is5GHz_Wifi_Supported" class="method returns boolean"} <i/> is5GHz_Wifi_Supported()
: Check if 5Ghz Band Wifi is supported

{:id="DeviceInfo.isDarkMode" class="method returns boolean"} <i/> isDarkMode()
: Check if your device is in Night / Dark Mode

{:id="DeviceInfo.isDeviceCharging" class="method returns boolean"} <i/> isDeviceCharging()
: Check if your Device is charging.

{:id="DeviceInfo.isDeviceToApRttSupported" class="method returns boolean"} <i/> isDeviceToApRttSupported()
: Check if Device To ApRtt Supported

{:id="DeviceInfo.isEmulator" class="method returns boolean"} <i/> isEmulator()
: Detect if your device is an emulator

{:id="DeviceInfo.isEnhancedPowerReportingSupported" class="method returns boolean"} <i/> isEnhancedPowerReportingSupported()
: Check if Enhanced Power Reporting Supported

{:id="DeviceInfo.isPreferredNetworkOffloadSupported" class="method returns boolean"} <i/> isPreferredNetworkOffloadSupported()
: Check if Preferred Network Offload Supported

{:id="DeviceInfo.isWifiEnabled" class="method returns boolean"} <i/> isWifiEnabled()
: Check if Wifi is enabled

{:id="DeviceInfo.isWifiScanAlwaysAvailable" class="method returns boolean"} <i/> isWifiScanAlwaysAvailable()
: Check if Wifi Scanning is always available.

{:id="DeviceInfo.isWifiTdlsSupported" class="method returns boolean"} <i/> isWifiTdlsSupported()
: Check if Wifi Tdls Supported.

{:id="DeviceInfo.isWifi_P2P_Supported" class="method returns boolean"} <i/> isWifi_P2P_Supported()
: Check if Wifi P2P Supported

## Screenshot  {#Screenshot}

Component for Screenshot



### Properties  {#Screenshot-Properties}

{:.properties}

{:id="Screenshot.FileName" .text} *FileName*
: Set fileName

### Events  {#Screenshot-Events}

{:.events}

{:id="Screenshot.AfterScreenshot"} AfterScreenshot(*image*{:.text})
: The AfterScreenshot event

### Methods  {#Screenshot-Methods}

{:.methods}

{:id="Screenshot.TakeScreenshot" class="method"} <i/> TakeScreenshot()
: Take a screenshot
