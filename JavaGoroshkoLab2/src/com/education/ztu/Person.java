package com.education.ztu;

public abstract class Person implements Human {
    private String firstname;
    private String lastname;
    private int age;
    private Gender gender;
    private Location location;

    public Person() {
        this.firstname = "Vlad";
        this.lastname = "Savchuk";
        this.age = 19;
        this.gender = Gender.Male;
        this.location = Location.ZHYTOMYR;
    }

    public Person(String firstname, String lastname, int age, Gender gender, Location location) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.location = location;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String getFullInfo() {
        String occupation = getOccupation();
        return String.format("Full name: %s %s, Age: %d, Gender: %s, Location: %s, Occupation: %s",
        firstname, lastname, age, gender, location, occupation);
    }

    @Override
    public void sayAge() {
        System.out.println(String.format("Age: %d y.o.", age));
    }

    @Override
    public void sayGender() {
        System.out.println(String.format("Gender: %s", gender));
    }

    @Override
    public void sayLocation() {
        System.out.println(String.format("Location: %s", location));
    }

    @Override
    public void sayFullName() {
        System.out.println(String.format("Full name: %s %s", firstname, lastname));
    }

    @Override
    public void whoIAm() {
        sayFullName();
        sayAge();
        sayGender();
        sayLocation();
    }

    public abstract String getOccupation();
}