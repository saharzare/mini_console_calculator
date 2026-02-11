package org.example;

import java.util.ArrayList;

public class CalculatorService {
        public double sum(double a ,double b){
            return a+b;
        }
        public double subtract(double a ,double b){
            return a-b;
        }
        public double multiply(double a , double b){
            return a*b;
        }
        public double divide(double a, double b) throws InvalidOperationException {
            if (b == 0 ){
                throw new ArithmeticException (" **division to zero is not possible**");}

            return a/b;
        }
        public double rest(double a, double b){
            return a%b;
        }
// ----------------------Advanced Operation

        public double sum(ArrayList<Double> numbers){
            double sumation = 0;
            for(double n : numbers){
                sumation+= n;
            }
            return sumation;}
    
    //-----average----
        public double average(ArrayList<Double> numbers) throws InvalidOperationException {
            if(numbers.isEmpty()) {
            throw new InvalidOperationException("Can not calculate average of empty list");}

            return sum(numbers) / numbers.size();}
    
//------------minimum--------------
        public double min(ArrayList<Double> numbers) throws InvalidOperationException {
            if (numbers.isEmpty()){ throw new InvalidOperationException("not possible");}
            double minimum = numbers.getFirst() ;
            for(double n: numbers){ if (n < minimum){
                minimum = n;}}
            return minimum;}
//---------------maximum-------------------
        public double max(ArrayList<Double> numbers) throws InvalidOperationException {
            if (numbers.isEmpty()) {
                throw new InvalidOperationException("Not possible");}
            double maximum = numbers.getFirst();
            for (double n : numbers) {
                maximum = numbers.getFirst();
                if (n > maximum) {
                    maximum = n;
                }
            }
            return maximum;}
}
