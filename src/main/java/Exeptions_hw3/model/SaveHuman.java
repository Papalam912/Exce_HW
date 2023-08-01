package Exeptions_hw3.model;

import Exeptions_hw3.presenter.Presenter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveHuman {
    private Presenter presenter;

    public SaveHuman(Presenter presenter) {
        this.presenter = presenter;
    }

    public static void addHuman(String surname, String name, String secondSurname, String birthDate, String numberPhone, String gender)  {
        Human human = new Human(surname, name, secondSurname, birthDate, numberPhone, gender);
        try (FileWriter writer = new FileWriter(new File(surname.toLowerCase() + ".txt"), true);) {  //true - дозапись
            try {
                writer.write(String.valueOf(human));
                writer.write("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("файл  " + surname.toLowerCase() + ".txt - создан, добавлена следующая запись: \n" + human);
        } catch (IOException e) {
                e.printStackTrace();
        }
//        System.out.println(human);
    }
}