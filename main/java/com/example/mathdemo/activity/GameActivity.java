package com.example.mathdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mathdemo.R;
import com.example.mathdemo.adapter.GameAdapter;
import com.example.mathdemo.model.GameModel;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    String[] questions = {"200", "16", "144", "-1", "50"};
    String[] answer1 = {"199 + 1", "4+4", "12+12", "1-2", "5x10"};
    String[] answer2 = {"199-1", "8+5", "12x12", "0-0", "49+1"};
    String[] answer3 = {"50+50", "8x2", "120+14", "1+1", "51-1"};
    String[] answer4 = {"200/0", "8x8", "143+2", "2-1", "100/2"};

    private List<GameModel> gameList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        recyclerView = findViewById(R.id.game_recycler);
        layoutManager = new LinearLayoutManager(GameActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        
        configureData();
    }

    private void configureData() {
        for (int i = 0; i < questions.length; i++) {

            GameModel model = new GameModel();
            model.setQuestion(questions[i]);
            model.setFirstAnswer(answer1[i]);
            model.setSecondAnswer(answer2[i]);
            model.setThirdAnswer(answer3[i]);
            model.setForthAnswer(answer4[i]);

            gameList.add(model);
        }

        GameAdapter gameAdapter = new GameAdapter(GameActivity.this, gameList, recyclerView);
        recyclerView.setAdapter(gameAdapter);
        gameAdapter.notifyDataSetChanged();

    }
}