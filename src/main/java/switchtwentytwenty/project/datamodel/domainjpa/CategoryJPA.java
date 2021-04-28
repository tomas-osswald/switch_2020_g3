package switchtwentytwenty.project.datamodel.domainjpa;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name="categories")
public class CategoryJPA {

    @Getter
    private String categoryName;

    @Id
    private CategoryIDJPA categoryIDJPA;

    @Getter
    private Long parentID;

    @Getter
    private String familyIDJPA;

    public CategoryJPA(String categoryName, CategoryIDJPA categoryIDJPA, Long parentID, String familyIDJPA) {
        this.categoryName = categoryName;
        this.categoryIDJPA = categoryIDJPA;
        this.parentID = parentID;
        this.familyIDJPA = familyIDJPA;
    }

    public CategoryJPA(String categoryName, Long parentID, String familyIDJPA) {
        this.categoryName = categoryName;
        this.parentID = parentID;
        this.familyIDJPA = familyIDJPA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryJPA that = (CategoryJPA) o;
        return categoryIDJPA.equals(that.categoryIDJPA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryIDJPA);
    }
}
