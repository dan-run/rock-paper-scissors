import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

group = "rock.paper"
version = "0.0.1"
val testkitVersion = "5.4.2"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    testImplementation("io.kotest:kotest-runner-junit5:$testkitVersion")
    testImplementation("io.kotest:kotest-assertions-core:$testkitVersion")
    testImplementation("io.kotest:kotest-property:$testkitVersion")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}