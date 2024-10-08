package com.sparta.schedule_develop;


import com.sparta.schedule_develop.entity.Schedule;
import com.sparta.schedule_develop.repository.ScheduleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
public class TransactionTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("일정 생성 성공")
    void test1(){
        Schedule schedule = new Schedule();
        schedule.setUserName("백한비");
        schedule.setScheduleDate(LocalDate.parse("2024-10-08"));
        schedule.setScheduleTitle("19:00 라이브 세션");
        schedule.setScheduleDescription("git 코드리뷰 세션");
        schedule.setSchedulePassword("1234");
        schedule.setUserId("bhb");
        em.persist(schedule);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("트랜잭션 전파 테스트")
    void test3() {
        scheduleRepository.createSchedule(em);
        System.out.println("테스트 test3 메서드 종료");
    }


}
