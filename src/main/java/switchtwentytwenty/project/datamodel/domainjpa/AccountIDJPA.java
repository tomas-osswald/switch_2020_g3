package switchtwentytwenty.project.datamodel.domainjpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Embeddable
public class AccountIDJPA implements Serializable {

    @Getter
    @Setter
    private Long id;

    public AccountIDJPA (Long id) {
        this.id = id;
    }

    public Long toLong () {
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountIDJPA that = (AccountIDJPA) o;
        return Objects.equals(id, that.id); }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
