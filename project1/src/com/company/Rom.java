package com.company;

import java.util.HashMap;
import java.util.Map;

public class Rom {
    public static Map<String, Integer> rom = new HashMap<>(); //создаем мапу для перевода в арабские цифры
    public static Map<Integer, String> rim = new HashMap<>();//создаем мапу для перевода в римские

    static {
        rom.put("I", 1);
        rom.put("II", 2);
        rom.put("III", 3);
        rom.put("IV", 4);
        rom.put("V", 5);
        rom.put("VI", 6);
        rom.put("VII", 7);
        rom.put("VIII", 8);
        rom.put("IX", 9);
        rom.put("X", 10);

        rim.put(1, "I");
        rim.put(5, "V");
        rim.put(10, "X");
        rim.put(20, "XX");
        rim.put(30, "XXX");
        rim.put(40, "XL");
        rim.put(50, "L");
        rim.put(60, "LX");
        rim.put(70, "LXX");
        rim.put(80, "LXXX");
        rim.put(90, "XC");
        rim.put(100, "C");
    }

    public static int resultArabian = 0; //переменная для арабского результата
    public static String resultRom = "";//переменная для римского результата
    public static String ostRom = "";

    public static String checkRom(String ex) {
        String[] num;
        String sign;
        if(ex.contains("+")) {
             num = ex.split("\\+");
             sign = "+";
        } else if (ex.contains("-")) {
            num = ex.split("-");
            sign = "-";
        } else if(ex.contains("*")) {
            num = ex.split("\\*");
            sign = "*";
        } else  if(ex.contains("/")) {
            num = ex.split("/");
            sign = "/";
        }else{
            throw new RuntimeException("Неверный ввод");
        }
        return "Ответ: " + checkSign(num, sign);
    }

    public static String checkSign(String[] num, String sign) {
        int num1 = rom.get(num[0]);// перевод римских цифр в арабские
        int num2 = rom.get(num[1]);
        switch (sign) { //определяем знак в примере
            case "/":
                resultArabian = num1 / num2;
                break;
            case "*":
                resultArabian = num1 * num2;
                break;
            case "+":
                resultArabian = num1 + num2;
                break;
            case "-":
                resultArabian = num1 - num2;
                break;
            default:
                throw new RuntimeException("Неверный ввод");
        }
        if (resultArabian < 1) throw new RuntimeException("Неверный ввод");
        return changeSystem(resultArabian);
    }

    public static String changeSystem(int resultArabian) {
        if (resultArabian >= 10 && resultArabian < 100) { //логика перевода для двузначного результата
            int ostArabian = resultArabian % 10;
            int full = resultArabian - ostArabian;
            if (ostArabian <= 3) {
                while (ostArabian > 0) {
                    ostRom += "I";
                    ostArabian -= 1;
                }
            } else if (ostArabian == 4) {
                ostRom = "IV";
            } else if (ostArabian < 9) {
                ostRom = "V";
                while (ostArabian > 5) {
                    ostRom += "I";
                    ostArabian -= 1;
                }
            } else {
                ostRom = "IX";
            }
            resultRom = rim.get(full) + ostRom;
        } else if (resultArabian < 10) { // логика перевода для однозначного результата
            if (resultArabian <= 3) {
                while (resultArabian > 0) {
                    resultRom += "I";
                    resultArabian -= 1;
                }
            } else if (resultArabian == 4) {
                resultRom = "IV";
            } else if (resultArabian < 9) {
                resultRom = "V";
                while (resultArabian > 5) {
                    resultRom += "I";
                    resultArabian -= 1;
                }
            } else {
                resultRom = "IX";
            }
        } else { // перевод для 100
            resultRom = rim.get(100);
        }
        return resultRom;
    }
}