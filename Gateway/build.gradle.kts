plugins {
	java
	id("org.springframework.boot") version "3.1.5"
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
	/** ----------------- SPRING CLOUD BOOTSTRAP DEPENDENCY ----------------- **/
	implementation("org.springframework.cloud:spring-cloud-starter-bootstrap")
	/** ------------------------------------------------------------ **/
	
	/** ----------------- SPRING CLOUD CENTRALIZED CONFIG DEPENDENCY ----------------- **/
	implementation("org.springframework.cloud:spring-cloud-starter-config")
	/** ------------------------------------------------------------ **/

	/** ----------------- SPRING CLOUD GATEWAY DEPENDENCY ----------------- **/
	implementation("org.springframework.cloud:spring-cloud-starter-gateway")
	/** ------------------------------------------------------------ **/

	/** ----------------- SPRING CLOUD DISCOVERY CLIENT DEPENDENCY ----------------- **/
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")
	/** ------------------------------------------------------------ **/

	/** ----------------- ACTUATOR DEPENDENCY ----------------- **/
	implementation("org.springframework.boot:spring-boot-starter-actuator") // THIS DEPENDENCY ALSO USED BY MICROMETER
	/** ------------------------------------------------------------ **/

	/** ----------------- SPRING KAFKA DEPENDENCY ----------------- **/
	implementation("org.springframework.kafka:spring-kafka")
	/** ------------------------------------------------------------ **/

	/** ----------------- MICROMETER DEPENDENCY ----------------- **/
	implementation("io.zipkin.brave:brave")
	implementation("io.micrometer:micrometer-tracing-bridge-brave")
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
