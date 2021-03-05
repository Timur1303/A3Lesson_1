package kg.geektech.adnroid3.lesson_1.ui;

import android.content.Context;

import java.util.Arrays;
import java.util.List;

import kg.geektech.adnroid3.lesson_1.domain.Card;
import kg.geektech.adnroid3.lesson_1.domain.Game;

public class EmojiGame {

    private final Game<String> game;

    public EmojiGame(Context context) {
        game = new Game<>(Arrays.asList("👻", "🎃", "👹"),context);
    }

    public void choose(Card<String> card) {
        game.choose(card);
    }

    public void showText() {

    }

    public List<Card<String>> getCards() {
        return game.getCards();
    }
}
