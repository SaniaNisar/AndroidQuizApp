package com.app.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        FrameLayout logoContainer = findViewById(R.id.logoContainer);

        // Animation is applied to both the logo(squared) & circle background too
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.logo_animation);
        logoContainer.startAnimation(animation);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, StartActivity.class));
            finish();
        }, 3000);
    }
}
