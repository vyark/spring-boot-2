package com.epam.service;

import com.epam.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void createUser() {
        userService.createUser(any());

        verify(userRepository).save(any());
    }

    @Test
    public void readUser() {
        userService.readUser();

        verify(userRepository).findAll();
    }

    @Test
    public void deleteUser() {
        userService.deleteUserById(anyLong());

        verify(userRepository).deleteById(anyLong());
    }
}
