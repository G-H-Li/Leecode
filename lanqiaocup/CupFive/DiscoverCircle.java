package lanqiaocup.CupFive;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DiscoverCircle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<ArrayList<Integer>> nums = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(in.nextInt());tmp.add(in.nextInt());
            nums.add(tmp);
        }
        in.close();

        for(int i=0; i<n; i++){
            List<Integer> prefix = new ArrayList<Integer>();
            prefix.add(i+1);
            if(isCircle(nums, prefix)){
                prefix.sort(Comparator.naturalOrder());
                for(int j:prefix){
                    System.out.printf("%d ", j);
                }
                break;
            }
        }
        
    }

    public static boolean isCircle(List<ArrayList<Integer>> nums, List<Integer> prefix) {
        int a = prefix.get(prefix.size()-1);
        for(int i=0; i<prefix.size()-1; i++){
            if(prefix.get(i)==a){
                prefix.remove(prefix.size()-1);
                return true;
            }
        }
        
        List<ArrayList<Integer>> linkedList = new LinkedList<>(nums);
        int num = prefix.get(prefix.size()-1);
        for(int i=0; i<linkedList.size(); i++){
            if(linkedList.get(i).get(0)==num){
                ArrayList<Integer> tmp = linkedList.remove(i);
                prefix.add(tmp.get(1));
                return isCircle(linkedList, prefix);
            }else if(linkedList.get(i).get(1)==num){
                ArrayList<Integer> tmp = linkedList.remove(i);
                prefix.add(tmp.get(0));
                return isCircle(linkedList, prefix);
            }
        }
        return false;
    }
    
}
