# DeepLinkDispatchDocumentor

## Description

Generate a document from "DeepLinkDispatch.DeepLink" annotation.

## Quick Start :racehorse::dash:

### Step 1: Install

Add to your project `build.gradle` file:

```groovy
buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
    }
}

apply plugin: 'com.neenbedankt.android-apt'

repositories {
    jcenter()
}
```

Add to your app `build.gradle` file:

```groovy
dependencies {
    compile 'com.airbnb:deeplinkdispatch:2.0.1'
    apt 'com.github.hisaichi5518:deeplinkdispatchdocumentor-processor:0.0.4'
    apt 'com.airbnb:deeplinkdispatch-processor:2.0.1'
}
```

### Step 2: Build

Build > Rebuild Project

### Step 3: Finish!

open `docs/DeepLinkDispatch.DeepLink.md` :tada::tada::tada:

## See Also


## Author

[@hisaichi5518](https://twitter.com/hisaichi5518)

## LICENSE

```
The MIT License (MIT)

Copyright (c) 2016 hisaichi5518

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
