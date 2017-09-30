package com.lordprimustl.primaltutors;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lordprimustl.primaltutors.Models.question;
import com.lordprimustl.primaltutors.Models.subject;
import com.lordprimustl.primaltutors.Models.topic;
import com.orm.SugarContext;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class SplashScreen extends AppCompatActivity {

    SharedPreferences spref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        spref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor e = spref.edit();
        if(spref.getBoolean("FR",true))
        {
            List<question> w = question.listAll(question.class);
            out.println(w);

            int f = question.deleteAll(question.class);
            out.println(f);
            //subject.deleteAll(subject.class);

            List<subject> sub = new ArrayList<>();
            sub.add(new subject("1","Mathematics"));
            sub.add(new subject("2","English"));
            sub.add(new subject("3","Science"));
            sub.add(new subject("4","Civic Education"));
            sub.add(new subject("5","Social Studies"));
            subject.saveInTx(sub);
            List<subject> allsub = subject.listAll(subject.class);
            out.println(allsub);

            //Class_id, Subject_id, Topic_id
            List<topic> m = new ArrayList<>();
            m.add(new topic("2","1","1","NUMBER AND NUMERATION (1-1000)"));
            m.add(new topic("2","1","2","PLACE VALUE"));
            m.add(new topic("2","1","3","ADDITION AND SUBTRACTION"));
            m.add(new topic("2","1","4","MULTIPLICATION"));
            topic.saveInTx(m);


            List<topic> t = new ArrayList<>();
            t.add(new topic("2","2","1","NOUNS (SINGULAR AND PLURALS)"));
            t.add(new topic("2","2","2","NOUNS (PROPER, COMMON AND COLLECTIVE NOUNS)"));
            t.add(new topic("2","2","3","VERBS"));
            topic.saveInTx(t);
            e.putBoolean("FR",false).apply();



            //public question(String question, String optionA, String optionB, String optionC, String optionD, String answer, String class_id, String subject_id, String topic_id) {
            List<question> q = new ArrayList<>();
            q.add(new question("Two hundred and seventy-three is","372","732","273","272","273","2","1","1"));
            q.add(new question("Which of these is correct","526 > 581","207 > 270","300 < 279","502 > 205","502 > 205","2","1","1"));
            q.add(new question("The place value of 2 in 321 is","hundred","tens","unit","thousand","tens","2","1","2"));
            q.add(new question("Add the place value of 3 in 7435 and 23","30","303","33","330","273","2","1","2"));
            question.saveInTx(q);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, ClassActivity.class));
                finish();
            }
        }, 3000);


    }
}
