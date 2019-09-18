package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class DistilleryRepositoryImpl implements DistilleryRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @SuppressWarnings("deprecation")
    @Transactional
    public List<Distillery> findAllDistilleriesWith12YearOldWhiskies() {
        List<Distillery> results = null;
        try {
            Session session = entityManager.unwrap(Session.class);
            Criteria cr = session.createCriteria(Distillery.class);
            cr.createAlias("whiskies", "w");
            cr.add(Restrictions.eq("w.age", 12));
            results = cr.list();
        }
        catch(HibernateException ex) {
            ex.printStackTrace();
        }
        return results;
    }
}
