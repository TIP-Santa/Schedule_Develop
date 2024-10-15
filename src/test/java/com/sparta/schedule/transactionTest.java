package com.sparta.schedule;

import com.sparta.schedule.entity.Schedule;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class transactionTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("일정 생성")
    void test1() {
        Schedule schedule = new Schedule();
        schedule.setWriterName("TIP");
        schedule.setScheduleTitle("09:00 ~ 09:10");
        schedule.setScheduleDescription("데일리 스크럼 작성");
        schedule.setSchedulePassword("1234");
        em.persist(schedule);
    }
}
