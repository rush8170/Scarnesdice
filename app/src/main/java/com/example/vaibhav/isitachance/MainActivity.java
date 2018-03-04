package com.example.vaibhav.isitachance;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    boolean turn=true;
    int mCurrentscore = 0;
    int mTotalScore = 0;
    int mComputerScore = 0;
    TextView totalScore;
    TextView computerScore;
    TextView currentScore;
    TextView currentScoretext, computerScoretext, totalScoretext,wintext;
    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalScoretext = (TextView) findViewById(R.id.textView6);
        totalScore = (TextView) findViewById(R.id.textView7);
        computerScoretext = (TextView) findViewById(R.id.textView8);
        computerScore = (TextView) findViewById(R.id.textView9);
        currentScoretext = (TextView) findViewById(R.id.textView10);
        currentScore = (TextView) findViewById(R.id.textView11);
        wintext=(TextView)findViewById(R.id.wintextView);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);

        b1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {

                    totalScore = (TextView) findViewById(R.id.textView7);
                    computerScore = (TextView) findViewById(R.id.textView9);
                    currentScore = (TextView) findViewById(R.id.textView11);
                    b1 = (Button) findViewById(R.id.button);
                    b2 = (Button) findViewById(R.id.button2);
                    b3 = (Button) findViewById(R.id.button3);
                    //String temp;
                if(turn){
                    Random r1 = new Random();
                    int i = r1.nextInt(6) + 1;
                    ImageView imageView = (ImageView) findViewById(R.id.imageView);
                    switch (i) {
                        case 1:
                            imageView.setImageResource(R.drawable.dice1);
                            mCurrentscore = 0;
                            break;
                        case 2:
                            imageView.setImageResource(R.drawable.dice2);
                            mCurrentscore += 2;
                            break;
                        case 3:
                            imageView.setImageResource(R.drawable.dice3);
                            mCurrentscore += 3;
                            break;
                        case 4:
                            imageView.setImageResource(R.drawable.dice4);
                            mCurrentscore += 4;
                            break;
                        case 5:
                            imageView.setImageResource(R.drawable.dice5);
                            mCurrentscore += 5;
                            break;
                        case 6:
                            imageView.setImageResource(R.drawable.dice6);
                            mCurrentscore += 6;
                    }
                    animate(imageView);
                    currentScore.setText(Integer.toString(mCurrentscore));
                    if (i == 1) {
                        Toast turnupdate = Toast.makeText(getApplicationContext(), "Computers turn", Toast.LENGTH_SHORT);
                        turnupdate.show();
                        turn = !turn;
                        computerTurn();
                    } else if (mCurrentscore + mTotalScore >= 100) {
                        reset();
                        Toast winupdate = Toast.makeText(getApplicationContext(), "You Win", Toast.LENGTH_SHORT);
                        winupdate.show();
                        wintext.setText("You win...CONGRATS!!");
                        wintext.setVisibility(View.VISIBLE);
                    }
                }
                }
            });
        b2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTotalScore += mCurrentscore;
                totalScore.setText(Integer.toString(mTotalScore));
                mCurrentscore = 0;
                currentScore.setText("0");
                Toast turnupdate = Toast.makeText(getApplicationContext(), "Computer's turn", Toast.LENGTH_SHORT);
                turnupdate.show();
                turn=!turn;
                computerTurn();
            }
        });
        b3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
              reset();
            }
        });
    }
    public void computerTurn() {
        totalScore = (TextView) findViewById(R.id.textView7);
        computerScore = (TextView) findViewById(R.id.textView9);
        currentScore = (TextView) findViewById(R.id.textView11);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        final Handler handler = new Handler();
        b1.setEnabled(false);
        b2.setEnabled(false);


        handler.postDelayed(new Runnable() {
            Random r2 = new Random();
            int j = r2.nextInt(6) + 1;

            @Override
            public void run() {
                    int i = 0;
                    if (mCurrentscore + mComputerScore <= 100 && j != 0) {
                        Random r1 = new Random();
                        i = r1.nextInt(6) + 1;
                        ImageView imageView = (ImageView) findViewById(R.id.imageView);
                        switch (i) {
                            case 1:
                                imageView.setImageResource(R.drawable.dice1);
                                mCurrentscore = 0;
                                break;
                            case 2:
                                imageView.setImageResource(R.drawable.dice2);
                                mCurrentscore += 2;
                                break;
                            case 3:
                                imageView.setImageResource(R.drawable.dice3);
                                mCurrentscore += 3;
                                break;
                            case 4:
                                imageView.setImageResource(R.drawable.dice4);
                                mCurrentscore += 4;
                                break;
                            case 5:
                                imageView.setImageResource(R.drawable.dice5);
                                mCurrentscore += 5;
                                break;
                            case 6:
                                imageView.setImageResource(R.drawable.dice6);
                                mCurrentscore += 6;
                        }
                        animate(imageView);
                        currentScore.setText(Integer.toString(mCurrentscore));
                        if(i!=1 && j!=0){
                            handler.postDelayed(this,1000);
                        }
                        j--;
                    }
                    else {
                        if (j == 0) {
                            turn = !turn;
                            mComputerScore += mCurrentscore;
                            mCurrentscore = 0;
                            computerScore.setText(Integer.toString(mComputerScore));
                            currentScore.setText(Integer.toString(mCurrentscore));
                            b1.setEnabled(true);
                            b2.setEnabled(true);
                            Toast turnupdate = Toast.makeText(getApplicationContext(), "User's turn", Toast.LENGTH_SHORT);
                            turnupdate.show();
                        }
                        else  {
                            reset();
                            Toast winupdate = Toast.makeText(getApplicationContext(), "Computer wins", Toast.LENGTH_SHORT);
                            winupdate.show();
                            wintext.setText("computer wins...RESET to play again");
                            wintext.setVisibility(View.VISIBLE);
                            b1.setEnabled(false);
                            b2.setEnabled(false);
                        }
                    }
                    if(i==1) {
                        mCurrentscore = 0;
                        currentScore.setText("0");
                        b1.setEnabled(true);
                        b2.setEnabled(true);
                        Toast turnupdate = Toast.makeText(getApplicationContext(), "User's turn", Toast.LENGTH_SHORT);
                        turnupdate.show();
                        turn = !turn;
                }
                }
        }, 1000);

        }


    public void reset() {

        totalScoretext = (TextView) findViewById(R.id.textView6);
        totalScore = (TextView) findViewById(R.id.textView7);
        computerScoretext = (TextView) findViewById(R.id.textView8);
        computerScore = (TextView) findViewById(R.id.textView9);
        currentScoretext = (TextView) findViewById(R.id.textView10);
        currentScore = (TextView) findViewById(R.id.textView11);
        wintext=(TextView)findViewById(R.id.wintextView);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        totalScore.setText("0");
        mTotalScore = 0;
        mCurrentscore = 0;
        mComputerScore = 0;
        computerScore.setText(Integer.toString(mComputerScore));
        currentScore.setText(Integer.toString(mCurrentscore));
        b1.setEnabled(true);
        b2.setEnabled(true);
        wintext.setVisibility(View.INVISIBLE);
    }
    private void animate(final ImageView imageView){
        int fadeinduration=500;
        int timeinbetween=3000;
        int fadeoutduration=1000;
        Animation fadein=new AlphaAnimation(0,1);
        fadein.setInterpolator(new DecelerateInterpolator());
        fadein.setDuration(fadeinduration);

        Animation fadeout=new AlphaAnimation(1,0);
        fadeout.setInterpolator(new AccelerateInterpolator());
        fadeout.setStartOffset(fadeinduration+timeinbetween);
        fadeout.setDuration(fadeoutduration);

        AnimationSet animationSet=new AnimationSet(false);
        animationSet.addAnimation(fadein);
        animationSet.addAnimation(fadeout);
        animationSet.setRepeatCount(1);
        imageView.setAnimation(animationSet);

        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {


            }
        });
    }
}




