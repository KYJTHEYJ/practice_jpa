package kyj.practice.demo.dto;

public record CountrySearchCondition(
        // 회원 코드 검색
        String code
        // 인구수 이상, 이하 검색시
        , Integer populationLowEq
        , Integer populationUpEq
) {
}
