    package com.google.appinventor.components.runtime;

    /*
    
    
      _   _           _    ___________ _____ 
     | | | |         | |  |_   _|  _  \  ___|
     | |_| |_   _  __| |_ __| | | | | | |__  
     |  _  | | | |/ _` | '__| | | | | |  __| 
     | | | | |_| | (_| | | _| |_| |/ /| |___ 
     \_| |_/\__, |\__,_|_| \___/|___/ \____/  @ Hybro 2020
             __/ |                           
            |___/                            


    */



    

import android.provider.*;
import android.content.ContentUris;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import android.provider.MediaStore;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.net.*;
import java.util.*;
import java.text.SimpleDateFormat;

@DesignerComponent(version = 4, description = "A component to work with files and folders", category = ComponentCategory.UTILS, nonVisible = true, iconName = "https://cdn.hybro.io/file.png")
@SimpleObject
@UsesPermissions(permissionNames = "android.permission.READ_EXTERNAL_STORAGE, android.permission.WRITE_EXTERNAL_STORAGE")
public final class FileUtils extends AndroidNonvisibleComponent {
  public Context context;
public Activity activity;
  private boolean isRepl = false;

  public FileUtils(ComponentContainer container) {
    super(container.$form());
    context = container.$context();
if (form instanceof com.google.appinventor.components.runtime.ReplForm){
      isRepl = true; 
}
  }
  
  @SimpleFunction(description = "Get mime-type of a file from path")
  public String MimeType(String path) throws IOException {
    FileNameMap fileNameMap = URLConnection.getFileNameMap();
    String mimeType = fileNameMap.getContentTypeFor(path);
    return mimeType;
  }
  
  @SimpleFunction(description = "Get file extension from file")
  public String FileExtension(String path) throws IOException {
    String fileName = path;
    if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
      return "." + fileName.substring(fileName.lastIndexOf(".") + 1); 
    return ".file";
  }
  
  @SimpleFunction(description = "Get file name from path")
  public String FileName(String path) throws IOException {
    File file = new File(path);
    String FileName = file.getName();
    return FileName;
  }
  
@SimpleFunction(description = "Return a list of filenames from the assets")
  public List<String> FileListFromAssets() {
    List<String> fileNames = new ArrayList<>();
    if (!isRepl) {
      AssetManager am = context.getAssets();
      try {
        String[] files = am.list("");
        fileNames = new ArrayList<>(Arrays.asList(files));
        String[] dir = { "webkit", "external_comps", "images" };
        for (int j = dir.length - 1; j >= 0; j--)
          fileNames.remove(dir[j]); 
      } catch (IOException e) {
        e.printStackTrace();
      } 
    } else {
      String completePath = completeFileName("//");
      File dirPath = new File(completePath);
      fileNames = getList(dirPath, "", false);
    } 
    return fileNames;
  }
  @SimpleFunction(description = "Get files list asynchronously from a dir which has a huge number of files")
  public void FileListAsync(final String dir,final String filter,final boolean withFolders) {
    AsynchUtil.runAsynchronously(new Runnable() {
          public void run() {
            AsyncFileList(dir, filter, withFolders);
          }
        });
  }
  
