package com.exercise.eurekaserver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class EurekaServerApplicationTests {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void applicationContextShouldLoad() {
        Assertions.assertNotNull(applicationContext);
    }

    @Test
    void applicationNameShouldExist() {
        Assertions.assertTrue(
                applicationContext.containsBean("eurekaServerApplication")
        );
    }

}