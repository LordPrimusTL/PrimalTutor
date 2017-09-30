package com.lordprimustl.primaltutors;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lordprimustl.primaltutors.Models.question;

import java.util.List;

import static java.lang.System.out;

public class ClassActivity extends AppCompatActivity {

    CardView c1, c2, c3, c4, c5, c6;
    CoordinatorLayout cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Select Class");
        toolbar.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        setSupportActionBar(toolbar);

        c1 = (CardView) findViewById(R.id.YearOne);
        c2 = (CardView) findViewById(R.id.YearTwo);
        c3 = (CardView) findViewById(R.id.YearThree);
        c4 = (CardView) findViewById(R.id.YearFour);
        c5 = (CardView) findViewById(R.id.YearFive);
        c6 = (CardView) findViewById(R.id.YearSix);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(cd,"You Clicked On Year One",Snackbar.LENGTH_SHORT).show();
                onClassClicked(1);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClassClicked(2);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClassClicked(3);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClassClicked(4);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClassClicked(5);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClassClicked(6);
            }
        });





    }

    private void onClassClicked(int j)
    {
        Intent i = new Intent(ClassActivity.this, SubjectActivity.class);
        i.putExtra("class",j);
        startActivity(i);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
    }

}
