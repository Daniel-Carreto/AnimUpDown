package com.keychain.mdtheme;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView.getVisibility()== View.INVISIBLE){
                    int xValue = textView.getWidth()/2;
                    int yValue = textView.getHeight()/2;

                    int endRadiousValue = Math.max(textView.getWidth(),textView.getHeight());

                    Animator animator = ViewAnimationUtils.createCircularReveal(textView,xValue,yValue,0,endRadiousValue);
                    textView.setVisibility(View.VISIBLE);
                    animator.start();
                }else{
                    int xValue = textView.getWidth()/2;
                    int yValue = textView.getHeight()/2;

                    int startRadiousValue = textView.getWidth();

                    Animator animator = ViewAnimationUtils.createCircularReveal(textView,xValue,yValue,startRadiousValue,0);
                    animator.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            textView.setVisibility(View.INVISIBLE);
                        }
                    });
                    animator.start();
                }
            }
        });



    }
}
