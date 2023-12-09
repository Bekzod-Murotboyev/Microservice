plugins {
    java
    id("org.springframework.boot") version "3.1.4"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "dev.bekzod"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2022.0.4"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")

    /** ----------------- SPRING CLOUD CENTRALIZED CONFIG DEPENDENCY ----------------- **/
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    /** ------------------------------------------------------------ **/

    /** ----------------- SERVICE DISCOVERY CLIENT DEPENDENCY ----------------- **/
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
    /** ------------------------------------------------------------ **/


    /** ----------------- H2 DATABASE DRIVER DEPENDENCY ----------------- **/
    runtimeOnly("com.h2database:h2")
    runtimeOnly("io.r2dbc:r2dbc-h2")
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

    /** ----------------- DEPENDENCIES FOR TESTING ----------------- **/
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    /** ------------------------------------------------------------ **/
}

/** ----------------- DEPENDENCY VERSION MANAGEMENT ----------------- **/
dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}
/** ------------------------------------------------------------------- **/

tasks.withType<Test> {
    useJUnitPlatform()
}
