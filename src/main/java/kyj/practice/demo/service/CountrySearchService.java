package kyj.practice.demo.service;

import kyj.practice.demo.dto.CountryAllInfoResponse;
import kyj.practice.demo.dto.CountryAndCapitalInfoResponse;
import kyj.practice.demo.dto.CountryInfoResponse;
import kyj.practice.demo.dto.CountrySearchCondition;
import kyj.practice.demo.entity.Country;
import kyj.practice.demo.repository.CountrySelectQueryRepository;
import kyj.practice.demo.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountrySearchService {
    private final CountryRepository countryRepository;
    private final CountrySelectQueryRepository countryQueryRepository;

    public List<CountryAndCapitalInfoResponse> getAllCountryNameAndCapitalName() {
        return countryRepository.getCountryNameAndCapitalName().stream()
                .map(result -> new CountryAndCapitalInfoResponse(
                        String.valueOf(result[0])
                        , String.valueOf(result[1])
                        , result[2] == null ? null : String.valueOf(result[2])
                        , result[3] == null ? null : String.valueOf(result[3])
                )).toList();
    }

    public Slice<CountryInfoResponse> getCountryInfo(Pageable pageable) {
        Slice<Country> sliceCountryInfo = countryRepository.findAllSlice(pageable);
        return sliceCountryInfo.map(result -> new CountryInfoResponse(
                result.getCode(), result.getName()
        ));
    }

    public List<CountryAllInfoResponse> getCountryAllInfo() {
        return countryQueryRepository.findAll();
    }

    public CountryAllInfoResponse getCountryInfo(CountrySearchCondition condition) {
        return countryQueryRepository.findByCode(condition);
    }
}
