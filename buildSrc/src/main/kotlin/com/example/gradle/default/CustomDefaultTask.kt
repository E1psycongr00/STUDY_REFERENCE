package com.example.gradle.default

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class CustomDefaultTask : DefaultTask() {
    init {
        group = "custom"
        description = "기본 커스텀 태스크 예제"
    }

    @TaskAction
    fun run() {
        println("커스텀 태스크가 실행되었습니다!")
        println("현재 프로젝트: ${project.name}")
    }
} 