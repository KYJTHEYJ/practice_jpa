package kyj.practice.demo.posting.service;

import kyj.practice.demo.posting.dto.*;
import kyj.practice.demo.posting.entity.Posting;
import kyj.practice.demo.posting.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostingService {
    private final PostingRepository postingRepository;

    @Transactional
    public CreatePostingResponse save(CreatePostingRequest createPostingRequest) {
        Posting posting = new Posting(createPostingRequest.getTitle(), createPostingRequest.getContent());
        Posting savedPosting = postingRepository.save(posting);
        return new CreatePostingResponse(savedPosting.getId(), savedPosting.getTitle(), savedPosting.getContent());
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<GetPostingsResponse> getAll() {
        List<Posting> postings = postingRepository.findAll();
        return postings.stream().map(posting -> new GetPostingsResponse(posting.getId(), posting.getTitle())).toList();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public GetPostingResponse getOneById(Long postingsId) {
        Posting posting = postingRepository.findById(postingsId).orElseThrow(() -> new IllegalStateException("없는 포스팅입니다"));
        return new GetPostingResponse(posting.getId(), posting.getTitle(), posting.getContent());
    }

    @Transactional
    public PutPostingResponse updateById(PutPostingRequest request, Long postingId) {
        Posting posting = postingRepository.findById(postingId).orElseThrow(() -> new IllegalStateException("없는 포스팅입니다"));
        posting.update(request.getTitle(), request.getContent());
        return new PutPostingResponse(posting.getId());
    }

    @Transactional
    public void deleteById(Long postingId) {
        if(!postingRepository.existsById(postingId))
            throw new IllegalArgumentException("없는 포스팅 입니다");

        postingRepository.deleteById(postingId);
    }
}
