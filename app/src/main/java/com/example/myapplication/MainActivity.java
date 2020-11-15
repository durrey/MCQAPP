package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button ans1,ans2,ans3,ans4;
TextView score,ques;
private Questions myQuestion = new Questions();
private String myanswer;
private int myScore=0;
    int t=0;

private int len= myQuestion.myQuestions.length;
Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random=new Random();

        ans1=(Button) findViewById(R.id.ans1);
        ans2=(Button) findViewById(R.id.ans2);
        ans3=(Button) findViewById(R.id.ans3);
        ans4=(Button) findViewById(R.id.ans4);

        score=(TextView) findViewById(R.id.score);
        ques=(TextView) findViewById(R.id.ques);
        score.setText("Score : " + myScore);

        updateQ (t++);
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans1.getText() == myanswer)
                {
                    myScore++;
                    score.setText("Score : " + myScore);
                    updateQ(t++);
                }
                else
                {
                    score.setText("Score : " + myScore);
                    updateQ(t++);
                }

            }
        });

       ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ans2.getText() == myanswer)
                {
                    myScore++;
                    score.setText("Score : " + myScore);
                    updateQ(t++);
                }
                else
                {
                    score.setText("Score : " + myScore);
                    updateQ(t++);
                }

            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ans3.getText() == myanswer)
                {
                    myScore++;
                    score.setText("Score : " + myScore);
                    updateQ(t++);
                }
                else
                {
                    score.setText("Score : " + myScore);
                    updateQ(t++);
                }

            }
        });

        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans4.getText() == myanswer)
                {
                    myScore++;
                    score.setText("Score : " + myScore);
                    updateQ(t++);
                }
                else
                {
                    score.setText("Score : " + myScore);
                    updateQ(t++);
                }
            }
        });
    }
    private void updateQ(int n)
    {
        if(t>10)
        {
            end();
        }
        else {
            ques.setText(myQuestion.getQues(n));
            ans1.setText(myQuestion.getAns1(n));
            ans2.setText(myQuestion.getAns2(n));
            ans3.setText(myQuestion.getAns3(n));
            ans4.setText(myQuestion.getAns4(n));

            myanswer = myQuestion.getCorrectans(n);

        }
    }

    private void end()
    {
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("You Scored " + myScore + " / 10.")
                .setCancelable(false)
                .setPositiveButton("New Quiz", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                })

                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog alertDialog= alertDialogBuilder.create();
        alertDialog.show();

    }
}