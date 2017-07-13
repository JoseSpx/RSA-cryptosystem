package josesp.splash.com.rsacriptosystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity{

    private final int SCREEN_DISPLAY_DELAY = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(timerTask,SCREEN_DISPLAY_DELAY);

    }

    public void hide(){
        View view = getWindow().getDecorView();
        int options = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        view.setSystemUiVisibility(options);
    }

}
