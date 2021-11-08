package com.java.card;

import javax.naming.Name;

public enum Goal {

    RSF("Royal Straight Flush", 0), SFL("Straight Flush", 10), FCD("Four Card", 20),
    FHS("Full House", 30),
    FLS("Flush(Spade)", 41), FLH("Flush(Heart)", 42), FLD("Flush(Diamond)", 43), FLC("Flush(Club)", 44),
    STR("Straight", 50),
    THR("Triple", 60), TWO("Two Pair", 70), ONE("One Pair", 80),
    HGH("High Card", 90);

    private String name;
    private Integer rank;

    Goal(String name, Integer rank){
        this.name = name;
        this.rank = rank;
    }
}
