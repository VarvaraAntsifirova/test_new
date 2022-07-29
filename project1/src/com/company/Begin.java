package com.company;

import java.util.Scanner;

public class Begin {
    public static void main(String[] args) {
        int num1;
        int num2;
        String sign;
        System.out.println("Введите выражение для вычисления: ");
        Scanner sc = new Scanner(System.in);
        String ex = sc.nextLine();
        char[] exArray = ex.toCharArray();
        if (ex.length() == 4) {
            if (isNumeric1(exArray)) {
                num1 = Integer.parseInt("" + exArray[0] + "" + exArray[1]);
                num2 = Integer.parseInt(String.valueOf(exArray[3]));
                sign = String.valueOf(exArray[2]);
                System.out.println("Ответ: " + Arabian.checkArabian(num1, num2, sign));
            } else if (isNumeric2(exArray)) {
                num1 = Integer.parseInt(String.valueOf(exArray[0]));
                num2 = Integer.parseInt("" + exArray[2] + "" + exArray[3]);
                sign = String.valueOf(exArray[1]);
                System.out.println("Ответ: " + Arabian.checkArabian(num1, num2, sign));
            } else {
                try {
                    System.out.println(Rom.checkRom(ex));
                } catch (RuntimeException e) {
                    throw  new RuntimeException("Неверный ввод");
                }
            }
        } else if (ex.length() == 5 && isNumeric1(exArray)) {
            num1 = Integer.parseInt("" + exArray[0] + "" + exArray[1]);
            num2 = Integer.parseInt("" + exArray[3] + "" + exArray[4]);
            sign = String.valueOf(exArray[2]);
            System.out.println("Ответ: " + Arabian.checkArabian(num1, num2, sign));
        } else if (isNumeric3(exArray)) {
            num1 = Integer.parseInt(String.valueOf(exArray[0]));
            num2 = Integer.parseInt(String.valueOf(exArray[2]));
            sign = String.valueOf(exArray[1]);
            System.out.println("Ответ: " + Arabian.checkArabian(num1, num2, sign));
        } else {
            System.out.println(Rom.checkRom(ex));
        }
    }

    public static boolean isNumeric1(char[] exArray) {
        try {
            Integer.parseInt(String.valueOf(exArray[0]));
            Integer.parseInt(String.valueOf(exArray[1]));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNumeric2(char[] exArray) {
        try {
            Integer.parseInt(String.valueOf(exArray[2]));
            Integer.parseInt(String.valueOf(exArray[3]));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNumeric3(char[] exArray) {
        try {
            Integer.parseInt(String.valueOf(exArray[0]));
            Integer.parseInt(String.valueOf(exArray[2]));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
