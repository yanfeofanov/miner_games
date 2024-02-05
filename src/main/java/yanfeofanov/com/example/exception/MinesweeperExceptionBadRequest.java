package yanfeofanov.com.example.exception;

public class MinesweeperExceptionBadRequest extends RuntimeException{



    @Override
    public String getMessage() {
        return " Произошла непредвиденная ошибка! ";
    }
}
