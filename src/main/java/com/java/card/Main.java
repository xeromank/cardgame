package com.java.card;

import java.util.*;

public class Main {

//    final static String[] cardTypes = {"S", "H", "D", "C"};
//    final static String[] cardNumbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public static void main(String[] args) {

        System.out.print("User의 수를 입력하세요 >> ");
        Integer userCount = new Scanner(System.in).nextInt();

        GameInfo gameInfo = new GameInfo(userCount);

//        System.out.println(gameInfo.getLeftCards().getSize());
        gameInfo.open();
        gameInfo.open();

//        System.out.println(gameInfo.nextUser().getTempCards(gameInfo.getOpenCards().getCards()));
//        System.out.println(gameInfo.nextUser().getTempCards(gameInfo.getOpenCards().getCards()));
//
//        System.out.println(gameInfo.getOpenCards());
//        System.out.println(gameInfo.getOpenCards().getSize());

        User user = new User();
        user.getTempCards().add(new Card(CardType.S, CardNumber.ACE));
        user.getTempCards().add(new Card(CardType.H, CardNumber.NINE));
        user.getTempCards().add(new Card(CardType.C, CardNumber.JACK));
        user.getTempCards().add(new Card(CardType.S, CardNumber.JACK));
        user.getTempCards().add(new Card(CardType.S, CardNumber.NINE));
        user.getTempCards().add(new Card(CardType.D, CardNumber.NINE));
        user.getTempCards().add(new Card(CardType.D, CardNumber.JACK));


//        System.out.println(user.straight());
//        System.out.println(user.flush());
        System.out.println(user.pair(3));
    }

}
