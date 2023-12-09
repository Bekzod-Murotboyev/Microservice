plugins {
	java
	id("org.springframework.boot") version "3.1.5"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "dev.bekzod"
version = "0.0.1"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2022.0.4"

dependencies {

	/** ----------------- SPRING BOOT/CLOUD DEPENDENCIES ----------------- **/
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.cloud:spring-cloud-starter")
	implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
	/** -------------------------------------------------------------------------- **/

	/** -------------------- AUTHORIZATION SERVER DEPENDENCY -------------------- **/
	implementation("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")
	/** -------------------------------------------------------------------------- **/

	/** ----------------- SPRING CLOUD CENTRALIZED CONFIG DEPENDENCY ----------------- **/
	implementation("org.springframework.cloud:spring-cloud-starter-config")
	/** ------------------------------------------------------------ **/

	/** ----------------- H2 DATABASE DRIVER DEPENDENCY ----------------- **/
	runtimeOnly("com.h2database:h2")
	/** ------------------------------------------------------------ **/

	/** ----------------- LOMBOK ----------------- **/
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	/** ------------------------------------------------------------ **/

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
