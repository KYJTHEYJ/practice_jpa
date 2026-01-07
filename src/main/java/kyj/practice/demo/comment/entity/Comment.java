package kyj.practice.demo.comment.entity;

import jakarta.persistence.*;
import kyj.practice.demo.posting.entity.Posting;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "comments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    // optional -> JPA 상 null 여부
    // nullable 과 일치해야함
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "posting_id"
            , nullable = false
            , foreignKey = @ForeignKey(name = "fk_postings_comment", value = ConstraintMode.NO_CONSTRAINT))
    private Posting posting;

    public Comment(String content, Posting posting) {
        this.content = content;
        this.posting = posting;
    }

    public void update(String content) {
        this.content = content;
    }
}
