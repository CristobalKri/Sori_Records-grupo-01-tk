plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.sori_records_grupo01tk"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.sori_records_grupo01tk"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }


}

dependencies {

    implementation("com.google.accompanist:accompanist-permissions:0.32.0")
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
    implementation("org.osmdroid:osmdroid-android:6.1.15")
    implementation("com.google.android.gms:play-services-location:21.0.1")
    implementation("androidx.compose.material3:material3:1.4.0")
    implementation("com.google.accompanist:accompanist-pager:0.20.0")
    implementation("androidx.compose.ui:ui-util:1.9.3")
    implementation("io.coil-kt:coil-compose:2.2.2")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0-rc02")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
    implementation("androidx.datastore:datastore-preferences:1.1.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.9.2")
    implementation("androidx.compose.material:material-icons-core")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.material3.window.size.class1)
    implementation(libs.androidx.compose.foundation)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.text)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.foundation.layout)
    implementation(libs.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Junit
    testImplementation("junit:junit:4.13.2")

    // Mockito
    testImplementation("org.mockito:mockito-core:4.5.1")
    testImplementation("org.mockito:mockito-inline:4.5.1")
    androidTestImplementation("org.mockito:mockito-android:4.0.0")


    // Junit & Espresso
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.0")
    testImplementation("org.mockito:mockito-junit-jupiter:4.5.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // UI Testing
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.4.0")
    androidTestImplementation("androidx.compose.material3:material3:1.0.0")
    androidTestImplementation("androidx.navigation:navigation-testing:2.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-manifest:1.4.0")

    // LiveData
    testImplementation("androidx.lifecycle:lifecycle-livedata-ktx:2.10.0")
    testImplementation("androidx.arch.core:core-testing:2.1.0")

    // Arch & Coroutines && Kotlin
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.5.30")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")

    // Mockk
    testImplementation("io.mockk:mockk:1.13.4")
}