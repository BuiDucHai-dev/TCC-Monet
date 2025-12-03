import com.vanniktech.maven.publish.AndroidSingleVariantLibrary

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("com.vanniktech.maven.publish")
}

android {
    namespace = "com.tcc.monet.sdk"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

mavenPublishing {
    coordinates("io.github.buiduchai-dev", "monet-sdk", "1.0.0-SNAPSHOT")

    pom {
        name.set("Monet SDK")
        description.set("Monet SDK")
        inceptionYear.set("2025")
        url.set("https://github.com/BuiDucHai-dev/tcc-monet-sdk")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("username")
                name.set("User Name")
                url.set("https://github.com/username/")
            }
        }
        scm {
            url.set("https://github.com/username/mylibrary/")
            connection.set("scm:git:git://github.com/username/mylibrary.git")
            developerConnection.set("scm:git:ssh://git@github.com/username/mylibrary.git")
        }
    }
}

dependencies {

    // Google monet-sdk
    implementation(libs.play.services.ads)
    implementation(libs.billing.ktx)
    implementation(libs.sdp.android)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.config)
    implementation(libs.firebase.messaging)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}