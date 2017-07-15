package josesp.splash.com.rsacriptosystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import josesp.splash.com.rsacriptosystem.model.ExtendedEuclideanAlgorithm;
import josesp.splash.com.rsacriptosystem.model.InverseMultiplication;
import josesp.splash.com.rsacriptosystem.model.Nodo;

public class ManualActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);
    }

    public void btnAccept_onClick(View view){
        String stringP = ((EditText)findViewById(R.id.editP)).getText().toString();
        String stringQ = ((EditText)findViewById(R.id.editQ)).getText().toString();
        String stringE = ((EditText)findViewById(R.id.editE)).getText().toString();

        if(stringP.isEmpty() || stringQ.isEmpty() || stringE.isEmpty()){
            Toast toast = Toast.makeText(this,"Complete los datos",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        if(stringP.length() != stringQ.length()){
            Toast toast = Toast.makeText(this,"Las longitudes de P y Q son diferentes",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        int p = Integer.parseInt(stringP);
        int q = Integer.parseInt(stringQ);
        int e = Integer.parseInt(stringE);
        int n = p * q;
        int phi = (p - 1) * (q - 1);

        Nodo nodo = ExtendedEuclideanAlgorithm.applyExtendedEuclideanAlgorithm(e,phi);
        if(nodo.getD() != 1 || e > phi || e < 1){
            Toast toast = Toast.makeText(this,"E no es válido",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        int d = InverseMultiplication.getInverse(phi, e);
        if( d == -1){
            Toast toast = Toast.makeText(this,"No existe inverso multiplicativo",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        /*
        Toast toast = Toast.makeText(this,"n = "+n+"  phi = "+phi+"  d = "+d,Toast.LENGTH_LONG);
        toast.show();
        */
        Intent intent = new Intent(this,KeysActivity.class);
        intent.putExtra("n",n);
        intent.putExtra("e",e);
        intent.putExtra("d",d);
        startActivity(intent);

    }

    public void btnCancel_onClick(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
