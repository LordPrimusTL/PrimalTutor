package com.lordprimustl.primaltutors;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lordprimustl.primaltutors.Models.question;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

import static java.lang.System.out;

public class QuestionActivity extends AppCompatActivity {
    List<question> ques;
    Toolbar toolbar;
    TextView questv,ttv;
    RadioGroup rgb;
    RadioButton A,B,C,D,ans;
    Button smtbtn;
    int score = 0;
    CardView cv;

    int x = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qusetion);
        toolbar = (Toolbar) findViewById(R.id.qtoolbar);
        setSupportActionBar(toolbar);
        int class_id = Integer.parseInt(getIntent().getStringExtra("class_id"));
        int sub_id = Integer.parseInt(getIntent().getStringExtra("sub_id"));
        int topic_id = Integer.parseInt(getIntent().getStringExtra("topic_id"));
        out.println(class_id);
        out.println(sub_id);
        out.println(topic_id);
        ttv = (TextView) findViewById(R.id.qwerty);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rgb = (RadioGroup) findViewById(R.id.rdgrp);
        smtbtn = (Button) findViewById(R.id.btnSubmit);
        questv = (TextView) findViewById(R.id.ques);
        cv = (CardView) findViewById(R.id.quesCard);
        A = (RadioButton) findViewById(R.id.optA);
        B = (RadioButton) findViewById(R.id.optB);
        C = (RadioButton) findViewById(R.id.optC);
        D = (RadioButton) findViewById(R.id.optD);
        //List<question> ques = Select.from(question.class).where(Condition.prop("CLASSID").eq(class_id),Condition.prop("SUBJECTID").eq(sub_id),Condition.prop("TOPICID").eq(topic_id)).list();
        ques = question.findWithQuery(question.class,"select * from QUESTION  where CLASSID = " + class_id +" and SUBJECTID = " + sub_id + " and TOPICID = " + topic_id);
        out.println(ques);
        setUpData();
    }

    private void setUpData() {
        if((x) < ques.size())
        {
            ttv.setText("Question " + (x + 1));
            if(ques == null || ques.size() < 1)
            {
                onBackPressed();
            }
            else{
                questv.setText(ques.get(x).getQuestion());
                A.setText(ques.get(x).getOptionA());
                B.setText(ques.get(x).getOptionB());
                C.setText(ques.get(x).getOptionC());
                D.setText(ques.get(x).getOptionD());

                smtbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int sel = rgb.getCheckedRadioButtonId();
                        ans = (RadioButton) findViewById(sel);
                        out.println(ans.getText().toString());
                        out.println(ques.get(x).getAnswer());
                     if(ans.getText().toString().equals(ques.get(x).getAnswer()))
                        {
                            score = score + 1;
                            Snackbar.make(toolbar,"Correct Answer!", Snackbar.LENGTH_LONG).show();
                            x = x + 1;
                            setUpData();
                        }
                        else
                        {
                            Snackbar.make(toolbar,"Wrong, Answer is " + ques.get(x).getAnswer(), Snackbar.LENGTH_LONG).show();
                            x = x + 1;
                            setUpData();
                        }

                    }
                });
            }

        }
        else{
            cv.setEnabled(false);
            rgb.setEnabled(false);
            //smtbtn.setEnabled(false);
            smtbtn.setText("Restart Quiz");
            smtbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    x = 0;
                    score = 0;
                    smtbtn.setText("Submit");
                    setUpData();
                }
            });
            Snackbar.make(toolbar,"Score is " + score, Snackbar.LENGTH_INDEFINITE).show();
        }

    }

    public void DialogMan(int c)
    {
        AlertDialog.Builder ab = new AlertDialog.Builder(QuestionActivity.this);
        if(c == 1)
            ab.setView(R.layout.rightans);
        else
            ab.setView(R.layout.wrong);
        ab.setCancelable(false);
        ab.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                x = x + 1;
                dialogInterface.dismiss();
                setUpData();
            }
        }).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_up, R.anim.slide_bottom);
    }
}
