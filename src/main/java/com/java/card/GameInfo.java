package com.java.card;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GameInfo {

    private List<User> users = new ArrayList<>();
    private Cards leftCards;
    private Cards openCards;
    Integer userIdx;
    Integer userCnt;


    public GameInfo(Integer userCnt){
        this.userCnt = userCnt;
        this.userIdx = 0;
        makeCard();
        makeUsers();
    }

    private void makeUsers(){
        for(int i=0; i<userCnt; i++){
            makeUser(i);
        }
    }

    private void makeUser(Integer no){
        users.add(new User(100000L, this.leftCards, no));
    }

    private void makeCard(){
        leftCards = new Cards();
        openCards = new Cards();
        for(CardType cardType : CardType.values()){
            for(CardNumber cardNumber : CardNumber.values()){
                Card card = new Card(cardType, cardNumber);
                leftCards.addCard(card);
            }
        }

        leftCards.shuffle();
    }

    public User nextUser(){
        if(this.userIdx >= this.users.size()){
            this.userIdx = 0;
        }

        User user = this.users.get(userIdx++);
        if(user.isLive()){
            return user;
        }else{
            return nextUser();
        }

    }

    public void open(){
        if(openCards.getSize() == 0){
            openCards.addCard(leftCards.getCard());
            openCards.addCard(leftCards.getCard());
            openCards.addCard(leftCards.getCard());
        }else{
            openCards.addCard(leftCards.getCard());
        }
    }

    public void print() {
        leftCards.print();
    }
}
