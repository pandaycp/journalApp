package net.journalapp.service;

import net.journalapp.entity.UserEntity;
import net.journalapp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;

//@SpringBootTest
public class UserEntityDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUserNameTest(){
        UserEntity user = new UserEntity();
        user.setUserName("Ram");
        user.setPassword("123");
        user.setRoles(Arrays.asList("ADMIN", "USER"));
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(user);
                UserDetails userDetails = userDetailsService.loadUserByUsername("Ram");
        Assertions.assertNotNull(userDetails);

    }
}
