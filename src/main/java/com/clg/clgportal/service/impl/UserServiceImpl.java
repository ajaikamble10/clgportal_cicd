package com.clg.clgportal.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clg.clgportal.dto.UserDto;
import com.clg.clgportal.entity.User;
import com.clg.clgportal.exception.ResourceNotFoundException;
import com.clg.clgportal.repository.UserRepository;
import com.clg.clgportal.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void deleteUser(long id) {
       User user = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "user id", id));
       userRepo.delete(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> users = userRepo.findAll();
       List<UserDto> userDtos = users.stream().map(user->userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto getUserById(long id) {
        User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "user id", id));
        UserDto userDto = userToDto(user);
        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto, long id) {
        User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "user id", id));
        user.setUserDesc(userDto.getUserDesc());
        user.setStatus(userDto.getStatus());
        User updatedUser = userRepo.save(user);
        UserDto updatedUserToDto = userToDto(updatedUser);
        return updatedUserToDto;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user=new User();
        user.setUserDesc(userDto.getUserDesc());
        user.setStatus(userDto.getStatus());
        User newUser = userRepo.save(user);
        UserDto addedUser = userToDto(newUser);
        return addedUser;
    }

    public UserDto userToDto(User user){
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    public User dtoToUser(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        return user;
    }

}
