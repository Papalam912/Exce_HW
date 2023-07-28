package Exeptions_hw2;

import java.util.InputMismatchException;
import java.util.Scanner;

/*Если необходимо, исправьте данный код
(задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
*/
public class Ex002 {
    public static void main(String[] args) {
        testEsception();
    }

    private static void testEsception(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива: (0- выход из программы)");
        try {
            int value = Integer.parseInt(String.valueOf(scanner.nextInt()));
            if(value == 0){
                System.out.println("программа завершена");
                System.exit(0);}
            int[] intArray = new int[value];
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (InputMismatchException | ArithmeticException | ArrayIndexOutOfBoundsException e){
            System.err.println("Catching exception: " + e);
            testEsception();
        }
    }
}
