plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
	id("org.jooq.jooq-codegen-gradle") version "3.19.14"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.flywaydb:flyway-core")
	implementation("org.flywaydb:flyway-mysql")
	implementation("org.springframework.boot:spring-boot-starter-jooq")
	implementation("org.jooq:jooq-codegen:3.19.14")
	jooqCodegen("org.jooq:jooq-meta-extensions:3.19.14")
	jooqCodegen("org.jooq:jooq-codegen:3.19.14")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.mysql:mysql-connector-j")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("org.testcontainers:mysql")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

tasks.withType<Test> {
	useJUnitPlatform()
}

sourceSets {
	main {
		java {
			val mainDir = "src/main/java"
			val jooqDir = "src/main/generated"
			srcDirs(mainDir, jooqDir)
		}
	}
}



jooq {
	configuration {
		generator {
			database {
				name = "org.jooq.meta.extensions.ddl.DDLDatabase"

				properties {
					property {
						key = "scripts"
						value = "src/main/resources/db/migration"
					}
					property {
						key = "sort"
						value = "flyway"
					}
					property {
						key = "unqualifiedSchema"
						value = "none"
					}
					property {
						key = "defaultNameCase"
						value = "as_is"
					}
				}

			}

			strategy {
				name = "com.example.JPrefixGeneratorStrategy"
				java = """
					package com.example;

					import org.jooq.codegen.DefaultGeneratorStrategy;
					import org.jooq.meta.Definition;

					public class JPrefixGeneratorStrategy extends DefaultGeneratorStrategy {

					    @Override
					    public String getJavaClassName(Definition definition, Mode mode) {
					        if (mode == Mode.RECORD || mode == Mode.POJO || mode == Mode.DEFAULT) {
					            return "J" + super.getJavaClassName(definition, mode);
					        }
					        return super.getJavaClassName(definition, mode);
					    }
					}

				""".trimIndent()
			}

			generate {
				isDeprecated = false
				isRecords = true
				isImmutablePojos = true
				isFluentSetters = true
				isJavaTimeTypes = true
			}

			target {
				packageName = "jooq.jooq_dsl"
				directory = "src/main/generated"
				encoding = "UTF-8"
			}


		}
	}
}


