package com.gracefulfuture.data.structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author chenkun
 * @version 1.0
 * @description 计算器类
 * @create 2021/7/31 9:47
 */
public class Calculator {
    public static void main(String[] args) {
        System.out.println("请输入表达式：");
        Scanner scanner = new Scanner(System.in);
        String infixExpression = scanner.nextLine();
//        String infixExpression = "(3+4)*5-6";
        infixExpression = infixExpression.replaceAll("\\s","");
        System.out.println("中缀表达式是：\n" + infixExpression);
        int infixResult = calculateInfixExpression(infixExpression);
        System.out.println("中缀表达式计算结果是：" + infixResult);
        String suffixExpression = convert2SuffixExpression(infixExpression);
        System.out.println("后缀表达式是：\n" + suffixExpression);
        int suffixResult = calculateSuffixExpression(suffixExpression.trim());
        System.out.println("后缀表达式计算结果是：" + suffixResult);
        String prifixExpression = convert2PrefixExpression(infixExpression);
        System.out.println("前缀表达式是：\n" + prifixExpression);
        int prifixResult = calculatePrefixExpression(prifixExpression.trim());
        System.out.println("前缀表达式计算结果是：" + prifixResult);
    }

    /**
    * @description  计算前缀表达式的值
    * @author       chenkun
    * @param		infixExpression
    * @date         2021/8/2 9:16
    * @return		int
    */
    public static int calculateInfixExpression(String infixExpression){
        Stack<String> dataStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        String dataStr = "";
        for (int i = 0; i < infixExpression.length(); i++) {
            String currentStr = String.valueOf(infixExpression.charAt(i));
            if(currentStr.matches("\\d")){
                if(i == infixExpression.length() - 1){
                    dataStack.push(dataStr + currentStr);
                }else{
                    dataStr += currentStr;
                }
            }else{
                if(!dataStr.equals("")){
                    dataStack.push(dataStr);
                }
                dataStr = "";
                int currentPriority = calculatePriority(currentStr);
                if(operatorStack.size() == 0){
                    operatorStack.push(currentStr);
                }else if(currentStr.equals("(")){
                    operatorStack.push(currentStr);
                }else if(currentStr.equals(")")){
                    int topIndex = operatorStack.size() - 1;
                    while (!operatorStack.get(topIndex).equals("(")){
                        int value1 = Integer.parseInt(dataStack.pop());
                        int value2 = Integer.parseInt(dataStack.pop());
                        String operator = operatorStack.pop();
                        int result = calcultateValue(value1, value2, operator);
                        dataStack.push(result + "");
                        topIndex--;
                    }
                    operatorStack.pop();
                }else if(currentPriority >= calculatePriority(operatorStack.get(operatorStack.size() - 1))){
                    operatorStack.push(currentStr);
                }else {
                    int value1 = Integer.parseInt(dataStack.pop());
                    int value2 = Integer.parseInt(dataStack.pop());
                    String operator = operatorStack.pop();
                    int result = calcultateValue(value1, value2, operator);
                    dataStack.push(result + "");
                    operatorStack.push(currentStr);
                }
            }
        }
        for (int i = operatorStack.size() - 1; i >= 0; i--) {
            int value1 = Integer.parseInt(dataStack.pop());
            int value2 = Integer.parseInt(dataStack.pop());
            String operator = operatorStack.get(i);
            int result = calcultateValue(value1,value2,operator);
            dataStack.push(result + "");
        }
        return Integer.parseInt(dataStack.pop());
    }

    /**
    * @description  计算前缀表达式的值
    * @author       chenkun
    * @param		prefixExpression
    * @date         2021/8/2 9:15
    * @return		int
    */
    public static int calculatePrefixExpression(String prefixExpression){
        String[] elementArr = prefixExpression.split(" ");
        //符号栈
        Stack<String> dataStack = new Stack<>();
        //数栈
        Stack<String> operatorStack = new Stack<>();
        for (int i = elementArr.length - 1; i >= 0; i--) {
            String currentStr = String.valueOf(elementArr[i]);
            if(currentStr.matches("\\d+")){
                dataStack.push(currentStr);
            }else{
//                operatorStack.add(currentStr);
                int value1 = Integer.parseInt(dataStack.pop());
                int value2 = Integer.parseInt(dataStack.pop());
                int result = calcultateValue(value2, value1, currentStr);
                dataStack.push(result + "");
            }
        }
        return Integer.parseInt(dataStack.pop());
    }

    /**
     * @description  计算后缀表达式的值
     * @author       chenkun
     * @param        suffixExpression
     * @date         2021/7/31 14:08
     * @return       int
     */
    public static int calculateSuffixExpression(String suffixExpression) {
        String[] elementArr = suffixExpression.split(" ");
        //符号栈
        Stack<String> dataStack = new Stack<>();
        //数栈
        Stack<String> operatorStack = new Stack<>();
        for (int i = 0; i < elementArr.length; i++) {
            String currentStr = String.valueOf(elementArr[i]);
            if(currentStr.matches("\\d+")){
                dataStack.push(currentStr);
            }else{
//                operatorStack.add(currentStr);
                int value1 = Integer.parseInt(dataStack.pop());
                int value2 = Integer.parseInt(dataStack.pop());
                int result = calcultateValue(value1, value2, currentStr);
                dataStack.push(result + "");
            }
        }
        return Integer.parseInt(dataStack.pop());
    }

