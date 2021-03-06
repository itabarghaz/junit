package com.junit;

public class Calcul {

    ICalculService calculService;

    public Calcul(ICalculService calculService) {
        this.calculService = calculService;
    }

    public int somme(int x, int y) {
        return x + y;
    }
    public int division(int x, int y) {
        if (y == 0)
            throw new ArithmeticException();
        return
                x / y;
    }
    public int sommeCarre(int x, int y) {
        return somme(calculService.carre(x), calculService.carre(y));
    }


}
