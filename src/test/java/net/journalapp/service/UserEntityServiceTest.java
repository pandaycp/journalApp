package net.journalapp.service;

import net.journalapp.entity.UserEntity;
import net.journalapp.model.User;
import net.journalapp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("dev")
public class UserEntityServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeAll
    static void setup1(){}

    @BeforeEach
    void setup2(){}

    @AfterEach
    void setup3(){}

    @AfterAll
    static void setup4(){}

    /*@ValueSource(strings = {
            "Ram",
            "Shyam",
            "CP",
            "John"
    })
    @ParameterizedTest
    public void testFindByUserName(String userName){
        Assertions.assertNotNull(userRepository.findByUserName(userName), "failed for this user name " + userName);
    }*/

    /*
        enum UserName{
            Ram,
            Shyam,
            CP,
            John
        }
        @EnumSource
        @ParameterizedTest
        public void testFindByUserName(UserName userName){
            Assertions.assertNotNull(userRepository.findByUserName(userName.name()),
                                                                   "failed for this user name " + userName.name());
        }
    */
    @ArgumentsSource(UserArgumentsProvider.class)
    @ParameterizedTest
    public void testSaveEntry(User user){
        Assertions.assertFalse(userService.saveEntry(user));
    }

   /* @Disabled
        @ParameterizedTest
        @CsvSource({
                "1,2,3",
                "2,2,4",
                "4,5,9"})
        public void test(int a, int b, int expected){
            Assertions.assertEquals(expected, a+b);
    }*/
}
