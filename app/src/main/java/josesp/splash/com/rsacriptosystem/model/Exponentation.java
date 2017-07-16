package josesp.splash.com.rsacriptosystem.model;

import java.util.ArrayList;

public class Exponentation {

    public static int getExponentation(int a, int k, int n){ // base, exponente , Z
        int binario = getBinary(k);
        ArrayList<Integer> arregloK = convertToArray(binario);

        int i;
        double A, b;
        int t = arregloK.size() - 1;
        b = 1;
        if(k == 0){
            return (int)b;
        }
        A = a;
        if(arregloK.get(0) == 1){
            b = a;
        }
        for(i = 1; i <= t ; i++){
            A = Math.pow(A, 2) % n;
            if(arregloK.get(i) == 1){
                b = (A*b) % n;
            }
        }
        return (int)b;
    }
    
    private static int getBinary(int numero){
        int exp=0;
        double binario=0;
        int digito;
        while(numero!=0){
                digito = numero % 2;            
                binario = binario + digito * Math.pow(10, exp);   
                exp++;
                numero = numero/2;
        }
        return (int)binario;
    }
    
    private static ArrayList<Integer> convertToArray(int number){
        String string = String.valueOf(number);
        int size = string.length();
        int i;
        ArrayList<Integer> arreglo = new ArrayList<>();
        int n;
        
        for(i = size - 1; i >= 0  ; i--){
            n = Integer.valueOf(String.valueOf(string.charAt(i)));
            arreglo.add(n);
        }
        return arreglo;
    }
    
}
