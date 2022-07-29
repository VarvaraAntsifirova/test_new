package com.company;

public class Arabian {

    public static String checkArabian(int num1, int num2, String sign) {
        if (num1 < 1 || num1 > 10 || num2 > 10 || num2 < 1)
            throw new RuntimeException("Неверный ввод");
        return String.valueOf(checkSign(num1, num2, sign));
    }

    public static int checkSign(int num1, int num2, String sign) {
        int result;//переменная для результата
        if (num1 < 1 || num1 > 10 || num2 > 10 || num2 < 1)
            throw new RuntimeException("Неверный ввод");//убираем возможность внесения чисел меньше 1 и больше 10

        switch (sign) { // проверяем знак в примере
            case "/":
                result = num1 / num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            default:
                throw new RuntimeException("Неверный ввод");
        }
        return result;
    }
}