plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    defaultConfig {
        multiDexEnabled = true
    }
    namespace = "it.marioreina.demoviews.domain"
    compileSdk = libs.versions.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.valueOf(libs.versions.javaVersion.get())
        targetCompatibility = JavaVersion.valueOf(libs.versions.javaVersion.get())
    }
    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }
}

dependencies {
    implementation(project(":data"))
    api(libs.wereUseCase)
    implementation(libs.wereRetrofitutils)
    implementation(libs.koin.core)
    implementation(libs.koin.android)
}