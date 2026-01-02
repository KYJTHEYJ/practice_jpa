package kyj.practice.demo.controller;

import kyj.practice.demo.dto.CountryInformationSearchResponse;
import kyj.practice.demo.service.CountrySearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountrySearchController {
    private final CountrySearchService countrySearchService;

    @GetMapping("/api/capitals")
    public ResponseEntity<List<CountryInformationSearchResponse>> getCountryNameAndCapitalName() {
        return ResponseEntity.status(HttpStatus.OK).body(countrySearchService.getAllCountryNameAndCapitalName());
    }
}
