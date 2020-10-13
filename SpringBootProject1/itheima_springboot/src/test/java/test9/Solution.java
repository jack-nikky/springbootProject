package test9;

import java.util.Stack;


public class Solution {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
    /**
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public static boolean isValid (String s) {
        // write code here
        String[]  strList = s.split("");
        Stack<String> strStack = new Stack<>();
        for(String i:strList){
            if(strStack.isEmpty()){
                strStack.push(i);

            }else if(strStack.peek().equals("[") && i.equals("]")){
                strStack.pop();
            }else if(strStack.peek().equals("(") && i.equals(")")){
                strStack.pop();
            }else if(strStack.peek().equals("{") && i.equals("}")){
                strStack.pop();
            }else{
                if(i.equals("]") || i.equals("}")  || i.equals(")")){
                    return false;
                }
                strStack.push(i);
            }
        }
        return strStack.isEmpty();
    }
}
