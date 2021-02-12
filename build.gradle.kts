import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath("com.github.jengelman.gradle.plugins:shadow:2.0.4")
    }
}

plugins {
    idea
    kotlin("jvm") version "1.4.30"
}

apply {
    plugin("com.github.johnrengelman.plugin-shadow")
}

group = "me.ebonjaeger"
version = "1.1.2"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

val bukkitVersion = "1.15-R0.1-SNAPSHOT"
dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("junit", "junit", "4.12")
    testImplementation("com.natpryce:hamkrest:1.4.2.2")
    testImplementation("org.spigotmc:spigot-api:$bukkitVersion")

    compileOnly("org.spigotmc:spigot-api:$bukkitVersion")

    implementation("ch.jalu:configme:1.2.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

val shadowJar: ShadowJar by tasks
shadowJar.apply {
    manifest.attributes.apply {
        put("Implementation-Title", project.name)
        put("Implementation-Version", project.version)
    }

    relocate("kotlin", "me.ebonjaeger.appletreereloaded.kotlin")
}
