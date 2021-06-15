---
layout: documentation
title: Dynamic Components
---

[&laquo; Back to index](index.html)
# Dynamic Components

Table of Contents:

* [DynamicAdmobBanner](#DynamicAdmobBanner)
* [DynamicArrangement](#DynamicArrangement)
* [DynamicButton](#DynamicButton)
* [DynamicCheckBox](#DynamicCheckBox)
* [DynamicCircularProgress](#DynamicCircularProgress)
* [DynamicHSArrangement](#DynamicHSArrangement)
* [DynamicImage](#DynamicImage)
* [DynamicLabel](#DynamicLabel)
* [DynamicSpace](#DynamicSpace)
* [DynamicSwitch](#DynamicSwitch)
* [DynamicTextBox](#DynamicTextBox)
* [DynamicVSArrangement](#DynamicVSArrangement)

## DynamicAdmobBanner  {#DynamicAdmobBanner}

Component for DynamicAdmobBanner



### Properties  {#DynamicAdmobBanner-Properties}

{:.properties}
None


### Events  {#DynamicAdmobBanner-Events}

{:.events}

{:id="DynamicAdmobBanner.AdClicked"} AdClicked(*fid*{:.number})
: Event for AdClicked

{:id="DynamicAdmobBanner.AdClosed"} AdClosed(*fid*{:.number})
: Event for AdClosed

{:id="DynamicAdmobBanner.AdFailedToLoad"} AdFailedToLoad(*errorCode*{:.number},*fid*{:.number})
: Event for AdFailedToLoad

{:id="DynamicAdmobBanner.AdLeftApplication"} AdLeftApplication(*fid*{:.number})
: Event for AdLeftApplication

{:id="DynamicAdmobBanner.AdLoaded"} AdLoaded(*fid*{:.number})
: Event for AdLoaded

{:id="DynamicAdmobBanner.AdOpenend"} AdOpenend(*fid*{:.number})
: Event for AdOpenend

### Methods  {#DynamicAdmobBanner-Methods}

{:.methods}

{:id="DynamicAdmobBanner.AddBanner" class="method"} <i/> AddBanner(*id*{:.number},*layoutId*{:.number})
: Add A Admob Banner

{:id="DynamicAdmobBanner.DeleteBanner" class="method"} <i/> DeleteBanner(*id*{:.number})
: Method for DeleteBanner

{:id="DynamicAdmobBanner.LoadAd" class="method"} <i/> LoadAd(*id*{:.number})
: Method for LoadAd

{:id="DynamicAdmobBanner.SetAdUnitID" class="method"} <i/> SetAdUnitID(*id*{:.number},*adunit*{:.text})
: Method for SetAdUnitID

{:id="DynamicAdmobBanner.SetBannerSize" class="method"} <i/> SetBannerSize(*id*{:.number},*width*{:.number},*height*{:.number})
: Method for SetBannerSize

{:id="DynamicAdmobBanner.SetVisible" class="method"} <i/> SetVisible(*id*{:.number},*visible*{:.boolean})
: Method for SetVisible

{:id="DynamicAdmobBanner.isVisible" class="method returns boolean"} <i/> isVisible(*viewID*{:.number})
: Get the view's visibility

## DynamicArrangement  {#DynamicArrangement}

Component for DynamicArrangement



### Properties  {#DynamicArrangement-Properties}

{:.properties}
None


### Events  {#DynamicArrangement-Events}

{:.events}

{:id="DynamicArrangement.ArrangementClicked"} ArrangementClicked(*iD*{:.number})
: Event for ArrangementClicked

### Methods  {#DynamicArrangement-Methods}

{:.methods}

{:id="DynamicArrangement.AddArrangement" class="method"} <i/> AddArrangement(*id*{:.number},*width*{:.number},*height*{:.number},*layout*{:.component},*horizontal*{:.boolean},*alignment*{:.number},*parentArrangementId*{:.number})
: Add A Arrangement

{:id="DynamicArrangement.DeleteArrangement" class="method"} <i/> DeleteArrangement(*id*{:.number})
: Method for DeleteArrangement

{:id="DynamicArrangement.PercentSizeHeight" class="method returns number"} <i/> PercentSizeHeight(*percent*{:.number})
: Method for PercentSizeHeight

{:id="DynamicArrangement.PercentSizeWidth" class="method returns number"} <i/> PercentSizeWidth(*percent*{:.number})
: Method for PercentSizeWidth

{:id="DynamicArrangement.SetArrangementClickable" class="method"} <i/> SetArrangementClickable(*clickable*{:.boolean},*id*{:.number})
: Method for SetArrangementClickable

{:id="DynamicArrangement.SetBackroundColor" class="method"} <i/> SetBackroundColor(*id*{:.number},*color*{:.any})
: Method for SetBackroundColor

{:id="DynamicArrangement.SetSize" class="method"} <i/> SetSize(*id*{:.number},*width*{:.number},*height*{:.number})
: Method for SetSize

{:id="DynamicArrangement.SetVisible" class="method"} <i/> SetVisible(*id*{:.number},*visible*{:.boolean})
: Method for SetVisible

{:id="DynamicArrangement.isVisible" class="method returns boolean"} <i/> isVisible(*viewID*{:.number})
: Get the view's visibility

{:id="DynamicArrangement.setCornerRadius" class="method"} <i/> setCornerRadius(*id*{:.number},*TopLeft*{:.number},*TopRight*{:.number},*BottomLeft*{:.number},*BottomRight*{:.number},*color*{:.any})
: Set the corner radius of DynamicArrangement.

{:id="DynamicArrangement.setPadding" class="method"} <i/> setPadding(*id*{:.number},*Top*{:.number},*Bottom*{:.number},*Left*{:.number},*Right*{:.number})
: Set padding.

## DynamicButton  {#DynamicButton}

Component for DynamicButton



### Properties  {#DynamicButton-Properties}

{:.properties}
None


### Events  {#DynamicButton-Events}

{:.events}

{:id="DynamicButton.ButtonClicked"} ButtonClicked(*btnID*{:.number})
: Event for ButtonClicked

{:id="DynamicButton.ButtonLongClicked"} ButtonLongClicked(*btnID*{:.number})
: Event for ButtonLongClicked

### Methods  {#DynamicButton-Methods}

{:.methods}

{:id="DynamicButton.AddButton" class="method"} <i/> AddButton(*id*{:.number},*text*{:.text},*width*{:.number},*height*{:.number},*layout*{:.number})
: Add A Button

{:id="DynamicButton.CustomFontTypeface" class="method"} <i/> CustomFontTypeface(*id*{:.number},*typefaces*{:.text})
: Specifies the path of the fonts of the DynamicButton.  This will override the settings in FontTypeface.

{:id="DynamicButton.DeleteButton" class="method"} <i/> DeleteButton(*id*{:.number})
: Method for DeleteButton

{:id="DynamicButton.PercentSizeHeight" class="method returns number"} <i/> PercentSizeHeight(*percent*{:.number})
: Method for PercentSizeHeight

{:id="DynamicButton.PercentSizeWidth" class="method returns number"} <i/> PercentSizeWidth(*percent*{:.number})
: Method for PercentSizeWidth

{:id="DynamicButton.SetButtonColor" class="method"} <i/> SetButtonColor(*id*{:.number},*color*{:.any})
: Method for SetButtonColor

{:id="DynamicButton.SetButtonEnabled" class="method"} <i/> SetButtonEnabled(*id*{:.number},*enabled*{:.boolean})
: Method for SetButtonEnabled

{:id="DynamicButton.SetButtonSize" class="method"} <i/> SetButtonSize(*id*{:.number},*width*{:.number},*height*{:.number})
: Method for SetButtonSize

{:id="DynamicButton.SetButtonText" class="method"} <i/> SetButtonText(*id*{:.number},*text*{:.text})
: Method for SetButtonText

{:id="DynamicButton.SetTextColor" class="method"} <i/> SetTextColor(*id*{:.number},*color*{:.any})
: Method for SetTextColor

{:id="DynamicButton.SetTextSize" class="method"} <i/> SetTextSize(*id*{:.number},*size*{:.number})
: Method for SetTextSize

{:id="DynamicButton.SetVisible" class="method"} <i/> SetVisible(*id*{:.number},*visible*{:.boolean})
: Method for SetVisible

{:id="DynamicButton.isVisible" class="method returns boolean"} <i/> isVisible(*viewID*{:.number})
: Get the view's visibility

## DynamicCheckBox  {#DynamicCheckBox}

Component for DynamicCheckBox



### Properties  {#DynamicCheckBox-Properties}

{:.properties}
None


### Events  {#DynamicCheckBox-Events}

{:.events}

{:id="DynamicCheckBox.CheckedChanged"} CheckedChanged(*id*{:.number},*isChecked*{:.boolean})
: Event for CheckedChanged

### Methods  {#DynamicCheckBox-Methods}

{:.methods}

{:id="DynamicCheckBox.AddCheckBox" class="method"} <i/> AddCheckBox(*id*{:.number},*text*{:.text},*width*{:.number},*height*{:.number},*layout*{:.number})
: Add A CheckBox

{:id="DynamicCheckBox.DeleteCheckBox" class="method"} <i/> DeleteCheckBox(*id*{:.number})
: Method for DeleteCheckBox

{:id="DynamicCheckBox.PercentSizeHeight" class="method returns number"} <i/> PercentSizeHeight(*percent*{:.number})
: Method for PercentSizeHeight

{:id="DynamicCheckBox.PercentSizeWidth" class="method returns number"} <i/> PercentSizeWidth(*percent*{:.number})
: Method for PercentSizeWidth

{:id="DynamicCheckBox.SetCheckBoxColor" class="method"} <i/> SetCheckBoxColor(*id*{:.number},*color*{:.any})
: Method for SetCheckBoxColor

{:id="DynamicCheckBox.SetCheckBoxEnabled" class="method"} <i/> SetCheckBoxEnabled(*id*{:.number},*enabled*{:.boolean})
: Method for SetCheckBoxEnabled

{:id="DynamicCheckBox.SetCheckBoxSize" class="method"} <i/> SetCheckBoxSize(*id*{:.number},*width*{:.number},*height*{:.number})
: Method for SetCheckBoxSize

{:id="DynamicCheckBox.SetTextColor" class="method"} <i/> SetTextColor(*id*{:.number},*color*{:.any})
: Method for SetTextColor

{:id="DynamicCheckBox.SetVisible" class="method"} <i/> SetVisible(*id*{:.number},*visible*{:.boolean})
: Method for SetVisible

{:id="DynamicCheckBox.isVisible" class="method returns boolean"} <i/> isVisible(*viewID*{:.number})
: Get the view's visibility

## DynamicCircularProgress  {#DynamicCircularProgress}

Component for DynamicCircularProgress



### Properties  {#DynamicCircularProgress-Properties}

{:.properties}
None


### Events  {#DynamicCircularProgress-Events}

{:.events}

{:id="DynamicCircularProgress.CircularProgressClicked"} CircularProgressClicked(*btnID*{:.number})
: Event for CircularProgressClicked

{:id="DynamicCircularProgress.CircularProgressLongClicked"} CircularProgressLongClicked(*btnID*{:.number})
: Event for CircularProgressLongClicked

### Methods  {#DynamicCircularProgress-Methods}

{:.methods}

{:id="DynamicCircularProgress.AddCircularProgress" class="method"} <i/> AddCircularProgress(*id*{:.number},*width*{:.number},*height*{:.number},*layout*{:.number},*indeterminate*{:.boolean})
: Add A CircularProgress

{:id="DynamicCircularProgress.DeleteCircularProgress" class="method"} <i/> DeleteCircularProgress(*id*{:.number})
: Method for DeleteCircularProgress

{:id="DynamicCircularProgress.SetCircularProgressSize" class="method"} <i/> SetCircularProgressSize(*id*{:.number},*width*{:.number},*height*{:.number})
: Method for SetCircularProgressSize

{:id="DynamicCircularProgress.SetProgressBackgroundBarColor" class="method"} <i/> SetProgressBackgroundBarColor(*id*{:.number},*color*{:.any})
: Method for SetProgressBackgroundBarColor

{:id="DynamicCircularProgress.SetVisible" class="method"} <i/> SetVisible(*id*{:.number},*visible*{:.boolean})
: Method for SetVisible

{:id="DynamicCircularProgress.isVisible" class="method returns boolean"} <i/> isVisible(*viewID*{:.number})
: Get the view's visibility

## DynamicHSArrangement  {#DynamicHSArrangement}

Component for DynamicHSArrangement



### Properties  {#DynamicHSArrangement-Properties}

{:.properties}
None


### Events  {#DynamicHSArrangement-Events}

{:.events}

{:id="DynamicHSArrangement.ArrangementClicked"} ArrangementClicked(*iD*{:.number})
: Event for ArrangementClicked

### Methods  {#DynamicHSArrangement-Methods}

{:.methods}

{:id="DynamicHSArrangement.AddArrangement" class="method"} <i/> AddArrangement(*id*{:.number},*width*{:.number},*height*{:.number},*alignment*{:.number},*layout*{:.number})
: Add A Arrangement

{:id="DynamicHSArrangement.DeleteArrangement" class="method"} <i/> DeleteArrangement(*id*{:.number})
: Method for DeleteArrangement

{:id="DynamicHSArrangement.PercentSizeHeight" class="method returns number"} <i/> PercentSizeHeight(*percent*{:.number})
: Method for PercentSizeHeight

{:id="DynamicHSArrangement.PercentSizeWidth" class="method returns number"} <i/> PercentSizeWidth(*percent*{:.number})
: Method for PercentSizeWidth

{:id="DynamicHSArrangement.SetArrangementClickable" class="method"} <i/> SetArrangementClickable(*clickable*{:.boolean},*id*{:.number})
: Method for SetArrangementClickable

{:id="DynamicHSArrangement.SetBackroundColor" class="method"} <i/> SetBackroundColor(*id*{:.number},*color*{:.any})
: Method for SetBackroundColor

{:id="DynamicHSArrangement.SetSize" class="method"} <i/> SetSize(*id*{:.number},*width*{:.number},*height*{:.number})
: Method for SetSize

{:id="DynamicHSArrangement.SetVisible" class="method"} <i/> SetVisible(*id*{:.number},*visible*{:.boolean})
: Method for SetVisible

{:id="DynamicHSArrangement.isVisible" class="method returns boolean"} <i/> isVisible(*viewID*{:.number})
: Get the view's visibility

## DynamicImage  {#DynamicImage}

Component for DynamicImage



### Properties  {#DynamicImage-Properties}

{:.properties}
None


### Events  {#DynamicImage-Events}

{:.events}

{:id="DynamicImage.ButtonClicked"} ButtonClicked(*btnID*{:.number})
: User tapped and released the component.

{:id="DynamicImage.ButtonLongClicked"} ButtonLongClicked(*btnID*{:.number})
: User held the component down.

### Methods  {#DynamicImage-Methods}

{:.methods}

{:id="DynamicImage.AddImage" class="method"} <i/> AddImage(*id*{:.number},*width*{:.number},*height*{:.number},*image*{:.text},*layoutId*{:.number})
: Add A Image

{:id="DynamicImage.DeleteImage" class="method"} <i/> DeleteImage(*id*{:.number})
: Method for DeleteImage

{:id="DynamicImage.PercentSizeHeight" class="method returns number"} <i/> PercentSizeHeight(*percent*{:.number})
: Method for PercentSizeHeight

{:id="DynamicImage.PercentSizeWidth" class="method returns number"} <i/> PercentSizeWidth(*percent*{:.number})
: Method for PercentSizeWidth

{:id="DynamicImage.SetImage" class="method"} <i/> SetImage(*id*{:.number},*image*{:.text})
: Method for SetImage

{:id="DynamicImage.SetSize" class="method"} <i/> SetSize(*id*{:.number},*width*{:.number},*height*{:.number})
: Method for SetSize

{:id="DynamicImage.SetVisible" class="method"} <i/> SetVisible(*id*{:.number},*visible*{:.boolean})
: Method for SetVisible

{:id="DynamicImage.isVisible" class="method returns boolean"} <i/> isVisible(*viewID*{:.number})
: Get the view's visibility

## DynamicLabel  {#DynamicLabel}

Component for DynamicLabel



### Properties  {#DynamicLabel-Properties}

{:.properties}
None


### Events  {#DynamicLabel-Events}

{:.events}

{:id="DynamicLabel.ButtonClicked"} ButtonClicked(*btnID*{:.number})
: User tapped and released the component.

{:id="DynamicLabel.ButtonLongClicked"} ButtonLongClicked(*btnID*{:.number})
: User held the component down.

### Methods  {#DynamicLabel-Methods}

{:.methods}

{:id="DynamicLabel.AddLabel" class="method"} <i/> AddLabel(*id*{:.number},*text*{:.text},*layout*{:.number})
: Add A Label

{:id="DynamicLabel.DeleteLabel" class="method"} <i/> DeleteLabel(*id*{:.number})
: Method for DeleteLabel

{:id="DynamicLabel.PercentSizeHeight" class="method returns number"} <i/> PercentSizeHeight(*percent*{:.number})
: Method for PercentSizeHeight

{:id="DynamicLabel.PercentSizeWidth" class="method returns number"} <i/> PercentSizeWidth(*percent*{:.number})
: Method for PercentSizeWidth

{:id="DynamicLabel.SetFont" class="method"} <i/> SetFont(*id*{:.number},*font*{:.text})
: Method for SetFont

{:id="DynamicLabel.SetLabelColor" class="method"} <i/> SetLabelColor(*id*{:.number},*color*{:.any})
: Method for SetLabelColor

{:id="DynamicLabel.SetLabelSize" class="method"} <i/> SetLabelSize(*id*{:.number},*size*{:.number})
: Method for SetLabelSize

{:id="DynamicLabel.SetSize" class="method"} <i/> SetSize(*id*{:.number},*width*{:.number},*height*{:.number})
: Method for SetSize

{:id="DynamicLabel.SetText" class="method"} <i/> SetText(*id*{:.number},*text*{:.text})
: Method for SetText

{:id="DynamicLabel.SetVisible" class="method"} <i/> SetVisible(*id*{:.number},*visible*{:.boolean})
: Method for SetVisible

{:id="DynamicLabel.isVisible" class="method returns boolean"} <i/> isVisible(*viewID*{:.number})
: Get the view's visibility

## DynamicSpace  {#DynamicSpace}

Component for DynamicSpace



### Properties  {#DynamicSpace-Properties}

{:.properties}
None


### Events  {#DynamicSpace-Events}

{:.events}
None


### Methods  {#DynamicSpace-Methods}

{:.methods}

{:id="DynamicSpace.AddSpace" class="method"} <i/> AddSpace(*id*{:.number},*width*{:.number},*height*{:.number},*layoutId*{:.number})
: Add A Space

{:id="DynamicSpace.DeleteSpace" class="method"} <i/> DeleteSpace(*id*{:.number})
: Method for DeleteSpace

{:id="DynamicSpace.PercentSizeHeight" class="method returns number"} <i/> PercentSizeHeight(*percent*{:.number})
: Method for PercentSizeHeight

{:id="DynamicSpace.PercentSizeWidth" class="method returns number"} <i/> PercentSizeWidth(*percent*{:.number})
: Method for PercentSizeWidth

{:id="DynamicSpace.SetSize" class="method"} <i/> SetSize(*id*{:.number},*width*{:.number},*height*{:.number})
: Method for SetSize

{:id="DynamicSpace.SetVisible" class="method"} <i/> SetVisible(*id*{:.number},*visible*{:.boolean})
: Method for SetVisible

{:id="DynamicSpace.isVisible" class="method returns boolean"} <i/> isVisible(*viewID*{:.number})
: Get the view's visibility

## DynamicSwitch  {#DynamicSwitch}

Component for DynamicSwitch



### Properties  {#DynamicSwitch-Properties}

{:.properties}
None


### Events  {#DynamicSwitch-Events}

{:.events}

{:id="DynamicSwitch.CheckedChanged"} CheckedChanged(*id*{:.number},*isChecked*{:.boolean})
: Event for CheckedChanged

### Methods  {#DynamicSwitch-Methods}

{:.methods}

{:id="DynamicSwitch.AddSwitch" class="method"} <i/> AddSwitch(*id*{:.number},*text*{:.text},*width*{:.number},*height*{:.number},*layout*{:.number})
: Add A Switch

{:id="DynamicSwitch.DeleteSwitch" class="method"} <i/> DeleteSwitch(*id*{:.number})
: Method for DeleteSwitch

{:id="DynamicSwitch.PercentSizeHeight" class="method returns number"} <i/> PercentSizeHeight(*percent*{:.number})
: Method for PercentSizeHeight

{:id="DynamicSwitch.PercentSizeWidth" class="method returns number"} <i/> PercentSizeWidth(*percent*{:.number})
: Method for PercentSizeWidth

{:id="DynamicSwitch.SetSwitchColor" class="method"} <i/> SetSwitchColor(*id*{:.number},*color*{:.any})
: Method for SetSwitchColor

{:id="DynamicSwitch.SetSwitchEnabled" class="method"} <i/> SetSwitchEnabled(*id*{:.number},*enabled*{:.boolean})
: Method for SetSwitchEnabled

{:id="DynamicSwitch.SetSwitchSize" class="method"} <i/> SetSwitchSize(*id*{:.number},*width*{:.number},*height*{:.number})
: Method for SetSwitchSize

{:id="DynamicSwitch.SetTextColor" class="method"} <i/> SetTextColor(*id*{:.number},*color*{:.any})
: Method for SetTextColor

{:id="DynamicSwitch.SetVisible" class="method"} <i/> SetVisible(*id*{:.number},*visible*{:.boolean})
: Method for SetVisible

{:id="DynamicSwitch.isVisible" class="method returns boolean"} <i/> isVisible(*viewID*{:.number})
: Get the view's visibility

## DynamicTextBox  {#DynamicTextBox}

Component for DynamicTextBox



### Properties  {#DynamicTextBox-Properties}

{:.properties}
None


### Events  {#DynamicTextBox-Events}

{:.events}
None


### Methods  {#DynamicTextBox-Methods}

{:.methods}

{:id="DynamicTextBox.AddEditText" class="method"} <i/> AddEditText(*id*{:.number},*text*{:.text},*width*{:.number},*height*{:.number},*layoutId*{:.number})
: Add A EditText

{:id="DynamicTextBox.CustomFontTypeface" class="method"} <i/> CustomFontTypeface(*id*{:.number},*typefaces*{:.text})
: Specifies the path of the fonts of the DynamicTextBox.  This will override the settings in FontTypeface.

{:id="DynamicTextBox.DeleteEditText" class="method"} <i/> DeleteEditText(*id*{:.number})
: Method for DeleteEditText

{:id="DynamicTextBox.PercentSizeHeight" class="method returns number"} <i/> PercentSizeHeight(*percent*{:.number})
: Method for PercentSizeHeight

{:id="DynamicTextBox.PercentSizeWidth" class="method returns number"} <i/> PercentSizeWidth(*percent*{:.number})
: Method for PercentSizeWidth

{:id="DynamicTextBox.SetBackgroundColor" class="method"} <i/> SetBackgroundColor(*id*{:.number},*color*{:.any})
: Method for SetBackgroundColor

{:id="DynamicTextBox.SetEditTextEnabled" class="method"} <i/> SetEditTextEnabled(*id*{:.number},*enabled*{:.boolean})
: Method for SetEditTextEnabled

{:id="DynamicTextBox.SetEditTextHint" class="method"} <i/> SetEditTextHint(*id*{:.number},*text*{:.text})
: Method for SetEditTextHint

{:id="DynamicTextBox.SetEditTextSize" class="method"} <i/> SetEditTextSize(*id*{:.number},*width*{:.number},*height*{:.number})
: Method for SetEditTextSize

{:id="DynamicTextBox.SetEditTextText" class="method"} <i/> SetEditTextText(*id*{:.number},*text*{:.text})
: Method for SetEditTextText

{:id="DynamicTextBox.SetTextColor" class="method"} <i/> SetTextColor(*id*{:.number},*color*{:.any})
: Method for SetTextColor

{:id="DynamicTextBox.SetTextSize" class="method"} <i/> SetTextSize(*id*{:.number},*size*{:.number})
: Method for SetTextSize

{:id="DynamicTextBox.SetVisible" class="method"} <i/> SetVisible(*id*{:.number},*visible*{:.boolean})
: Method for SetVisible

{:id="DynamicTextBox.isVisible" class="method returns boolean"} <i/> isVisible(*viewID*{:.number})
: Get the view's visibility

## DynamicVSArrangement  {#DynamicVSArrangement}

Component for DynamicVSArrangement



### Properties  {#DynamicVSArrangement-Properties}

{:.properties}
None


### Events  {#DynamicVSArrangement-Events}

{:.events}

{:id="DynamicVSArrangement.ArrangementClicked"} ArrangementClicked(*iD*{:.number})
: Event for ArrangementClicked

### Methods  {#DynamicVSArrangement-Methods}

{:.methods}

{:id="DynamicVSArrangement.AddArrangement" class="method"} <i/> AddArrangement(*id*{:.number},*width*{:.number},*height*{:.number},*alignment*{:.number},*layout*{:.number})
: Add A Arrangement

{:id="DynamicVSArrangement.DeleteArrangement" class="method"} <i/> DeleteArrangement(*id*{:.number})
: Method for DeleteArrangement

{:id="DynamicVSArrangement.PercentSizeHeight" class="method returns number"} <i/> PercentSizeHeight(*percent*{:.number})
: Method for PercentSizeHeight

{:id="DynamicVSArrangement.PercentSizeWidth" class="method returns number"} <i/> PercentSizeWidth(*percent*{:.number})
: Method for PercentSizeWidth

{:id="DynamicVSArrangement.SetArrangementClickable" class="method"} <i/> SetArrangementClickable(*clickable*{:.boolean},*id*{:.number})
: Method for SetArrangementClickable

{:id="DynamicVSArrangement.SetBackroundColor" class="method"} <i/> SetBackroundColor(*id*{:.number},*color*{:.any})
: Method for SetBackroundColor

{:id="DynamicVSArrangement.SetSize" class="method"} <i/> SetSize(*id*{:.number},*width*{:.number},*height*{:.number})
: Method for SetSize

{:id="DynamicVSArrangement.SetVisible" class="method"} <i/> SetVisible(*id*{:.number},*visible*{:.boolean})
: Method for SetVisible

{:id="DynamicVSArrangement.isVisible" class="method returns boolean"} <i/> isVisible(*viewID*{:.number})
: Get the view's visibility
