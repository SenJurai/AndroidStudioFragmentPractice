package com.example.rezasoltani.activity1;

/**
 * Created by reza.soltani on 2017-11-18.
 */

public class Calc {


    public Double sum(Double num1, Double num2)
    {
        return num1 + num2;
    }

    public Double sum(String num1, String num2)
    {
        Double dblNumber1 = Double.parseDouble(num1);
        Double dblNumber2 = Double.parseDouble(num2);
        return sum(dblNumber1, dblNumber2);
    }

    public Double sub(Double num1, Double num2)
    {
        return num1 - num2;
    }

    public Double sub(String num1, String num2)
    {
        Double dblNumber1 = Double.parseDouble(num1);
        Double dblNumber2 = Double.parseDouble(num2);
        return sub(dblNumber1, dblNumber2);
    }

    public Double div(Double num1, Double num2)
    {
        return num1 / num2;
    }

    public Double div(String num1, String num2)
    {
        Double dblNumber1 = Double.parseDouble(num1);
        Double dblNumber2 = Double.parseDouble(num2);
        return div(dblNumber1, dblNumber2);
    }
    public Double mul(Double num1, Double num2)
    {
        return num1 * num2;
    }
    public Double mul(String num1, String num2)
    {
        Double dblNumber1 = Double.parseDouble(num1);
        Double dblNumber2 = Double.parseDouble(num2);
        return mul(dblNumber1, dblNumber2);
    }

}
