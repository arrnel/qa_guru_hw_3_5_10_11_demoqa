package guru.qa.com.demoqa.objects.user;

import guru.qa.com.demoqa.helpers.DateConverter;
import guru.qa.com.demoqa.objects.user.userObjects.City;
import guru.qa.com.demoqa.objects.user.userObjects.Gender;
import guru.qa.com.demoqa.objects.user.userObjects.Hobby;
import guru.qa.com.demoqa.objects.user.userObjects.State;
import guru.qa.com.demoqa.objects.user.userObjects.Subject;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class User {

    String firstName;
    String lastName;
    String email;
    Gender gender;
    String phoneNumber;
    String dateOfBirth;
    int dayOfBirth;
    int monthOfBirth;
    int yearOfBirth;
    ArrayList<Subject> subjects;
    ArrayList<Hobby> hobbies;
    String picture;
    String address;
    State state;
    City city;
    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public User setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public User setDateOfBirth(String dateOfBirth) {
        if (dateOfBirth==null || dateOfBirth.equals("")){

            Assertions.fail("Некорректный тип dateOfBirth: \"" + dateOfBirth + "\"");

        }else{
            try {
                DateConverter convertDate = new DateConverter();
                LocalDate localDate = convertDate.stringToLocalDate(dateOfBirth, "dd.MM.yyyy");

                setDayOfBirth(localDate.getDayOfMonth());
                setMonthOfBirth(localDate.getMonthValue());
                setYearOfBirth(localDate.getYear());


            }catch (DateTimeParseException ex){

                System.out.println(ex);
                Assertions.fail("Некорректный тип даты рождения: \"" + dateOfBirth + "\". Дата рождения должна быть в формате \"dd.MM.yyyy\", где \"dd\",\"MM\",\"yyyy\" - числа. ");

            }
        }

        this.dateOfBirth = dateOfBirth;

        return this;

    }

    public int getDayOfBirth() {
        return dayOfBirth;
    }

    public User setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;

        return this;
    }

    public int getMonthOfBirth() {
        return monthOfBirth;
    }

    public User setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
        return this;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public User setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        return this;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public User setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
        return this;
    }

    public ArrayList<Hobby> getHobbies() {
        return hobbies;
    }

    public User setHobbies(ArrayList<Hobby> hobbies) {
        this.hobbies = hobbies;
        return this;
    }

    public String getPicture() {
        return picture;
    }

    public User setPicture(String picture) {
        this.picture = picture;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public State getState() {
        return state;
    }

    public User setState(State state) {
        this.state = state;
        return this;
    }

    public City getCity() {
        return city;
    }

    public User setCity(City city) {
        this.city = city;
        return this;
    }

    public String getAllSubjectsInString(ArrayList<Subject> subjects) {
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < subjects.size(); i++){
            text.append(Subject.getSubjectValue(subjects.get(i)));
            if(subjects.size() < 2 || i != subjects.size() - 1){
                text.append(", ");
            }
        }

        return text.toString();
    }

    public String getAllHobbiesInString(ArrayList<Hobby> hobbies) {
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < hobbies.size(); i++){
            text.append(Hobby.getHobbyValue(hobbies.get(i)));
            if(hobbies.size() < 2 || i != hobbies.size() - 1){
                text.append(", ");
            }
        }

        return text.toString();
    }
}
