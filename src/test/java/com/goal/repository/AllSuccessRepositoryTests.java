package com.goal.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.goal.entity.AllSuccess;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AllSuccessRepositoryTests {

	 @Autowired
	    public AllSuccessRepository allSuccessRepository;

	@Test
	public void test_save() {
		AllSuccess allSuccess = new AllSuccess();
		allSuccess.setUserId("abc");
		allSuccess.setSuccess(false);

     // 저장
		allSuccessRepository.save(allSuccess);

     // 잘 저장되었는지 확인
		AllSuccess allSuccess1 = allSuccessRepository.findByUserId(allSuccess.getUserId());
		assertEquals(allSuccess, allSuccess1);


     //수정
     AllSuccess allSuccess2 = allSuccessRepository.findByUserId(allSuccess.getUserId());
     allSuccess2.setSuccess(true);

     //저장
     allSuccessRepository.save(allSuccess2);

     //비교 확인
     AllSuccess allSuccess3 = allSuccessRepository.findByUserId(allSuccess.getUserId());
     assertEquals(allSuccess2, allSuccess3);


	}
}
