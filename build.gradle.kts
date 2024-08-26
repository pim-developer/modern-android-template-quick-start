// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.mongodb.realm.kotlin) apply false
    kotlin("jvm").version(libs.versions.kotlinSerialization).apply(false) // Needed at least for type-safe navigation with compose Navigation
    kotlin("plugin.serialization").version(libs.versions.kotlinSerialization).apply(false) // Needed at least for type-safe navigation with compose Navigation

    alias(libs.plugins.compose.compiler) apply false // https://developer.android.com/develop/ui/compose/compiler
}