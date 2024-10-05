package com.eglab.intelli.video.admin.infrastructure;

import com.eglab.intelli.video.admin.application.UseCase;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(new UseCase().execute());
    }
}