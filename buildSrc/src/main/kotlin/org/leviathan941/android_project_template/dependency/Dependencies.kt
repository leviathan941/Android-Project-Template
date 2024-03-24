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

package org.leviathan941.android_project_template.dependency

object Plugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.ANDROID_PLUGIN}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_PLUGIN}" }
}

object Dependencies {
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.ACTIVITY_COMPOSE}" }
    val androidCoreKtx by lazy { "androidx.core:core-ktx:${Versions.ANDROID_CORE}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.APP_COMPAT}" }
    val compose = ComposeDependency(Versions.COMPOSE)
    val composeCompiler by lazy { "androidx.compose.compiler:compiler:${Versions.COMPOSE_COMPILER}" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3:${Versions.COMPOSE_MATERIAL_3}" }
    val dataStorePreferences by lazy { "androidx.datastore:datastore-preferences:${Versions.DATA_STORE}" }
    val lifecycle = LifecycleDependency(Versions.LIFECYCLE)
    val material by lazy { "com.google.android.material:material:${Versions.MATERIAL}" }
    val room = RoomDependency(Versions.ROOM)
}

class ComposeDependency(private val version: String) {
    val ui by lazy { "androidx.compose.ui:ui:$version" }
    val runtimeLivedata by lazy { "androidx.compose.runtime:runtime-livedata:$version" }
    val uiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:$version" }
    val uiTooling by lazy { "androidx.compose.ui:ui-tooling:$version" }
}

class LifecycleDependency(private val version: String) {
    val livedataKtx by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:$version" }
    val viewModelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:$version" }
    val viewModelSavedState by lazy { "androidx.lifecycle:lifecycle-viewmodel-savedstate:$version" }
}

class RoomDependency(private val version: String) {
    val compiler by lazy { "androidx.room:room-compiler:$version" }
    val ktx by lazy { "androidx.room:room-ktx:$version" }
}
