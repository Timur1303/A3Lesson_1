package kg.geektech.adnroid3.lesson_1.domain;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<Content> {

    private final List<Card<Content>> cards = new ArrayList<>();
    Context context;

    public Game(List<Content> contents, Context context) {
        this.context = context;
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>((i * 2) + 1, false, false, contents.get(i)));
            cards.add(new Card<>(i * 2, false, false, contents.get(i)));
        }
        Collections.shuffle(cards);
    }

    public void choose(Card<Content> card) {
        card.setFaceUp(!card.isFaceUp());
        checkPairs(card);
    }

    private void checkPairs(Card<Content> card) {
        for (Card<Content> anotherCard : cards) {
            if (card.isFaceUp() && anotherCard.isFaceUp()) {
                if (card.equals(anotherCard) && card.getId() != anotherCard.getId()) {
                    card.setMatched(true);
                    anotherCard.setMatched(true);
                    Log.d("tag", "MATCH!");
                }
            }
        }

        remove();
    }

    private void remove() {
        List<Card<Content>> resultCards = new ArrayList<>(cards);
        for (Card<Content> c : cards) {
            if (c.isMatched()) {
                resultCards.remove(c);
            }
        }
        cards.clear();
        cards.addAll(resultCards);
        if (getCards().size() == 0) {
            finish(context);
        }
    }

    private void finish(Context context) {
        if (getCards().size() == 0) {
            Toast.makeText(context, "GAME OVER!", Toast.LENGTH_SHORT).show();
        }
    }


    public List<Card<Content>> getCards() {
        return cards;
    }

}
