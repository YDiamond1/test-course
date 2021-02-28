

val test_version = "5.7.0"
plugins {
    java
    kotlin("jvm") version "1.4.30"
}

group = "dawin.york"
version = "1.0"

repositories {
    mavenCentral()
}


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation(platform("org.junit:junit-bom:5.7.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}


tasks.test{
    useJUnitPlatform()
    testLogging{
        events("passed", "skipped", "failed")
    }
}
