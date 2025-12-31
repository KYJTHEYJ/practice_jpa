package kyj.practice.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class CountryLanguageId implements Serializable {
    private static final long serialVersionUID = 4493617395119693991L;
    @ColumnDefault("''")
    @Column(name = "CountryCode", nullable = false, length = 3)
    private String countryCode;

    @ColumnDefault("''")
    @Column(name = "Language", nullable = false, length = 30)
    private String language;


}