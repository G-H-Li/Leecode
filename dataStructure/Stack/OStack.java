package dataStructure.Stack;

import java.util.Scanner;
import java.util.Stack;

public class OStack{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> st = new Stack<String>();

        int num = sc.nextInt();
        // 当前输入
        String curString;
        int max = 0;
        for(int i=0; i < num; i++){
            curString = sc.nextLine();
            if(curString.equals("for")){
                st.push(curString);
            }
            if(curString.equals("end") && !st.isEmpty()){
                st.pop();
            }
            //记录最高栈数量
            if(st.size() > max){
                max = st.size();
            }
        }
        sc.close();
        System.out.println(max);
    }
}