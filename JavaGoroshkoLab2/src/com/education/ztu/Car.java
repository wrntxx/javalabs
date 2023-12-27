package com.education.ztu;

import java.time.LocalDate;

public class Car {
    private String brand;
    private Engine engine;
    private int year;

    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
        this.engine = new Engine();
    }

    public String getFullInfo() {
        return String.format("Brand: %s, Year: %d Engine: %s", brand, year, engineIsRunning() ? "Running" : "Stopped");
    }

    public boolean engineIsRunning() {
        return engine.isEngineWorks();
    }

    public boolean isOldCar() {
        int currentYear = LocalDate.now().getYear();
        return (currentYear - year) > 15;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
