package com.example.peter.magic8ball;

import android.app.ActionBar;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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


        RelativeLayout relativeLayout_623 = new RelativeLayout(this);
        RelativeLayout.LayoutParams layout_796 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        relativeLayout_623.setLayoutParams(layout_796);

        EditText TextInput = new EditText(this);
        TextInput.setId(R.id.TextInput);
        TextInput.setRawInputType(InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
        RelativeLayout.LayoutParams  layout_532 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,50,getResources().getDisplayMetrics()));
        TextInput.setSingleLine();
        TextInput.setLayoutParams(layout_532);
        relativeLayout_623.addView(TextInput);

        RelativeLayout ImageContainer = new RelativeLayout(this);
        ImageContainer.setId(R.id.ImageContainer);
        RelativeLayout.LayoutParams layout_947 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layout_947.addRule(RelativeLayout.BELOW, TextInput.getId());
        ImageContainer.setLayoutParams(layout_947);

        ImageView Background = new ImageView(this);
        Background.setId(R.id.Background);
        Background.setBackgroundResource(R.drawable.background);
        RelativeLayout.LayoutParams layout_825 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layout_825.addRule(RelativeLayout.BELOW,TextInput.getId());
        Background.setLayoutParams(layout_825);
        ImageContainer.addView(Background);

        ImageView CircleImage = new ImageView(this);
        CircleImage.setId(R.id.CircleImage);
        CircleImage.setBackgroundResource(R.drawable.circle1);
        RelativeLayout.LayoutParams layout_622 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);;
        CircleImage.setLayoutParams(layout_622);
        ImageContainer.addView(CircleImage);
        relativeLayout_623.addView(ImageContainer);

        Button ShakeButton = new Button(this);
        ShakeButton.setText("SHAKE");
        ShakeButton.setId(R.id.ShakeButton);
        RelativeLayout.LayoutParams layout_333 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        layout_333.addRule(RelativeLayout.BELOW, ImageContainer.getId());
        ShakeButton.setLayoutParams(layout_333);
        relativeLayout_623.addView(ShakeButton);

        TextView Responder = new TextView(this);
        Responder.setText(getResources().getString(R.string.blank));
        Responder.setId(R.id.Responder);
        Responder.setTextSize((30 / getApplicationContext().getResources().getDisplayMetrics().density));
        Responder.setGravity(Gravity.CENTER);
        Responder.setTypeface(Typeface.DEFAULT_BOLD);
        Responder.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        RelativeLayout.LayoutParams layout_756 = new RelativeLayout.LayoutParams(300, RelativeLayout.LayoutParams.WRAP_CONTENT);
        Responder.setLayoutParams(layout_756);
        relativeLayout_623.addView(Responder);


        setContentView(relativeLayout_623);

        //When the ShakeButton is Pressed
        ShakeButton.setOnClickListener(new View.OnClickListener() {
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


        ImageView img = (ImageView) findViewById(R.id.CircleImage);
        AlphaAnimation animation1 = new AlphaAnimation(0.0f,1.0f);
        animation1.setDuration(1000);
        img.startAnimation(animation1);
        img.startAnimation(animation1);
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
