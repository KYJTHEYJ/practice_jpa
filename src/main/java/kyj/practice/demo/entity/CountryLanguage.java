package kyj.practice.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "countrylanguage", schema = "world")
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId id;

    @MapsId("countryCode")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("''")
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country countryCode;

    @ColumnDefault("'F'")
    @Lob
    @Column(name = "IsOfficial", nullable = false)
    private String isOfficial;

    @ColumnDefault("0.0")
    @Column(name = "Percentage", nullable = false, precision = 4, scale = 1)
    private BigDecimal percentage;


}