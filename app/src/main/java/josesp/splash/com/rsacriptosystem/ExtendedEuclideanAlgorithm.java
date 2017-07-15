package josesp.splash.com.rsacriptosystem;

public class ExtendedEuclideanAlgorithm {

    /*public static void main(String[] args) {

        int a = 34;
        int b = 3;


        Nodo nodo = applyExtendedEuclideanAlgorithm(a, b);
        System.out.println("El Maximo comun Divisor es :  : "+nodo.getD() + "  X : "+nodo.getX() + " Y : "+nodo.getY());
        System.out.println("El contador es : " + nodo.getContador());
        System.out.println("Comprobando propiedad : ");
        Boolean band = comprobarPropiedad(a, b, nodo.getD());
        System.out.println("La propiedad es " + band);
    }*/

    public static Nodo applyExtendedEuclideanAlgorithm(int a, int b){
        Nodo nodo = new Nodo();
        if(b == 0){
            nodo.setD(a);
            nodo.setX(1);
            nodo.setY(0);
            nodo.setContador(0);
        }
        else{
            int x1 = 0, x2 = 1, y1 = 1, y2 = 0, q = 0, r, x, y;
            int c = 0;
            while(b > 0){
                c++;
                System.out.println("------Paso : " + c);
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
                System.out.println("q : "+ q +"  r : "+ r + " x : "
                        + x + "  y : "+ y + " a : "+ a + " b : "+ b
                        + " x2 : " + x2 + " x1 : "+ x1 + " y2 : "+ y2 + " y1 : " + y1);
            }
            nodo.setD(a);
            nodo.setX(x2);
            nodo.setY(y2);
            nodo.setContador(c);
        }
        return nodo;
    }

    public static Boolean comprobarPropiedad(int a, int b, int d){
        int number1 = (int)Math.pow(2,d) - 1;
        Nodo nodo = applyExtendedEuclideanAlgorithm((int)Math.pow(2,a) - 1,(int)Math.pow(2,b) - 1);
        return number1 == nodo.getD();
    }

}

