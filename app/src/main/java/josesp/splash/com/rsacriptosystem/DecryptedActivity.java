package josesp.splash.com.rsacriptosystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class DecryptedActivity extends AppCompatActivity {

    private ArrayList<String> characters = new ArrayList<>(Arrays.asList(
            "?"," ",
            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
            ".","_","-","\n",
            "1","2","3","4","5","6","7","8","9","0"
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_decrpyted);

        ((TextView)(findViewById(R.id.txtDecryptedBlocks))).setMovementMethod(new ScrollingMovementMethod());
        ((TextView)(findViewById(R.id.txtTextDecrypted))).setMovementMethod(new ScrollingMovementMethod());

        Bundle bundle = getIntent().getExtras();
        ArrayList<String> list = bundle.getStringArrayList("list");

        ArrayList<String> listSeparate = separate(list);
        String textBlocks = convertArrayToString(listSeparate);
        String text = decrypt(listSeparate); // ocurre error

        ((TextView)(findViewById(R.id.txtDecryptedBlocks))).setText(textBlocks);
        ((TextView)(findViewById(R.id.txtTextDecrypted))).setText(text);
    }

    private ArrayList<String> separate(ArrayList<String> list) {
        ArrayList<String> listSeparate = new ArrayList<>();
        String aux;
        for(int i = 0; i < list.size() ; i++){
            aux = list.get(i);
            listSeparate.add(aux.substring(0,2));
            listSeparate.add(aux.substring(2,4));
        }
        return listSeparate;
    }

    private String convertArrayToString(ArrayList<String> list) {
        StringBuilder string = new StringBuilder();
        for(int i = 0 ; i < list.size() ; i++){
            string.append(list.get(i));
            string.append(" ");
        }
        return string.toString();
    }

    private String decrypt(ArrayList<String> list){
        int i, n;
        StringBuilder text = new StringBuilder();
        for(i = 0; i < list.size() ; i++){
            n = Integer.valueOf(list.get(i));
            text.append(characters.get(n));
        }
        return text.toString();
    }
}
