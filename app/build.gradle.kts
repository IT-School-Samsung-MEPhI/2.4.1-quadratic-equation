plugins {
    id("com.android.application")
}

android {
    namespace = "ru.samsung.itschool.mdev.homework"
    compileSdk = 34

    defaultConfig {
        applicationId = "ru.samsung.itschool.mdev.homework"
        minSdk = 23
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    testImplementation(libs.junit)
    testImplementation(libs.robolectric)
}