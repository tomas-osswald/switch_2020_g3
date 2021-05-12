package switchtwentytwenty.project.domain.valueobject;

import java.util.Objects;

public class Movement implements ValueObject {

    private Monetary monetary;

    public Movement(Monetary monetary) {
        this.monetary = monetary;
    }

    public Monetary getMonetary() {
        return monetary;
    }

    public void setMonetary(Monetary monetary) {
        this.monetary = monetary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movement)) return false;
        Movement movement = (Movement) o;
        return Objects.equals(getMonetary(), movement.getMonetary());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMonetary());
    }
}