  @SimpleFunction(description = "Get all files list with filter(if applied).Use file extension as filter like mp3 or png else use empty string.To get folders along with files use true else false in 'withFolders'")
  public List<String> FilesList(final String dir,final String filter,final boolean withFolders){
    String completePath = completeFileName(dir);
    List<String> fileNames = new ArrayList<>();
    if (!dir.startsWith("//")) {
      File dirPath = new File(completePath);
      if (dirPath.isDirectory()) {
        fileNames = getList(dirPath, filter, withFolders);
      } else {
        fileNames.add(completePath);
      } 
    } 
    return fileNames;
  }
private List<String> getList(File parentDir, String extension, boolean includeSubdirectories) {
    ArrayList<String> inFiles = new ArrayList<>();
    String[] fileNames = parentDir.list();
    for (String fileName : fileNames) {
      File file = new File(parentDir.getPath() + File.separator + fileName);
      if (file.isDirectory()) {
        if (includeSubdirectories && 
          !parentDir.getPath().contains("/AppInventor/assets"))
          inFiles.addAll(getList(file, extension, includeSubdirectories)); 
      } else if (fileName.toLowerCase().endsWith("." + extension) || extension.charAt(0) == '*') {
        if (parentDir.getPath().contains("/AppInventor/assets")) {
          inFiles.add(fileName);
        } else {
          inFiles.add(parentDir.getPath() + File.separator + fileName);
        } 
      } 
    } 
    return inFiles;
  }
  private void AsyncFileList(String directoryName, String extension, boolean includeSubdirectories) {
    String completePath = completeFileName(directoryName);
    List<String> fileNames = new ArrayList<>();
    if (!directoryName.startsWith("//")) {
      File dirPath = new File(completePath);
      if (dirPath.isDirectory()) {
        fileNames = getList(dirPath, extension, includeSubdirectories);
      } else {
        fileNames.add(completePath);
      } 
    } 
    final List<String> result = fileNames;
    activity.runOnUiThread(new Runnable() {
          public void run() {
            GotFileList(result);
          }
        });
  }
  @SimpleFunction(description = "Get folder list(without files) from given directory.It does not returns folders of folders")
  public List<String> FolderList(String dir) {
    String completePath = completeFileName(dir);
    List<String> dirNames = new ArrayList<>();
    if (!dir.startsWith("//")) {
      File dirPath = new File(completePath);
      if (dirPath.isDirectory()) {
        String[] fileNames = dirPath.list();
        for (String fileName : fileNames) {
          File dir1 = new File(dirPath.getPath() + File.separator + fileName);
          if (dir1.isDirectory())
            dirNames.add(dir1.getPath()); 
        } 
      } 
    } 
    return dirNames;
  }
  
  @SimpleFunction(description = "Get path from file name")
  public String FilePath(final String fileName) {
    return completeFileName(fileName);
  }
private String completeFileName(String fileName) {
        File sd = Environment.getExternalStorageDirectory();
        String completeFileName = fileName;
        if (fileName.startsWith("file:///")) {
            completeFileName = fileName.substring(7);
        } else if (fileName.startsWith("//")) {
            fileName = fileName.substring(2);
            if (isRepl) {
                completeFileName = Environment.getExternalStorageDirectory().getPath() + "/AppInventor/assets/" + fileName;
            } else {
                completeFileName = fileName;
            }
        } else if (fileName.startsWith("/")) {
            if (!fileName.startsWith(sd.toString()))
                completeFileName = sd + fileName;
        } else {
            completeFileName = sd + File.separator + fileName;
        }
        return completeFileName;
    }
  
  @SimpleFunction(description = "Checks whether path is a file or not.Prefix the filename with '/' to look for the file  on the SD card. For instance /myFile.txt will look for the file /mnt/sdcard/myFile.txt.If you use '//' before filename it will always return false as it can not check asset files. If fileOrDirectoryName starts with file:/// you can specify a complete path to the file or directory.")
  public boolean IsFile(String fileOrFolderName) {
    if (fileOrFolderName.startsWith("//")) {
      return false;
    } 
    String completeFilepath = completeFileName(fileOrFolderName);
    File file = new File(completeFilepath);
    if (file.isFile()) {
      return true;
    } 
    return false;
  }
  
  @SimpleFunction(description = "Get last modified time of a file")
  public String LastModTime(String filename, String format) {
    File file = new File(completeFileName(filename));
    Long mod = Long.valueOf(file.lastModified());
    Date date = new Date(mod.longValue());
    	SimpleDateFormat formatter = new SimpleDateFormat(format);
    return formatter.format(date);
  }
  
  @SimpleEvent(description = "Event raised after 'FileAndFoldersList' method.Get all files and folders from given directory")
  public void GotFileList(List filesList) {
    EventDispatcher.dispatchEvent(this, "GotFileList",filesList);
  }
  
  @SimpleFunction(description = "Checks whether a file or folder is writable or not")
  public boolean IsWritable(String fileOrFolderName) {
    File dir = new File(completeFileName(fileOrFolderName));
    boolean writable = dir.canWrite();
    return writable;
  }
  
