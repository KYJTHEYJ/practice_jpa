package kyj.practice.demo.repository;

import kyj.practice.demo.entity.CountryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, Long> {
}