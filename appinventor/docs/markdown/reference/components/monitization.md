---
layout: documentation
title: Monitization
---

[&laquo; Back to index](index.html)
# Monitization

Table of Contents:

* [AndroidPay](#AndroidPay)
* [FacebookBannerAds](#FacebookBannerAds)
* [FacebookInterstitialAds](#FacebookInterstitialAds)
* [FacebookRewardedAds](#FacebookRewardedAds)
* [PayPal](#PayPal)
* [UPIGateway](#UPIGateway)

## AndroidPay  {#AndroidPay}

Component for AndroidPay



### Properties  {#AndroidPay-Properties}

{:.properties}

{:id="AndroidPay.UPIDialogTitle" .text .do} *UPIDialogTitle*
: Returns the title of UPI Select Dialog

{:id="AndroidPay.UpiId" .text} *UpiId*
: returns the UPI ID

### Events  {#AndroidPay-Events}

{:.events}

{:id="AndroidPay.AppNotFound"} AppNotFound()
: When any UPI app not found in the user's phone

{:id="AndroidPay.CancelledByUser"} CancelledByUser()
: When Payment cancelled by the user

{:id="AndroidPay.InternetError"} InternetError()
: When Internet Error detect in users phone

{:id="AndroidPay.PaymentFailed"} PaymentFailed(*refId*{:.text})
: When Payment failed

{:id="AndroidPay.PaymentSuccessful"} PaymentSuccessful(*refId*{:.text})
: When Payment successful

### Methods  {#AndroidPay-Methods}

{:.methods}

{:id="AndroidPay.MakePayment" class="method"} <i/> MakePayment(*name*{:.text},*note*{:.text},*amount*{:.text},*currency*{:.text})
: Make the payment using UPI

## FacebookBannerAds  {#FacebookBannerAds}

Component for FacebookBannerAds



### Properties  {#FacebookBannerAds-Properties}

{:.properties}

{:id="FacebookBannerAds.BannerSize" .text .wo} *BannerSize*
: Facebook Banner Ads Size

{:id="FacebookBannerAds.Height" .number .bo} *Height*
: Specifies the `FacebookBannerAds`'s vertical height, measured in pixels.

{:id="FacebookBannerAds.HeightPercent" .number .wo .bo} *HeightPercent*
: Specifies the `FacebookBannerAds`'s vertical height as a percentage
 of the [`Screen`'s `Height`](userinterface.html#Screen.Height).

{:id="FacebookBannerAds.PlacementId" .text .wo} *PlacementId*
: Facebook Ads Placement ID

{:id="FacebookBannerAds.Visible" .boolean} *Visible*
: Specifies whether the `FacebookBannerAds` should be visible on the screen.  Value is `true`{:.logic.block}
 if the `FacebookBannerAds` is showing and `false`{:.logic.block} if hidden.

{:id="FacebookBannerAds.Width" .number .bo} *Width*
: Specifies the horizontal width of the `FacebookBannerAds`, measured in pixels.

{:id="FacebookBannerAds.WidthPercent" .number .wo .bo} *WidthPercent*
: Specifies the horizontal width of the `FacebookBannerAds` as a percentage
 of the [`Screen`'s `Width`](userinterface.html#Screen.Width).

### Events  {#FacebookBannerAds-Events}

{:.events}

{:id="FacebookBannerAds.AdClicked"} AdClicked()
: Event for AdClicked

{:id="FacebookBannerAds.AdLoaded"} AdLoaded()
: Event for AdLoaded

{:id="FacebookBannerAds.ErrorOccured"} ErrorOccured(*error*{:.text})
: Event for ErrorOccured

{:id="FacebookBannerAds.LoggingImpression"} LoggingImpression()
: Event for LoggingImpression

### Methods  {#FacebookBannerAds-Methods}

{:.methods}

{:id="FacebookBannerAds.LoadAd" class="method"} <i/> LoadAd()
: Method for LoadAd

## FacebookInterstitialAds  {#FacebookInterstitialAds}

Component for FacebookInterstitialAds



### Properties  {#FacebookInterstitialAds-Properties}

{:.properties}

{:id="FacebookInterstitialAds.PlacementId" .text .wo} *PlacementId*
: Facebook Ads Placement ID

### Events  {#FacebookInterstitialAds-Events}

{:.events}

{:id="FacebookInterstitialAds.AdClicked"} AdClicked()
: Event for AdClicked

{:id="FacebookInterstitialAds.AdLoaded"} AdLoaded()
: Event for AdLoaded

{:id="FacebookInterstitialAds.ErrorOccured"} ErrorOccured(*error*{:.text})
: Event for ErrorOccured

{:id="FacebookInterstitialAds.InterstitialDismissed"} InterstitialDismissed()
: Event for InterstitialDismissed

{:id="FacebookInterstitialAds.InterstitialDisplayed"} InterstitialDisplayed()
: Event for InterstitialDisplayed

{:id="FacebookInterstitialAds.LoggingImpression"} LoggingImpression()
: Event for LoggingImpression

### Methods  {#FacebookInterstitialAds-Methods}

{:.methods}

{:id="FacebookInterstitialAds.IsAdInvalidated" class="method returns boolean"} <i/> IsAdInvalidated()
: Method for IsAdInvalidated

{:id="FacebookInterstitialAds.IsAdLoaded" class="method returns boolean"} <i/> IsAdLoaded()
: Method for IsAdLoaded

{:id="FacebookInterstitialAds.LoadAd" class="method"} <i/> LoadAd()
: Method for LoadAd

{:id="FacebookInterstitialAds.ShowAd" class="method"} <i/> ShowAd()
: Method for ShowAd

## FacebookRewardedAds  {#FacebookRewardedAds}

Component for FacebookRewardedAds



### Properties  {#FacebookRewardedAds-Properties}

{:.properties}

{:id="FacebookRewardedAds.PlacementId" .text .wo} *PlacementId*
: Set Your Facebook ads placementId

### Events  {#FacebookRewardedAds-Events}

{:.events}

{:id="FacebookRewardedAds.AdClicked"} AdClicked()
: Event for AdClicked

{:id="FacebookRewardedAds.AdLoaded"} AdLoaded()
: Event for AdLoaded

{:id="FacebookRewardedAds.ErrorOccured"} ErrorOccured(*error*{:.text})
: Event for ErrorOccured

{:id="FacebookRewardedAds.LoggingImpression"} LoggingImpression()
: Event for LoggingImpression

{:id="FacebookRewardedAds.RewardedVideoClosed"} RewardedVideoClosed()
: Event for RewardedVideoClosed

{:id="FacebookRewardedAds.RewardedVideoCompleted"} RewardedVideoCompleted()
: Event for RewardedVideoCompleted

### Methods  {#FacebookRewardedAds-Methods}

{:.methods}

{:id="FacebookRewardedAds.IsAdInvalidated" class="method returns boolean"} <i/> IsAdInvalidated()
: Method for IsAdInvalidated

{:id="FacebookRewardedAds.IsAdLoaded" class="method returns boolean"} <i/> IsAdLoaded()
: Method for IsAdLoaded

{:id="FacebookRewardedAds.LoadAd" class="method"} <i/> LoadAd()
: Method for LoadAd

{:id="FacebookRewardedAds.ShowAd" class="method"} <i/> ShowAd()
: Method for ShowAd

## PayPal  {#PayPal}

Component for PayPal



### Properties  {#PayPal-Properties}

{:.properties}
None


### Events  {#PayPal-Events}

{:.events}

{:id="PayPal.OnConfigError"} OnConfigError()
: Event for OnConfigError()

{:id="PayPal.OnPaymentCancelled"} OnPaymentCancelled()
: Event for OnPaymentCancelled()

{:id="PayPal.OnPaymentFailed"} OnPaymentFailed(*errorMessage*{:.text})
: Event for OnPaymentFailed()

{:id="PayPal.OnPaymentSuccessful"} OnPaymentSuccessful(*successDetails*{:.text})
: Event for OnPaymentSuccessful()

### Methods  {#PayPal-Methods}

{:.methods}

{:id="PayPal.ConfigPaypal" class="method"} <i/> ConfigPaypal(*clientid*{:.text},*env*{:.text},*merchantname*{:.text})
: Configure the PayPal Payment Gateway by passing clientId and ENVIRONMENT

{:id="PayPal.StartPayment" class="method"} <i/> StartPayment(*amount*{:.text},*currency*{:.text},*description*{:.text})
: Start Payment Gateway by passing amount, currencyType and description for Payment

## UPIGateway  {#UPIGateway}

Component for UPIGateway



### Properties  {#UPIGateway-Properties}

{:.properties}

{:id="UPIGateway.UpiId" .text .wo} *UpiId*
: Property for UpiId

### Events  {#UPIGateway-Events}

{:.events}

{:id="UPIGateway.PaymentCancelled"} PaymentCancelled()
: Payment Cancel

{:id="UPIGateway.PaymentFailed"} PaymentFailed()
: Payment Fail

{:id="UPIGateway.PaymentSuccessful"} PaymentSuccessful()
: Payment Success

{:id="UPIGateway.RegisteredFailed"} RegisteredFailed()
: Registered Fail

### Methods  {#UPIGateway-Methods}

{:.methods}

{:id="UPIGateway.StartPaymentUPI" class="method"} <i/> StartPaymentUPI(*amount*{:.text},*name*{:.text},*note*{:.text})
: Start the Payment
