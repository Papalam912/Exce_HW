package Exeptions_hw3.presenter;

import Exeptions_hw3.view.View;
import Exeptions_hw3.model.SaveHuman;

import java.io.IOException;

public class Presenter {
    private View view;
    private SaveHuman saveHuman;

    public Presenter(View view) {
        this.view = view;
        this.saveHuman = saveHuman;
    }

    public void addHuman(String surname, String name, String secondSurname, String birthday, String numberPhone, String gender) throws IOException {
        SaveHuman.addHuman(surname, name, secondSurname, birthday, numberPhone, gender);
    }
}
