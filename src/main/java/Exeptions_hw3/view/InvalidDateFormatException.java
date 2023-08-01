package Exeptions_hw3.view;

public class InvalidDateFormatException extends RuntimeException {
    public InvalidDateFormatException() {
        super("ошибка ввода даты! верный формат: dd/MM/yyyy");
    }
}