    /**
     * @description  把中缀表达式转换成后缀表达式
     * @author       chenkun
     * @param        infixExpression
     * @date         2021/7/31 9:51
     * @return       java.lang.String
     */
    public static String convert2SuffixExpression(String infixExpression) {
        StringBuffer suffixExpression = new StringBuffer();
        //数栈
        Stack<String> dataStack = new Stack<>();
        String dataStr = "";
        List<String> operatorStack = new ArrayList<>();
        for (int i = 0; i < infixExpression.length(); i++) {
            String currentStr = String.valueOf(infixExpression.charAt(i));
            if (currentStr.matches("\\d")) {
                if (i == infixExpression.length() - 1) {
                    dataStack.push(dataStr + currentStr);
                } else {
                    dataStr += currentStr;
                }
            } else {
                if (!dataStr.equals("")) {
                    dataStack.push(dataStr);
                }
                dataStr = "";
                int currentPriority = calculatePriority(currentStr);
                if (operatorStack.size() == 0) {
                    operatorStack.add(currentStr);
                } else if (currentStr.equals("(")) {
                    operatorStack.add(currentStr);
                } else if (currentStr.equals(")")) {
                    int topIndex = operatorStack.size() - 1;
                    while (!operatorStack.get(topIndex).equals("(")) {
                        dataStack.push(operatorStack.get(topIndex));
                        operatorStack.remove(topIndex);
                        topIndex--;
                    }
                    operatorStack.remove(topIndex);
                } else if (currentPriority >= calculatePriority(operatorStack.get(operatorStack.size() - 1))) {
                    operatorStack.add(currentStr);
                } else {
                    int topIndex = operatorStack.size() - 1;
//                    int topPriority = calculatePriority(operatorStack.get(topIndex));
                    while (topIndex >= 0 && currentPriority < calculatePriority(operatorStack.get(topIndex))) {
                        dataStack.push(operatorStack.get(topIndex));
                        operatorStack.remove(topIndex);
                        topIndex--;
                    }
                    operatorStack.add(currentStr);
                }
            }
        }
        for (int i = operatorStack.size() - 1; i >= 0; i--) {
            dataStack.push(operatorStack.get(i));
        }
        dataStack.stream().forEach(e -> {
            suffixExpression.append(e).append(" ");
        });
        return suffixExpression.toString();
    }

    public static String convert2PrefixExpression(String infixExpression){
        StringBuffer prifixExpression = new StringBuffer();
        Stack<String> dataStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        StringBuffer dataStr = new StringBuffer();
        for (int i = infixExpression.length() - 1; i >= 0 ; i--) {
            String currentStr = String.valueOf(infixExpression.charAt(i));
            if(currentStr.matches("\\d")){
                if(i == 0){
                    dataStack.push(dataStr.append(currentStr).toString());
                }else{
                    dataStr.append(currentStr);
                }
            }else{
                if(!dataStr.toString().equals("")){
                    dataStack.push(dataStr.toString());
                }
                dataStr.delete(0,dataStr.length());
                int currentPriority = calculatePriority(currentStr);
                if(operatorStack.size() == 0){
                    operatorStack.push(currentStr);
                }else if(currentStr.equals(")")){
                    operatorStack.push(currentStr);
                }else if(currentStr.equals("(")){
                    int topIndex = operatorStack.size() - 1;
                    while (!operatorStack.get(topIndex).equals(")")) {
                        dataStack.push(operatorStack.get(topIndex));
                        operatorStack.remove(topIndex);
                        topIndex--;
                    }
                    operatorStack.remove(topIndex);
                }else if(currentPriority >= calculatePriority(operatorStack.get(operatorStack.size() - 1))){
                    operatorStack.push(currentStr);
                }else{
                    int topIndex = operatorStack.size() - 1;
//                    int topPriority = calculatePriority(operatorStack.get(topIndex));
                    while (topIndex >= 0 && currentPriority < calculatePriority(operatorStack.get(topIndex))) {
                        dataStack.push(operatorStack.get(topIndex));
                        operatorStack.remove(topIndex);
                        topIndex--;
                    }
                    operatorStack.add(currentStr);
                }
            }
        }

        for (int i = operatorStack.size() - 1; i >= 0; i--) {
            dataStack.push(operatorStack.get(i));
        }

        dataStack.stream().forEach(e -> {
            prifixExpression.append(e).append(" ");
        });
        return prifixExpression.reverse().toString();
    }

    /**
     * @description  计算运算符的优先级
     * @author       chenkun
     * @param        operator
     * @date         2021/7/31 10:18
     * @return       int
     */
    private static int calculatePriority(String operator) {
        int priority = -1;
        switch (operator) {
            case "(":
            case ")": {
                priority = 0;
                break;
            }
            case "%":
            case "/":
            case "*": {
                priority = 2;
                break;
            }
            case "+":
            case "-": {
                priority = 1;
                break;
            }
            default:
                break;
        }
        return priority;
    }

    /**
     * @description  求两个数的运算结果
     * @author       chenkun
     * @param        value1
     * @param        value2
     * @param        operator
     * @date         2021/7/31 14:17
     * @return       int
     */
    private static int calcultateValue(int value1, int value2, String operator) {
        int result = 0;
        switch (operator) {
            case "+": {
                result = value1 + value2;
                break;
            }
            case "-": {
                result = value2 - value1;
                break;
            }
            case "*": {
                result = value1 * value2;
                break;
            }
            case "/": {
                result = value2 / value1;
                break;
            }
            case "%": {
                result = value2 % value1;
                break;
            }
            default:
                break;
        }
        return result;
    }
}
