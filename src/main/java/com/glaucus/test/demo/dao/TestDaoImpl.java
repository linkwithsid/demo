package com.glaucus.test.demo.dao;

import com.glaucus.test.demo.entity.TestEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TestDaoImpl implements TestDao {


    private AtomicInteger value = new AtomicInteger();

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer getIncrementedValue() {
        Session session = null;
        TestEntity testEntity = new TestEntity();
        testEntity.setId("0");
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            if(0 == value.get()){
                testEntity.setValue(value.incrementAndGet());
                session.saveOrUpdate(testEntity);
            }
            else {
                    testEntity.setValue(value.incrementAndGet());
                    session.update(testEntity);    // update the DB with increment value
                }
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        finally {
            if(null != session) {
                session.close();
            }
        }
        return testEntity.getValue();
    }
}
