package josesp.splash.com.rsacriptosystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class KeysActivity extends AppCompatActivity {

    private String n;
    private String e;
    private String d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keys);

        Bundle data = getIntent().getExtras();
        n = data.getInt("n")+"";
        e = data.getInt("e")+"";
        d = data.getInt("d")+"";
        ((TextView)findViewById(R.id.txtN)).setText(n);
        ((TextView)findViewById(R.id.txtE)).setText(e);
        ((TextView)findViewById(R.id.txtD)).setText(d);
    }

    public void btnExit_onclick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void btnCreateMessage_onClick(View view){
        Intent intent = new Intent(this,MessageActivity.class);
        intent.putExtra("n",n);
        intent.putExtra("e",e);
        intent.putExtra("d",d);
        startActivity(intent);
    }

}
