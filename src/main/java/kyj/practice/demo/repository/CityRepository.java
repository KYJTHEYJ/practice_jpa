package kyj.practice.demo.repository;

import kyj.practice.demo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}