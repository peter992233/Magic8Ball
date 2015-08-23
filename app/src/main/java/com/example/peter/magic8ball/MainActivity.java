package com.example.peter.magic8ball;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Instantiating the UI
        EditText TextInput = (EditText) findViewById(R.id.TextInput);
        Button shakeButton = (Button) findViewById(R.id.ShakeButton);


        //When the ShakeButton is Pressed
        shakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AskQuestion();
            }
        });


        //When the Done Key is Pressed Keyboard
        TextInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if(actionId == EditorInfo.IME_ACTION_DONE){
                    AskQuestion();
                }
                return false;
            }
        });

    }


    public void createUI(){


    }



    //Ask Question to the UI
    public void AskQuestion(){
        Magic8BallModel EB = new Magic8BallModel();
        TextView responseText = (TextView) findViewById(R.id.Responder);
        responseText.setText(EB.getResponse());
        ChangeCircle();
    }

    public void ChangeCircle(){

        int iv1,iv2,iv3,iv4,iv5,iv6;
        ImageView Circle = (ImageView) findViewById(R.id.CircleImage);

        Random rand = new Random();
        int n = 6-1+1;
        int randomNum = rand.nextInt()%n;

        switch (randomNum){
            case 1:{
                Circle.setBackgroundResource(R.drawable.circle1);
                break;
            }
            case 2:{
                Circle.setBackgroundResource(R.drawable.circle2);
                break;
            }
            case 3:{
                Circle.setBackgroundResource(R.drawable.circle3);
                break;
            }
            case 4:{
                Circle.setBackgroundResource(R.drawable.circle4);
                break;
            }
            case 5:{
                Circle.setBackgroundResource(R.drawable.circle5);
                break;
            }
            case 6:{
                Circle.setBackgroundResource(R.drawable.circle6);
                break;
            }
            default:
                Circle.setBackgroundResource(R.drawable.circle1);

        }


        Handler hStopper = new Handler();
        hStopper.postDelayed(new Runnable() {
            @Override
            public void run() {
                ImageView img = (ImageView) findViewById(R.id.CircleImage);
                AlphaAnimation animation1 = new AlphaAnimation(0.0f,1.0f);
                animation1.setDuration(1000);
                img.startAnimation(animation1);
                img.startAnimation(animation1);
            }
        },1000);
    }


    //Ask Question to the Console
    public void ConsoleQuestion(Magic8BallModel MEB, String s){
        MEB.askQuestion(s);
    }

    public void lab1(){

        //This is the code from lab 1
        Log.d("DBG", "THIS IS A PRINT TO CONSOLE EXAMPLE");
        Log.d("DBG", "Peter Brown");
        double age = new Double(21.11111d);
        Log.d("DBG", String.format("%.2f", age));
        String name = new String("Peter Brown");
        Log.d("DBG", name);


        Magic8BallModel EightBall = new Magic8BallModel();
        ConsoleQuestion(EightBall, "Will i get good marks?");
        ConsoleQuestion(EightBall, "Is this thing on?");
        ConsoleQuestion(EightBall, "Should I Slap Jimmy?");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
