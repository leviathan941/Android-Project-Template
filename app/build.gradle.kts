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

import org.leviathan941.androidprojecttemplate.AndroidSdk
import org.leviathan941.androidprojecttemplate.Application
import org.leviathan941.androidprojecttemplate.Versions

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.kapt)
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
        kotlinCompilerExtensionVersion = libs.compose.compiler.get().version
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation(libs.google.material)

    implementation(libs.compose.compiler)
    implementation(libs.compose.ui)
    implementation(libs.compose.runtime.livedata)
    implementation(libs.compose.material3)

    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)

    implementation(libs.compose.activity)

    implementation(libs.datastore.preferences)

    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.tooling.preview)
}
