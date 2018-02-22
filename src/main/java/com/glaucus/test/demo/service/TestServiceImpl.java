package com.glaucus.test.demo.service;

import com.glaucus.test.demo.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl implements TestService {

    @Autowired
    TestDao testDao;

    @Override
    public Integer getIncrementedValue() {
        return testDao.getIncrementedValue();
    }
}
