import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    java
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "me.bardy"
version = "1.1"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper", "paper-api", "1.17-R0.1-SNAPSHOT")
    compileOnly("net.luckperms", "api", "5.3")
}

tasks {
    shadowJar {
        archiveFileName.set("RankupOnClaim-${project.version}.jar")
    }
    processResources {
        filter<ReplaceTokens>("tokens" to mapOf("version" to project.version.toString()))
    }
}
