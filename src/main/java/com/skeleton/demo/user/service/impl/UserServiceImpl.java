package com.skeleton.demo.user.service.impl;

import com.skeleton.demo.user.dto.UserDto;
import com.skeleton.demo.user.dao.UserDao;
import com.skeleton.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDaoImpl")
    UserDao userDao;

    @Override
    public void addUser(UserDto.loginDto user) throws Exception {
        System.out.println("UserServiceImpl addUser Start");

        userDao.addUser(user.testConvert());
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
