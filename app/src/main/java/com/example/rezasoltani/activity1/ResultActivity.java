package com.example.rezasoltani.activity1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Double result = extras.getDouble("RESULT");

        TextView textview = (TextView) findViewById(R.id.txtResult);
        textview.setText(result.toString());

    }

    // this method will run when the Close button is clicked!
    public void close(View view)
    {
       // Toast.makeText(this,"close button is clicked!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(); // create a a new Intent
        intent.putExtra("MESSAGE", "Thank you for your using the calculator!"); // set the data
        setResult(RESULT_OK, intent); // set the data to be returned to the calling activity
        finish();  // close the activity

    }
}
