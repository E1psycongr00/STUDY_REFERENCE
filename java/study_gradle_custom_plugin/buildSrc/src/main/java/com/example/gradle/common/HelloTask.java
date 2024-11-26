package com.example.gradle.common;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public class HelloTask extends DefaultTask {

    @Input
    private String message;

    public HelloTask() {
        setGroup("my-custom");
        setDescription("기본 커스텀 태스크 예제입니당!!!");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @TaskAction
    void hello() {
        System.out.println(message);
    }
}