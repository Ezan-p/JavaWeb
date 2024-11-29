package com.ezan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringbootwebTliasApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootwebTliasApplication.class, args);
    }

}
