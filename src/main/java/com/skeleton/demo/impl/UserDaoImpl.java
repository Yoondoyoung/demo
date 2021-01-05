package com.skeleton.demo.impl;

import com.skeleton.demo.dto.UserDto;
import com.skeleton.demo.service.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository("userDaoImpl")
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
    public List<UserDto> getUserList() throws Exception {

        return sqlSession.selectList("UserMapper.getUserList");
    }

    @Override
    public void deleteUser(String userId) throws Exception {

    }
}
