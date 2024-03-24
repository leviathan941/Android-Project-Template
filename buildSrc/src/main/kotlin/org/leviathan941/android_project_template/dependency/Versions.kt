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

import org.gradle.api.JavaVersion

object Versions {
    const val ACTIVITY_COMPOSE = "1.8.2"
    const val ANDROID_CORE = "1.12.0"
    const val ANDROID_PLUGIN = "8.3.0"
    const val APP_COMPAT = "1.6.1"
    const val COMPOSE = "1.6.4"
    const val COMPOSE_COMPILER = "1.5.11"
    const val COMPOSE_MATERIAL_3 = "1.2.1"
    const val DATA_STORE = "1.0.0"
    const val KOTLIN_PLUGIN = "1.9.23"
    const val LIFECYCLE = "2.7.0"
    const val MATERIAL = "1.11.0"
    const val ROOM = "2.6.1"

    val JAVA_SRC_COMPAT = JavaVersion.VERSION_11
    val JAVA_TARGET_COMPAT = JavaVersion.VERSION_11
    const val KOTLIN_JVM = 11
}
