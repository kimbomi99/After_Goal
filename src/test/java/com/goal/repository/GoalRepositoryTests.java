package com.goal.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.goal.entity.Goal;
import com.goal.repository.GoalRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GoalRepositoryTests {

    @Autowired
    GoalRepository goalRepository;

    @Test
    public void test_findAll_findById() {
        // 모든 레코드 조회
        List<Goal> list = goalRepository.findAll();

        for (Goal goal1 : list) {
            // findById로 레코드 다시 조회
            Goal goal2 = goalRepository.findById(goal1.getId());

            // 동일한 레코드이므로 값도 동일해야 함
            assertEquals(goal1, goal2);
        }
    }

    @Test
    public void test_save_delete() {
        // 새 레코드 객체 생성
        Goal goal1 = new Goal();
        goal1.setUserId("abc");
        goal1.setGoalList("우리나라 모든 산 등반해보기");
        goal1.setSuccess(false);

        // 저장
        goalRepository.save(goal1);

        // 잘 저장되었는지 확인
        Goal goal2 = goalRepository.findById(goal1.getId());
        assertEquals(goal1, goal2);

        // 삭제
        goalRepository.deleteById(goal1.getId());

        // 삭제 확인
        goal2 = goalRepository.findById(goal1.getId());
        assertEquals(goal2, null);
    }

    @Test
    public void test_update() {
        // 첫번째 레코드
        Goal goal1 = goalRepository.findAll().get(0);

        // 첫번째 레코드의 모든 멤버 변수 값을 수정한다.
        // 단 id, userId는 제외
        goal1.setGoalList("우리나라 모든 산 등반하기!!");
        goal1.setSuccess(true);

        // 저장
        goalRepository.save(goal1);

        // 잘 저장되었는지 확인
        Goal goal2 = goalRepository.findById(goal1.getId());
        assertEquals(goal1, goal2);

        // 다시 값 수정
        goal1.setGoalList("전국일주하기!");
        goal1.setSuccess(false);

        // 저장
        goalRepository.save(goal1);

        // 잘 저장되었는지 확인
        goal2 = goalRepository.findById(goal1.getId());
        assertEquals(goal1, goal2);
    }

    @Test
    public void test_success_count() {

    	 Goal goal1 = new Goal();
         goal1.setUserId("abc");
         goal1.setGoalList("우리나라 모든 산 등반해보기");
         goal1.setSuccess(true);

         // 저장
         goalRepository.save(goal1);

         Goal goal2 = new Goal();
         goal2.setUserId("abc");
         goal2.setGoalList("1년에 책 50권 읽기");
         goal2.setSuccess(true);

         // 저장
         goalRepository.save(goal2);


    	//사용자가 성공한 목표 갯수 추출
    	long count1=goalRepository.countByUserIdAndSuccess("abc", true);
    	//사용자가 설정한 목표 갯수 추출
    	long count2= goalRepository.countByUserId("abc");

    	//올바른 갯수는 성공한 목표갯수가 설정한 목표 갯수 보다 많으면 안됨
    	boolean correct=(count1<=count2 ? true : false);
    	assertTrue(correct);
    }


}
