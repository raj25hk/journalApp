package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserRepository userRepository;

    @Disabled
    // @Test
    @ParameterizedTest
    @CsvSource({
            "ram",
            "raj"
    })
    public void testAdd(String name) {
//        User user = userRepository.findByUserName("ram");
        assertNotNull(userRepository.findByUserName(name), "failed for: " + name);

//        assertEquals(4, 2+2);
//        assertTrue(5 > 3);
    }

//    @ParameterizedTest
//    @CsvSource({
//            "1,1,2",
//            "2,4,6",
////            "3,3,5" //fail test case
//    })
//    public void test(int a, int b, int expected){
//        assertEquals(expected, a + b);
//    }
}
