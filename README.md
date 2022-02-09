<h1 align="center"> Foldable Android Example </h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
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
    implementation "androidx.window:window:1.0.0-rc01"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
}
```

## WindowManager Example
[WindowManager Example](https://github.com/GetStream/foldable-android-example/tree/main/windowmanager-example) module shows how to calculate the screen size and determine device postures with Jetpack WindowManager. You can also refer to the links below for additional help:
- [Support foldable and dual-screen devices with Jetpack WindowManager](https://developer.android.com/codelabs/android-window-manager-dual-screen-foldables#2)
- [Unbundling the WindowManager](https://medium.com/androiddevelopers/unbundling-the-windowmanager-fa060adb3ce9)
- [Migrate your UI to responsive layouts](https://developer.android.com/guide/topics/large-screens/migrate-to-responsive-layouts)   

### Preview
![example](https://user-images.githubusercontent.com/24237865/147902922-9c790bd6-4feb-420a-a8e1-52082662c779.png)

## WindowManager Chat
[WindowManager Chat](https://github.com/GetStream/foldable-android-example/tree/main/windowmanager-chat) module demonstrates how to build responsive chat UIs with XML layout with [Stream Chat SDK](https://getstream.io/tutorials/android-chat/). You can also refer to the links below for additional help:
- [Exploring Jetpack WindowManager to Support Foldable Devices]()
- [Android Chat Messaging Tutorial](https://getstream.io/tutorials/android-chat/)

### Preview
![example](https://user-images.githubusercontent.com/24237865/148728601-85ab2f45-fc0b-45a3-9bc4-e39207b6a552.png)

## WindowManager Chat Compose
[WindowManager Chat Compose](https://github.com/GetStream/foldable-android-example/tree/main/windowmanager-chat-compose) module demonstrates how to build responsive chat UIs with [Stream Jetpack Compose SDK](https://getstream.io/chat/compose/tutorial/). You can also refer to the links below for additional help:
- [Exploring Jetpack WindowManager to Support Foldable Devices]()
- [Compose Chat Messaging Tutorial](https://getstream.io/chat/compose/tutorial/)

### Preview
![showcase](https://user-images.githubusercontent.com/24237865/147902734-a395261f-d2e4-4151-a2ae-53cbd0964355.png)

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