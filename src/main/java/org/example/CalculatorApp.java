package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CalculatorApp {
    public static void main(String[] args) throws InvalidOperationException {
        Scanner scanner = new Scanner(System.in);
        //new object of class
        CalculatorService calculator = new CalculatorService();
        HistoryService history = new HistoryService();

        boolean runningCalculator = true;
        while (runningCalculator) {
            System.out.println("""
                    ---- Mini Calculator ----
                    1. Simple Operation(Tow numbers)
                    2. Advanced Operation(List)
                    3. Show History
                    4. Clear History
                    0. Exit
                    """);
            System.out.println("Now Your Choice:");
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 0 -> runningCalculator = false;
                    case 1 -> simpleOperation(scanner, calculator,history);
                    case 2 -> advancedOperation(scanner,calculator,history);
                    case 3 -> history.show();
                    case 4 -> history.clear();
                    default -> throw new InvalidOperationException("Invalid");

                }
            } catch (Exception e ) {
                System.out.println("Error for enter the input");
                scanner.nextLine();
            }

        }
    }

        //---------method declaration---
        //این متود فقط برای منو داخلی برنامه است (فقط داخل همین کلاس استفاده میشه) پرایویت باشه
        //چون از برنامه مین صدا زده میشه پس استاتیک
        //مین خودش استاتیکه و فقط میشه متودهای استاتیک رو اوش صدا زد
        //وید ینی این متود چیزی برنمیگردونه فقط عملیات انجام میده
        //متود همیشه کملکیسه
        //ابزارهایی که این متود برای کارش لازم داره در داخل پرانتز بعنوان پارامتر نوشته شده
        private static void simpleOperation
        (Scanner scanner,CalculatorService calculator,HistoryService history ) throws InvalidOperationException {
            System.out.println("1- enter you first number:");
            double a = scanner.nextDouble();

            System.out.println("2- enter you second number:");
            double b = scanner.nextDouble();

            System.out.println("3- enter the operation");
            String op = scanner.next();
            double result;
            switch (op) {
                case "+" -> result = calculator.sum(a, b);
                case "-" -> result = calculator.subtract(a, b);
                case "/" -> result = calculator.divide(a, b);
                case "*" -> result = calculator.multiply(a, b);
                case "%" -> result = calculator.rest(a, b);
                default -> throw new InvalidOperationException("Invalid inputs");
            }
            System.out.println(a + " " + op + " " + b + "=" + result);
            history.add(a + " " + op + " " + b + "=" + result);
        }

        private static void advancedOperation(
            Scanner scanner,CalculatorService calculator,HistoryService history ) throws InvalidOperationException {
        //چنتتا عدد داره
        System.out.println("How many numbers you have?:");
        //کاربر وارد میکنه
                int count = scanner.nextInt() ;
                // اگر عدد اشتباخ وراد کنه بگه
                if(count <=0) {
                    throw new InvalidOperationException("Empty list");}
                // حالا میخواد لیست رو پر کنه
            System.out.println("now input the numbers:");
            ArrayList<Double> numbers = new ArrayList<Double>();
                //برای پر کردن لیست باید scanner  داشته باشیم چون نمیخوایم کد رو تکرار کینم از حلقه میریم
                for (int i = 0 ; i < count; i++){
                    numbers.add(scanner.nextDouble());
                }
                System.out.println("choose operation: 1.Sum  2.Average  3.Max  4.Min");


                int ops = scanner.nextInt();
                double results;
                switch (ops){
                    case 1 -> results = calculator.sum(numbers);
                    case 2 -> results = calculator.average(numbers);
                    case 3 -> results = calculator.max(numbers);
                    case 4 -> results = calculator.min(numbers);
                    default -> throw new InvalidOperationException("invalid");}

                System.out.println("result:" + results);
                history.add("Advanced Result = " + results);


    }







        }
