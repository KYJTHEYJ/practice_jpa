package kyj.practice.demo.posting.repository;

import kyj.practice.demo.posting.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingRepository extends JpaRepository<Posting, Long> {
}
