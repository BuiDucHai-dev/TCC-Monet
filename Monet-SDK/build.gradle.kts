import org.gradle.kotlin.dsl.release

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("com.vanniktech.maven.publish")
    signing
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates("io.github.buiduchai-dev", "monet-sdk", "1.0.0")

    pom {
        name = "Monet SDK"
        description = "Monet SDK"
        inceptionYear = "2025"
        url = "https://github.com/BuiDucHai-dev/TCC-Monet"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                distribution = "http://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "BuiDucHai-dev"
                name = "Bui Duc Hai"
                url = "https://github.com/BuiDucHai-dev"
            }
        }
        scm {
            url = "https://github.com/BuiDucHai-dev/TCC-Monet"
            connection = "scm:git:git://github.com/BuiDucHai-dev/TCC-Monet.git"
            developerConnection = "scm:git:ssh://git@github.com/BuiDucHai-dev/TCC-Monet.git"
        }
    }
}

//publishing {
//    publications {
//        create<MavenPublication>("release") {
//            groupId = "io.github.buiduchai-dev"
//            artifactId = "monet-sdk"
//            version = "1.0.0"
//
//            afterEvaluate {
//                from(components["release"])
//            }
//        }
//    }
//    repositories {
//        maven {
//            name = "OSSRH"
//            url = uri("https://central.sonatype.com/repository/maven/")
//            credentials {
//                username = providers.gradleProperty("mavenCentralUsername").get()
//                password = providers.gradleProperty("mavenCentralPassword").get()
//            }
//        }
//    }
//}

signing {
    setRequired {
        !gradle.taskGraph.allTasks.any { it is PublishToMavenLocal }
    }
//    isRequired.set(!gradle.taskGraph.allTasks.any { it.name == "publishToMavenLocal" })
    sign(publishing.publications)
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