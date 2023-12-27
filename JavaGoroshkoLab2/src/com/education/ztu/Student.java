package com.education.ztu;

public class Student extends Person {
    public static int counter = 0;

    private String university;
    private String speciality;
    private int course;

    public Student(String university, String speciality, int course) {
        super();
        this.university = university;
        this.speciality = speciality;
        this.course = course;
        counter++;
    }

    public Student(String firstname, String lastname, int age, Gender gender, Location location, String university,
            String speciality, int course) {
        super(firstname, lastname, age, gender, location);
        this.university = university;
        this.speciality = speciality;
        this.course = course;
        counter++;
    }

    public static void showCounter() {
        System.out.println(String.format("Counter: %d", counter));
    }

    @Override
    public String getFullInfo() {
        String fullInfo = super.getFullInfo();
        return String.format("%s, University: %s, Speciality: %s, Course: %d", fullInfo, university, speciality,
                course);
    }

    @Override
    public String getOccupation() {
        return "Student";
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}