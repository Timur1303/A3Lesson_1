package kg.geektech.adnroid3.lesson_1.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import kg.geektech.adnroid3.lesson_1.R;
import kg.geektech.adnroid3.lesson_1.domain.Card;
import kg.geektech.adnroid3.lesson_1.ui.adapter.EmojiAdapter;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.Listener {

    private RecyclerView recyclerView;
    private EmojiAdapter emojiAdapter;
    private EmojiGame emojiGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_cards);
        emojiGame = new EmojiGame(this);
        emojiAdapter = new EmojiAdapter(emojiGame,this, MainActivity.this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(emojiAdapter);
    }

    @Override
    public void cardClick(Card<String> card) {
        emojiAdapter.notifyDataSetChanged();
    }
}