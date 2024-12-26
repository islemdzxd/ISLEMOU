package com.example.myunogame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<CarteVue> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public List<CarteVue> getHand() {
        return hand;
    }

    public void drawCard(CarteVue card) {
        hand.add(card);
    }

    public void playCard(CarteVue card) {
        hand.remove(card);
    }

    public boolean hasWon() {
        return hand.isEmpty();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
