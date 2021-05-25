package switchtwentytwenty.project.datamodel.domainjpa;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class CategoryJPA {

    @Getter
    private String categoryName;

    @Getter
    @Id
    private Long categoryIDJPA;

    @Getter
    private Long parentID;

    @Getter
    private FamilyIDJPA familyIDJPA;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryJPA that = (CategoryJPA) o;
        return categoryIDJPA.equals(that.categoryIDJPA);
    }

    public boolean isStandard() {
        return this.familyIDJPA == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryIDJPA);
    }

    public static class Builder {

        private String categoryName;
        private Long categoryIDJPA;
        private Long parentID;
        private FamilyIDJPA familyIDJPA;

        public Builder(String categoryName) {
            this.categoryName = categoryName;
        }

        public Builder withCategoryIDJPA(Long categoryIDJPA) {
            this.categoryIDJPA = categoryIDJPA;
            return this;
        }

        public Builder withParentID(Long parentID) {
            this.parentID = parentID;
            return this;
        }

        public Builder withFamilyIDJPA(FamilyIDJPA familyIDJPA) {
            this.familyIDJPA = familyIDJPA;
            return this;
        }

        public CategoryJPA build() {
            CategoryJPA categoryJPA = new CategoryJPA();

            categoryJPA.categoryName = this.categoryName;
            categoryJPA.categoryIDJPA = this.categoryIDJPA;
            categoryJPA.parentID = this.parentID;
            categoryJPA.familyIDJPA = this.familyIDJPA;

            return categoryJPA;
        }

    }
}
