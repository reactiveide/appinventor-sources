---
layout: documentation
title: Experimental
---

[&laquo; Back to index](index.html)
# Experimental

Table of Contents:

* [DynamicCard](#DynamicCard)
* [DynamicWebView](#DynamicWebView)
* [FirebaseDB](#FirebaseDB)
* [ImageUtil](#ImageUtil)

## DynamicCard  {#DynamicCard}

Component for DynamicCard



### Properties  {#DynamicCard-Properties}

{:.properties}
None


### Events  {#DynamicCard-Events}

{:.events}

{:id="DynamicCard.CardClicked"} CardClicked(*cardID*{:.number})
: Event for CardClicked

### Methods  {#DynamicCard-Methods}

{:.methods}

{:id="DynamicCard.AddCard" class="method"} <i/> AddCard(*id*{:.number},*width*{:.number},*height*{:.number},*layoutId*{:.number})
: Add A CardView

{:id="DynamicCard.DeleteCard" class="method"} <i/> DeleteCard(*id*{:.number})
: Method for DeleteCard

{:id="DynamicCard.SetBackroundColor" class="method"} <i/> SetBackroundColor(*id*{:.number},*color*{:.any})
: Method for SetBackroundColor

{:id="DynamicCard.SetCardClickable" class="method"} <i/> SetCardClickable(*clickable*{:.boolean},*id*{:.number})
: Method for SetCardClickable

{:id="DynamicCard.SetCardSize" class="method"} <i/> SetCardSize(*id*{:.number},*width*{:.number},*height*{:.number})
: Method for SetCardSize

{:id="DynamicCard.SetElevation" class="method"} <i/> SetElevation(*id*{:.number},*elevation*{:.number})
: Method for SetElevation

{:id="DynamicCard.SetRadius" class="method"} <i/> SetRadius(*id*{:.number},*radius*{:.number})
: Method for SetRadius

{:id="DynamicCard.SetVisible" class="method"} <i/> SetVisible(*id*{:.number},*visible*{:.boolean})
: Method for SetVisible

{:id="DynamicCard.isVisible" class="method returns boolean"} <i/> isVisible(*viewID*{:.number})
: Get the view's visibility

## DynamicWebView  {#DynamicWebView}

Component for DynamicWebView



### Properties  {#DynamicWebView-Properties}

{:.properties}
None


### Events  {#DynamicWebView-Events}

{:.events}
None


### Methods  {#DynamicWebView-Methods}

{:.methods}

{:id="DynamicWebView.AddWebView" class="method"} <i/> AddWebView(*webViewID*{:.number},*width*{:.number},*height*{:.number},*parentLayoutID*{:.number})
: Add A WebView

{:id="DynamicWebView.DeleteView" class="method"} <i/> DeleteView(*webViewID*{:.number})
: Delete the selected view

{:id="DynamicWebView.canGoBack" class="method returns boolean"} <i/> canGoBack(*webViewID*{:.number})
: Get if the Dynamic WebView can go back

{:id="DynamicWebView.canGoForward" class="method returns boolean"} <i/> canGoForward(*webViewID*{:.number})
: Get if the Dynamic WebView can go forward

{:id="DynamicWebView.getWebViewURL" class="method returns text"} <i/> getWebViewURL(*webViewID*{:.number})
: Get the Dynamic WebView's current URL

{:id="DynamicWebView.goBack" class="method"} <i/> goBack(*webViewID*{:.number})
: Call the Dynamic WebView to go back

{:id="DynamicWebView.goForward" class="method"} <i/> goForward(*webViewID*{:.number})
: Call the Dynamic WebView to go forward

{:id="DynamicWebView.isVisible" class="method returns boolean"} <i/> isVisible(*webViewID*{:.number})
: Get the view's visibility

{:id="DynamicWebView.setURL" class="method"} <i/> setURL(*webViewID*{:.number},*url*{:.text})
: Call the Dynamic WebView to go to a specific URL

{:id="DynamicWebView.setVisible" class="method"} <i/> setVisible(*webViewID*{:.number},*isVisible*{:.boolean})
: Set the view's visibility

## FirebaseDB  {#FirebaseDB}

The Firebase component communicates with a Web service to store
 and retrieve information.  The component has methods to
 store a value under a tag and to retrieve the value associated with
 the tag. It also possesses a listener to fire events when stored
 values are changed.

 [Additional Information](../other/firebase.html)



### Properties  {#FirebaseDB-Properties}

{:.properties}

{:id="FirebaseDB.DeveloperBucket" .text .do} *DeveloperBucket*
: Getter for the DeveloperBucket.

{:id="FirebaseDB.FirebaseToken" .text .do} *FirebaseToken*
: Getter for the FirebaseToken.

{:id="FirebaseDB.FirebaseURL" .text .do} *FirebaseURL*
: Specifies the URL for the Firebase.

 The default value is currently my private Firebase URL, but this will
 eventually changed once the App Inventor Candle plan is activated.

{:id="FirebaseDB.Persist" .boolean .wo .do} *Persist*
: If true, variables will retain their values when off-line and the App exits. Values will be uploaded to Firebase the next time the App is run while connected to the network. This is useful for applications which will gather data while not connected to the network. Note: AppendValue and RemoveFirst will not work correctly when off-line, they require a network connection.<br/><br/> <i>Note</i>: If you set Persist on any Firebase component, on any screen, it makes all Firebase components on all screens persistent. This is a limitation of the low level Firebase library. Also be aware that if you want to set persist to true, you should do so before connecting the Companion for incremental development.

{:id="FirebaseDB.ProjectBucket" .text} *ProjectBucket*
: Getter for the ProjectBucket.

### Events  {#FirebaseDB-Events}

{:.events}

{:id="FirebaseDB.DataChanged"} DataChanged(*tag*{:.text},*value*{:.any})
: Indicates that the data in the Firebase has changed.
 Launches an event with the tag and value that have been updated.

{:id="FirebaseDB.FirebaseError"} FirebaseError(*message*{:.text})
: Indicates that the communication with the Firebase signaled an error.

{:id="FirebaseDB.FirstRemoved"} FirstRemoved(*value*{:.any})
: Event triggered by the "RemoveFirst" function. The argument "value" is the object that was the first in the list, and which is now removed.

{:id="FirebaseDB.GotValue"} GotValue(*tag*{:.text},*value*{:.any})
: Indicates that a GetValue request has succeeded.

{:id="FirebaseDB.TagList"} TagList(*value*{:.list})
: Event triggered when we have received the list of known tags. Used with the "GetTagList" Function.

### Methods  {#FirebaseDB-Methods}

{:.methods}

{:id="FirebaseDB.AppendValue" class="method"} <i/> AppendValue(*tag*{:.text},*valueToAdd*{:.any})
: Append a value to the end of a list atomically. If two devices use this function simultaneously, both will be appended and no data lost.

{:id="FirebaseDB.ClearTag" class="method"} <i/> ClearTag(*tag*{:.text})
: Asks Firebase to forget (delete or set to "null") a given tag.

{:id="FirebaseDB.GetTagList" class="method"} <i/> GetTagList()
: Get the list of tags for this application. When complete a "TagList" event will be triggered with the list of known tags.

{:id="FirebaseDB.GetValue" class="method"} <i/> GetValue(*tag*{:.text},*valueIfTagNotThere*{:.any})
: GetValue asks Firebase to get the value stored under the given tag.
 It will pass valueIfTagNotThere to GotValue if there is no value stored
 under the tag.

{:id="FirebaseDB.RemoveFirst" class="method"} <i/> RemoveFirst(*tag*{:.text})
: Return the first element of a list and atomically remove it. If two devices use this function simultaneously, one will get the first element and the the other will get the second element, or an error if there is no available element. When the element is available, the "FirstRemoved" event will be triggered.

{:id="FirebaseDB.StoreValue" class="method"} <i/> StoreValue(*tag*{:.text},*valueToStore*{:.any})
: Asks Firebase to store the given value under the given tag.

{:id="FirebaseDB.Unauthenticate" class="method"} <i/> Unauthenticate()
: Unauthenticate from Firebase.

   Firebase keeps track of credentials in a cache in shared_prefs
 It will re-use these credentials as long as they are valid. Given
 That we retrieve a FirebaseToken with a version long life, this will
 effectively be forever. Shared_prefs survive an application update
 and depending on how backup is configured on a device, it might survive
 an application removal and reinstallation.

   Normally this is not a problem, however if we change the credentials
 used, for example the App author is switching from one Firebase account
 to another, or invalided their firebase.secret, this cached credential
 is invalid, but will continue to be used, which results in errors.

   This function permits us to unauthenticate, which tosses the cached
 credentials. The next time authentication is needed we will use our
 current FirebaseToken and get fresh credentials.

## ImageUtil  {#ImageUtil}

Component for ImageUtil



### Properties  {#ImageUtil-Properties}

{:.properties}
None


### Events  {#ImageUtil-Events}

{:.events}
None


### Methods  {#ImageUtil-Methods}

{:.methods}

{:id="ImageUtil.resizeImageRetainRadio" class="method"} <i/> resizeImageRetainRadio(*imageInputPath*{:.text},*imageOutputPath*{:.text},*size*{:.number})
: Method for resizeImageRetainRadio