  @SimpleFunction(description = "Checks whether a file or folder is readable or not")
  public boolean IsReadable(String fileOrFolderName) {
    File dir = new File(completeFileName(fileOrFolderName));
    return dir.canRead();
  }
  
  @SimpleFunction(description = "Checks whether a file or folder is executable or not")
  public boolean IsExecutable(String fileOrFolderName) {
    File dir = new File(completeFileName(fileOrFolderName));
    return dir.canExecute();
  }
private void copyOrMove2(String completeFromFileName, String completeToFileName, Boolean copyFileFromAssets, String action) throws Exception {
    InputStream in = null;
    OutputStream out = null;
    if (copyFileFromAssets.booleanValue()) {
      in = form.getAssets().open(completeFromFileName);
    } else {
      in = new FileInputStream(completeFromFileName);
    } 
    out = new FileOutputStream(completeToFileName);
    byte[] buffer = new byte[1024];
    int read;
    while ((read = in.read(buffer)) != -1)
      out.write(buffer, 0, read); 
    in.close();
    in = null;
    out.flush();
    out.close();
    out = null;
    if (action == "move") {
      (new File(completeFromFileName)).delete();
    } 
  }
  private void AsyncCopyOrMove(String completeFromFileName, String completeToFileName, Boolean copyFileFromAssets, String action) {
    try {
      copyOrMove2(completeFromFileName, completeToFileName, copyFileFromAssets, action);
      BackToUiThread(true, action + " successful", action);
    } catch (FileNotFoundException fnfe1) {
      String errorMessage = fnfe1.getMessage();
      fnfe1.printStackTrace();
      BackToUiThread(false, errorMessage, action);
    } catch (Exception e) {
      String errorMessage = e.getMessage();
      e.printStackTrace();
      BackToUiThread(false, errorMessage, action);
    } 
  }
  
  private void BackToUiThread(final boolean successful, final String response, String action) {
    if (action == "move") {
      activity.runOnUiThread(new Runnable() {
            public void run() {
              FileMoved(successful);
            }
          });
    } else {
      activity.runOnUiThread(new Runnable() {
            public void run() {
             FileCopied(successful);
            }
          });
    } 
  }
private void copyOrMove1(String fromFileName, String toFileName, final String action, boolean async) {
    String message = "";
    boolean error = false;
    if (toFileName.startsWith("//")) {
      error = true;
    } else if (!(IsFile(fromFileName))) {
      error = true;
    } else if (!Exists(fromFileName)) {
      error = true;
    } else if (action.equals("move") && fromFileName.startsWith("//")) {
      error = true;
    } 
    if (error) {
      if (async) {
        if (action.equals("move")) {
          FileMoved(false);
        } else {
          FileCopied(false);
        } 
      } 
    } else {
      final String completeFromFileName = completeFileName(fromFileName);
      final String completeToFileName = completeFileName(toFileName);
      Integer endIndex = Integer.valueOf(completeToFileName.lastIndexOf("/"));
      String outputPath = completeToFileName.substring(0, endIndex.intValue());
      File dir = new File(outputPath);
      if (!dir.exists())
        dir.mkdirs(); 
      Boolean copyFileFromAssets = Boolean.valueOf(false);
      if (fromFileName.startsWith("//") && !isRepl)
        copyFileFromAssets = Boolean.valueOf(true); 
      final Boolean copyFileFromAssetsResult = copyFileFromAssets;
      if (async) {
        AsynchUtil.runAsynchronously(new Runnable() {
              public void run() {
                AsyncCopyOrMove(completeFromFileName, completeToFileName, copyFileFromAssetsResult, action);
              }
            });
      } else {
        try {
          copyOrMove2(completeFromFileName, completeToFileName, copyFileFromAssets, action);
        } catch (FileNotFoundException fnfe1) {
          fnfe1.printStackTrace();
        } catch (Exception e) {
          e.printStackTrace();
        } 
      } 
    } 
  }
@SimpleFunction(description = "Moves big files asynchronously and raises event 'FileMoved'")
public void MoveFileAsync(String src, String des) {
    copyOrMove1(src, des, "move", true);
  }
@SimpleFunction(description = "Copies big files asynchronously and raises event 'FileCopied'")
public void CopyFileAsync(String src, String des) {
    copyOrMove1(src, des, "copy", true);
  }
  @SimpleFunction(description = "Copies a file and raises event named File Copied")
  public void CopyFile(String from, String to) {
    copyOrMove1(from, to, "copy", false);
  }
  
