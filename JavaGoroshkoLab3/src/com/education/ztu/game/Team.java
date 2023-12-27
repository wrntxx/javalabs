package com.education.ztu.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<T extends Participant> {
    private String name;
    private List<T> participants = new ArrayList<T>();

    public Team(String name) {
        this.name = name;
    }

    public Team(Team<T> otherTeam) {
        this.name = otherTeam.name;

        for (T participant : otherTeam.participants) {
            if (participant instanceof Cloneable) {
                try {
                    this.participants.add((T)participant.clone());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Participants must implement Cloneable");
            }
        }
    }

    public void addNewParticipant(T participant) {
        participants.add(participant);
        if(participant instanceof Participant) {
            System.out.println("To the team " + name + " was added participant " + ((Participant) participant).getName());
        } else {
            System.out.println("To the team " + name + " was added participant " + participant);
        }
    }
    public void playWith(Team<T> team) {
        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if(i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.name;
        }
        System.out.println("The team " + winnerName + " is winner!");
    }

    public String getName() {
        return name;
    }

    public List<T> getParticipants() {
        return participants;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParticipants(List<T> participants) {
        this.participants = participants;
    }
}
