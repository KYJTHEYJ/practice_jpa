package kyj.practice.demo.comment.service;

import kyj.practice.demo.comment.dto.*;
import kyj.practice.demo.comment.entity.Comment;
import kyj.practice.demo.comment.repository.CommentRepository;
import kyj.practice.demo.posting.entity.Posting;
import kyj.practice.demo.posting.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostingRepository postingRepository;

    @Transactional
    public CreateCommentResponse createComment(Long postingId, CreateCommentRequest createCommentRequest) {
        Posting posting = postingRepository.findById(postingId).orElseThrow(() -> new IllegalStateException("없는 포스팅 입니다"));

        Comment comment = new Comment(createCommentRequest.getContent(), posting);
        Comment savedComment = commentRepository.save(comment);

        return new CreateCommentResponse(savedComment.getId(), savedComment.getContent());
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<GetCommentResponse> getAll(Long postingId) {
        Posting posting = postingRepository.findById(postingId).orElseThrow(() -> new IllegalStateException("없는 포스팅 입니다"));

        List<Comment> comments = commentRepository.findByPosting(posting);
        return comments.stream().map(comment -> new GetCommentResponse(comment.getId(), comment.getContent())).toList();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public GetCommentResponse getOne(Long commentId) {
        Comment comments = commentRepository.findById(commentId).orElseThrow(() -> new IllegalStateException("없는 댓글 입니다"));
        return new GetCommentResponse(comments.getId(), comments.getContent());
    }

    @Transactional
    public PutCommentResponse updateById(PutCommentRequest request, Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalStateException("없는 댓글 입니다"));
        comment.update(request.getContent());
        return new PutCommentResponse(comment.getId());
    }

    @Transactional
    public void deleteById(Long commentId) {
        if(!commentRepository.existsById(commentId))
            throw new IllegalArgumentException("없는 댓글 입니다");

        commentRepository.deleteById(commentId);
    }
}
