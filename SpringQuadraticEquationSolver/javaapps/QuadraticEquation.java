package javaapps;

import java.util.ArrayList;

public class QuadraticEquation {
    private Double a, b, c;

    QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Double findDiscriminant(){
        return b*b - 4*a*c;
    }

    public ArrayList findRoots(){
        ArrayList alRoots = new ArrayList();
        Double discriminant = findDiscriminant();
        Double x1, x2;

        if (Math.abs(discriminant) < 2 * Double.MIN_VALUE) {
            x1 = (-b + Math.sqrt(findDiscriminant())) / (2*a);
            alRoots.add(x1);
        } else if (discriminant.compareTo(new Double("0.0")) > 0) {
            x1 = (-b + Math.sqrt(findDiscriminant())) / (2*a);
            x2 = (-b - Math.sqrt(findDiscriminant())) / (2*a);
            alRoots.add(x1);
            alRoots.add(x2);
        }
        return alRoots;
    }
}
