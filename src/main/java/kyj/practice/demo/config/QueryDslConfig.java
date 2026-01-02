package kyj.practice.demo.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// QueryDSL 쿼리를 만들기 위해 설정
// QueryDSL 의 핵심 클래스이자 시작점
// EntityManager 를 내부에 갖고 있음

@Configuration
@RequiredArgsConstructor
public class QueryDslConfig {
    private final EntityManager em;

    @Bean
    public JPAQueryFactory queryFactory() {
        return new JPAQueryFactory(em);
    }
}
