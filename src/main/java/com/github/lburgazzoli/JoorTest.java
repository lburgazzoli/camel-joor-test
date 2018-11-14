package com.github.lburgazzoli;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.camel.builder.RouteBuilder;
import org.joor.Reflect;

public class JoorTest {
    public static void main(String[] args) throws Exception {
        try (InputStream in = JoorTest.class.getResourceAsStream("/WithCustomProcessor.java")) {
            String source = new Scanner(in, "UTF-8").useDelimiter("\\A").next();
            RouteBuilder builder = Reflect.compile("com.example.WithCustomProcessor", source).create().get();

            builder.configure();
        }
    }
}
