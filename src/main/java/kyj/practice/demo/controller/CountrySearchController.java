package kyj.practice.demo.controller;

import kyj.practice.demo.dto.CountryAndCapitalInfoResponse;
import kyj.practice.demo.dto.CountryInfoResponse;
import kyj.practice.demo.service.CountrySearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountrySearchController {
    private final CountrySearchService countrySearchService;

    @GetMapping("/api/capitals")
    public ResponseEntity<List<CountryAndCapitalInfoResponse>> getCountryNameAndCapitalName() {
        return ResponseEntity.status(HttpStatus.OK).body(countrySearchService.getAllCountryNameAndCapitalName());
    }

    @GetMapping("/api/countrys")
    public ResponseEntity<Slice<CountryInfoResponse>> getCountryInfo(
            @RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "100") int pageSize
            ) {
        // 페이지 번호, 한 페이지당 요소 크기
        Pageable pageable = PageRequest.of(page, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(countrySearchService.getCountryInfo(pageable));
    }
}
