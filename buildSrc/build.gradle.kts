plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

//gradlePlugin {
//    plugins {
//        register("customPlugin") {
//            id = "custom-plugin"
//            implementationClass = "com.example.gradle.CustomPlugin"
//        }
//    }
//}


