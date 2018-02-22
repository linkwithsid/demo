package com.glaucus.test.demo.dao;

import com.glaucus.test.demo.entity.TestEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImpl implements TestDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Integer getIncrementedValue() {
        Session session = null;
        TestEntity testEntity = null;
        synchronized (this) {
            try {
                session = sessionFactory.openSession();
                session.beginTransaction();
                testEntity = session.get(TestEntity.class, "0"); //get 0th element from DB
                if (null == testEntity) {                              // if 0th element not available add element to DB
                    testEntity = new TestEntity();
                    testEntity.setId("0");
                    testEntity.setValue(1);
                    session.save(testEntity);
                } else {                                            // update the DB with increment value
                    testEntity.setValue(testEntity.getValue() + 1);
                    session.update(testEntity);
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
        }
        return testEntity.getValue();
    }
}
