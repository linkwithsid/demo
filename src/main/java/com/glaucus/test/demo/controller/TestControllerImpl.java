package com.glaucus.test.demo.controller;

import com.glaucus.test.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControllerImpl implements TestController {

    @Autowired
    private TestService testService;

    @Override
    public Integer getIncrementedValue() {
        return testService.getIncrementedValue();
    }
}
