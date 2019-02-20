package com.joesamyn.giflib;


import com.joesamyn.giflib.controller.GifController;
import com.joesamyn.giflib.data.CategoryRepository;
import com.joesamyn.giflib.data.GifRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// This annotation will allow an auto configure of our application.
@EnableAutoConfiguration
// This annotation tells the spring framework to scan our project for controllers.
@ComponentScan("com.joesamyn.giflib")
public class AppConfig {
    public static void main(String[] args) {

        // This method will run our application, creating a new application context.
        // We choose the method run, and our current class because that is where we want to run from
        SpringApplication.run(AppConfig.class, args);
    }
}
