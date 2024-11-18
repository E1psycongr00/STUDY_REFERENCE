import com.example.gradle.common.HelloTask;

plugins {
    `java`
}

repositories {
    mavenCentral()
}

dependencies {

}


tasks.register<HelloTask>("helloMyTask") {
    message = "Hello, World!"
}