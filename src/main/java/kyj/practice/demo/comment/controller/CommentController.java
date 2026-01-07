package kyj.practice.demo.comment.controller;

import kyj.practice.demo.comment.dto.*;
import kyj.practice.demo.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/postings/{postingId}/comments")
    public ResponseEntity<CreateCommentResponse>  createComment(@PathVariable Long postingId, @RequestBody CreateCommentRequest createCommentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.createComment(postingId, createCommentRequest));
    }

    @GetMapping("/postings/{postingId}/comments")
    public ResponseEntity<List<GetCommentResponse>> getCommentAll(@PathVariable Long postingId) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getAll(postingId));
    }

    @GetMapping("/postings/{postingId}/comments/{commentId}")
    public ResponseEntity<GetCommentResponse> getOneCommentById(@PathVariable Long commentId) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getOne(commentId));
    }

    @PutMapping("/postings/{postingId}/comments/{commentId}")
    public ResponseEntity<PutCommentResponse> updateCommentById(@PathVariable Long commentId, @RequestBody PutCommentRequest putCommentRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.updateById(putCommentRequest, commentId));
    }

    @DeleteMapping("/postings/{postingId}/comments/{commentId}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable Long commentId) {
        commentService.deleteById(commentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
