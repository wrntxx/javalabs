package com.education.ztu.game;

import java.util.Comparator;
import java.util.Objects;

public abstract class Participant implements Cloneable, Comparable<Participant> {
    private String name;
    private int age;

    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Participant participant = (Participant) o;
        return name == participant.name && age == participant.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d", name, age);
    }

    @Override
    public int compareTo(Participant o) {
        return this.name.compareTo(o.name);
    }

    public static Comparator<Participant> ageComparator = Comparator.comparingInt(Participant::getAge);

    public static Comparator<Participant> nameThenAgeComparator = Comparator
            .comparing(Participant::getName)
            .thenComparingInt(Participant::getAge);
}
