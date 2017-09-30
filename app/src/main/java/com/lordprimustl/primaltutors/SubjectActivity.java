package com.lordprimustl.primaltutors;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.lordprimustl.primaltutors.Adapters.subjectAdapter;
import com.lordprimustl.primaltutors.Models.subject;

import java.util.List;

import static java.lang.System.out;

public class SubjectActivity extends AppCompatActivity {

    subjectAdapter sa;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Select Subject");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        lv = (ListView) findViewById(R.id.subject_rv);
        final int class_id = getIntent().getIntExtra("class", 0);
        out.println("Class ID from Subject---------------------------------");
        out.println(class_id);
        List<subject> sub = subject.listAll(subject.class);
        out.println(sub);
        sa = new subjectAdapter(this, sub);
        lv.setAdapter(sa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object o = lv.getItemAtPosition(i);
                subject s = (subject)o;
                Intent in = new Intent(SubjectActivity.this, TopicActivity.class);
                in.putExtra("class_id",String.valueOf(class_id));
                in.putExtra("sub_id",s.getSub_id());
                startActivity(in);
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
            }
        });
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_up,R.anim.slide_bottom);
    }
}
