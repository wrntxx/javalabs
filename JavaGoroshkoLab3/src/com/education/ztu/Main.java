package com.education.ztu;

import com.education.ztu.game.Student;
import com.education.ztu.game.Team;

public class Main {

    public static void main(String[] args) {
        Student student = new Student("Mykola", 20);

        try {
            Student studentClone = (Student) student.clone();

            Team<Student> team = new Team<Student>("Dragon");
            team.addNewParticipant(student);
            team.addNewParticipant(studentClone);
            System.out.println();

            Team<Student> teamClone = new Team<Student>(team);

            System.out.println("Origin");
            System.out.println(student);
            System.out.println("Hashcode: " + student.hashCode());
            System.out.println();

            System.out.println("Clone");
            System.out.println(studentClone);
            System.out.println("Hashcode: " + studentClone.hashCode());
            System.out.println();

            System.out.println("student equals to studentClone: " + student.equals(studentClone));
            System.out.println();

            System.out.println("Origin");
            System.out.println("Team name: " + team.getName());
            System.out.println("Team participants: " + team.getParticipants());
            System.out.println();

            System.out.println("Clone");
            System.out.println("Team name: " + teamClone.getName());
            System.out.println("Team participants: " + teamClone.getParticipants());
            System.out.println();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
