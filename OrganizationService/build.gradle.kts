plugins {
    java
    id("org.springframework.boot") version "3.1.4"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "dev.bekzod"
version = "0.0.1"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2022.0.4"

dependencies {
    /** ----------------- SPRING BOOT DEPENDENCIES ----------------- **/
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
    /** ------------------------------------------------------------ **/

    /** ----------------- SPRING CLOUD CENTRALIZED CONFIG DEPENDENCY ----------------- **/
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    /** ------------------------------------------------------------ **/

    /** ----------------- SERVICE DISCOVERY CLIENT DEPENDENCY ----------------- **/
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    /** ------------------------------------------------------------ **/

    /** -------------------- RESOURCE AND CLIENT SERVICE DEPENDENCIES -------------------- **/
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    /** -------------------------------------------------------------------- **/

    /** ----------------- H2 DATABASE DRIVER DEPENDENCY ----------------- **/
    runtimeOnly("com.h2database:h2")
    /** ------------------------------------------------------------ **/

    /** ----------------- RESILIENCE4J DEPENDENCY ----------------- **/
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j")
    /** ------------------------------------------------------------ **/


    /** ----------------- SPRING KAFKA DEPENDENCY ----------------- **/
    implementation("org.springframework.kafka:spring-kafka")
    /** ------------------------------------------------------------ **/

    /** ----------------- MAPSTRUCT ----------------- **/
    implementation("org.mapstruct:mapstruct:1.5.3.Final")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.3.Final")
    /** ------------------------------------------------------------ **/

    /** ----------------- LOMBOK ----------------- **/
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    /** ------------------------------------------------------------ **/

    /** ----------------- ACTUATOR DEPENDENCY ----------------- **/
    implementation("org.springframework.boot:spring-boot-starter-actuator") // THIS DEPENDENCY ALSO USED BY MICROMETER
    /** ------------------------------------------------------------ **/

    /** ----------------- MICROMETER DEPENDENCY ----------------- **/
    implementation("io.micrometer:micrometer-tracing-bridge-brave")
    implementation("io.zipkin.brave:brave")
    implementation("io.github.openfeign:feign-micrometer")
    /** ------------------------------------------------------------ **/

    /** ----------------- DEPENDENCIES FOR TESTING ----------------- **/
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    /** ------------------------------------------------------------ **/
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
