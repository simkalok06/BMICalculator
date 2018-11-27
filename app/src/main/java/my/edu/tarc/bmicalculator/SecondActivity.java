package my.edu.tarc.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView weight;
        weight = findViewById(R.id.showWeight);

        Intent intent = getIntent();
        if(intent.hasExtra(MainActivity.TAG_MESSAGE)){
            String stringMsg;
            stringMsg = intent.getStringExtra(MainActivity.TAG_MESSAGE);
            weight.setText(stringMsg);
        }
    }
}
