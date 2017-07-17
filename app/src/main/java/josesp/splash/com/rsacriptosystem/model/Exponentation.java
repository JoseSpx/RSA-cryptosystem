package josesp.splash.com.rsacriptosystem.model;

import java.util.ArrayList;

public class Exponentation {

    public static int getExponentation(int a, int k, int n){ // base, exponente , Z
        String binario = getBinary(k);
        ArrayList<Integer> arregloK = convertToArray(binario);

        int i;
        int A;
        int b;
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
            A = (A*A) % n;
            if(arregloK.get(i) == 1){
                b = (A*b) % n;
            }
        }
        return b;
    }

    private static String getBinary(int numero){
        String binario = "";
        if (numero > 0) {
            while (numero > 0) {
                if (numero % 2 == 0) {
                    binario = "0" + binario;
                } else {
                    binario = "1" + binario;
                }
                numero = numero / 2;
            }
        }
        return binario;
    }
    
    private static ArrayList<Integer> convertToArray(String string){
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
