package switchtwentytwenty.project.domain.sandbox;


public class Result<T> {

    private boolean result;
    private T content;

    public Result(boolean result, T content) {
        this.result = result;
        this.content = content;
    }

    public static <T> Result<T> success() {
        return new Result<>(true, null);
    }

    public static <T> Result<T> failure(T messageContent) {
        return new Result<>(false, messageContent);
    }

    public boolean isSuccess() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;

        Result<T> result = (Result<T>) o;

        return this.result == result.result && this.content.equals(result.content);
    }
}

