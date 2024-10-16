package com.sparta.schedule.service;

import com.sparta.schedule.dto.comments.CommentsRequestDto;
import com.sparta.schedule.dto.comments.CommentsResponseDto;
import com.sparta.schedule.repository.CommentsRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;
    public CommentsService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    public CommentsResponseDto createComments(CommentsRequestDto createCommentsRequestDto) {
        return null;
    }
}