  @SimpleFunction(description = "Deletes a file.Prefix the filename with / (i.e. relative path) to delete a file on the SD card. For instance /myFile.txt will delete the file /mnt/sdcard/myFile.txt. You can't delete a file from assets.If a fileName starts with file:/// you can specify a complete path to the file.")
  public void DeleteFile(String fileName) {
    try{
      String completeFileName = completeFileName(fileName);
      (new File(completeFileName)).delete();
    } catch (Exception e){
e.printStackTrace();
}
  }
  
  @SimpleFunction(description = "Moves a file")
  public void MoveFile(String from, String to) {
    copyOrMove1(from, to, "move", false);
  }
  
  @SimpleFunction(description = "Renames a file without deleting old file")
  public void RenameFile(String filename, String newFilename) {
try{
    File f = new File(completeFileName(filename));
    File t = new File(completeFileName(newFilename));
    boolean result = f.renameTo(t);
}catch (Exception e){
e.printStackTrace();
}
  }
  
  @SimpleFunction(description = "Deletes a file or folder.If path is a folder then it will delete all files and folders of that folder.")
  public void Delete(String path) {
boolean result = false;
        File f = new File(path);
        if (f.exists()) {
            if (f.isDirectory()) {
                File[] list = f.listFiles();
                if (list != null){
                    for (File nf:list
                    ) {
                      if (nf.isFile()){
                          nf.delete();
                      }else {
                          Delete(nf.toString());
                      }
                    }
                }
            }
           result = f.delete();
        }
        FileOrFolderDeleted(result);
  }
  
  @SimpleEvent(description = "Event raised after 'CopyFileAsync' method.If file copied then returns true else false")
  public void FileCopied(boolean success) {
    EventDispatcher.dispatchEvent(this, "FileCopied",success);
  }
  
  @SimpleEvent(description = "Event raised after 'Delete' method.If file or folder is deleted then returns true else false")
  public void FileOrFolderDeleted(boolean success) {
    EventDispatcher.dispatchEvent(this, "FileOrFolderDeleted",success);
  }
  
  @SimpleEvent(description = "Event raised after 'MoveFileAsync' method.If file is moved then returns true else false")
  public void FileMoved(boolean success) {
    EventDispatcher.dispatchEvent(this, "FileMoved",success);
  }
  
  @SimpleEvent(description = "Event raised after 'Create Directory' method.If directory has been created then returns true else false")
  public void DirectoryCreated(boolean IsDirectoryCreated) {
    EventDispatcher.dispatchEvent(this, "DirectoryCreated",IsDirectoryCreated);
  }
  
  @SimpleFunction(description = "Returns a list of available storage directories")
  public List<String> AvailableStorageDirectories() {
    StorageUtil storageUtil = new StorageUtil();
    String[] strings = storageUtil.getStorageDirectories();
    List<String> stringList = new ArrayList<>(Arrays.asList(strings));
    return stringList;
  }
@SimpleFunction(description = "Returns free size in bytes of the external storage or memory")
  public long FreeSizeOfMemory() {
    long bytesAvailable = 0L;
    if (Build.VERSION.SDK_INT <= 8) {
      StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
      bytesAvailable = stat.getBlockSize() * stat.getAvailableBlocks();
    } else {
      File sd = Environment.getExternalStorageDirectory();
      bytesAvailable = sd.getUsableSpace();
    } 
    return bytesAvailable;
  }
  
  @SimpleFunction(description = "Returns total space of a directory")
  public long TotalSpace(String dirName) {
    File file = new File(completeFileName(dirName));
    return file.getTotalSpace();
  }
  
