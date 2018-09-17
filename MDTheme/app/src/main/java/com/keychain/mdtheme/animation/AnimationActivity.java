package com.keychain.mdtheme.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeScroll;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.keychain.mdtheme.R;

public class AnimationActivity extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    Button btnTransition;
    GridLayout gridLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        imageView1 = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        btnTransition = (Button) findViewById(R.id.button);


        btnTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(gridLayout,new Slide());
                revealOrHideTheImages(imageView1,imageView2,imageView3,imageView4);
            }
        });
    }

    private void revealOrHideTheImages(View... image){
        for (View view: image) {
            boolean isImageVisible = view.getVisibility() == View.VISIBLE;
            view.setVisibility(isImageVisible ? View.INVISIBLE: View.VISIBLE);
        }
    }
}
