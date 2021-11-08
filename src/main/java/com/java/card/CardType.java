package com.java.card;

import lombok.Getter;

import javax.naming.Name;

@Getter
public enum CardType {

    S("spade", 0), H("heart", 1), D("diamond", 2), C("club", 3);

    private String name;
    private Integer rank;

    CardType(String name, Integer rank){
        this.name = name;
        this.rank = rank;
    }
}
