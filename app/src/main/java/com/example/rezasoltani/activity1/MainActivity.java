package com.example.rezasoltani.activity1;


import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    static final String MYAPP = "MYAPP";


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // get the response from second activity

        // is this method called by the second activity that we know!
        if (requestCode == 0)
        {
            // is everything okay..
            if (resultCode == RESULT_OK)
            {
                // read the data
                String message = data.getStringExtra("MESSAGE");


                // show the data as a toast
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();


            }
        }


    }


    @Override
    protected void onStart() {
        super.onStart();

        Log.d(MYAPP, "My activity just started - onStart!!");


    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(MYAPP, "My activity just stopped - onStop!!");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(MYAPP, "My activity just stopped - onDestroy!!");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(MYAPP, "My activity just stopped - onPause!!");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(MYAPP, "My activity just started - onResume!!");
    }




    // method 2 to connect a button to a method
    public void multi(View view)
    {
        EditText etxNumber1 = (EditText) findViewById(R.id.etxNumber1);
        String number1 = etxNumber1.getText().toString();

        Toast.makeText(this, "The multi button is clicked!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Add the welcome fragment when the activity Start!
        FragmentManager fg = getSupportFragmentManager();
        FragmentTransaction ft = fg.beginTransaction();

        WelcomeFragment welcomeFragment = new WelcomeFragment();
        ft.add(R.id.fragmentContainer, welcomeFragment);
        ft.commit();


         // third approach
        //Button btnSub = (Button) findViewById(R.id.btnSub);
       // btnSub.setOnClickListener(this);



        // The code for button 2 which does division
        //Button btnDivide = (Button) findViewById(R.id.btnDivide);


        // I dont need this listener anymore...

//        btnDivide.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Here we are suppose divide the two given numbers!
//
//                // commenting out the Toast because we don't need it for now
//                // Toast.makeText(getApplicationContext(), "The button 2 is clicked!", Toast.LENGTH_SHORT).show();
//
//                // Read # from first edittext
//
//                EditText etxNumber1 = (EditText) findViewById(R.id.etxNumber1);
//                String number1 = etxNumber1.getText().toString();
//
//
//                // Read second # from second edittext
//                EditText etxNumber2 = (EditText) findViewById(R.id.etxNumber2);
//                String number2 = etxNumber2.getText().toString();
//
//
//                // Do that math
//                Calc calc = new Calc();
//                Double result = calc.div(number1, number2);
//
//
//                // Display the result
//                // Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
//
//                // open second activity and show the result there!
//                Intent intent = new Intent(getApplicationContext(), ResultActivity.class );
//                intent.putExtra("RESULT", result);
//                startActivityForResult(intent, 0);
//
//            }
//        });

        Log.d(MYAPP, "My activity just started - onCreate!!");

    }




    // all buttons point to this method!
    @Override
    public void onClick(View v) {

        EditText etxNumber1 = (EditText) findViewById(R.id.etxNumber1);
        String number1 = etxNumber1.getText().toString();


        // Read second # from second edittext
        EditText etxNumber2 = (EditText) findViewById(R.id.etxNumber2);
        String number2 = etxNumber2.getText().toString();

        // Input validation
        if (number1.isEmpty())
        {

           // Toast.makeText(this, "Please enter a valid number in the first field", Toast.LENGTH_SHORT).show();

            AlertDialog.Builder b = new AlertDialog.Builder(this);
            b.setTitle("Problem with Input");
            b.setMessage("Please enter a valid number for first field ");
            b.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
               @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            AlertDialog mydialog = b.create();
            mydialog.show();
              return;
        }
        if (number2.isEmpty())
        {
            Toast.makeText(this, "Please enter a valid number for second field", Toast.LENGTH_SHORT).show();
            return;
        }

        // for the two zeros case
            if(Double.parseDouble(number1) ==0 && Double.parseDouble(number2)==0){
                AlertDialog.Builder a = new AlertDialog.Builder(this);
                a.setTitle("Problem with Input");
                a.setMessage("Please enter valid numbers in the fields! ");
                a.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog mydialog = a.create();
                mydialog.show();
                return;

            }


        if (Double.parseDouble(number2)==0) {
            FragmentManager a = getSupportFragmentManager();
            FragmentTransaction ft2 = a.beginTransaction();
            ErrorFragment errorFragment = new ErrorFragment();
            Bundle mydata2 = new Bundle();
            mydata2.putString("ERROR", "Please add a valid number in the second field");
            errorFragment.setArguments(mydata2);
            ft2.replace(R.id.fragmentContainer, errorFragment);
            ft2.commit();
            return;
        }

        Calc calc = new Calc();

        Double result = 0.0;
        String symbol = ".";

        if (v.getId() == R.id.btnAdd)
        {
            // Do that math

            result = calc.sum(number1, number2);
            symbol = "+";
            // do the add
        }
        else if (v.getId() == R.id.btnDivide)
        {
            // do the division

            result = calc.div(number1, number2);
            symbol = "/";

        }
        else if (v.getId() == R.id.btnMultiply)
        {

            result = calc.mul(number1, number2);
            symbol = "*";
            // do the multiplcation
        }
        else if (v.getId() == R.id.btnSub)
        {

            result = calc.sub(number1, number2);
            symbol = "-";
            // do the subtration
        }



        // store the operation in the  bottom history fragment!
        String data = number1 + symbol + number2 + " = " + result;
        ResultFragment resultFragment =
                (ResultFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_result);
        resultFragment.getData(data);


        // add a new fragment that shows th result of the operation

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        AnswerFragment answerFragment = new AnswerFragment();

        // get the math result and put it in a bundle and pass it to the fragment
        Bundle mydata = new Bundle();
        mydata.putString("ANSWER", result.toString());
        answerFragment.setArguments(mydata);

        ft.replace(R.id.fragmentContainer, answerFragment);
        // you can keep track of all transactions(fragment) by uncommenting the following line
        //ft.addToBackStack(null);

        ft.commit();

        // open second activity and show the result there!
        //Intent intent = new Intent(getApplicationContext(), ResultActivity.class );
        //intent.putExtra("RESULT", result);
        //startActivityForResult(intent, 0);
// th bundle for the second error fragment

    }
}
