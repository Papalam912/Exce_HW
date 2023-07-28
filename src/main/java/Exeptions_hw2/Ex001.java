package Exeptions_hw2;

/* 1.Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
    Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить
    у пользователя ввод данных.*/

import java.util.Scanner;

public class Ex001 {
    public static void main(String[] args) {
        System.out.println("введено дробное число: "+ getFloat() + "\n" + "программа завершена успешно");
    }
    private static float getFloat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дробное число: ");
        float number = 0;
        try {
            number = Float.parseFloat(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("NumberFormatException:  ошибка преобразования строки в число");
            return getFloat();
        }
        return number;
    }
}

