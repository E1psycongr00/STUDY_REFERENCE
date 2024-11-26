import com.example.gradle.default.CustomDefaultTask


plugins {
    `java`
}

repositories {
    mavenCentral()
}

tasks.register<CustomDefaultTask>("helloTask")