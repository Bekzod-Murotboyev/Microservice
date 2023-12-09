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

    /** ----------------- SPRING CLOUD DISCOVERY CLIENT DEPENDENCY ----------------- **/
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    /** ------------------------------------------------------------ **/

    /** -------------------- RESOURCE AND CLIENT SERVICE DEPENDENCIES -------------------- **/
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    /** -------------------------------------------------------------------- **/

    /** ----------------- SERVICE CLOUD FEIGN CLIENT DEPENDENCY ----------------- **/
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    /** ------------------------------------------------------------ **/

    /** ----------------- H2 DATABASE DRIVER DEPENDENCY ----------------- **/
    runtimeOnly("com.h2database:h2")
    /** ------------------------------------------------------------ **/

    /** ----------------- SERVICE CLOUD STREAM DEPENDENCY ----------------- **/
    implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka-streams")
    /** ------------------------------------------------------------ **/

    /** ----------------- REDIS DEPENDENCY ----------------- **/
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    /** ----------------------------------------------------------- **/

    /** ----------------- CIRCUIT BREAKER DEPENDENCY ----------------- **/
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
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

    /** ----------------- MICROMETER DEPENDENCIES ----------------- **/
    implementation("io.micrometer:micrometer-tracing-bridge-brave")
    implementation("io.zipkin.reporter2:zipkin-reporter-brave")
    implementation("io.github.openfeign:feign-micrometer") // HELPING THIS DEPENDENCY FEIGN CLIENT PROPAGATES TRACE ID TO DURING SERVICE CALL
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
