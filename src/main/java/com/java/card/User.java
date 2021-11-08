package com.java.card;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Getter
@ToString
@NoArgsConstructor
public class User {

    private List<Card> myCards = new ArrayList<>();
    private List<Card> tempCards = new ArrayList<>();
    private Long money;
    private Boolean live;
    private Integer no;

    public User(Long money, Cards cards, Integer no){
        this.live = true;
        this.money = money;
        this.no = no;
        this.myCards.add(cards.getCard());
        this.myCards.add(cards.getCard());
    }

    public void fold(){
        this.live = false;
    }

    public Boolean isLive() {
        return this.live;
    }

    public void makeTempCards(List<Card> openCards){
        this.tempCards = new ArrayList<>();
        tempCards.addAll(myCards);
        tempCards.addAll(openCards);

        Collections.sort(tempCards, new Card.CardComparator());
    }

    public List<Card> getTempCards(List<Card> openCards){
        makeTempCards(openCards);
        return this.tempCards;
    }

    public String getPoints(){

        return null;
    }

    public Pair pair(int pair){

        Integer pairCount = 0;

        Map<CardNumber, List<Card>> cardsByNumber = this.tempCards.stream().collect(Collectors.groupingBy(Card::getCardNumber));
        cardsByNumber.values().removeIf( lst -> lst.size() != pair);

        Map<CardNumber, List<Card>> cardsByNumberSorted = cardsByNumber.entrySet().stream().
                sorted((e1, e2) -> e1.getKey().getRank() > e2.getKey().getRank() ? 1 : -1).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        pairCount = cardsByNumberSorted.size();

        if(pairCount > 2){
            int c = 0;
            Set<CardNumber> keys = cardsByNumberSorted.keySet();
            for(CardNumber number: keys){
                if(c > 1){
                    cardsByNumberSorted.remove(number);
                }
                c++;
            }
        }

        return new Pair(pairCount, cardsByNumberSorted);

    }

    public CardType flush(){

        Map<CardType, List<Card>> cardsByType = this.tempCards.stream().collect(Collectors.groupingBy(Card::getCardType));
        cardsByType.values().removeIf(lst -> lst.size() < 5);

        for(CardType type: cardsByType.keySet()){
            return type;
        }

        return null;
    }

    public List<Card> straight(){

        List<Card> pass = new ArrayList<>();
        Boolean existsAce = false;
        Integer continueCnt = 0;

        for(Card card : tempCards){
            if(pass.isEmpty()){
                pass.add(card);
                continueCnt++;
            }else{
                Card preCard = pass.get(pass.size()-1);
                if(preCard.getCardNumber() == CardNumber.ACE){
                    existsAce = true;
                }

                if(preCard.getNumberRank() == card.getNumberRank() - 1){
                    continueCnt++;
                    pass.add(card);
                }else if(preCard.getNumberRank() == card.getNumberRank()){
                    pass.add(card);
                }else{
                    continueCnt = 0;
                    pass = new ArrayList<>();
                }
            }
        }

        if(continueCnt == 4 && existsAce){
            if(pass.get(pass.size()-1).getNumberRank() == 12){
                continueCnt++;
                pass.addAll(tempCards.stream().filter(e -> e.getNumberRank() == 0).collect(Collectors.toList()));
            }
        }

        if(continueCnt < 5){
            pass = new ArrayList<>();
        }

        return pass;
    }

    public void getPoint(){
        List<Card> straight = straight();
        CardType flush = flush();

        if(!straight.isEmpty() && flush != null){

        }
    }
}
