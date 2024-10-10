package com.sparta.schedule_develop.service;

import com.sparta.schedule_develop.dto.ScheduleRequestDto;
import com.sparta.schedule_develop.dto.ScheduleResponseDto;
import com.sparta.schedule_develop.entity.Schedule;
import com.sparta.schedule_develop.repository.ScheduleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    @PersistenceContext
    EntityManager em;

    private final ScheduleRepository scheduleRepository;
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // POST
    public ScheduleResponseDto createSchedule(ScheduleRequestDto createScheduleRequestDto) {
        // RequestDto > Entity
        Schedule schedule = new Schedule();
        schedule.setUserName(createScheduleRequestDto.getUserName());
        schedule.setScheduleDate(createScheduleRequestDto.getScheduleDate());
        schedule.setScheduleTitle(createScheduleRequestDto.getScheduleTitle());
        schedule.setScheduleDescription(createScheduleRequestDto.getScheduleDescription());
        schedule.setSchedulePassword(createScheduleRequestDto.getSchedulePassword());
        schedule.setUserId(createScheduleRequestDto.getUserId());
        // DB 저장
        Schedule saveSchedule = scheduleRepository.save(schedule);
        // Entity > ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
        return scheduleResponseDto;
    }

    // GET
    public List<ScheduleResponseDto> getSchedule(Long scheduleKey, String userName, LocalDate scheduleDate) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<ScheduleResponseDto> criteriaQuery = criteriaBuilder.createQuery(ScheduleResponseDto.class);
        Root<Schedule> root = criteriaQuery.from(Schedule.class);

        List<Predicate> predicates = new ArrayList<>();

        if(scheduleKey != null){
            predicates.add(criteriaBuilder.equal(root.get("scheduleKey"), scheduleKey));
        }
        if(userName != null && !userName.isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("userName"), userName));
        }
        if(scheduleDate != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("scheduleDate"), scheduleDate));
        }

        if(!predicates.isEmpty()) {
            criteriaQuery.select(criteriaBuilder.construct(ScheduleResponseDto.class,
                    root.get("scheduleKey"),
                    root.get("userName"),
                    root.get("scheduleDate"),
                    root.get("scheduleTitle"),
                    root.get("scheduleDescription"),
                    root.get("userId"),
                    root.get("lastModifiedDateTime")))
                    .where(predicates.toArray(new Predicate[0]));
        } else {
            criteriaQuery.select(criteriaBuilder.construct(ScheduleResponseDto.class,
                    root.get("scheduleKey"),
                    root.get("userName"),
                    root.get("scheduleDate"),
                    root.get("scheduleTitle"),
                    root.get("scheduleDescription"),
                    root.get("userId"),
                    root.get("lastModifiedDateTime")));
        }
        return em.createQuery(criteriaQuery).getResultList();
    }

    // PUT
    @Transactional
    public Long updateSchedule(Long scheduleKey, ScheduleRequestDto updateScheduleRequestDto) {
        // 해당 일정이 DB에 존재하는지 확인
        Schedule schedule = findScheduleByKey(scheduleKey);
        // 일정 내용 수정
        schedule.update(updateScheduleRequestDto);
        return scheduleKey;
    }

    // DELETE
    public Long deleteSchedule(Long scheduleKey) {
        // 해당 일정이 DB에 존재하는지 확인
        Schedule schedule = findScheduleByKey(scheduleKey);

        // 해당 일정 삭제
        scheduleRepository.delete(schedule);
        return scheduleKey;
    }

    private Schedule findScheduleByKey(Long scheduleKey) {
        return scheduleRepository.findById(scheduleKey).orElseThrow(() ->
                new IllegalArgumentException("선택한 일정이 존재하지 않습니다.")
        );
    }


}
