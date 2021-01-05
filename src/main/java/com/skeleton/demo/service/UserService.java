package com.skeleton.demo.service;

import com.skeleton.demo.dto.UserDto;

import java.util.Map;

public interface UserService {

    public void addUser(UserDto user) throws Exception;

    public UserDto getUser(String userId) throws Exception;

    public Map<String,Object> getUserList() throws Exception;

    public void deleteUser(String userId) throws Exception;
}
