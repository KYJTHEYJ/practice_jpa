package kyj.practice.demo.comment.dto;

import lombok.Getter;

@Getter
public class PutCommentResponse {
    private final Long id;

    public PutCommentResponse(Long id) {
        this.id = id;
    }
}
