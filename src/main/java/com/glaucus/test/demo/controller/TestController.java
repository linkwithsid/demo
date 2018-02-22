package com.glaucus.test.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface TestController {

    /**
     * This method returns  increment value available in DB
     *
     * @return Integer
     */
    @RequestMapping( value = "/increment" , method = RequestMethod.GET)
    Integer getIncrementedValue();

}
