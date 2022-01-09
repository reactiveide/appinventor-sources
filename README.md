# Welcome to ReactiveIDE 

## Disclaimer
[ReactiveIDE](https://reactiveide.com) is ***No Longer*** based on MIT App Inventor 2 and ***WILL NOT*** be offering any support to any MIT App Inventor 2 based Platform.

The following Source Code is a ***Development Copy*** of ReactiveIDE based on MIT App Inventor 2 under MIT License which is ***NOT production ready***. 

Features, Components and contents with this source code may be ***unfinnished, not functional, or causing error***, there is ***NO Guarantee*** of functionality.

## Introduction

This code is based on [MIT App Inventor 2](http://appinventor.mit.edu) and is designed to be run in Google's App Engine.

We provide this code for reference and for experienced people who wish
to operate their own instance and/or contribute to the project.

This code is known to work with Java 8.

## Licenses

This Project is now available under the MIT License !

If you are contributing to any OPEN SOURCE Project or MIT App Inventor 2 and you find anything useful here, feel free to use it within the license. 

(We encourage you to help our community and contribute to open source)

https://github.com/reactiveide/appinventor-sources/blob/master/LICENSE

## Contributors

If you are interested in this project and would like to improve this project, any contribution to this project is appreciated.
Simply open a pull request or issue, our developer will review it.

Tips :
Since this software is based on MIT App Inventor 2, you may be able to find a lot more information about the project via [this link](https://mit-cml.github.io/appinventor-sources/) and how to contribute to it.

## Setup instructions

This is a quick guide to get started with the sources. More detailed instructions can be found [here](https://docs.google.com/document/pub?id=1Xc9yt02x3BRoq5m1PJHBr81OOv69rEBy8LVG_84j9jc), a slide show can be seen [here](http://josmas.github.io/contributingToAppInventor2/#/).

This guide will let you get started only on Linux or macOS. Although it is possible to setup for Windows, we DO NOT provide any help for setting up on Windows platform currently, but Ubuntu Subsystem (WSL) on Windows 10 works fine, just follow the instructions for Linux.

### Dependencies
Software that you will need before working on this project :

- Java 8 (OpenJDK 8 is recommended, JRE is not enough)
- Apache Ant
- GCloud SDK (for JAVA)
- Python

Note 1: If you are working on a 64-bit linux system, you may need to install 32-bit version of: glibc(to get a 32-bit version of ld-linux.so), zlib and libstdc++.

If you are on a Debian-based distribution(Ubuntu), use:

    $ sudo apt-get install libc6:i386 zlib1g:i386 libstdc++6:i386

If you are on an RPM-based distribution(Fedora), use:

    $ sudo dnf install glibc.i686 zlib.i686 libstdc++.i686

Note 2: Certain Java 8 features, such as lambda expressions, are not supported on Android, so please don't use them in your changes to the source code.

### Forking or cloning
Consider ***forking*** the project if you want to make changes to the sources. If you simply want to run it locally, you can simply ***clone*** it.

#### Forking
If you decide to fork, follow the [instructions](https://help.github.com/articles/fork-a-repo) given by github. After that you can clone your own copy of the sources with:

    $ git clone https://github.com/YOUR_USER_NAME/appinventor-sources.git

Make sure you change *YOUR_USER_NAME* to your user name.

Configuring a remote pointing to this repository is also a good idea if you are forking:

    $ cd appinventor-sources
    $ git remote add upstream https://github.com/mit-cml/appinventor-sources.git

Finally, you will also have to make sure that you are ignoring files that need ignoring:

    $ cp sample-.gitignore .gitignore

### Checkout dependencies
App Inventor uses Blockly, the web-based visual programming editor from Google, as a core part of its editor. Blockly core is made available to App Inventor as a git submodule. The first time after forking or cloning the repository, you will need to perform the following commands:

    $ git submodule update --init

For developers who will be working on Blockly within the context of App Inventor, the preferred checkout procedure is to perform a `git submodule init`, edit the `.git/config` file to use the read/write SSH URL for [MIT CML's Blockly fork](https://github.com/mit-cml/blockly) instead of the public read-only HTTPS URL assumed by default (to support pushing changes). After changing `.git/config`, a `git submodule update` will pull the repository.

If you need to switch back to a branch that does contains the Blockly and Closure Library sources in the tree, you will need to run the command:

    $ git submodule deinit --all

to clear out the submodules ___before switching branches___. When switching back, you will need to repeat the initialization and update procedure above.

### Troubleshooting common installation issues
Run this command to run a self-diagnosis of your environment. This command tries to figure out common installation issues and offers you a solution to fix them yourself. Make sure this passes all the checks before you proceed further.

    $ ./buildtools
    
    You should see a menu with option (B.Doctor) , type "B" and hit enter.

### Compiling
Before compiling the code, an [auth key](https://docs.google.com/document/pub?id=1Xc9yt02x3BRoq5m1PJHBr81OOv69rEBy8LVG_84j9jc#h.yikyg2e1rfut) is needed. You can create one by running the following commands:

    $ ./buildtools
    
    You should see a menu with option (2.Make Auth Key) , type "2" and hit enter.

Once the key is in place, type the following to compile :

    $ ./buildtools
    
    You should see a menu with option (4.Build (Full)) , type "4" and hit enter.

You will see a lot of stuff in the terminal and after a few minutes (it can take from 2 to 10 minutes, depending on your machine specs) you should see a message saying something like *Build Successful*.

Tips : 
The standard compile option (4.Build (Full)) will compile the full source code including the AI Companion App (Mobile App for Live Testing), to reduce compilation time you may use option 5 (5.Build (Without Companion)). This will compile the source code without compile the AI Companion App.

### Running the server(s)
There are two servers in App Inventor, the main server that deals with project information, and the build server that creates apk files. More detailed information can be found in the [App Inventor Developer Overview](https://docs.google.com/document/d/1hIvAtbNx-eiIJcTA2LLPQOawctiGIpnnt0AvfgnKBok/pub) document.

#### Running the main server

    $ ./buildtools
    
    You should see a menu with option (8.Run Local Server) , type "8" and hit enter.

Make sure you have installed Google Cloud SDK in your system enviroment and is callable via the gcloud command

#### Running the build server
The build server can be run from the terminal by typing:

    $ ./buildtools
    
    You should see a menu with option (10.Run Build Server) , type "10" and hit enter.

Note that you will only need to run the build server if you are going to build an app as an apk. You can do all the layout and programming without having the build server running, but you will need it to download the apk.

### Accessing your local server
You should now be up and running; you can test this by pointing your browser to:

    http://localhost:8888

Before entering or scanning the QR code in the Companion, check the box labeled "Use Legacy Connection".

### Running tests
The automated tests depend on [Phantomjs](http://phantomjs.org/). Make sure you install it and add it to your path. After that, you can run all tests by typing the following in a terminal window:

    $ ./buildtools
    
    You should see a menu with option (A.Run Tests) , type "A" and hit enter.

### Building Release Code

Release builds with optimizations turned on for the web components of the system can be done by passing `-Drelease=true` to `ant`, e.g.:

```
cd appinventor
ant -Drelease=true noplay
```

The release configuration sets the following additional options:

- Blockly Editor is compiled with SIMPLE optimizations (instead of RAW)
- App Engine YaClient module is compiled without `<collapse-all-properties/>` to create per-language/browser builds
- App Engine YaClient module is compiled with optimization tuned to 9 and with 8 threads

### Hot-reloading GWT code with 'Super Dev Mode'
1. Run `cd appinventor`
2. Run `ant devmode`
3. [Run the main server](#running-the-main-server).
4. Open http://localhost:9876 (*GWT CodeServer*) and drag the two bookmarklets (*Dev Mode On & Off*) to the bookmarks bar.
5. Open http://localhost:8888 (*App Engine server*)
6. To see changes "live":
   1. Save your changes in file.
   2. Click on the *"Dev Mode On"* bookmarklet.
   3. A popup will be shown with a button to compile `ode` module.
   4. Press that button to compile. (That button is actually a bookmarklet. So you can drag this button to the bookmarks bar as well. This will come handy for subsequent compilations)
   5. After that, *GWT CodeServer* will compile the module incrementally.
   6. Refresh the page and that's it! The changes are live.

Logs can be found at http://localhost:9876/log/ode and SourceMaps at http://localhost:9876/sourcemaps/ode
