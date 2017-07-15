package josesp.splash.com.rsacriptosystem;

public class InverseMultiplication {

    public static int getInverse(int z,int number){

        int i , n ,x, y , d;

        Nodo nodo;

        for(i = 0; i < z ; i++){
            nodo = ExtendedEuclideanAlgorithm.applyExtendedEuclideanAlgorithm(i,z);
            if( nodo.getD() == 1){
                y = nodo.getY();
                d = (number * i) + (z * y);

                if( d == 1){
                    return i;
                }
            }
        }

        return -1;
    }

}
