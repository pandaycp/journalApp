package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;

//@SpringBootTest
public class UserDetailsServiceImplTest {

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
        User user = new User();
        user.setUserName("Ram");
        user.setPassword("123");
        user.setRoles(Arrays.asList("ADMIN", "USER"));
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(user);
                UserDetails userDetails = userDetailsService.loadUserByUsername("Ram");
        Assertions.assertNotNull(userDetails);

    }
}
