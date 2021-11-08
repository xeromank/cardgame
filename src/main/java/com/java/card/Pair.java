package com.java.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@ToString
@Getter
@AllArgsConstructor
public class Pair {

    private Integer pairCount;
    Map<CardNumber, List<Card>> pairCards;
}
