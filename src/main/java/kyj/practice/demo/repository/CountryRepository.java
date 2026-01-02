package kyj.practice.demo.repository;

import kyj.practice.demo.entity.Country;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {
    @Query(value = """
            SELECT C.Code, C.Name, C2.ID, C2.Name
            FROM COUNTRY C
            LEFT JOIN CITY C2
            ON C.Code = C2.CountryCode
            AND C.Capital = C2.ID
            """
           , nativeQuery = true)
    List<Object[]> getCountryNameAndCapitalName();



    @Query("SELECT c FROM Country c ORDER BY c.name DESC")
    Slice<Country> findAllSlice(Pageable pageable);
}