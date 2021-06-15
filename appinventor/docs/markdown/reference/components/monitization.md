---
layout: documentation
title: Monitization
---

[&laquo; Back to index](index.html)
# Monitization

Table of Contents:

* [AndroidPay](#AndroidPay)
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
