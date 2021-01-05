package com.skeleton.demo.impl;

import com.skeleton.demo.dto.UserDto;
import com.skeleton.demo.service.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class UserDaoImpl implements UserDao {

    @Autowired
    SqlSession sqlSession;

    @Override
    public void addUser(UserDto user) throws Exception {
        System.out.println("UserDaoImpl addUser Start");
        sqlSession.insert("UserMapper.addUSer",user);
    }

    @Override
    public UserDto getUser(String userId) throws Exception {
        return null;
    }

    @Override
    public Map<String, Object> getUserList() throws Exception {
        return null;
    }

    @Override
    public void deleteUser(String userId) throws Exception {

    }
}
