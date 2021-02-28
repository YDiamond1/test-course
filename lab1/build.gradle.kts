plugins {
    java
    kotlin("jvm")
}


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
