package kyj.practice.demo.repository;

import kyj.practice.demo.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountrySearchRepository extends JpaRepository<Country, Long> {
}