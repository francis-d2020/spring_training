package com.cydeo.service.impl;


import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
//this annotation enables mockito
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;    // Mock object instead of UserRepository object

    @Mock
    UserMapper userMapper;

    @InjectMocks //inject the mock object inside the UserServiceImpl instead of the real
            //userRepository and userMapper
    UserServiceImpl userService;

    @Test
    void findByUserName_Test() {

        // I'm calling the real method inside the main, which is the method I want to test.
        userService.findByUserName("harold@manager.com");

        // I'm checking if this method ran or not.
        verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);

        //how many times did the method run(we expect 1)
        verify(userRepository, times(1)).findByUserNameAndIsDeleted("harold@manager.com", false);

        //examples of verifying how many times did the method run
        verify(userRepository, atLeastOnce()).findByUserNameAndIsDeleted("harold@manager.com", false);
        verify(userRepository, atLeast(1)).findByUserNameAndIsDeleted("harold@manager.com", false);

        verify(userRepository, atMostOnce()).findByUserNameAndIsDeleted("harold@manager.com", false);
        verify(userRepository, atMost(10)).findByUserNameAndIsDeleted("harold@manager.com", false);

        //with InOrder we test if these methods are running in the order they written
        InOrder inOrder = inOrder(userRepository, userMapper);

        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@manager.com", false);
        inOrder.verify(userMapper).convertToDto(null);

    }

}



