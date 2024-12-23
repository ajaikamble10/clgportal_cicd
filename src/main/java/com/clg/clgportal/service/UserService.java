package com.clg.clgportal.service;

import java.util.List;

import com.clg.clgportal.dto.UserDto;

public interface UserService {
    public UserDto addUser(UserDto userDto);
    public UserDto updateUser(UserDto userDto,long id);
    public void deleteUser(long id);
    public UserDto getUserById(long id);
    public List<UserDto> getAllUsers();
}
