import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.androiddevtaha.touristspotter"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.androiddevtaha.touristspotter"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        buildConfigField("String", "API_KEY", properties.getProperty("apikey"))
        buildConfigField("String", "BASE_URL", properties.getProperty("baseUrl"))

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    val composeVersion = "1.0.1"
    val hiltVersion = "2.46.1"
    val navVersion = "2.6.0"
    val retrofitConvertoerVersion = "2.9.0"
    val okhttp3LoggingVersion = "4.11.0"
    val okhttp3Version = "4.11.0"
    val retrofitVersion = "2.9.0"
    val activityComposeVersion = "1.7.2"
    val coreKtxVersion = "1.10.1"
    val junitExtVersion = "1.1.5"
    val testMonitorVersion = "1.6.1"
    val testngVersion = "6.9.6"
    val coilComposeVersion = "2.4.0"
    val accompanistSystemUiControllerVersion = "0.28.0"
    val accompanistPermissionsVersion = "0.31.3-beta"
    val accompanistWebViewVersion = "0.28.0"
    val lottieComposeVersion = "6.1.0"
    val hiltNavigationComposeVersion = "1.1.0-alpha01"
    val gsonVersion = "2.10.1"
    val composeUITestManifestVVersion = "1.4.3"
    val lifecycleRuntimeKtxVersion = "2.6.1"
    val lifecycleViewModelComposeVersion = "2.6.1"
    val lifecycleViewModelKtsVersion = "2.6.1"
    val lifecycleRunTimeComposeVersion = "2.6.1"
    val lifecycleSavedStateVersion = "2.6.1"
    val lifecycleRuntimeTestingVersion = "2.6.1"
    val dagger2Version = "2.46.1"


    // retrofit
    val retrofitConvertoer = "com.squareup.retrofit2:converter-gson:$retrofitConvertoerVersion"
    val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"

    // okhttp3
    val okhttp3Logging = "com.squareup.okhttp3:logging-interceptor:$okhttp3LoggingVersion"
    val okhttp3 = "com.squareup.okhttp3:okhttp:$okhttp3Version"

    // core
    val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
    val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"

    // testing
    val junitExt = "androidx.test.ext:junit-ktx:$junitExtVersion"
    val testMonitor = "androidx.test:monitor:$testMonitorVersion"
    val testng = "org.testng:testng:$testngVersion"

    // Coil
    val coilCompose = "io.coil-kt:coil-compose:$coilComposeVersion"

    // Accompanist
    val accompanistSystemUiController =
        "com.google.accompanist:accompanist-systemuicontroller:$accompanistSystemUiControllerVersion"
    val accompanistPermissions =
        "com.google.accompanist:accompanist-permissions:$accompanistPermissionsVersion"
    val accompanistWebView = "com.google.accompanist:accompanist-webview:$accompanistWebViewVersion"

    // Lottie
    val lottieCompose = "com.airbnb.android:lottie-compose:$lottieComposeVersion"

    // Dagger Hilt
    val hiltAndroid = "com.google.dagger:hilt-android:$hiltVersion"
    val hiltCompiler = "com.google.dagger:hilt-compiler:$hiltVersion"
    val dagger = "com.google.dagger:dagger:$dagger2Version"

    // Navigation
    val navCompose = "androidx.navigation:navigation-compose:$navVersion"
    val hiltNavigationCompose =
        "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

    // Gson
    val gson = "com.google.code.gson:gson:$gsonVersion"

    // Compose
    val composeBom = "androidx.compose:compose-bom:$composeVersion"
    val composeUI = "androidx.compose.ui:ui"
    val composeUIGraphics = "androidx.compose.ui:ui-graphics"
    val composeUIToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    val composeMaterial3 = "androidx.compose.material3:material3"
    val composeUITestJunit4 = "androidx.compose.ui:ui-test-junit4"
    val composeUITooling = "androidx.compose.ui:ui-tooling"
    val composeUITestManifest = "androidx.compose.ui:ui-test-manifest"
    val composeUITestManifestV =
        "androidx.compose.ui:ui-test-manifest:$composeUITestManifestVVersion"
    val composeFoundation = "androidx.compose.foundation:foundation"

    // Lifecycle
    val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleRuntimeKtxVersion"
    val lifecycleViewModelCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleViewModelComposeVersion"
    val lifecycleViewModelKts =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleViewModelKtsVersion"
    val lifecycleRunTimeCompose =
        "androidx.lifecycle:lifecycle-runtime-compose:$lifecycleRunTimeComposeVersion"
    val lifecycleSavedState =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleSavedStateVersion"
    val lifecycleRuntimeTesting =
        "androidx.lifecycle:lifecycle-runtime-testing:$lifecycleRuntimeTestingVersion"

    // core + testing
    implementation(coreKtx)
    implementation(junitExt)
    implementation(testMonitor)
    testImplementation(testng)
    androidTestImplementation(testng)
    androidTestImplementation(platform(composeBom))
    androidTestImplementation(composeUITestJunit4)
    debugImplementation(composeUITooling)
    debugImplementation(composeUITestManifest)
    debugImplementation(composeUITestManifestV)

    // Hilt
    implementation(hiltAndroid)
    kapt(hiltCompiler)
    implementation(dagger)
    implementation(hiltNavigationCompose)

    //gson
    implementation(gson)

    // Retrofit
    implementation(retrofit)
    implementation(retrofitConvertoer)
    implementation(okhttp3Logging)
    implementation(okhttp3)

    //coil
    implementation(coilCompose)
    // accompanist

    implementation(accompanistSystemUiController)
    implementation(accompanistPermissions)
    implementation(accompanistWebView)

    // lottie
    implementation(lottieCompose)

    // compose
    implementation(platform(composeBom))
    implementation(composeUI)
    implementation(composeUIGraphics)
    implementation(composeUIToolingPreview)
    implementation(composeMaterial3)
    implementation(activityCompose)
    implementation(composeFoundation)
    implementation(navCompose)

    // lifecycle
    implementation(lifecycleRuntimeKtx)
    implementation(lifecycleViewModelCompose)
    implementation(lifecycleViewModelKts)
    implementation(lifecycleRunTimeCompose)
    implementation(lifecycleSavedState)
    testImplementation(lifecycleRuntimeTesting)

}