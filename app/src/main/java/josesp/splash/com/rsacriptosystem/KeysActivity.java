package josesp.splash.com.rsacriptosystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class KeysActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keys);

        Bundle data = getIntent().getExtras();
        ((TextView)findViewById(R.id.txtN)).setText(data.getInt("n")+"");
        ((TextView)findViewById(R.id.txtE)).setText(data.getInt("e")+"");
        ((TextView)findViewById(R.id.txtD)).setText(data.getInt("d")+"");
    }

    public void btnExit_onclick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void btnCreateMessage_onClick(View view){

    }

}
