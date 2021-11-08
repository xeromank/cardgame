package com.java.card;

import lombok.Data;
import lombok.ToString;

import java.util.Comparator;

@Data
@ToString
public class Card {

    private CardType cardType;
    private CardNumber cardNumber;

    public Integer getTypeRank(){
        return this.cardType.getRank();
    }

    public Integer getNumberRank(){
        return this.cardNumber.getRank();
    }

    public Card(CardType cardType, CardNumber cardNumber){
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }

    static class CardComparator implements Comparator<Card>{

        @Override
        public int compare(Card o1, Card o2) {

            if(o1.cardNumber.getRank() < o2.cardNumber.getRank()){
                return -1;
            }else if(o1.cardNumber.getRank() == o2.cardNumber.getRank()){
                if(o1.cardType.getRank() < o2.cardType.getRank()){
                    return -1;
                }
            }else{
                return 1;
            }

            return 0;
        }
    }
}
