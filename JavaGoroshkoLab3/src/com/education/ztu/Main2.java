package com.education.ztu;

import com.education.ztu.game.Schoolar;
import com.education.ztu.game.Team;

public class Main2 {
    public static void main(String[] args) {
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);
        Schoolar schoolar3 = new Schoolar("Sergey", 12);
        Schoolar schoolar4 = new Schoolar("Olga", 14);
        Schoolar schoolar5 = new Schoolar("Olga", 10);

        Team<Schoolar> team = new Team<Schoolar>("Dragon");
        team.addNewParticipant(schoolar1);
        team.addNewParticipant(schoolar2);
        team.addNewParticipant(schoolar3);
        team.addNewParticipant(schoolar4);
        team.addNewParticipant(schoolar5);

        team.getParticipants().sort(Schoolar::compareTo);
        System.out.println("Sorted by name: ");
        team.getParticipants().forEach(System.out::println);
        System.out.println();
        
        team.getParticipants().sort(Schoolar.ageComparator);
        System.out.println("Sorted by age: ");
        team.getParticipants().forEach(System.out::println);
        System.out.println();

        team.getParticipants().sort(Schoolar.nameThenAgeComparator);
        System.out.println("Sorted by name, than by age: ");
        team.getParticipants().forEach(System.out::println);
        System.out.println();
    }
}
