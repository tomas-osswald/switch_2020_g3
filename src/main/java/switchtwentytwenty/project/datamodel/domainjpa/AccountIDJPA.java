package switchtwentytwenty.project.datamodel.domainjpa;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@ToString
@NoArgsConstructor
@Embeddable
public class AccountIDJPA implements Serializable {

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
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
