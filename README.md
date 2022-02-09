<h1 align="center"> Foldable Android Example </h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://github.com/GetStream/foldable-chat-android/actions/workflows/android.yml"><img alt="Build Status" src="https://github.com/GetStream/foldable-chat-android/actions/workflows/android.yml/badge.svg"/></a>
</p>

<p align="center">
A demo project that demonstrates foldable dual devices with Jetpack WindowManager.<br>
  <img src="https://user-images.githubusercontent.com/24237865/147445558-c749acd6-28aa-40c6-8e37-2a1121a9c165.png" />
</p>

## Overview
This demo project demonstrates dual-screen devices are portable devices with two symmetric screens that work together in unique ways to provide productivity in a flexible form factor. For more details, you can check it out [Introduction to dual-screen devices](https://docs.microsoft.com/en-us/dual-screen/introduction).

## Pre-requisites
- Android SDK 31
- [Android Studio Arctic Fox](https://developer.android.com/studio) or higher
- [Android Gradle Plugin 7.0.1+](https://developer.android.com/studio/releases/gradle-plugin#7-0-0) and **Java 11**
- The [Android Emulator v30.0.6+](https://developer.android.com/studio/releases/emulator#30-0-26) includes foldables support
- [Surface Duo 2 emulator](https://docs.microsoft.com/en-us/dual-screen/android/emulator/surface-duo-download?tabs=mac#install-and-run-the-sdk-and-emulator)

## Install and run the Foldable Emulator
To get started, you need to install the Foldable emulator. This project uses **Surface Duo 2 emulator**, and you can check it out the links below:
- [Download and install the Surface Duo emulator image](https://docs.microsoft.com/en-us/dual-screen/android/emulator/surface-duo-download?tabs=mac#download-and-install-the-surface-duo-emulator-image).
- [Get started with the Surface Duo 2 emulator](https://docs.microsoft.com/en-us/dual-screen/android/emulator/get-started).

<img width="1372" alt="Screen Shot 2021-12-28 at 10 07 14 AM" src="https://user-images.githubusercontent.com/24237865/147519212-e9e421bb-2fb9-48bc-9d45-db4d5feefed3.png">

## Jetpack WindowManager
The [Jetpack WindowManager](https://developer.android.com/jetpack/androidx/releases/window) library targets foldable devices and enables application developers to support new device form factors and multi-window environments. You can find Jetpack WindowManager information in the Guide: [Learn about foldables](https://developer.android.com/guide/topics/large-screens/learn-about-foldables).

### Including on your project
Add the below dependencies to your `build.gradle` file.

```gradle
dependencies {
    implementation "androidx.window:window:1.0.0"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
}
```

<img align="right" width="15%" src="https://user-images.githubusercontent.com/24237865/149445065-47c2506d-a738-4fb2-b4fb-eb6841b9e202.png" />

## WindowManager Example
[WindowManager Example](https://github.com/GetStream/foldable-chat-android/tree/main/windowmanager-example) module shows how to calculate the screen size and determine device postures with Jetpack WindowManager. You can also refer to the links below for additional help:
- [Exploring Jetpack WindowManager for Foldable Devices](https://getstream.io/blog/jetpack-windowmanager-foldable/)
- [Support foldable and dual-screen devices with Jetpack WindowManager](https://developer.android.com/codelabs/android-window-manager-dual-screen-foldables#2)
- [Unbundling the WindowManager](https://medium.com/androiddevelopers/unbundling-the-windowmanager-fa060adb3ce9)
- [Migrate your UI to responsive layouts](https://developer.android.com/guide/topics/large-screens/migrate-to-responsive-layouts)   

### Preview
![example](https://user-images.githubusercontent.com/24237865/147902922-9c790bd6-4feb-420a-a8e1-52082662c779.png)

<a href="https://getstream.io/tutorials/android-chat/">
<img src="https://user-images.githubusercontent.com/24237865/138428440-b92e5fb7-89f8-41aa-96b1-71a5486c5849.png" align="right" width="12%"/></a>

## WindowManager Chat
[WindowManager Chat](https://github.com/GetStream/foldable-chat-android/tree/main/windowmanager-chat) module demonstrates how to build responsive chat UIs with XML layout with [Stream Chat SDK](https://getstream.io/tutorials/android-chat/). You can also refer to the links below for additional help:
- [Exploring Jetpack WindowManager to Support Foldable Devices]()
- [Android Chat Messaging Tutorial](https://getstream.io/tutorials/android-chat/)

### Preview
![example](https://user-images.githubusercontent.com/24237865/148728601-85ab2f45-fc0b-45a3-9bc4-e39207b6a552.png)

<img align="right" width="15%" src="https://user-images.githubusercontent.com/24237865/149444862-961adb83-da2a-4179-9c27-37edb2f982f4.png">

## WindowManager Chat Compose
[WindowManager Chat Compose](https://github.com/GetStream/foldable-chat-android/tree/main/windowmanager-chat-compose) module demonstrates how to build responsive chat UIs with [Stream Jetpack Compose SDK](https://getstream.io/chat/compose/tutorial/). You can also refer to the links below for additional help:
- [Exploring Jetpack WindowManager to Support Foldable Devices]()
- [Compose Chat Messaging Tutorial](https://getstream.io/chat/compose/tutorial/)

### Preview
![showcase](https://user-images.githubusercontent.com/24237865/147902734-a395261f-d2e4-4151-a2ae-53cbd0964355.png)

## Butterfly

<a align="center">
  <img src="https://user-images.githubusercontent.com/24237865/150674436-d2713bf0-da35-4b75-8629-5c83d8500cd7.png" width="65%" align="center" />
</a>

If you're looking for useful APIs for Jetpack WindowManager, check out the [Butterfly](https://github.com/getStream/butterfly). The Butterfly helps you to build adaptive and responsive UIs for Android with Jetpack WindowManager. Also, it supports useful functions for Jetpack Compose and LiveData integration.

## Find this library useful? ❤️

Support it by joining __[stargazers](https://github.com/getStream/foldable-chat-android/stargazers)__ for this repository. ⭐️ <br>
Also, follow **[Stream](https://twitter.com/getstream_io)** on Twitter for our next creations!

# License
```xml
Copyright 2022 Stream.IO, Inc. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
