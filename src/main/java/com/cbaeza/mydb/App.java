/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.cbaeza.mydb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Main app
 */
@ComponentScan(basePackages = "com.cbaeza")
@SpringBootApplication
public class App {

  private static final Logger LOG = LoggerFactory.getLogger(App.class.getName());

  public String getGreeting() {
    return "Hello App.";
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

}
