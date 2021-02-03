package switchtwentytwenty.project.domain.sandbox;


import java.util.Objects;

public class Result<T> {

    private final boolean aBoolean;
    private final T content;

    public Result(boolean result, T content) {
        this.aBoolean = result;
        this.content = content;
    }

    public static <T> Result<T> success() {
        return new Result<>(true, null);
    }

    public static <T> Result<T> failure(T messageContent) {
        return new Result<>(false, messageContent);
    }

    public boolean isSuccess() {
        return aBoolean;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;

        Result<T> otherResult = (Result<T>) o;

        return this.aBoolean == otherResult.aBoolean && this.content.equals(otherResult.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aBoolean, content);
    }
}

