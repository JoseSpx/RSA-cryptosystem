package josesp.splash.com.rsacriptosystem.model;

public class InverseMultiplication {

    public static int getInverse(int z,int number){
        int i , n ,x, y , d;
        Nodo nodo;

        nodo = ExtendedEuclideanAlgorithm.applyExtendedEuclideanAlgorithm(number,z);
        if(nodo.getD() != -1){
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

}
