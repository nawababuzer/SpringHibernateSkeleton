package com.abz.skeleton.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abz.skeleton.controller.UserCommand;
import com.abz.skeleton.controller.UserGrid;
import com.abz.skeleton.dao.UserDao;
import com.abz.skeleton.model.User;
import com.abz.skeleton.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public User get(Long id) {
        return userDao.get(id);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserGrid findAll() {
        return new UserGrid(userDao.findAll());
    }

    @Override
    @Transactional
    public void save(UserCommand userCommand) {
        userDao.save(userCommand.toUser());
    }

    @Override
    @Transactional
    public void saveAll(UserGrid userGrid) {
        for (User user : userGrid.getUsers()) {
            userDao.save(user);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public void updateWithAll(UserGrid userGrid) {
        UserGrid allUsers = findAll();
        allUsers.getUserMap().putAll(userGrid.getUserMap());
        userGrid.setUserMap(allUsers.getUserMap());
    }
}
