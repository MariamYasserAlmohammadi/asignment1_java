package basics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.basics.R;

public class XOGameActivity extends AppCompatActivity {
    TextView playerOneScore;
    TextView playerTwoScore;
    ConstraintLayout mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xogame);
        playerOneScore = findViewById(R.id.player1_score);
        playerTwoScore = findViewById(R.id.player2_score);
        mainView = findViewById(R.id.main_view);
    }

    int counter = 0;
    int score1=0;
    int score2=0;

    public void onPlayerClick(View view) {
        Button clickedButton = ((Button) view);
        if (clickedButton.getText().toString().isEmpty())
            return;
        if (counter % 2 == 0) {
            score1+=1;
            clickedButton.setText("X");
        } else {
            score2+=1;
            clickedButton.setText("O");
        }
        counter++;
        if (checkWinner("X")){
            score1+=5;
            playerOneScore.setText(score1+"");
            initBoard();

        } else if (checkWinner("O")) {
            score2+=5;
            playerTwoScore.setText(score2+"");
            initBoard();

        } else if (counter==9) {
            // draw
            initBoard();
        }

    }

    private void initBoard() {
        for (int i=0;i<9;i++){
            ((Button) mainView.findViewWithTag("i")).setText("");
        }
        counter=0;
//        int childernCount = mainView.getChildCount();
//        for (int i = 0; i < childernCount; i++) {
//            View view = mainView.getChildAt(i);
//            if (view instanceof LinearLayout) {
//                LinearLayout row = ((LinearLayout) view);
//                int j = 0;
//                for (j = 0; j < row.getChildCount(); j++) {
//                    ((Button) row.getChildAt(j)).setText("");
//                }
//            }
//
//        }
    }

    private boolean checkWinner(String playerSymbol) {
        int childernCount = mainView.getChildCount();
        for (int i = 0; i < childernCount; i++) {
            View view = mainView.getChildAt(i);
            if (view instanceof LinearLayout) {
                LinearLayout row = ((LinearLayout) view);
                int j = 0;
                for (j = 0; j < row.getChildCount(); j++) {
                    if (((Button) row.getChildAt(j))
                            .getText().toString()
                            .equals(playerSymbol)) {
                        break;
                    }
                }
                if (j == 3) return true;
            }

        }
        for (int i = 0; i < 9; i+=3) {
            if (((Button) mainView.findViewWithTag(i + ""))
                    .getText().toString().equals(playerSymbol)
                    && ((Button) mainView.findViewWithTag(i + 3 + ""))
                    .getText().toString().equals(playerSymbol)
                    && ((Button) mainView.findViewWithTag(i + 6 + ""))
                    .getText().toString().equals(playerSymbol)) {
                return true;
            }

        }
        for (int i = 0; i < 3; i++) {
            if (((Button) mainView.findViewWithTag(i + ""))
                    .getText().toString().equals(playerSymbol)
                    && ((Button) mainView.findViewWithTag(i + 1 + ""))
                    .getText().toString().equals(playerSymbol)
                    && ((Button) mainView.findViewWithTag(i + 2 + ""))
                    .getText().toString().equals(playerSymbol)) {
                return true;
            }

        }
        if (((Button) mainView.findViewWithTag("0"))
                .getText().toString().equals(playerSymbol)
                && ((Button) mainView.findViewWithTag("4"))
                .getText().toString().equals(playerSymbol)
                && ((Button) mainView.findViewWithTag("8"))
                .getText().toString().equals(playerSymbol)) {
            return true;
        }
        if (((Button) mainView.findViewWithTag("2"))
                .getText().toString().equals(playerSymbol)
                && ((Button) mainView.findViewWithTag("4"))
                .getText().toString().equals(playerSymbol)
                && ((Button) mainView.findViewWithTag("6"))
                .getText().toString().equals(playerSymbol)) {
            return true;
        }
        return false;

    }

}