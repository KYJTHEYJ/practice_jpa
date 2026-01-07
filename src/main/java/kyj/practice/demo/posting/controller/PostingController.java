package kyj.practice.demo.posting.controller;

import kyj.practice.demo.posting.dto.*;
import kyj.practice.demo.posting.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostingController {
    private final PostingService postingService;

    @PostMapping("/postings")
    public ResponseEntity<CreatePostingResponse> createPost(@RequestBody CreatePostingRequest createPostingRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postingService.save(createPostingRequest));
    }

    @GetMapping("/postings")
    public ResponseEntity<List<GetPostingsResponse>> getPostingAll() {
        return ResponseEntity.status(HttpStatus.OK).body(postingService.getAll());
    }

    @GetMapping("/postings/{postingId}")
    public ResponseEntity<GetPostingResponse> getPostingsById(@PathVariable Long postingId) {
        return ResponseEntity.status(HttpStatus.OK).body(postingService.getOneById(postingId));
    }

    @PutMapping("/postings/{postingId}")
    public ResponseEntity<PutPostingResponse> updatePostingsById(@RequestBody PutPostingRequest request, @PathVariable Long postingId) {
        return ResponseEntity.status(HttpStatus.OK).body(postingService.updateById(request, postingId));
    }

    @DeleteMapping("/postings/{postingId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long postingId) {
        postingService.deleteById(postingId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
