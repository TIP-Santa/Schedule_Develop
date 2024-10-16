package com.sparta.schedule.repository;


import com.sparta.schedule.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Page<Schedule> findAllByOrderByModifiedDateTimeDesc(Pageable pageable);

    Schedule findByScheduleKey(Long scheduleKey);

}
