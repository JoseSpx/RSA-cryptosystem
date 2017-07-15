package josesp.splash.com.rsacriptosystem.model;

public class ExtendedEuclideanAlgorithm {

    public static Nodo applyExtendedEuclideanAlgorithm(long a, long b){
        Nodo nodo = new Nodo();
        if(b == 0){
            nodo.setD(a);
            nodo.setX(1);
            nodo.setY(0);
        }
        else{
            long x1 = 0, x2 = 1, y1 = 1, y2 = 0, q , r, x, y;
            while(b > 0){
                q = a / b;
                r = a - (b * q);
                x = x2 - q * x1;
                y = y2 - q * y1;
                a = b;
                b = r;
                x2 = x1;
                x1 = x;
                y2 = y1;
                y1 = y;
            }
            nodo.setD(a);
            nodo.setX(x2);
            nodo.setY(y2);
        }
        return nodo;
    }


}

