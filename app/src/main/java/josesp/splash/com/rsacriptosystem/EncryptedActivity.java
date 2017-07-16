package josesp.splash.com.rsacriptosystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class EncryptedActivity extends AppCompatActivity {

    private ArrayList<String> listOfblocks;
    private ArrayList<String> textEncrypted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_encrpyted);

        ((TextView)(findViewById(R.id.txtBlocks))).setMovementMethod(new ScrollingMovementMethod());
        ((TextView)(findViewById(R.id.txtTextEncrypted))).setMovementMethod(new ScrollingMovementMethod());

        Bundle bundle = getIntent().getExtras();
        listOfblocks = bundle.getStringArrayList("listOfBlocks");
        textEncrypted = bundle.getStringArrayList("textEncrypted");

        ((TextView)(findViewById(R.id.txtBlocks))).setText(convertArrayListToString(listOfblocks));
        ((TextView)(findViewById(R.id.txtTextEncrypted))).setText(convertArrayListToString(textEncrypted));
    }

    public String convertArrayListToString(ArrayList<String> list){
        StringBuilder stringBuilder = new StringBuilder();
        for(String w : list){
            stringBuilder.append(w);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public void btnDescifrar_onclick(View view){

    }


}
