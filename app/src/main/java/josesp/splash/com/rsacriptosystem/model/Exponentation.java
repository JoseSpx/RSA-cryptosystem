package josesp.splash.com.rsacriptosystem.model;

import java.util.ArrayList;

public class Exponentation {

    /*
    public static void main(String[] args) {
        int n = 7087051;
        int a = 111;
        int k = 1111;
        
        int binario = getBinary(k);
        ArrayList<Integer> arregloK = convertToArray(binario);
        System.out.println(arregloK);
        System.out.println("El resultado es : " + getExponentation(a, k, arregloK, n));
    }*/

    public static double getExponentation(int a, int k ,ArrayList<Integer> arregloK,int n){
        int i;
        double A, b;
        int t = arregloK.size() - 1;
        b = 1;
        if(k == 0){
            return b;
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
        return b;
    }
    
    public static int getBinary(int numero){
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
    
    public static ArrayList<Integer> convertToArray(int number){
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
