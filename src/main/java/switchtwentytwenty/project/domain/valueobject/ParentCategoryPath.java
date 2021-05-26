package switchtwentytwenty.project.domain.valueobject;

import java.util.Objects;

public class ParentCategoryPath {

    private final String parentCategory;

    public ParentCategoryPath(String parentCategoryPath) {
        this.parentCategory = parentCategoryPath;
        validateParentCategoryPath();
    }

    private void validateParentCategoryPath() {
        if (!isNull()) {
            if (!isBlank()) {
                verifyFormat();
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public String toString() {
        return parentCategory;
    }

    private boolean isNull() {
        return parentCategory == null;
    }

    private boolean isBlank() {
        return parentCategory.trim().length() == 0;
    }

    //Validate Path -> REGEX to avoid invalid characters? FORMATO - http://(grupo)X/(categories)**/(ParentCategoryID)**
    private void verifyFormat() {
        /* "\\d{4}(-\\d{3})?"
        String regex = "((http|https)://)(www.)?"
                + "[a-zA-Z0-9@:%.\+~#?&//=]"
                + "{2,256}\.[a-z]"
                + "{2,6}\b([-a-zA-Z0-9@:%"
                + ".\+~#?&//=]*)";
        if(Pattern.matches(regex, parentCategory)) throw new IllegalArgumentException();
   */
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParentCategoryPath)) return false;
        ParentCategoryPath that = (ParentCategoryPath) o;
        return Objects.equals(parentCategory, that.parentCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentCategory);
    }

}