package kg.geektech.adnroid3.lesson_1.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kg.geektech.adnroid3.lesson_1.R;
import kg.geektech.adnroid3.lesson_1.domain.Card;
import kg.geektech.adnroid3.lesson_1.ui.EmojiGame;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiHolder> {

    private final Listener listener;
    private Context context;
    private EmojiGame emojiGame;

    public EmojiAdapter(EmojiGame emojiGame, Listener listener, Context context) {
        this.emojiGame = emojiGame;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new EmojiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        holder.onBind(emojiGame.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return emojiGame.getCards().size();
    }

    class EmojiHolder extends RecyclerView.ViewHolder {
        private final TextView tvCard;

        public EmojiHolder(@NonNull View itemView) {
            super(itemView);
            tvCard = itemView.findViewById(R.id.tv_card_content);
        }

        public void onBind(Card<String> card) {
            if (card.isFaceUp()) {
                tvCard.setBackgroundColor(Color.WHITE);
                tvCard.setText(card.getContent());
            } else {
                tvCard.setBackgroundColor(Color.BLUE);
                tvCard.setText("");
            }
            itemView.setOnClickListener(v -> {
                emojiGame.choose(card);
                listener.cardClick(card);
            });
        }
    }

    public interface Listener {
        void cardClick(Card<String> card);
    }
}