  @SimpleFunction(description = "Returns free space of a directory")
  public long FreeSpace(String dirName) {
    File file = new File(completeFileName(dirName));
    return file.getFreeSpace();
  }
  @SimpleFunction(description="Returns size of file or folder in bytes")
public long FileOrFolderSize(String fileOrFolderName) {
    File f = new File(completeFileName(fileOrFolderName));
    if (f.isFile()){
        return f.length();
    }
    else {
        long size = 0L;
        File[] list = f.listFiles();
        if (list != null){
            for (File file:list
                 ) {
                size += FileOrFolderSize(file.toString());
            }
        }
        return size;
    }
}
  @SimpleFunction(description = "Creates a new directory if it does not exists")
  public void CreateDirectory(String dir) {
    File file = new File(dir);
    boolean result = false;
    if (!file.exists())
      result = file.mkdir(); 
    DirectoryCreated(result);
  }
  
  @SimpleFunction(description = "Checks that directory/file exists or not")
  public boolean Exists(String fileOrDirectoryName) {
    if (fileOrDirectoryName.startsWith("//") && !isRepl)
      try {
        AssetManager am = context.getAssets();
        InputStream is = am.open(fileOrDirectoryName.substring(2));
        if (is.available() > 0) {
          return true;
        } 
        return false;
      } catch (IOException e) {
        e.printStackTrace();
        return false;
      }  
    String completeFileName = completeFileName(fileOrDirectoryName);
    File file = new File(completeFileName);
    if (file.exists()) {
      return true;
    } 
    return false;
  }
  
  @SimpleFunction(description = "Creates Application Specific Directory (/storage/emulated/0/<package name>/files) in case it does not exists")
  public void CreateApplicationSpecificDirectory() {
    File dir = context.getExternalFilesDir(null);
    if (!dir.exists())
      dir.mkdirs(); 
  }
  
  @SimpleFunction(description = "Returns path to application specific directory")
  public String ApplicationSpecificDirectory() {
    File file = context.getExternalFilesDir(null);
    return file.toString();
  }
  
  @SimpleFunction(description = "Checks that given file is hidden or not")
  public boolean IsHidden(String fileName) {
    File file = new File(completeFileName(fileName));
    return file.isHidden();
  }
  
  @SimpleFunction(description = "Checks that given path is complete path or not")
  public boolean IsAbsolute(String path) {
    File file = new File(path);
    return file.isAbsolute();
  }
  
