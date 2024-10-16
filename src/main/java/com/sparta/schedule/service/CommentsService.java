package com.sparta.schedule.service;

import com.sparta.schedule.dto.comments.CommentsRequestDto;
import com.sparta.schedule.dto.comments.CommentsResponseDto;
import com.sparta.schedule.entity.Comments;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.CommentsRepository;
import com.sparta.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentsService(CommentsRepository commentsRepository, ScheduleRepository scheduleRepository) {
        this.commentsRepository = commentsRepository;
        this.scheduleRepository = scheduleRepository;
    }

    // POST
    public CommentsResponseDto createComments(CommentsRequestDto createCommentsRequestDto) {
        Schedule schedule = findByScheduleKey(createCommentsRequestDto.getScheduleKey());
        Comments comments = new Comments(createCommentsRequestDto);
        comments.setSchedule(schedule);
        Comments savedComments = commentsRepository.save(comments);
        return new CommentsResponseDto(savedComments);
    }

    // GET
    public List<CommentsResponseDto> getComments(Long scheduleKey) {
        Schedule schedule = scheduleRepository.findById(scheduleKey)
                .orElseThrow(() -> new RuntimeException("일정을 찾을 수 없습니다."));
        List<Comments> comments = commentsRepository.findBySchedule(schedule);
        return comments.stream().map(CommentsResponseDto::new).collect(Collectors.toList());
    }

    // PUT
    @Transactional
    public CommentsResponseDto updateComments(Long commentsKey, CommentsRequestDto updateCommentsRequestDto) {
        Comments comments = findComments(commentsKey);
        comments.update(updateCommentsRequestDto);
        CommentsResponseDto commentsResponseDto = new CommentsResponseDto(comments);
        return commentsResponseDto;
    }

    // DELETE
    public Long deleteComments(Long commentsKey) {
        Comments comments = findComments(commentsKey);
        commentsRepository.delete(comments);
        return commentsKey;
    }



    private Comments findComments(Long commentsKey) {
        return commentsRepository.findById(commentsKey).orElseThrow(() ->
                new RuntimeException("선택한 댓글이 존재하지 않습니다.")
        );
    }
    private Schedule findByScheduleKey(Long scheduleKey) {
        return scheduleRepository.findById(scheduleKey).orElseThrow(() ->
                new RuntimeException("선택한 일정을 찾을 수 없습니다.")
        );
    }
}
