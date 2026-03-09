package net.engineeringdigest.journalApp.service;


import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

public class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsernameTest() {
//        when(userRepository.findByUserName("ram"))
//                .thenReturn(
//                    User.builder()
//                    .userName("ram")
//                    .password("adcdacxf")
//                    .roles(new ArrayList<String>()) // Ensure your custom User builder accepts List<String>
//                    .build()
//                );
        // 1. Create the mock user object first
        User mockUser = User.builder()
                .userName("ram")
                .password("adcdacxf")
                .roles(new ArrayList<>())
                .build();

        // 2. Use a literal string "ram" instead of ArgumentMatchers.anyString()
        // This prevents Mockito from getting confused by method call order
        when(userRepository.findByUserName("ram")).thenReturn(mockUser);

        // 3. Execute
        UserDetails user = userDetailsService.loadUserByUsername("ram");

        // 4. Assert
        Assertions.assertNotNull(user);
    }
}
