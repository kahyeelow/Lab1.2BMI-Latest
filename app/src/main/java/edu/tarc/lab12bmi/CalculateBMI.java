package edu.tarc.lab12bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CalculateBMI extends AppCompatActivity {

    private EditText editTextWeight, editTextHeight;
    private TextView textViewResult;
    private ImageView imageViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_bmi);

        editTextWeight = (EditText)findViewById(R.id.editTextWeight);
        editTextHeight = (EditText)findViewById(R.id.editTextHeight);
        textViewResult = (TextView)findViewById(R.id.textViewResult);
        imageViewResult = (ImageView)findViewById(R.id.imageViewResult);
    }

    public void calculateBMI(View view)
    {
        double weight,height,bmi;
        String status;

        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());
        height /=100;

        bmi = weight / (height*height);

        if(bmi <= 18.5)
        {
            status =  "You are under weight.";
            imageViewResult.setImageResource(R.drawable.under);

        }
        else if(bmi >= 25)
        {
            status = "You are over weight.";
            imageViewResult.setImageResource(R.drawable.over);
        }
        else
        {
            status = "You are considered normal.";
            imageViewResult.setImageResource(R.drawable.normal);
        }

        textViewResult.setText(String.format("%.2f",bmi) + " " +status);


    }

    public void resetInput(View view)
    {
        editTextWeight.setText("");
        editTextHeight.setText("");
    }


}
