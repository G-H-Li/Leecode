package lanqiaocup.CupFive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Travel {

    static double result;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<LinkedList<Integer>> graph = new ArrayList<LinkedList<Integer>>();

        for(int i=0; i<m+1; i++){
            graph.add(new LinkedList<>());
        }

        for(int i=0; i<n+1; i++){
            int a= in.nextInt(), b= in.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        in.close();

        
        for(int i=0; i<n; i++){
            result = 0;
            List<Integer> prefix = new ArrayList<Integer>();
            prefix.add(i+1);
            dfs(graph, prefix);
            System.out.printf("%.9f\n", result);
        }
    }

    public static void dfs(List<LinkedList<Integer>> graph, List<Integer> prefix) {
        if(prefix.size()>1 ){
            //开始计算此环路的值
            double divided = 1;
            for(int i=0; i<prefix.size()-1; i++){
                int a = prefix.get(i);
                if(i == 0){
                    divided *= graph.get(a).size();
                }else{
                    divided *= (graph.get(a).size() - 1);
                }
            }
            double num = (prefix.size()-1)/divided;
            if(num< Math.pow(10, -11)){
                return;
            }

            if(prefix.get(prefix.size()-1) == prefix.get(0)){
                result += num;
                return;
            }
        }

        int num = prefix.get(prefix.size()-1);
        for(int i:graph.get(num)){
            if(prefix.size() >1 && i == prefix.get(prefix.size()-2)){
                continue;
            }
            List<Integer> tmp = new ArrayList<Integer>(prefix);
            tmp.add(i);
            dfs(graph, tmp);
        }
    }
    
}
