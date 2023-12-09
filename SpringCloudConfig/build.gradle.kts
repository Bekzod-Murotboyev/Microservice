plugins {
    java
    id("org.springframework.boot") version "3.1.4"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "dev.bekzod"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2022.0.4"
val projectAlias = "cloud-service"

dependencies {
    implementation("org.springframework.cloud:spring-cloud-config-server")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

// TASK FOR CHANGING FINAL .JAR FILE NAME
tasks.bootJar {
    archiveFileName.set("$projectAlias.jar")
}
