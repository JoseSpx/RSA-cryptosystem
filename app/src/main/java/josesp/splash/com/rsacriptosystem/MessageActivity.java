package josesp.splash.com.rsacriptosystem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import josesp.splash.com.rsacriptosystem.model.Exponentation;

public class MessageActivity extends AppCompatActivity {

    private ArrayList<String> characters = new ArrayList<>(Arrays.asList(
           //0   1
            "?"," ",
           //2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27
            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
           //28 29  30  31
            ".","_","-","\n",
            "1","2","3","4","5","6","7","8","9","0"
    ));

    private int n;
    private int d;
    private int e;

    @Override
    protected void onCreate(Bundle savedInstaceState){
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_create_message);

        Bundle bundle = getIntent().getExtras();
        n = Integer.valueOf(bundle.getString("n"));
        d = Integer.valueOf(bundle.getString("d"));
        e = Integer.valueOf(bundle.getString("e"));
        //System.out.println("Carac : - " + characters.get(56));
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

        ArrayList<String> listOfBlocks = getListOfBlocks(message);//recorreArray(listOfBlocks);
        ArrayList<String> textEncrypted = getTextEncrypted(listOfBlocks);
        if(listOfBlocks.get(listOfBlocks.size() - 1).equals("1")){
            listOfBlocks.remove(listOfBlocks.size()-1);
        }
        Intent intent = new Intent(this, EncryptedActivity.class);
        intent.putStringArrayListExtra("listOfBlocks",listOfBlocks);
        intent.putStringArrayListExtra("textEncrypted",textEncrypted);
        intent.putExtra("n",n);
        intent.putExtra("d",d);
        startActivity(intent);

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

    public ArrayList<String> getListOfBlocks(String message){
        int i;
        int code;
        String newCode;
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
        return list;
    }

    public ArrayList<String> getTextEncrypted(ArrayList<String> list){
        int size = list.size();
        System.out.println("Size : " + size);
        if(size %  2 == 1){
            list.add("01"); // espacio vacio
        }
        int counter;
        ArrayList<String> listOfTwoBlocks = new ArrayList<>();
        for(int i = 0; i < list.size() ; i = i + 2){
            counter = i;
            listOfTwoBlocks.add(list.get(counter)+list.get(++counter));
        }

        ArrayList<String> listSemiEncrypted = new ArrayList<>();
        int number;
        int exponentitation;
        for(int i = 0; i < listOfTwoBlocks.size() ; i++){
            number = Integer.valueOf(listOfTwoBlocks.get(i));
            exponentitation = Exponentation.getExponentation(number,e,n);
            listSemiEncrypted.add(convertToLenghtPair(exponentitation));
        }
        return listSemiEncrypted;
    }

    public String convertToLenghtPair(int number){
        String n = String.valueOf(number);
        if(n.length() % 2 == 1){
            return "0"+n;
        }
        return n;
    }

    public void closeKeyboard(){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow((findViewById(R.id.txtMessage)).getWindowToken(), 0);
    }

    public void enableUI(Boolean bool){
        (findViewById(R.id.txtMessage)).setEnabled(bool);
        (findViewById(R.id.btnEncode)).setEnabled(bool);
    }

    public void recorreArray(ArrayList<String> list){
        for(String a : list){
            System.out.println(a);
        }
    }

}
