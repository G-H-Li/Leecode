package lanqiaocup.CupFive;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NoCoupleA{

    static int num = 0;

    public static void DFS(List<Integer> candidate, String prefix){
        if(prefix.length() >= 2){
            int a = prefix.charAt(prefix.length()-1);
            int b = prefix.charAt(prefix.length()-2);
            if(Math.abs(a-b) == 1){
                return;
            }
        }
		if(prefix.length()!=0 && candidate.size()==0){
			//System.out.println(prefix);
            num += 1;
		}
		
		
		for(int i=0; i<candidate.size(); i++){
			
			List<Integer> temp = new LinkedList<Integer>(candidate);
			int item = (int)temp.remove(i);  // 取出被删除的元素，这个元素当作一个组合用掉了
			DFS(temp, prefix+item);
		}
	}
	public static void main(String[] args) {
		
		Integer[] array = {0,1,2,3,4,5,6,7,8,9}; 
		List<Integer> list = Arrays.asList(array);
        
		DFS(list, "");
        System.out.println(num);
    }

}