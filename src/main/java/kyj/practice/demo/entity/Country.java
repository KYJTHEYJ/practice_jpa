package kyj.practice.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name ="country", schema = "world")
public class Country {
    @Id
    @ColumnDefault("''")
    @Column(name = "Code", nullable = false, length = 3)
    private String code;

    @ColumnDefault("''")
    @Column(name = "Name", nullable = false, length = 52)
    private String name;

    @ColumnDefault("'Asia'")
    @Lob
    @Column(name = "Continent", nullable = false)
    private String continent;

    @ColumnDefault("''")
    @Column(name = "Region", nullable = false, length = 26)
    private String region;

    @ColumnDefault("0.00")
    @Column(name = "SurfaceArea", nullable = false, precision = 10, scale = 2)
    private BigDecimal surfaceArea;

    @Column(name = "IndepYear")
    private Short indepYear;

    @ColumnDefault("0")
    @Column(name = "Population", nullable = false)
    private Integer population;

    @Column(name = "LifeExpectancy", precision = 3, scale = 1)
    private BigDecimal lifeExpectancy;

    @Column(name = "GNP", precision = 10, scale = 2)
    private BigDecimal gnp;

    @Column(name = "GNPOld", precision = 10, scale = 2)
    private BigDecimal gNPOld;

    @ColumnDefault("''")
    @Column(name = "LocalName", nullable = false, length = 45)
    private String localName;

    @ColumnDefault("''")
    @Column(name = "GovernmentForm", nullable = false, length = 45)
    private String governmentForm;

    @Column(name = "HeadOfState", length = 60)
    private String headOfState;

    @Column(name = "Capital")
    private Integer capital;

    @ColumnDefault("''")
    @Column(name = "Code2", nullable = false, length = 2)
    private String code2;
}