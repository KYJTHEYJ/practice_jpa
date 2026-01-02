package kyj.practice.demo.service;

import kyj.practice.demo.dto.CountryInformationSearchResponse;
import kyj.practice.demo.repository.CountrySearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountrySearchService {
    private final CountrySearchRepository countrySearchRepository;

    public List<CountryInformationSearchResponse> getAllCountryNameAndCapitalName() {
        return countrySearchRepository.getCountryNameAndCapitalName().stream()
                .map(result -> new CountryInformationSearchResponse(
                        String.valueOf(result[0])
                        , String.valueOf(result[1])
                        , result[2] == null ? null : String.valueOf(result[2])
                        , result[3] == null ? null : String.valueOf(result[3])
                )).toList();
    }
}
