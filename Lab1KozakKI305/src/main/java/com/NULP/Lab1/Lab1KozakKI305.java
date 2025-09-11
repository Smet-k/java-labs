package com.NULP.Lab1;

import java.io.*;
import java.util.*;

/**
* Клас Lab1KozakKI305 реалізує приклад програми до лабораторної роботи №1
*/
public class Lab1KozakKI305 {

    /**
    * Статичний метод CustomPrint виводить стрічку S
    * одночасно в термінал та в наданий файл 
    *
    * @param s рядок для виводу
    * @param fout об'єкт куди буде записано текст
    *
    */
    public static void CustomPrint(String s, PrintWriter fout){
            System.out.print(s);
            fout.print(s);
    }

    /**
    * Статичний метод InitMatrix ініціалізовує та заповнює квадратну зубчасту
    * матрицю розміру size, символами symbol
    *
    * @param size Розмір квадратної матриці
    * @param symbol Символ яким матриця буде заповнена
    * @return Двовимірний масив рядків із заповненою матрицею
    */
    public static String[][] InitMatrix(int size, String symbol){
        String[][] matrix = new String[size][];
        for (int i = 0;i < matrix.length; i++){
            matrix[i] = new String[i + 1];
            Arrays.fill(matrix[i], symbol);
        }
        return matrix;
    }

    /**
    * Статичний метод DrawFigure зчитує дані з матриці та
    * передає їх CustomPrint
    * 
    * @param matrix Матриця з якої буде передаватись малюнок
    * @throws FileNotFoundException якщо виникають проблеми зі створенням файлу
    *
    */
    public static void DrawFigure(String[][] matrix) throws FileNotFoundException{
        final File outputFile = new File("Figure.txt");
        PrintWriter fout = new PrintWriter(outputFile);

        for(String[] arr : matrix){
            for(int i = matrix.length;i > 0;i--){
                if(i <= arr.length)
                    CustomPrint(arr[i - 1], fout);
                else
                    CustomPrint(" ", fout);
            }
            CustomPrint("\n", fout);
        }

        fout.flush();
        fout.close();
    }

    /**
    * Статичний метод main є точкою входу в програму
    *
    * @param args
    * @throws FileNotFoundException якщо виникають проблеми зі створенням файлу
    *
    */
    public static void main(String[] args) throws FileNotFoundException{
        final Scanner in = new Scanner(System.in);
        int size;
        String symbol;

        System.out.print("Enter the size of Square Matrix: ");
        size = in.nextInt();
        in.nextLine();

        System.out.print("Enter the filling symbol: ");
        symbol = in.next();

        in.close();
        if(symbol.length() > 1 || symbol.length() == 0){
            System.err.println(symbol.length() > 1 ? "Too many symbols provided" : "Filling symbol was not provided");
            return;
        }
        
        String[][] matrix = InitMatrix(size, symbol);
        DrawFigure(matrix);
    }
}
