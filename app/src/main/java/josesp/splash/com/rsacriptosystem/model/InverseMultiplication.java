package josesp.splash.com.rsacriptosystem.model;

import java.math.BigInteger;

public class InverseMultiplication {

    public static int getInverse2(int z,int number){
        int i ;
        long y, d;
        Nodo nodo;

        nodo = ExtendedEuclideanAlgorithm.applyExtendedEuclideanAlgorithm(number,z);
        if(nodo.getD() != 1){
            return -1;
        }

        for(i = 2; i < z ; i++){
            nodo = ExtendedEuclideanAlgorithm.applyExtendedEuclideanAlgorithm(i,z);
            y = nodo.getY();
            d = (number * i) + (z * y);
            if( d == 1){
                return i;
            }
        }

        return -1;
    }

    public static int getInverse(int z,int number){
        int i ;
        Nodo nodo = ExtendedEuclideanAlgorithm.applyExtendedEuclideanAlgorithm(number,z);
        if(nodo.getD() != 1){
            return -1;
        }

        BigInteger bigZ = BigInteger.valueOf(z);
        BigInteger bigNumber = BigInteger.valueOf(number);
        BigInteger bigD;
        BigInteger bigI;
        BigInteger bigMenos1 = BigInteger.valueOf(1);
        BigInteger bigCero = BigInteger.valueOf(0);
        BigInteger multi;

        for(i = 2; i < z ; i++){
            bigI = BigInteger.valueOf(i);
            multi = bigNumber.multiply(bigI);
            bigD = multi.subtract(bigMenos1);
            if(bigD.mod(bigZ).equals(bigCero)){
                return i;
            }
            //System.out.println(i);
        }

        return -1;
    }


}
