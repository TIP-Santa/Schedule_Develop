package com.sparta.schedule.controller;

import com.sparta.schedule.dto.comments.CommentsRequestDto;
import com.sparta.schedule.dto.comments.CommentsResponseDto;
import com.sparta.schedule.entity.Comments;
import com.sparta.schedule.service.CommentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    private final CommentsService commentsService;
    public CommentsController(CommentsService commentsService){
        this.commentsService = commentsService;
    }

    // 댓글 작성
    @PostMapping
    public ResponseEntity<CommentsResponseDto> createComments(@RequestBody CommentsRequestDto createCommentsRequestDto){
        CommentsResponseDto responseDto = commentsService.createComments(createCommentsRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 특정 일정 댓글 조회
    @GetMapping("/{scheduleKey}")
    public ResponseEntity<List<CommentsResponseDto>> getComments(@PathVariable Long scheduleKey){
        List<CommentsResponseDto> comments = commentsService.getComments(scheduleKey);
        return ResponseEntity.ok(comments);
    }

    // 특정 댓글 수정
    @PutMapping("/{commentsKey}")
    public CommentsResponseDto updateComments(@PathVariable Long commentsKey, @RequestBody CommentsRequestDto updateCommentsRequestDto){
        return commentsService.updateComments(commentsKey, updateCommentsRequestDto);
    }

    // 특정 댓글 삭제
    @DeleteMapping("{commentsKey}")
    public Long deleteComments(@PathVariable Long commentsKey){
        return commentsService.deleteComments(commentsKey);
    }

}
