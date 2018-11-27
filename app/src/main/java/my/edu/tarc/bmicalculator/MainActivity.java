package my.edu.tarc.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_MESSAGE = "my.edu.tarc.bmicalculator.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view){
        EditText inputWeight, inputHeight;
        inputWeight = findViewById(R.id.weight);
        if(TextUtils.isEmpty(inputWeight.getText())){
            inputWeight.setError("Error, weight is empty!");
            return;
        }
        inputHeight = findViewById(R.id.height);
        if(TextUtils.isEmpty(inputHeight.getText())){
            inputHeight.setError("Error, height is empty!");
            return;
        }

        Double weight,height,bmi;
        weight = Double.parseDouble(inputWeight.getText().toString());
        height = Double.parseDouble(inputHeight.getText().toString());
        bmi = weight/height;

        String under, normal, over;
        under = "Under weight";
        normal =  "Normal weight";
        over = "Over weight";
        Intent intent = new Intent(this,SecondActivity.class);

        if(bmi<18.5){ //under
            intent.putExtra(TAG_MESSAGE, under);
        }else if(bmi>=18.5 && bmi <25){ //normal
            intent.putExtra(TAG_MESSAGE, normal);
        }else{ //over
            intent.putExtra(TAG_MESSAGE, over);
        }
        startActivity(intent);
    }
}
