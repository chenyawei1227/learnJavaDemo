package arithmetic;

import org.junit.Test;
import java.util.Stack;

/**
 * @Author: chenyawei
 * @Date: 2020-05-28  11:05
 * @Description:
 */
public class ArithmeticUtil {

    @Test
    public void test() {
        String exp = "(9-4^3)^3"; //待计算的表达式(6+9)*(9-4^3)^2/2
        char[] arr = exp.toCharArray();//拆分字符串
        Double result = arithmeticByTwoStack(arr);
        System.out.println(exp + " = " + result);
    }

    private Double arithmeticByTwoStack(char[] str) {
        //将拆分好的字符依次放入两个栈中
        Stack<Character> opStack = new Stack<>(); //操作符栈
        Stack<Double> numStack = new Stack<>();  //数值栈

        char ch;
        StringBuilder tempStr; //存储临时数组存储子串
        Double tempData; //存储将子串转化成double类型的数
        Double od1, od2; //存储值栈依次pop出来的操作数
        char tempPop;//存储操作符

        int length = str.length;//计算str数组的长度
        int i = 0;//声明字符数组循环索引
        try {
            while (i < length) {
                ch = str[i];
                if ((ch >= '0' && ch <= '9') || ch == '.') { //若为数值或小数点
                    tempStr = new StringBuilder();
                    while ((ch >= '0' && ch <= '9') || ch == '.') { //截取子串
                        tempStr = tempStr.append(ch);
                        if (i == length - 1){
                            ++i;
                            break;
                        }
                        ch = str[++i];
                    }
                    tempData = Double.valueOf(String.valueOf(tempStr));//将子串转化成double类型的数
                    numStack.push(tempData);//入值栈
                } else if (isOp(ch)) {
                    if(opStack.size() == 0){
                        opStack.push(ch);
                    } else if ('(' == ch) { //如果为(，直接进栈
                        opStack.push(ch);
                    } else if (')' == ch) {  //如果为),一直出栈直到遇到(
                        while (level(opStack.peek()) != -1) //若栈顶元素不为(,进入while循环
                        {
                            od2 = numStack.pop();
                            od1 = numStack.pop();
                            tempPop = opStack.pop();
                            numStack.push(calculate(od1, od2, tempPop));
                        }
                        opStack.pop(); //做括号出栈
                    } else if (level(ch) > level(opStack.peek())) { //栈为空或所扫描的操作符优先等级比栈顶元素高，直接进栈
                        opStack.push(ch);
                    } else {
                        //如果所扫描的操作符优先等级没有栈顶元素高，
                        //一直出栈直到比栈顶元素优先级高
                        while (level(ch) <= level(opStack.peek())) {
                            od2 = numStack.pop();
                            od1 = numStack.pop();
                            tempPop = opStack.pop();
                            numStack.push(calculate(od1, od2, tempPop));
                            if (opStack.size() == 0) break;  //如果栈为空，退出循环
                        }
                        opStack.push(ch);
                    }
                    i++;
                } else {
                    System.out.println("输入的表达式有误(检查是否有除+-*/^()和数字以外的字符)");
                    return null;
                }
            }
            while (opStack.size() != 0){
                od2 = numStack.pop();
                od1 = numStack.pop();
                tempPop = opStack.pop();
                numStack.push(calculate(od1,od2,tempPop));
            }
        }catch (Exception e){
            System.out.println("输入的表达式有误,请检查表达式括号是否成对");
            return null;
        }
        return numStack.pop();
    }

    private Double calculate(Double od1, Double od2, char tempPop) { //计算
        switch (tempPop) {
            case '+':
                return od1 + od2;//计算加法
            case '-':
                return od1 - od2;//计算减法
            case '*':
                return od1 * od2;//计算乘法
            case '/':
                return od1 / od2;//计算除法
            case '%':
                return od1 % od2; //求余
            case '^':
                return Math.pow(od1, od2);//ob1的ob2次方，指数
        }
        return 0.0;
    }

    private boolean isOp(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '(' || ch == ')' || ch == '^')
            return true;
        return false;
    }

    private int level(char op) {
        if (op == '+' || op == '-')//若为+、-，等级为1
            return 1;
        else if (op == '*' || op == '/' || op == '%')
            return 2;         //若为*、/、%,等级为2
        else if (op == '^')
            return 3;         //若为^,等级为3
        else if (op == '(')
            return -1;      //若为(,等级为-1
        else
            return -3;       //其他等级为-3；
    }
}

