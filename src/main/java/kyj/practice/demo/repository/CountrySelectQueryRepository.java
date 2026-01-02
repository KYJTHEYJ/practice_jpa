package kyj.practice.demo.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kyj.practice.demo.dto.CountryAllInfoResponse;
import kyj.practice.demo.dto.CountrySearchCondition;
import kyj.practice.demo.entity.Country;
import kyj.practice.demo.entity.QCountry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.util.StringUtils.hasText;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CountrySelectQueryRepository {
    private final JPAQueryFactory queryFactory;

    // region 일반 전체 조회
    public List<CountryAllInfoResponse> findAll() {
        QCountry country = QCountry.country;

        List<Country> CountryAllInfoList = queryFactory
                .selectFrom(country) // select * from 이 합쳐진 부분
                .fetch(); // 실행하기

        return CountryAllInfoList.stream().map(
                result -> new CountryAllInfoResponse(
                        result.getCode()
                        , result.getName()
                        , result.getContinent()
                        , result.getRegion()
                        , result.getSurfaceArea()
                        , result.getIndepYear()
                        , result.getPopulation()
                        , result.getLifeExpectancy()
                        , result.getGnp()
                        , result.getGNPOld()
                        , result.getLocalName()
                        , result.getGovernmentForm()
                        , result.getHeadOfState()
                        , result.getCapital()
                        , result.getCode2()
                )
        ).toList();
    }

    //region 동적 단일 조회
    public CountryAllInfoResponse findByCode(CountrySearchCondition condition) {
        QCountry country = QCountry.country;

        return queryFactory
                .select(Projections.constructor(CountryAllInfoResponse.class
                        , country.code
                        , country.name
                        , country.continent
                        , country.region
                        , country.surfaceArea
                        , country.indepYear
                        , country.population
                        , country.lifeExpectancy
                        , country.gnp
                        , country.gNPOld
                        , country.localName
                        , country.governmentForm
                        , country.headOfState
                        , country.capital
                        , country.code2
                ))
                .from(country)
                .where(
                        countryCodeEquals(condition.code())
                        , countryPopulationUpEq(condition.populationUpEq())
                        , countryPopulationLowEq(condition.populationLowEq())
                ) // where code = ? and population >= ? and population <= ?
                .fetchOne(); // 1개의 결과를 받아오거나 없으면 null
    }

    private BooleanExpression countryCodeEquals(String code) {
        QCountry country = QCountry.country;

        return hasText(code) ? country.code.eq(code) : null;
    }

    private BooleanExpression countryPopulationUpEq(Integer population) {
        QCountry country = QCountry.country;

        return population != null ? country.population.goe(population) : null;
    }

    private BooleanExpression countryPopulationLowEq(Integer population) {
        QCountry country = QCountry.country;

        return population != null ? country.population.loe(population) : null;
    }
    //endregion
}
