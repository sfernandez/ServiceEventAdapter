import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.2.41"

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlinModule("gradle-plugin", kotlin_version))
    }
}

plugins {
    java
}

group = "com.sevent"
version = "1.0-SNAPSHOT"

apply {
    plugin("kotlin")
}

val kotlin_version: String by extra

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlinModule("stdlib-jdk8", kotlin_version))
    compile("org.apache.camel", "camel-core", "2.21.1")
    compile("org.slf4j","slf4j-nop","1.7.25")
    compile("org.apache.camel", "camel-jetty", "2.21.1")
    compile("org.apache.camel", "camel-http4", "2.21.1")
    compile("org.apache.camel", "camel-rabbitmq", "2.21.1")
    testCompile("org.apache.camel", "camel-test", "2.21.1")
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}