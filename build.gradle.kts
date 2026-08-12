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
}

dependencies {
  compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
}

if (!destDir.isNullOrEmpty()) {
    tasks.named<Jar>("jar") {
        destinationDirectory.set(file(destDir as String))
    }
}

java {
  toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}
