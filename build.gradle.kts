plugins {
    kotlin("jvm") version "2.0.10"
}

group = "org.gang"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
}

dependencies {
    testImplementation(kotlin("test"))
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}