package Exeptions_hw2;/*Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
Пользователю должно показаться сообщение, что пустые строки вводить нельзя.*/

import java.util.Objects;
import java.util.Scanner;

public class Ex004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Введите строку: ");
            String str = scanner.nextLine();
            if (!Objects.equals(str, "")) {
                System.out.println("внесена строка: " + str);
            } else {
                System.err.println("Exception: пустые строки вводить нельзя!");
                break;
            }
        }
    }
}
