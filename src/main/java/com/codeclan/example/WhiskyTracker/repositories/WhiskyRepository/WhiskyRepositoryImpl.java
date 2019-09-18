package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @SuppressWarnings("deprecation")
    @Transactional
    public List<Whisky> findAllWhiskysFromDistilleryByAge(Distillery distillery, int age) {
        List<Whisky> results = null;
        try {
            Session session = entityManager.unwrap(Session.class);
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "d");
            cr.add(Restrictions.eq("d.id", distillery.getId()));
            cr.add(Restrictions.eq("age", age));
            results = cr.list();
        }
        catch(HibernateException ex) {
            ex.printStackTrace();
        }
        return results;
    }
}
