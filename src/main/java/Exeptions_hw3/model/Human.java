package Exeptions_hw3.model;

public class Human {
    private String surname;
    private String name;
    private String secondSurname;
    private String birthDate;
    private String numberPhone;
    private String gender;

//    public enum Gender {m, f}

    public Human(String surname, String name, String secondSurname, String birthDate, String numberPhone, String gender) {
        this.surname = surname;
        this.name = name;
        this.secondSurname = secondSurname;
        this.birthDate = birthDate;
        this.numberPhone = numberPhone;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "<"+ surname +">  <"+ name +">  <"+ secondSurname +">  <"+ birthDate
                +">  <"+ numberPhone +">  <"+ gender +">";
    }
}


