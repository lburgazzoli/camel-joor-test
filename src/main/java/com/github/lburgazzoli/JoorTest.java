package com.github.lburgazzoli;

import java.nio.file.Files;
import java.nio.file.Path;

import org.joor.Reflect;

public class JoorTest {
    public static void main(String[] args) throws Exception {
        String data = Files.readString(Path.of("data/MyData.java"));
        String route = Files.readString(Path.of("data/MyRoutes.java"));

        Reflect.compile("my.example.MyData", data).create().get();
        Reflect.compile("my.example.MyRoutes", route).create().get();
    }
}
