package com.skeleton.demo.user.dao;

import com.skeleton.demo.user.dto.UserDto;
import com.skeleton.demo.user.vo.UserVO;

import java.util.List;

public interface UserDao {

    public void addUser(UserVO user) throws Exception;

    public UserDto getUser(String userId) throws Exception;

    public List<UserDto> getUserList() throws Exception;

    public void deleteUser(String userId) throws Exception;
}
