package josesp.splash.com.rsacriptosystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import josesp.splash.com.rsacriptosystem.model.Exponentation;

public class EncryptedActivity extends AppCompatActivity {

    private ArrayList<String> listOfblocks;
    private ArrayList<String> textEncrypted;
    private int d;
    private int n;
    private int e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_encrpyted);

        ((TextView)(findViewById(R.id.txtBlocks))).setMovementMethod(new ScrollingMovementMethod());
        ((TextView)(findViewById(R.id.txtTextEncrypted))).setMovementMethod(new ScrollingMovementMethod());

        Bundle bundle = getIntent().getExtras();
        listOfblocks = bundle.getStringArrayList("listOfBlocks");
        textEncrypted = bundle.getStringArrayList("textEncrypted");
        n = bundle.getInt("n");
        d = bundle.getInt("d");
        e = bundle.getInt("e");

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
        ArrayList<String> list = new ArrayList<>();
        int aux;
        int exponentation;
        for(int i = 0; i < textEncrypted.size() ; i++){
            aux = Integer.valueOf(textEncrypted.get(i));
            exponentation = Exponentation.getExponentation(aux,d,n);
            list.add(convertTo4Digits(exponentation));
        }

        Intent intent = new Intent(this, DecryptedActivity.class);
        intent.putStringArrayListExtra("list",list);
        intent.putExtra("n",n);
        intent.putExtra("d",d);
        intent.putExtra("e",e);
        startActivity(intent);
    }

    public String convertTo4Digits(int number){
        String n = String.valueOf(number);
        if(n.length()  == 1){
            return "000" + n;
        }else if(n.length() == 2){
            return "00" + n;
        }else if(n.length() == 3){
            return "0" + n;
        }
        return n;
    }

    public void btnAnotherMessageEncrypt_onclick(View view){
        Intent intent = new Intent(this,MessageActivity.class);
        intent.putExtra("n",String.valueOf(n));
        intent.putExtra("d",String.valueOf(d));
        intent.putExtra("e",String.valueOf(e));
        startActivity(intent);
        finish();
    }

}
