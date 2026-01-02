package kyj.practice.demo.dto;

import java.math.BigDecimal;

public record CountryAllInfoResponse(
        String code
        , String name
        , String continent
        , String region
        , BigDecimal surfaceArea
        , Short indepYear
        , Integer population
        , BigDecimal lifeExpectancy
        , BigDecimal gnp
        , BigDecimal gNPOld
        , String localName
        , String governmentForm
        , String headOfState
        , Integer capital
        , String code2
) {
}
