package ru.kata.spring.boot_security.demo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

//    @Autowired
//    private EntityManagerFactory emf;

    @Override
    public List<User> showUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
        em.persist(user);
//        transaction.commit();
    }

    @Override
    public User findUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
//    @Transactional
    public void update(int id, User updatedUser) {
        User userToBeUpdated = findUserById(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setSalary(updatedUser.getSalary());

//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
        em.persist(userToBeUpdated);
//        transaction.commit();
    }

    public void delete(int id) {
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
        User user = findUserById(id);
        em.remove(user);
//        transaction.commit();
    }
}
