package Exeptions_hw3.view;

import Exeptions_hw3.presenter.Presenter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ConsoleUI implements View {
    private boolean work;
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        this.work = true;
    }

    @Override
    public void start() {
        System.out.println("Добро пожаловать в программу ввода данных о human!");
        System.out.println("----------------");
        while (work) {
            inputData();
            finish();
        }
    }

    public void finish() {
        System.out.println("программа завершена!");
        work = false;
    }

    private void inputData() {
        System.out.println("Введите через пробел: Фамилия, Имя, Отчество (формат: Ivanov Ivan Ivanovich), дата_рождения(формат: dd/MM/yyyy)," +
                " номер_телефона(11 цифр),  пол(m или f) или <q>(выход)");
        String data;
        data = scanner.nextLine();
        if (data.equalsIgnoreCase("q")) finish();
        String[] lst = data.split(" ");
        if (lst.length > 6) {
            throw new RuntimeException("несоответствие количества введенных значений запрошенным параметрам! введено - "
                    + lst.length + " значений (требуется 6)");
        } else if (lst.length < 6) {
            throw new RuntimeException("несоответствие количества введенных значений запрошенным параметрам! введено - "
                    + lst.length + " значений (требуется 6)");
        }

        String surname = lst[0];
        String name = lst[1];
        String secondSurname = lst[2];
//        if (!surname.matches("[а-яА-Я]+") || !name.matches("[а-яА-Я]+") // только русский алфавит
//                || !secondSurname.matches("[а-яА-Я]+")||
        if (!surname.matches("[a-zA-Z]+") || !name.matches("[a-zA-Z]+")  // только англ. алфавит
            || !secondSurname.matches("[a-zA-Z]+")){
            throw new RuntimeException("Ошибка при вводе ФИО! внесены символы отличные от букв англ. алфавита!");
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String birthDate;
        try {
            birthDate = formatter.format(formatter.parse(lst[3]));
        } catch (ParseException e) {
            throw new InvalidDateFormatException(); // создаю свое исключение
        }

        String numberPhone = lst[4];
        if(numberPhone.length() != 11 || !numberPhone.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")){
//            throw  new  NumberFormatException("неверный формат телефона! верный формат:+71234567890");// вариант со знаком
            throw  new  NumberFormatException("неверно введен номер телефона! верный формат: 11 цифр");
        }

        String gender = lst[5];
        if(!gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("f")) {
            throw new IllegalArgumentException("неверно введен гендерный признак! верный формат: m или f");
        }
//        System.out.println(Arrays.toString(lst)); // проверка введенных данных
        try {
            presenter.addHuman(surname, name, secondSurname, birthDate, numberPhone, gender);
        } catch (IOException e) {
            throw new RuntimeException("ошибка ввода данных");
        }
    }
}
