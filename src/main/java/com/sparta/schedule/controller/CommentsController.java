package com.sparta.schedule.controller;

import com.sparta.schedule.dto.comments.CommentsRequestDto;
import com.sparta.schedule.dto.comments.CommentsResponseDto;
import com.sparta.schedule.service.CommentsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    private final CommentsService commentsService;
    public CommentsController(CommentsService commentsService){
        this.commentsService = commentsService;
    }

    // 댓글 작성
    @PostMapping
    public CommentsResponseDto createComments(@RequestBody CommentsRequestDto createCommentsRequestDto){
        return commentsService.createComments(createCommentsRequestDto);
    }

}
