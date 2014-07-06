package com.abz.skeleton.service;

import com.abz.skeleton.controller.UserCommand;
import com.abz.skeleton.controller.UserGrid;
import com.abz.skeleton.model.User;

public interface UserService {

    User get(Long id);

    void save(UserCommand userCommand);

    void delete(User user);

    UserGrid findAll();

    void saveAll(UserGrid userGrid);

    void updateWithAll(UserGrid userGrid);
}
