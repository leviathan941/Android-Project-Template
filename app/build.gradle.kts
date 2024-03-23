/*
 * Copyright 2024 Alexey Kuzin <amkuzink@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.leviathan941.android_project_template.AndroidSdk
import org.leviathan941.android_project_template.Application
import org.leviathan941.android_project_template.dependency.Deps
import org.leviathan941.android_project_template.dependency.Versions

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("plugin.parcelize")
    kotlin("kapt")
}

android {
    namespace = "org.leviathan941.android_project_template"
    compileSdk = AndroidSdk.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = Application.ID
        minSdk = AndroidSdk.MIN_SDK_VERSION
        targetSdk = AndroidSdk.TARGET_SDK_VERSION
        versionCode = Application.version.code
        versionName = Application.version.name

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        setProperty("archivesBaseName", "${Application.BASE_NAME}-${Application.version.name}")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            versionNameSuffix = "-SNAPSHOT"
        }
    }
    compileOptions {
        sourceCompatibility = Versions.JAVA_SRC_COMPAT
        targetCompatibility = Versions.JAVA_TARGET_COMPAT
    }
    kotlin {
        jvmToolchain(Versions.KOTLIN_JVM)
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Deps.androidCoreKtx)
    implementation(Deps.appCompat)

    implementation(Deps.material)

    implementation(Deps.composeCompiler)
    implementation(Deps.compose.ui)
    implementation(Deps.compose.runtimeLivedata)
    implementation(Deps.composeMaterial3)
    implementation(Deps.compose.uiToolingPreview)

    implementation(Deps.lifecycle.livedataKtx)
    implementation(Deps.lifecycle.viewModelKtx)
    implementation(Deps.lifecycle.viewModelSavedState)

    implementation(Deps.activityCompose)

    implementation(Deps.dataStorePreferences)

    debugImplementation(Deps.compose.uiTooling)
}