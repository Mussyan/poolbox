import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"

    id("org.openapi.generator") version "6.4.0"
}

group = "com.greengrass"
version = "1.0.0.2023-04-18"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}

openApiGenerate {
    generatorName.set("kotlin-spring")

    configOptions.set(
        mapOf(
            "reactive" to "false",
            "interfaceOnly" to "true",
            "enumPropertyNaming" to "UPPERCASE",
            "useBeanValidation" to "false",
            "useTags" to "true",
            "useSpringBoot3" to "true",
            "oas3" to "false",
            "documentationProvider" to "none",
            "annotationLibrary" to "none"
        )
    )

    inputSpec.set("$rootDir/api.yaml")
    outputDir.set("$buildDir/generated/openapi/")

    apiPackage.set("com.greengrass.poolbox.operations")
    modelPackage.set("com.greengrass.poolbox.models")

    generateApiDocumentation.set(false)
    generateModelDocumentation.set(false)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

kotlin {
    sourceSets["main"].apply {
        kotlin.srcDirs(
            listOf(
                "$buildDir/generated/openapi/src/main",
            )
        )
    }
}

tasks.withType<org.openapitools.generator.gradle.plugin.tasks.GenerateTask> {
    outputs.upToDateWhen { false }
    outputs.cacheIf { false }
}