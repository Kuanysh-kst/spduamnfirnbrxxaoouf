package com.example.spduamnfirnbrxxaoouf.service;

import com.example.spduamnfirnbrxxaoouf.model.MongoUserDTO;
import com.example.spduamnfirnbrxxaoouf.repository.MongoUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MongoUserServiceImplTest {

    private MongoUserRepository mongoUserRepository;
    private MongoUserServiceImpl mongoUserService;

    @BeforeEach
    public void setUp() {
        mongoUserRepository = mock(MongoUserRepository.class);
        mongoUserService = new MongoUserServiceImpl(mongoUserRepository);
    }

    @Test
    public void testFindById() {
        MongoUserDTO mongoUser = new MongoUserDTO();
        mongoUser.setId(1L);
        mongoUser.setName("John Doe");
        mongoUser.setFirstPhone("1234567890");
        mongoUser.setSecondPhone("1223232343");
        when(mongoUserRepository.findById(1L)).thenReturn(Optional.of(mongoUser));

        Optional<MongoUserDTO> result = mongoUserService.findById(1L);

        assertEquals("John Doe", result.get().getName());
        assertEquals("1234567890", result.get().getFirstPhone());
        assertEquals("1223232343", result.get().getSecondPhone());
    }
}


