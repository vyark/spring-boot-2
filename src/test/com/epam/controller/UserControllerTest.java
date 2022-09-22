package com.epam.controller;

import com.epam.model.User;
import com.epam.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService service;

    @Test
    public void shouldCreateUser() throws Exception {
        when(service.createUser(any())).thenReturn(new User());
        this.mockMvc.perform(post("/users")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReadUser() throws Exception {
        when(service.readUser()).thenReturn(new ArrayList<>());
        this.mockMvc.perform(get("/user/")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateUser() throws Exception {
        when(service.updateUser(any(), anyLong())).thenReturn(new User());
        this.mockMvc.perform(put("/users/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteUser() throws Exception {
        this.mockMvc.perform(delete("/users/1")).andDo(print()).andExpect(status().isOk());
    }
}