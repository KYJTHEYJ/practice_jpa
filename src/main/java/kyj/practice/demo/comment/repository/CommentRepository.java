package kyj.practice.demo.comment.repository;

import kyj.practice.demo.comment.entity.Comment;
import kyj.practice.demo.posting.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPosting(Posting posting);
}
