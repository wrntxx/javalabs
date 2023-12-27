package com.education.ztu;

public class Teacher extends Person {
    public static int counter = 0;

    private String university;
    private String subject;
    private Car car;

    public Teacher(String university, String subject, Car car) {
        super();
        this.university = university;
        this.subject = subject;
        this.car = car;
        counter++;
    }

    public Teacher(String firstname, String lastname, int age, Gender gender, Location location, String university, String subject, Car car) {
        super(firstname, lastname, age, gender, location);
        this.university = university;
        this.subject = subject;
        this.car = car;
        counter++;
    }

    public static void showCounter() {
        System.out.println(String.format("Counter: %d", counter));
    }

    @Override
    public String getFullInfo() {
        String fullInfo = super.getFullInfo();
        return String.format("%s, University: %s, Subject: %s, Car: %s", fullInfo, university, subject, car.getFullInfo());
    }

    @Override
    public String getOccupation() {
        return "Teacher";
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}