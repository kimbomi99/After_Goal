package com.goal.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.goal.entity.User;
import com.goal.model.UserRegistration;
import com.goal.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTests {

	@Autowired UserService userService;
	@Autowired UserRepository userRepository;

    @Test
    public void test_findAll_findById() {
        // 모든 레코드 조회
        List<User> list = userService.findAll();
        for(User user1 : list) {
            // findById로 레코드 다시 조회
            User user2 = userRepository.findById(user1.getId());

            // 동일한 레코드이므로 값도 동일해야 함
            assertEquals(user1, user2);
        }
    }

    @Test
    public void test_save() {
        // 새 레코드 객체 생성
    	UserRegistration user1 = new UserRegistration();
        user1.setUserId("abc");
        user1.setPasswd1("12345678");
        user1.setPasswd2("12345678");
        user1.setName("abc");
        user1.setEmail("abc@naver.com");

        // 저장
        User user=userService.save(user1);

        // 잘 저장되었는지 확인
        User user2 = userRepository.findById(user.getId());
        assertEquals(user, user2);

    }

}
