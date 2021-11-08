package com.java.card;


import lombok.Getter;

@Getter
public enum CardNumber {

    ACE("ACE", 0), TWO("TWO", 12), THREE("THREE", 11),
    FOUR("FOUR", 10), FIVE("FIVE", 9), SIX("SIX", 8),
    SEVEN("SEVEN", 7), EIGHT("EIGHT", 6), NINE("NINE", 5),
    TEN("TEN", 4), JACK("JACK", 3), QUEEN("QUEEN", 2), KING("KING", 1);

    private String name;
    private Integer rank;

    CardNumber(String name, Integer rank){
        this.name = name;
        this.rank = rank;
    }
}
