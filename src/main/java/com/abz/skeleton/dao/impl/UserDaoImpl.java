package com.abz.skeleton.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.abz.skeleton.dao.BaseDao;
import com.abz.skeleton.dao.UserDao;
import com.abz.skeleton.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User get(Long id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM User ORDER BY id").list();
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().merge(user);
    }

    @Override
    public User findByUserName(String username) {
        return (User) sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.name = :username ")
                .setString("username", username).uniqueResult();
    }

}
