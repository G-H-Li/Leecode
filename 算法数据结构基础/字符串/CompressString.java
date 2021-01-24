import java.util.*;

public class CompressString{
    public static void main(String[] args) {
        String S = "aaaaccccbb";
        String input = S;
        
        Stack<Character> outSt = new Stack<Character>();
        int numOfAlpha = 0;
        
        int i=0;
        while(i < input.length()){
            if(outSt.empty() || input.charAt(i) != outSt.peek()){
                if(!outSt.empty()){
                    String str = String.valueOf(numOfAlpha);
                    char[] array = str.toCharArray();
                    for (int a = 0; a < array.length; a++) {
                        outSt.push(array[a]);
                    }
                    numOfAlpha = 0;
                }
                outSt.push(input.charAt(i));
                i += 1; //读取字符串中下一个字符
                numOfAlpha += 1;
            }else{
                numOfAlpha += 1;
                i += 1;
            }
        }
        String str = String.valueOf(numOfAlpha);
        char[] array = str.toCharArray();
        for (int a = 0; a < array.length; a++) {
            outSt.push(array[a]);
        }
        if(outSt.size() >= S.length()){
            System.out.println(S);
        }else{
            StringBuffer buffer = new StringBuffer();
            for(Object a : outSt.toArray()){
                buffer.append(a);
            }
            System.out.println(buffer.toString());
        }
    }
}
