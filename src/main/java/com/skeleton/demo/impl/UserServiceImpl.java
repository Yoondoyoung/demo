package com.skeleton.demo.impl;

import com.skeleton.demo.dto.UserDto;
import com.skeleton.demo.service.UserDao;
import com.skeleton.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDaoImpl")
    UserDao userDao;

    @Override
    public void addUser(UserDto user) throws Exception {
        System.out.println("UserServiceImpl addUser Start");
        userDao.addUser(user);
    }

    @Override
    public UserDto getUser(String userId) throws Exception {
        return null;
    }

    @Override
    public List<UserDto> getUserList() throws Exception {

        return userDao.getUserList();
    }

    @Override
    public void deleteUser(String userId) throws Exception {

    }
}
