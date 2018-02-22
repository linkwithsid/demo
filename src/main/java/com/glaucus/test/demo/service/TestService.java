package com.glaucus.test.demo.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface TestService {

    /**
     * This method increment value available in DB
     *
     * @return Integer
     */
    Integer getIncrementedValue();

}
