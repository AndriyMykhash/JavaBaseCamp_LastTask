//package com.galaxy.Hibernate;
//
//import com.galaxy.Representations.People;
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import java.util.List;
//
//
//
//public class PeopleDao {
//
//
////    public People findByValue(String value) {
////        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
////
////        Criteria criteria = session.createCriteria(People.class);
////        if(value.equals("name"))
////            People person = criteria.add(Restrictions.eq(value, )).uniqueResult();
////    }
//
//    public void save(People person) {
//
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//            session.save(person);
//        tx1.commit();
//        session.close();
//    }
//
//    public List<People> findAll(){
//        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persistence");
//        EntityManager entitymanager = emfactory.createEntityManager();
//        CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
//        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
//        Root from = criteriaQuery.from(People.class);
//
//        CriteriaQuery select = criteriaQuery.select(from);
//        TypedQuery typedQuery = entitymanager.createQuery(select);
//        List dep = typedQuery.getResultList();
//
//        entitymanager.close();
//        emfactory.close();
//
//        if (dep.isEmpty())
//            return null;
//        return dep;
//    }
//}