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
    kotlin("jvm") version "1.3.61"
}

apply {
    plugin("com.github.johnrengelman.plugin-shadow")
}

group = "me.ebonjaeger"
version = "1.1.1"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

val bukkitVersion = "1.15-R0.1-SNAPSHOT"
dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testCompile("junit", "junit", "4.12")
    testCompile("com.natpryce:hamkrest:1.4.2.2")
    testCompile("org.spigotmc:spigot-api:" + bukkitVersion)

    compileOnly("org.spigotmc:spigot-api:" + bukkitVersion)

    implementation("ch.jalu:configme:1.1.0")
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
        put("Implementation-Version", version)
    }

    classifier = null

    relocate("kotlin", "me.ebonjaeger.appletreereloaded.kotlin")
}
