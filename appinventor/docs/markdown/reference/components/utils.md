---
layout: documentation
title: Utils
---

[&laquo; Back to index](index.html)
# Utils

Table of Contents:

* [CustomDownload](#CustomDownload)
* [FileUtils](#FileUtils)
* [InAppUpdate](#InAppUpdate)
* [PackageUtils](#PackageUtils)

## CustomDownload  {#CustomDownload}

Component for CustomDownload



### Properties  {#CustomDownload-Properties}

{:.properties}

{:id="CustomDownload.DownloadName" .text .wo} *DownloadName*
: Set Download File Name(Also Include File Extension)

{:id="CustomDownload.DownloadPath" .text .wo} *DownloadPath*
: Set Path To Store Downloaded File

{:id="CustomDownload.DownloadingLink" .text .wo} *DownloadingLink*
: Set Downloading File Link

### Events  {#CustomDownload-Events}

{:.events}

{:id="CustomDownload.DownloadCancled"} DownloadCancled()
: Event for DownloadCancled

{:id="CustomDownload.DownloadComplete"} DownloadComplete()
: Event for DownloadComplete

{:id="CustomDownload.DownloadPaused"} DownloadPaused()
: Event for DownloadPaused

{:id="CustomDownload.DownloadStartOrResume"} DownloadStartOrResume()
: Event for DownloadStartOrResume

{:id="CustomDownload.ErrorOccured"} ErrorOccured(*error*{:.text})
: Event for ErrorOccured

{:id="CustomDownload.ProgressChanged"} ProgressChanged(*progressPercent*{:.number},*progressBytes*{:.number},*totalBytes*{:.number})
: Event for ProgressChanged

### Methods  {#CustomDownload-Methods}

{:.methods}

{:id="CustomDownload.CancelDownload" class="method"} <i/> CancelDownload()
: Method for CancelDownload

{:id="CustomDownload.DownloadFile" class="method"} <i/> DownloadFile()
: Method for DownloadFile

{:id="CustomDownload.PauseDownload" class="method"} <i/> PauseDownload()
: Method for PauseDownload

{:id="CustomDownload.ResumeDownload" class="method"} <i/> ResumeDownload()
: Method for ResumeDownload

## FileUtils  {#FileUtils}

Component for FileUtils



### Properties  {#FileUtils-Properties}

{:.properties}
None


### Events  {#FileUtils-Events}

{:.events}

{:id="FileUtils.DirectoryCreated"} DirectoryCreated(*IsDirectoryCreated*{:.boolean})
: Event raised after 'Create Directory' method.If directory has been created then returns true else false

{:id="FileUtils.FileCopied"} FileCopied(*success*{:.boolean})
: Event raised after 'CopyFileAsync' method.If file copied then returns true else false

{:id="FileUtils.FileMoved"} FileMoved(*success*{:.boolean})
: Event raised after 'MoveFileAsync' method.If file is moved then returns true else false

{:id="FileUtils.FileOrFolderDeleted"} FileOrFolderDeleted(*success*{:.boolean})
: Event raised after 'Delete' method.If file or folder is deleted then returns true else false

{:id="FileUtils.GotFileList"} GotFileList(*filesList*{:.list})
: Event raised after 'FileAndFoldersList' method.Get all files and folders from given directory

### Methods  {#FileUtils-Methods}

{:.methods}

{:id="FileUtils.ApplicationSpecificDirectory" class="method returns text"} <i/> ApplicationSpecificDirectory()
: Returns path to application specific directory

{:id="FileUtils.AvailableStorageDirectories" class="method returns list"} <i/> AvailableStorageDirectories()
: Returns a list of available storage directories

{:id="FileUtils.CopyFile" class="method"} <i/> CopyFile(*from*{:.text},*to*{:.text})
: Copies a file and raises event named File Copied

{:id="FileUtils.CopyFileAsync" class="method"} <i/> CopyFileAsync(*src*{:.text},*des*{:.text})
: Copies big files asynchronously and raises event 'FileCopied'

{:id="FileUtils.CreateApplicationSpecificDirectory" class="method"} <i/> CreateApplicationSpecificDirectory()
: Creates Application Specific Directory (/storage/emulated/0/<package name>/files) in case it does not exists

{:id="FileUtils.CreateDirectory" class="method"} <i/> CreateDirectory(*dir*{:.text})
: Creates a new directory if it does not exists

{:id="FileUtils.Delete" class="method"} <i/> Delete(*path*{:.text})
: Deletes a file or folder.If path is a folder then it will delete all files and folders of that folder.

{:id="FileUtils.DeleteFile" class="method"} <i/> DeleteFile(*fileName*{:.text})
: Deletes a file.Prefix the filename with / (i.e. relative path) to delete a file on the SD card. For instance /myFile.txt will delete the file /mnt/sdcard/myFile.txt. You can't delete a file from assets.If a fileName starts with file:/// you can specify a complete path to the file.

{:id="FileUtils.Exists" class="method returns boolean"} <i/> Exists(*fileOrDirectoryName*{:.text})
: Checks that directory/file exists or not

{:id="FileUtils.FileExtension" class="method returns text"} <i/> FileExtension(*path*{:.text})
: Get file extension from file

{:id="FileUtils.FileListAsync" class="method"} <i/> FileListAsync(*dir*{:.text},*filter*{:.text},*withFolders*{:.boolean})
: Get files list asynchronously from a dir which has a huge number of files

{:id="FileUtils.FileListFromAssets" class="method returns list"} <i/> FileListFromAssets()
: Return a list of filenames from the assets

{:id="FileUtils.FileName" class="method returns text"} <i/> FileName(*path*{:.text})
: Get file name from path

{:id="FileUtils.FileOrFolderSize" class="method returns number"} <i/> FileOrFolderSize(*fileOrFolderName*{:.text})
: Returns size of file or folder in bytes

{:id="FileUtils.FilePath" class="method returns text"} <i/> FilePath(*fileName*{:.text})
: Get path from file name

{:id="FileUtils.FilesList" class="method returns list"} <i/> FilesList(*dir*{:.text},*filter*{:.text},*withFolders*{:.boolean})
: Get all files list with filter(if applied).Use file extension as filter like mp3 or png else use empty string.To get folders along with files use true else false in 'withFolders'

{:id="FileUtils.FolderList" class="method returns list"} <i/> FolderList(*dir*{:.text})
: Get folder list(without files) from given directory.It does not returns folders of folders

{:id="FileUtils.FreeSizeOfMemory" class="method returns number"} <i/> FreeSizeOfMemory()
: Returns free size in bytes of the external storage or memory

{:id="FileUtils.FreeSpace" class="method returns number"} <i/> FreeSpace(*dirName*{:.text})
: Returns free space of a directory

{:id="FileUtils.GetContentUri" class="method returns text"} <i/> GetContentUri(*filename*{:.text})
: Converts filename to content uri

{:id="FileUtils.IsAbsolute" class="method returns boolean"} <i/> IsAbsolute(*path*{:.text})
: Checks that given path is complete path or not

{:id="FileUtils.IsExecutable" class="method returns boolean"} <i/> IsExecutable(*fileOrFolderName*{:.text})
: Checks whether a file or folder is executable or not

{:id="FileUtils.IsFile" class="method returns boolean"} <i/> IsFile(*fileOrFolderName*{:.text})
: Checks whether path is a file or not.Prefix the filename with '/' to look for the file  on the SD card. For instance /myFile.txt will look for the file /mnt/sdcard/myFile.txt.If you use '//' before filename it will always return false as it can not check asset files. If fileOrDirectoryName starts with file:/// you can specify a complete path to the file or directory.

{:id="FileUtils.IsHidden" class="method returns boolean"} <i/> IsHidden(*fileName*{:.text})
: Checks that given file is hidden or not

{:id="FileUtils.IsReadable" class="method returns boolean"} <i/> IsReadable(*fileOrFolderName*{:.text})
: Checks whether a file or folder is readable or not

{:id="FileUtils.IsWritable" class="method returns boolean"} <i/> IsWritable(*fileOrFolderName*{:.text})
: Checks whether a file or folder is writable or not

{:id="FileUtils.LastModTime" class="method returns text"} <i/> LastModTime(*filename*{:.text},*format*{:.text})
: Get last modified time of a file

{:id="FileUtils.MimeType" class="method returns text"} <i/> MimeType(*path*{:.text})
: Get mime-type of a file from path

{:id="FileUtils.MoveFile" class="method"} <i/> MoveFile(*from*{:.text},*to*{:.text})
: Moves a file

{:id="FileUtils.MoveFileAsync" class="method"} <i/> MoveFileAsync(*src*{:.text},*des*{:.text})
: Moves big files asynchronously and raises event 'FileMoved'

{:id="FileUtils.PathFromUri" class="method returns text"} <i/> PathFromUri(*contentUri*{:.text})
: Get file path from content uri

{:id="FileUtils.RenameFile" class="method"} <i/> RenameFile(*filename*{:.text},*newFilename*{:.text})
: Renames a file without deleting old file

{:id="FileUtils.TotalSpace" class="method returns number"} <i/> TotalSpace(*dirName*{:.text})
: Returns total space of a directory

## InAppUpdate  {#InAppUpdate}

Component for InAppUpdate



### Properties  {#InAppUpdate-Properties}

{:.properties}

{:id="InAppUpdate.FLEXIBLE" .number .ro .bo} *FLEXIBLE*
: Property for FLEXIBLE

{:id="InAppUpdate.IMMEDIATE" .number .ro .bo} *IMMEDIATE*
: Property for IMMEDIATE

### Events  {#InAppUpdate-Events}

{:.events}

{:id="InAppUpdate.UpdateAvailable"} UpdateAvailable()
: Event for UpdateAvailable

{:id="InAppUpdate.UpdateCancelled"} UpdateCancelled()
: Event for UpdateCancelled

{:id="InAppUpdate.UpdateDownloaded"} UpdateDownloaded()
: Event for UpdateDownloaded

{:id="InAppUpdate.UpdateFailed"} UpdateFailed()
: Event for UpdateFailed

{:id="InAppUpdate.UpdateNotAvailable"} UpdateNotAvailable()
: Event for UpdateNotAvailable

### Methods  {#InAppUpdate-Methods}

{:.methods}

{:id="InAppUpdate.CompleteUpdate" class="method"} <i/> CompleteUpdate()
: Method for CompleteUpdate

{:id="InAppUpdate.StartUpdater" class="method"} <i/> StartUpdater(*updateType*{:.number})
: Method for StartUpdater

## PackageUtils  {#PackageUtils}

Component for PackageUtils



### Properties  {#PackageUtils-Properties}

{:.properties}

{:id="PackageUtils.ApplicationName" .text .ro .bo} *ApplicationName*
: Returns name of current app

{:id="PackageUtils.PackageName" .text .ro .bo} *PackageName*
: Returns package name of current app

{:id="PackageUtils.VersionCode" .number .ro .bo} *VersionCode*
: Returns version code of current app

{:id="PackageUtils.VersionName" .text .ro .bo} *VersionName*
: Returns version name of current app

### Events  {#PackageUtils-Events}

{:.events}
None


### Methods  {#PackageUtils-Methods}

{:.methods}

{:id="PackageUtils.AddPermission" class="method"} <i/> AddPermission(*permissionName*{:.text})
: Tries to add a new dynamic permission to the system

{:id="PackageUtils.AppName" class="method returns text"} <i/> AppName(*packageName*{:.text})
: Returns app name from package

{:id="PackageUtils.AppPermissionsList" class="method returns list"} <i/> AppPermissionsList(*packageName*{:.text})
: Returns a list of permissions requested by a package

{:id="PackageUtils.AppVersionCode" class="method returns number"} <i/> AppVersionCode(*packageName*{:.text})
: Returns version code of given package

{:id="PackageUtils.AppVersionName" class="method returns text"} <i/> AppVersionName(*packageName*{:.text})
: Returns version name of given package

{:id="PackageUtils.CheckSelfPermission" class="method returns boolean"} <i/> CheckSelfPermission(*permission*{:.text})
: Checks that specific permission is granted or not to current running app

{:id="PackageUtils.FirstInstallTime" class="method returns text"} <i/> FirstInstallTime(*packageName*{:.text})
: Returns first install time of app/package

{:id="PackageUtils.GetPackageGIDS" class="method returns list"} <i/> GetPackageGIDS(*pkg*{:.text})
: Return a list of all of the POSIX secondary group IDs that have been assigned to the given package

{:id="PackageUtils.GetPackageUID" class="method returns number"} <i/> GetPackageUID(*pkg*{:.text})
: Return the UID associated with the given package name

{:id="PackageUtils.HasPermission" class="method returns boolean"} <i/> HasPermission(*permissionName*{:.text},*packageName*{:.text})
: Checks whether given package has specific permission

{:id="PackageUtils.HasSystemFeature" class="method returns boolean"} <i/> HasSystemFeature(*feature*{:.text})
: Checks whether system has particular feature

{:id="PackageUtils.Icon" class="method returns text"} <i/> Icon(*packageName*{:.text})
: Returns path to icon of given package/app

{:id="PackageUtils.InstalledApps" class="method returns list"} <i/> InstalledApps(*includeSystemApps*{:.boolean})
: Returns a list of all packages installed on system

{:id="PackageUtils.InstallerPackageName" class="method returns text"} <i/> InstallerPackageName(*pkg*{:.text})
: Retrieve the package name of the application that installed a package.This identifies which market the package came from

{:id="PackageUtils.InstantApp" class="method returns boolean"} <i/> InstantApp(*pkg*{:.text})
: Gets whether the given package is an instant app

{:id="PackageUtils.IsAppInstalled" class="method returns boolean"} <i/> IsAppInstalled(*packageName*{:.text})
: Returns true if app is installed

{:id="PackageUtils.IsAppSuspended" class="method returns boolean"} <i/> IsAppSuspended()
: Query if this app is currently suspended

{:id="PackageUtils.IsInstantApp" class="method returns boolean"} <i/> IsInstantApp()
: Gets whether this application is an instant app

{:id="PackageUtils.IsSafeMode" class="method returns boolean"} <i/> IsSafeMode()
: Checks whether system is booted in safe mode or not

{:id="PackageUtils.IsSystemApp" class="method returns boolean"} <i/> IsSystemApp(*packageName*{:.text})
: Returns true if app is system app

{:id="PackageUtils.LastUpdateTime" class="method returns text"} <i/> LastUpdateTime(*packageName*{:.text})
: Returns last update time of app/package

{:id="PackageUtils.RemovePermission" class="method"} <i/> RemovePermission(*permissionName*{:.text})
: Removes a permission that was previously added with 'AddPermission'

{:id="PackageUtils.SystemAvailableFeatures" class="method returns list"} <i/> SystemAvailableFeatures()
: Returns list of available features of system

{:id="PackageUtils.TargetSDK" class="method returns number"} <i/> TargetSDK(*packageName*{:.text})
: Returns target sdk of given package
