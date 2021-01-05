package com.skeleton.demo.service;

import com.skeleton.demo.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public void addUser(UserDto user) throws Exception;

    public UserDto getUser(String userId) throws Exception;

    public List<UserDto> getUserList() throws Exception;

    public void deleteUser(String userId) throws Exception;
}
