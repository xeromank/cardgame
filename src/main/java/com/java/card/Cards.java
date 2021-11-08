package com.java.card;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ToString
@Getter
public class Cards {

    private List<Card> cards = new ArrayList<>();

    public int getSize(){
        return cards.size();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void print() {
        System.out.println(cards);
    }

    public Card getCard(){
        Card card = cards.get(0);
        cards.remove(0);

        return card;
    }
}

