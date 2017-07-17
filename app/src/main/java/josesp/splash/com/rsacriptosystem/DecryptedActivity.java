package josesp.splash.com.rsacriptosystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class DecryptedActivity extends AppCompatActivity {

    private ArrayList<String> characters = new ArrayList<>(Arrays.asList(
            // "$","$","$","$","$","$","$","$","$","$",
            //0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25
            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
            //26  27  28  29  30  31  32  33  34  35  36  37  38  39  40  41  42  43 44  45  46  47  48  49  50  51
            "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
            //52  53  54  55  56  57  58  59  60  61  62  63
            "1","2","3","4","5","6","7","8","9","0"," ","?","ñ","Ñ",
            ".","_","-","\n",
            ";","#",":","(",")","+","-","¿","?","!","/","@",",","=","*","[","]","&","$","$","$","$","$","$","$","$",
            "$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$",
            "$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$","$"
    ));

    private int n;
    private int d;
    private int e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_decrpyted);

        ((TextView)(findViewById(R.id.txtDecryptedBlocks))).setMovementMethod(new ScrollingMovementMethod());
        ((TextView)(findViewById(R.id.txtTextDecrypted))).setMovementMethod(new ScrollingMovementMethod());

        Bundle bundle = getIntent().getExtras();
        ArrayList<String> list = bundle.getStringArrayList("list");
        n = bundle.getInt("n");
        d = bundle.getInt("d");
        e = bundle.getInt("e");

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

    public void btnSalir_onclick(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void btnAnotherMessage_onclick(View view){
        Intent intent = new Intent(this,MessageActivity.class);
        intent.putExtra("n",String.valueOf(n));
        intent.putExtra("d",String.valueOf(d));
        intent.putExtra("e",String.valueOf(e));
        startActivity(intent);
        finish();
    }

}
