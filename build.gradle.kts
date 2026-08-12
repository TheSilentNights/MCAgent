import java.util.Properties 

plugins{
    id("java")
}
 
val localProperties = Properties().apply {
    val file = rootProject.file("local.properties")
    if (file.exists()) {
        file.inputStream().use { load(it) }
    }
}

val destDir = localProperties.getProperty("plugin.build.output")

repositories {
  maven {
    name = "papermc"
    url = uri("https://repo.papermc.io/repository/maven-public/")
  }
  maven {
    name = "extendedclip"
    url = uri("https://repo.extendedclip.com/releases/")
  }
  maven {
    name = "citizens-repo"
    url = uri("https://maven.citizensnpcs.co/repo")
  }
}

dependencies {
  compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
  compileOnly("me.clip:placeholderapi:2.12.3")
  compileOnly("net.citizensnpcs:citizens-main:2.0.35-SNAPSHOT") {
    exclude("*")
  }
}

if (!destDir.isNullOrEmpty()) {
    tasks.named<Jar>("jar") {
        destinationDirectory.set(file(destDir as String))
    }
}

java {
  toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}
