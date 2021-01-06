package com.skeleton.demo.user.dao.impl;

import com.skeleton.demo.user.dto.UserDto;
import com.skeleton.demo.user.dao.UserDao;
import com.skeleton.demo.user.vo.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

    @Autowired
    SqlSession sqlSession;

    @Override
    public void addUser(UserVO user) throws Exception {
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
