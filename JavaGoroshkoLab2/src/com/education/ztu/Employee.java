package com.education.ztu;

public class Employee extends Person {
    public static int counter = 0;

    private String position;
    private String company;
    private Car car;

    private String occupation;

    private boolean isDriving;

    public Employee(String occupation, String position, String company, Car car) {
        super();
        this.occupation = occupation;
        this.position = position;
        this.company = company;
        this.car = car;
        counter++;
    }

    public Employee(String firstname, String lastname, int age, Gender gender, Location location, String occupation,
            String position, String company, Car car) {
        super(firstname, lastname, age, gender, location);
        this.occupation = occupation;
        this.position = position;
        this.company = company;
        this.car = car;
        counter++;
    }

    public static void showCounter() {
        System.out.println(String.format("Counter: %d", counter));
    }

    @Override
    public String getFullInfo() {
        String fullInfo = super.getFullInfo();
        return String.format("%s, Position: %s, Company: %s, Car: %s", fullInfo, position, company, car.getFullInfo());
    }

    public void startDriving() {
        if (car != null && car.getEngine().isEngineWorks()) {
            System.out.println("Starting to drive in a car.");
            isDriving = true;
        } else {
            System.out.println("You cannot start driving. Make sure the vehicle engine is running.");
        }
    }

    public void stopDriving() {
        if (isDriving) {
            System.out.println("Stopped driving.");
            isDriving = false;
        } else {
            System.out.println("Does not currently drive a car.");
        }
    }

    @Override
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}