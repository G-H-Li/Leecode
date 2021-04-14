package lanqiaocup.CupFive;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MaxNoMatch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        HashMap<Integer,Integer> hashScore = new HashMap<Integer,Integer>();
        for(int i=0; i<n; i++){
            int tmp = in.nextInt();
            if(hashScore.containsKey(tmp)){
                int a = hashScore.get(tmp);
                hashScore.put(tmp, ++a);
            }else{
                hashScore.put(tmp, 1);
            }
        }
        in.close();

        System.out.println(findMax(hashScore, k));
    }

    public static int findMax(HashMap<Integer,Integer> hashScore, int k) {

        //删除存在一样的
        if(k==0){
            return hashScore.size();
        }
        int result = 0;
        List<Integer> keys = new ArrayList<Integer>(hashScore.keySet());
        //keys.sort(Comparator.naturalOrder());
        for(int i: keys){
            if(hashScore.containsKey(i)){
                if(hashScore.containsKey(i-k) && hashScore.containsKey(i+k)){
                    if(hashScore.get(i-k)+hashScore.get(i+k) > hashScore.get(i)){
                        hashScore.remove(i);
                    }else{
                        hashScore.remove(i-k);
                        hashScore.remove(i+k);
                    }
                }else if(hashScore.containsKey(i-k)){
                    if(hashScore.get(i-k) > hashScore.get(i)){
                        hashScore.remove(i);
                    }else{
                        hashScore.remove(i-k);
                    }
                }else if(hashScore.containsKey(i+k)){
                    if(hashScore.get(i+k) > hashScore.get(i)){
                        hashScore.remove(i);
                    }else{
                        hashScore.remove(i+k);
                    }
                }
            }
        }

        for(int i:hashScore.values()){
            result += i;
        }
        return result;
    }
    
}
