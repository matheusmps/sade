package com.mc437.stepdefs;

import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mc437.configuration.AppConfig;

@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = { AppConfig.class })
public abstract class StepDefs {
    protected WebDriver driver;
    protected static final String ROOT_URL = "http://localhost:8080/sade-1.0.0/";
}
