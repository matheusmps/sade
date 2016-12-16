package com.mc437.stepdefs;

import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mc437.configuration.AppConfig;

@WebAppConfiguration
@ContextConfiguration(loader = AnnotationConfigWebContextLoader.class, classes = { AppConfig.class })
public abstract class StepDefs {
    protected static WebDriver driver;
    protected static final String ROOT_URL = "http://sample-env-2.v5vayj2nke.us-west-2.elasticbeanstalk.com/";
    protected static final String DRIVER_URL = "driver/chromedriver-mac";
}
