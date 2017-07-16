package josesp.splash.com.rsacriptosystem;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MessageActivity extends AppCompatActivity {

    private ArrayList<String> characters = new ArrayList<>(Arrays.asList(
            "?",
            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
            "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
            ".","_","-","\n"," ",
            "1","2","3","4","5","6","7","8","9","0"
    ));

    @Override
    protected void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_create_message);
    }

    public void btnEncode_onclick(View view){
        String message = ((EditText)(findViewById(R.id.txtMessage))).getText().toString();
        closeKeyboard();
        if(message.equals("")){
            Toast toast = Toast.makeText(this,"Mensaje Vacio",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,150);
            toast.show();
            return;
        }
        enableUI(false);
        (findViewById(R.id.progressBarMessage)).setVisibility(View.VISIBLE);
        int i;
        int code;
        String newCode;
        char c;
        ArrayList<String> list = new ArrayList<>();
        for(i = 0; i < message.length(); i++){
            code = getCode(message.charAt(i)+"");
            if(code == -1) {
                list.add("00");
            }else{
                newCode = convertToLenght2(code);
                list.add(newCode);
            }
        }
    }

    public int getCode(String a){
        int i;
        for(i = 0 ; i < characters.size() ; i++){
            if(characters.get(i).equals(a)){
                return i;
            }
        }
        return -1;
    }

    public String convertToLenght2(int number){
        String n = String.valueOf(number);
        if(n.length() == 2){
            return n;
        }
        return "0" + n;
    }

    public void closeKeyboard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow((findViewById(R.id.txtMessage)).getWindowToken(), 0);
    }

    public void enableUI(Boolean bool){
        (findViewById(R.id.txtMessage)).setEnabled(bool);
        (findViewById(R.id.btnEncode)).setEnabled(bool);
    }

}
