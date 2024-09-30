package service;


import model.Card;
import model.User;

import java.util.Objects;

public class CardService {
    private final Card[] cards = new Card[1000];
    private int index = 0;

    public boolean addCard(Card card, User user) {
        Card card1 = hasCard(card);
        if (card1 == null) {
            card.setUserId(user.getId());
            cards[index++] = card;
            return true;
        }
        return false;
    }

    private Card hasCard(Card card) {
        for (Card cardNumber : cards) {
            if (cardNumber != null && cardNumber.getCardNumber().equals(card.getCardNumber())) {
                return card;
            }
        }
        return null;
    }

    public Card[] getMyCards(User user) {
        int myCardsSize = 0;
        for (Card cardCh : cards) {
            if (cardCh != null && cardCh.getUserId().equals(user.getId())) {
                myCardsSize++;
            }
        }

        Card[] myCards = new Card[myCardsSize];
        myCardsSize = 0;
        for (Card cardCh : cards) {
            if (cardCh != null && cardCh.getUserId().equals(user.getId())) {
                myCards[myCardsSize++] = cardCh;
            }
        }

        return myCards;
    }

    public void deleteCard(String cardNumber, User currentUser) {
        Card[] myCards = getMyCards(currentUser);

        int index = 0;

        for (Card myCard : myCards) {
            if (Objects.equals(myCard.getCardNumber(), cardNumber)) {
                break;
            } else {
                return;
            }
        }


        for (int i = index; i < myCards.length; i++) {
            cards[i] = cards[i + 1];
        }
        this.index -= 1;
    }

    public String p2p(String cardNumber, String recipientCardNumber, double amount, User currentUser) {

        Card[] myCards = getMyCards(currentUser);
        Card fromNumber = new Card();
        Card toNumber = new Card();

        boolean founded = false;
        for (Card myCard : myCards) {
            if (Objects.equals(myCard.getCardNumber(), cardNumber)) {
                fromNumber = myCard;
                founded = true;
                break;
            }
        }

        boolean founded2 = false;
        for (Card card : cards) {
            if (Objects.equals(card.getCardNumber(), recipientCardNumber)) {
                toNumber = card;
                founded2 = true;
                break;
            }
        }

        if (!founded) {
            return "your card number is incorrect";
        }

        if (!founded2) {
            return "Recipient card number is incorrect";
        }

        fromNumber.setBalance(fromNumber.getBalance() - amount);
        toNumber.setBalance(toNumber.getBalance() + amount);

        return "Successfully";

    }

    public double getBalance(String cardNumber) {
        for (Card card : cards) {
            if (Objects.equals(card.getCardNumber(), cardNumber)) {
                return card.getBalance();
            }
        }
        return 0;
    }
}
