package com.goal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import com.goal.entity.User;
import com.goal.model.UserRegistration;
import com.goal.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceMockTests {

    @Mock UserRepository userRepository;
    @InjectMocks UserService userService;
    @Mock UserRegistration userRegistration;


    User user;
    List<User> users;
    UserRegistration user2;
    List<UserRegistration> users2;

    @Before
    public void prepare() {
        // 테스트 메소드들에서 사용할 객체를 미리 생성함
        this.user = new User();
        this.user.setUserId("abc");
        this.user.setName("abc");
        this.user.setPassword("12345678");
        this.user.setEnabled(true);
        this.user.setEmail("abc@naver.com");

        this.users = new ArrayList<User>();
        this.users.add(this.user);


        this.user2 = new UserRegistration();
        this.user2.setUserId("abc");
        this.user2.setName("abc");
        this.user2.setPasswd1("12345678");
        this.user2.setPasswd2("12345678");
        this.user2.setEmail("abc@naver.com");

        this.users2 = new ArrayList<UserRegistration>();
        this.users2.add(this.user2);




    }

    @Test
    public void test_findAll() {
        // 테스트 하기 위해서 mock 객체를 설정함.
        Mockito.when(userRepository.findAll())
               .thenReturn(this.users);

        List<User> users3 = userService.findAll();

        // 테스트 결과 확인
        assertEquals(this.users, users3);
        Mockito.verify(userRepository).findAll();
    }

    @Test
    public void test_hasErrors_아이디중복() {
        Mockito.when(userRepository.findByUserId(this.user.getUserId()))
               .thenReturn(this.user);
        BindingResult bindingResult = new BeanPropertyBindingResult(user2, "user");
        assertTrue(userService.hasErrors(user2, bindingResult));
        Mockito.verify(userRepository).findByUserId(this.user.getUserId());
    }

    @Test
    public void test_hasErrors_Ok() {
        Mockito.when(userRepository.findByUserId(ArgumentMatchers.anyString()))
               .thenReturn(null);
        BindingResult bindingResult = new BeanPropertyBindingResult(this.user2, "user");
        assertFalse(userService.hasErrors(user2, bindingResult));
        Mockito.verify(userRepository).findByUserId(this.user.getUserId());
    }
}