  @SimpleFunction(description = "Get file path from content uri")
  public String PathFromUri(String contentUri) throws IOException {
    Uri uri = Uri.parse(contentUri);
    boolean needToCheckUri = (Build.VERSION.SDK_INT >= 19);
    String selection = null;
    String[] selectionArgs = null;
    if (needToCheckUri && DocumentsContract.isDocumentUri(context.getApplicationContext(), uri)) {
      if (isExternalStorageDocument(uri)) {
        String docId = DocumentsContract.getDocumentId(uri);
        String[] split = docId.split(":");
        return Environment.getExternalStorageDirectory() + "/" + split[1];
      } 
      if (isDownloadsDocument(uri)) {
        String id = DocumentsContract.getDocumentId(uri);
        uri = ContentUris.withAppendedId(
            Uri.parse("content://downloads/public_downloads"), Long.valueOf(id).longValue());
      } else if (isMediaDocument(uri)) {
        String docId = DocumentsContract.getDocumentId(uri);
        String[] split = docId.split(":");
        String type = split[0];
        if ("image".equals(type)) {
          uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if ("video".equals(type)) {
          uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else if ("audio".equals(type)) {
          uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        } 
        selection = "_id=?";
        selectionArgs = new String[] { split[1] };
      } 
    } 
    if ("content".equalsIgnoreCase(uri.getScheme())) {
      String[] projection = { "_data" };
      Cursor cursor = null;
      try {
        cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
        int column_index = cursor.getColumnIndexOrThrow("_data");
        if (cursor.moveToFirst())
          return cursor.getString(column_index); 
      } catch (Exception exception) {}
    } else if ("file".equalsIgnoreCase(uri.getScheme())) {
      return uri.getPath();
    } 
    return null;
  }
  
  private boolean isExternalStorageDocument(Uri uri) {
    return "com.android.externalstorage.documents".equals(uri.getAuthority());
  }
  
  private boolean isDownloadsDocument(Uri uri) {
    return "com.android.providers.downloads.documents".equals(uri.getAuthority());
  }
  
  private boolean isMediaDocument(Uri uri) {
    return "com.android.providers.media.documents".equals(uri.getAuthority());
  }
public class StorageUtil {
    private final String EXTERNAL_STORAGE = System.getenv("EXTERNAL_STORAGE");
    
    private final String SECONDARY_STORAGES = System.getenv("SECONDARY_STORAGE");
    
    private final String EMULATED_STORAGE_TARGET = System.getenv("EMULATED_STORAGE_TARGET");
    
    @SuppressLint({"SdCardPath"})
    private final String[] KNOWN_PHYSICAL_PATHS = new String[] { 
        "/storage/sdcard0", "/storage/sdcard1", "/storage/extsdcard", "/storage/sdcard0/external_sdcard", "/mnt/extsdcard", "/mnt/sdcard/external_sd", "/mnt/sdcard/ext_sd", "/mnt/external_sd", "/mnt/media_rw/sdcard1", "/removable/microsd", 
        "/mnt/emmc", "/storage/external_SD", "/storage/ext_sd", "/storage/removable/sdcard1", "/data/sdext", "/data/sdext2", "/data/sdext3", "/data/sdext4", "/sdcard1", "/sdcard2", 
        "/storage/microsd" };
    
    public String[] getStorageDirectories() {
      Set<String> availableDirectoriesSet = new HashSet<>();
      if (!TextUtils.isEmpty(EMULATED_STORAGE_TARGET)) {
        availableDirectoriesSet.add(getEmulatedStorageTarget());
      } else {
        availableDirectoriesSet.addAll(getExternalStorage());
      } 
      Collections.addAll(availableDirectoriesSet, getAllSecondaryStorages());
      String[] storagesArray = new String[availableDirectoriesSet.size()];
      return availableDirectoriesSet.<String>toArray(storagesArray);
    }
    
    private Set<String> getExternalStorage() {
      Set<String> availableDirectoriesSet = new HashSet<>();
      if (Build.VERSION.SDK_INT >= 23) {
        File[] files = context.getExternalFilesDirs(null);
        for (File file : files) {
          if (file != null) {
            String applicationSpecificAbsolutePath = file.getAbsolutePath();
            String rootPath = applicationSpecificAbsolutePath.substring(0, applicationSpecificAbsolutePath
                .indexOf("Android/data"));
            availableDirectoriesSet.add(rootPath);
          } 
        } 
      } else if (TextUtils.isEmpty(EXTERNAL_STORAGE)) {
        availableDirectoriesSet.addAll(getAvailablePhysicalPaths());
      } else {
        availableDirectoriesSet.add(EXTERNAL_STORAGE);
      } 
      return availableDirectoriesSet;
    }
    
    private String getEmulatedStorageTarget() {
      String rawStorageId = "";
      if (Build.VERSION.SDK_INT >= 17) {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        String[] folders = File.separator.split(path);
        String lastSegment = folders[folders.length - 1];
        if (!TextUtils.isEmpty(lastSegment) && TextUtils.isDigitsOnly(lastSegment))
          rawStorageId = lastSegment; 
      } 
      if (TextUtils.isEmpty(rawStorageId))
        return this.EMULATED_STORAGE_TARGET; 
      return this.EMULATED_STORAGE_TARGET + File.separator + rawStorageId;
    }
    
    private String[] getAllSecondaryStorages() {
      if (!TextUtils.isEmpty(SECONDARY_STORAGES))
        return SECONDARY_STORAGES.split(File.pathSeparator); 
      return new String[0];
    }
    
    private List<String> getAvailablePhysicalPaths() {
      List<String> availablePhysicalPaths = new ArrayList<>();
      for (String physicalPath : KNOWN_PHYSICAL_PATHS) {
        File file = new File(physicalPath);
        if (file.exists())
          availablePhysicalPaths.add(physicalPath); 
      } 
      return availablePhysicalPaths;
    }
    
    private File[] getExternalFilesDirs(String type) {
      if (Build.VERSION.SDK_INT >= 19)
        return context.getExternalFilesDirs(type); 
      return new File[] { context.getExternalFilesDir(type) };
    }
  }
@SimpleFunction(description = "Converts filename to content uri")
  public String GetContentUri(String filename) {
    Uri uri = Uri.fromFile(new File(filename));
    return uri.toString();
  }
}

