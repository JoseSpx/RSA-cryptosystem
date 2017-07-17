package josesp.splash.com.rsacriptosystem;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
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
        new Generatekeys().execute();
    }

    public void btnCancel_onClick(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }


    private class Generatekeys extends AsyncTask<Void,Void,Integer>{

        private ProgressBar progressBar;

        private String stringP;
        private String stringQ;
        private String stringE;

        private int n;
        private int e;
        private int d;

        private final int empty = 1;
        private final int lenghtPQ = 2;
        private final int eInvalid = 3;
        private final int noExistsInverseM = 4;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            enableUI(false);
            stringP = ((EditText)findViewById(R.id.editP)).getText().toString();
            stringQ = ((EditText)findViewById(R.id.editQ)).getText().toString();
            stringE = ((EditText)findViewById(R.id.editE)).getText().toString();

            progressBar = (ProgressBar)findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            if(stringP.isEmpty() || stringQ.isEmpty() || stringE.isEmpty()){
                return empty;
            }

            int p = Integer.parseInt(stringP);
            int q = Integer.parseInt(stringQ);
            e = Integer.parseInt(stringE);
            n = p * q;
            int phi = (p - 1) * (q - 1);
            Nodo nodo = ExtendedEuclideanAlgorithm.applyExtendedEuclideanAlgorithm(phi,e);

            if(nodo.getD() != 1 || e > phi || e < 1){
                return eInvalid;
            }

            d = InverseMultiplication.getInverse(phi, e);

            if(d == -1){
                return noExistsInverseM;
            }

            return 5;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Integer data) {
            super.onPostExecute(data);
            if(data == empty){
                Toast toast = Toast.makeText(getBaseContext(),"Complete los datos",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 130);
                toast.show();
                enableUI(true);
                progressBar.setVisibility(View.INVISIBLE);
            }
            else if(data == eInvalid){
                Toast toast = Toast.makeText(getBaseContext(),"E no es válido",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 130);
                toast.show();
                enableUI(true);
                progressBar.setVisibility(View.INVISIBLE);
            }
            else if(data == noExistsInverseM){
                Toast toast = Toast.makeText(getBaseContext(),"No existe inverso multiplicativo",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 130);
                toast.show();
                enableUI(true);
                progressBar.setVisibility(View.INVISIBLE);
            }
            else{
                Intent intent = new Intent(getBaseContext(),KeysActivity.class);
                intent.putExtra("n",n);
                intent.putExtra("e",e);
                intent.putExtra("d",d);
                startActivity(intent);
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        private void enableUI(Boolean bool){
            findViewById(R.id.editP).setEnabled(bool);
            findViewById(R.id.editQ).setEnabled(bool);
            findViewById(R.id.editE).setEnabled(bool);
            findViewById(R.id.btnAccept).setClickable(bool);
            findViewById(R.id.btnCancelar).setClickable(bool);
        }

    }

}
