package com.lordprimustl.primaltutors;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lordprimustl.primaltutors.Adapters.topicAdapter;
import com.lordprimustl.primaltutors.Models.subject;
import com.lordprimustl.primaltutors.Models.topic;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

import static java.lang.System.out;

public class TopicActivity extends AppCompatActivity {

    ListView lv;
    topicAdapter ta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final int class_id = Integer.parseInt(getIntent().getStringExtra("class_id"));
        final int sub_id = Integer.parseInt(getIntent().getStringExtra("sub_id"));
        out.println(class_id);
        out.println(sub_id);
        //List<topic> e = Select.from(topic.class).where(Condition.prop("class_id").eq(class_id),Condition.prop("subject_id").eq(sub_id)).list();
        //List<topic> e = topic.listAll(topic.class);
        //List<topic> e = Select.from(topic.class).where(Condition.prop("class_id").eq(class_id),Condition.prop("subject_id").eq(sub_id)).list();
        List<topic> e = topic.findWithQuery(topic.class,"select * from TOPIC  where CLASSID = " + class_id +" and SUBJECTID = " + sub_id);
        out.println(e);
        lv = (ListView) findViewById(R.id.topic_rv);
        ta = new topicAdapter(this, e);

        lv.setAdapter(ta);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object o = lv.getItemAtPosition(i);
                topic t = (topic)o;
                Intent in = new Intent(TopicActivity.this, QuestionActivity.class);
                in.putExtra("class_id",String.valueOf(class_id));
                in.putExtra("sub_id",t.getSubject_id());
                in.putExtra("topic_id",t.getTopic_id());
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
