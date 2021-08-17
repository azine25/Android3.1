package com.example.android31.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.android31.databinding.ActivityMainBinding;
import com.example.android31.domain.CustomContent;
import com.example.android31.ui.adapters.EmojiAdapter;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.Listener {

    private ActivityMainBinding binding;
    private EmojiAdapter emojiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initRecycler();

        CustomContent customContent = new CustomContent(1, "Card 1", 15.0);
        CustomContent customContent2 = new CustomContent(1, "Card 1", 15.0);

        boolean isMatch = customContent.equals(customContent2);
        Log.d("TAG", "onCreate: " + isMatch);
    }

    private void initRecycler() {
        emojiAdapter = new EmojiAdapter(this);
        binding.recView.setAdapter(emojiAdapter);
    }

    @Override
    public void choose() {
        runOnUiThread(() -> {
            emojiAdapter.notifyDataSetChanged();
//            binding.recView.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "GAME OVER", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void notifyCards() {
        runOnUiThread(() -> {
            emojiAdapter.notifyDataSetChanged();
        });
    }
}