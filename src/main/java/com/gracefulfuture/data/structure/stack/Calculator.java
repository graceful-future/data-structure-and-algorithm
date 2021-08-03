package com.gracefulfuture.data.structure.stack;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String originalInfixExpression = scanner.nextLine();
//        String infixExpression = "(3+4)*5-6";
//        Pattern pattern = Pattern.compile("[\\d\\s]+");
        Pattern pattern = Pattern.compile("[\\d\\s+\\-*/().]+");
        Matcher matcher = pattern.matcher(originalInfixExpression);
//        System.out.println(matcher.matches());
        if(!matcher.matches()){
            System.out.println("表达式不合法,请重新输入!");
            return;
        }
        String infixExpression = originalInfixExpression.replaceAll("\\s","");
        String processedInfixExpression = processInfixExpression(originalInfixExpression);
        System.out.println("中缀表达式是：\n" + processedInfixExpression);
        BigDecimal infixResult = calculateInfixExpression(infixExpression);
        System.out.println("中缀表达式计算结果是：" + infixResult);
        String suffixExpression = convert2SuffixExpression(infixExpression);
        System.out.println("后缀表达式是：\n" + suffixExpression);
        BigDecimal suffixResult = calculateSuffixExpression(suffixExpression.trim());
        System.out.println("后缀表达式计算结果是：" + suffixResult);
        String prifixExpression = convert2PrefixExpression(infixExpression);
        System.out.println("前缀表达式是：\n" + prifixExpression);
        BigDecimal prifixResult = calculatePrefixExpression(prifixExpression.trim());
        System.out.println("前缀表达式计算结果是：" + prifixResult);
    }

    /**
    * @description  计算前缀表达式的值
    * @author       chenkun
    * @param		infixExpression
    * @date         2021/8/2 9:16
    * @return		int
    */
    public static BigDecimal calculateInfixExpression(String infixExpression){
        Stack<String> dataStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        String dataStr = "";
        for (int i = 0; i < infixExpression.length(); i++) {
            String currentStr = String.valueOf(infixExpression.charAt(i));
            if(currentStr.matches("\\d|\\.")){
                if(i == infixExpression.length() - 1){
                    String result =dataStr + currentStr;
                    resolveDataStr(result, dataStack);
                }else{
                    dataStr += currentStr;
                }
            }else{
                if(!dataStr.equals("")){
                    resolveDataStr(dataStr, dataStack);
//                    dataStack.push(dataStr);
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
                        BigDecimal value1 = new BigDecimal(dataStack.pop());
                        BigDecimal value2 = new BigDecimal(dataStack.pop());
                        String operator = operatorStack.pop();
                        BigDecimal result = calculateValue(value1, value2, operator);
                        dataStack.push(result + "");
                        topIndex--;
                    }
                    operatorStack.pop();
                }else if(currentPriority >= calculatePriority(operatorStack.get(operatorStack.size() - 1))){
                    operatorStack.push(currentStr);
                }else {
                    BigDecimal value1 = new BigDecimal(dataStack.pop());
                    BigDecimal value2 = new BigDecimal(dataStack.pop());
                    String operator = operatorStack.pop();
                    BigDecimal result = calculateValue(value1, value2, operator);
                    dataStack.push(result + "");
                    operatorStack.push(currentStr);
                }
            }
        }
        for (int i = operatorStack.size() - 1; i >= 0; i--) {
            BigDecimal value1 = new BigDecimal(dataStack.pop());
            BigDecimal value2 = new BigDecimal(dataStack.pop());
            String operator = operatorStack.get(i);
            BigDecimal result = calculateValue(value1,value2,operator);
            dataStack.push(result + "");
        }
        return new BigDecimal(dataStack.pop());
    }

    /**
    * @description  计算前缀表达式的值
    * @author       chenkun
    * @param		prefixExpression
    * @date         2021/8/2 9:15
    * @return		int
    */
    public static BigDecimal calculatePrefixExpression(String prefixExpression){
        String[] elementArr = prefixExpression.split(" ");
        //符号栈
        Stack<String> dataStack = new Stack<>();
        //数栈
        Stack<String> operatorStack = new Stack<>();
        for (int i = elementArr.length - 1; i >= 0; i--) {
            String currentStr = String.valueOf(elementArr[i]);
            if(currentStr.matches("\\d*\\.?\\d*")){
                dataStack.push(currentStr);
            }else{
//                operatorStack.add(currentStr);
                BigDecimal value1 = new BigDecimal(dataStack.pop());
                BigDecimal value2 = new BigDecimal(dataStack.pop());
                BigDecimal result = calculateValue(value2, value1, currentStr);
                dataStack.push(result + "");
            }
        }
        return new BigDecimal(dataStack.pop());
    }

    /**
     * @description  计算后缀表达式的值
     * @author       chenkun
     * @param        suffixExpression
     * @date         2021/7/31 14:08
     * @return       int
     */
    public static BigDecimal calculateSuffixExpression(String suffixExpression) {
        String[] elementArr = suffixExpression.split(" ");
        //符号栈
        Stack<String> dataStack = new Stack<>();
        //数栈
        Stack<String> operatorStack = new Stack<>();
        for (int i = 0; i < elementArr.length; i++) {
            String currentStr = String.valueOf(elementArr[i]);
            if(currentStr.matches("\\d*\\.?\\d*")){
                dataStack.push(currentStr);
            }else{
//                operatorStack.add(currentStr);
                BigDecimal value1 = new BigDecimal(dataStack.pop());
                BigDecimal value2 = new BigDecimal(dataStack.pop());
                BigDecimal result = calculateValue(value1, value2, currentStr);
                dataStack.push(result + "");
            }
        }
        return new BigDecimal(dataStack.pop());
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
            if (currentStr.matches("\\d|\\.")) {
                if (i == infixExpression.length() - 1) {
                    String result = dataStr + currentStr;
                    resolveDataStr(result, dataStack);
//                    dataStack.push(dataStr + currentStr);
                } else {
                    dataStr += currentStr;
                }
            } else {
                if (!dataStr.equals("")) {
                    resolveDataStr(dataStr, dataStack);
//                    dataStack.push(dataStr);
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
            if(currentStr.matches("\\d|\\.")){
                if(i == 0){
                    String result = dataStr.append(currentStr).toString();
                    resolveDataStr(result, dataStack);
//                    dataStack.push(dataStr.append(currentStr).toString());
                }else{
                    dataStr.append(currentStr);
                }
            }else{
                if(!dataStr.toString().equals("")){
                    resolveDataStr(dataStr.toString(), dataStack);
//                    dataStack.push(dataStr.toString());
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
    private static BigDecimal calculateValue(BigDecimal value1, BigDecimal value2, String operator) {
        BigDecimal result = null;
        switch (operator) {
            case "+": {
                result = value1.add(value2);
                break;
            }
            case "-": {
                result = value2.subtract(value1);
                break;
            }
            case "*": {
                result = value1.multiply(value2);
                break;
            }
            case "/": {
                result = value2.divide(value1, 5,RoundingMode.HALF_UP);
                break;
            }
            default:
                break;
        }
        return result;
    }

    /**
    * @description  解析操作数
    * @author       chenkun
    * @param		dataStr
    * @param		dataStack
    * @date         2021/8/3 11:07
    * @return		void
    */
    private static void resolveDataStr(String dataStr, Stack<String> dataStack){
        if(dataStr.matches("\\d+")){
            dataStack.push(dataStr);
        }else if(dataStr.matches("\\.\\d+")){
            dataStack.push("0" + dataStr);
        }else if(dataStr.matches("\\d+\\.")){
            dataStack.push(dataStr + "0");
        }else if(dataStr.matches("\\d+\\.?\\d+")){
            dataStack.push(dataStr);
        }else if(dataStr.matches("\\.")){
            System.out.println("表达式格式不正确");
            System.exit(1);
        }
    }

    /**
    * @description  处理中缀表达式
    * @author       chenkun
    * @param		infixExpression
    * @date         2021/8/3 13:03
    * @return		java.lang.String
    */
    private static String processInfixExpression(String infixExpression){
        StringBuffer stringBuffer = new StringBuffer();
        String[] elementArr = infixExpression.split(" ");
        for (int i = 0; i < elementArr.length; i++) {
            if(elementArr[i].startsWith(".")){
                elementArr[i] = "0" + elementArr[i];
            }
            if(elementArr[i].endsWith(".")){
                elementArr[i] = elementArr[i] + "0";
            }
            stringBuffer.append(elementArr[i]).append(" ");
        }
        return stringBuffer.toString().trim();
    }
}
