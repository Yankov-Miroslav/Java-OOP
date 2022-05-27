package cardSuit;

import cardsWithPower.CardRanks;
import cardsWithPower.CardSuits;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardRanks cardRank = CardRanks.valueOf(scanner.nextLine());
        CardSuits cardSuit = CardSuits.valueOf(scanner.nextLine());
        int sum = cardRank.getRankPower() + cardSuit.getPower();
        System.out.printf("Card name: %s of %s; Card power: %d", cardRank, cardSuit, sum);

    }
}
