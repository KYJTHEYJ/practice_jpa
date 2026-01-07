package kyj.practice.demo.posting.dto;

import lombok.Getter;

@Getter
public class PutPostingResponse {
    private final Long id;

    public PutPostingResponse(Long id) {
        this.id = id;
    }
}
