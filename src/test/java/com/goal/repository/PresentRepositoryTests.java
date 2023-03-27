package com.goal.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.goal.entity.Present;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PresentRepositoryTests {

    @Autowired
    PresentRepository presentRepository;

    @Test
    public void test_findAll_findById() {
        // 모든 레코드 조회
        List<Present> list = presentRepository.findAll();

        for (Present present1 : list) {
            // findById로 레코드 다시 조회
        	Present present2 = presentRepository.findByUserId(present1.getUserId());


            // 동일한 레코드이므로 값도 동일해야 함
            assertEquals(present1, present2);
        }
    }

    @Test
    public void test_save() {
        // 새 레코드 객체 생성
        Present present1 = new Present();
        present1.setUserId("abc");
        present1.setFilename("아이패드");
        present1.setFileOriName("wish");
        present1.setFileurl("C:/imageUpload/");
        present1.setResolution("열심히 하자! 할 수 있다!!!");

        // 저장
        presentRepository.save(present1);

        // 잘 저장되었는지 확인
        Present present2 = presentRepository.findByUserId(present1.getUserId());
        assertEquals(present1, present2);

    }

    @Test
    public void test_update() {
        // 첫번째 레코드
        Present present1 = presentRepository.findAll().get(0);

        // 첫번째 레코드의 모든 멤버 변수 값을 수정한다.
        // 단 userId는 제외
        present1.setFilename("노트북");
        present1.setResolution("열심히 하자~ 할 수 있다!!!");

        // 저장
        presentRepository.save(present1);


        // 잘 저장되었는지 확인
        Present present2 = presentRepository.findByUserId(present1.getUserId());
        assertEquals(present1, present2);

        // 다시 값 수정
        present1.setFilename("최신형 휴대폰");
        present1.setResolution("열심히 하자~ 할 수 있다!");

        // 저장
        presentRepository.save(present1);

        // 잘 저장되었는지 확인
        present2 = presentRepository.findByUserId(present1.getUserId());
        assertEquals(present1, present2);
    }



}

