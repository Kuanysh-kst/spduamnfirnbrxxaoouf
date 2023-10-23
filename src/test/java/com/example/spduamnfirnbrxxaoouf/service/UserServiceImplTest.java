package com.example.spduamnfirnbrxxaoouf.service;

import com.example.spduamnfirnbrxxaoouf.model.UserDTO;
import com.example.spduamnfirnbrxxaoouf.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {

    private UserRepository userRepository;
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void testFindById() {
        UserDTO user = new UserDTO();
        user.setId(1L);
        user.setName("John Doe");
        user.setFirstPhone("1234567890");
        user.setSecondPhone("1223232343");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<UserDTO> result = userService.findById(1L);

        assertEquals("John Doe", result.get().getName());
        assertEquals("1234567890", result.get().getFirstPhone());
        assertEquals("1223232343", result.get().getSecondPhone());
    }
}