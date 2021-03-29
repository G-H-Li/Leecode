package dataStructure.Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class ConcatArray{
    public static void main(String[] args) {
        //搭建数组
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, int[]> lsLinkedList = new HashMap<Integer, int[]>();

        int arrayNum = sc.nextInt();
        int[] inputTemp;
        for(int i=0; i<arrayNum; i++){
            int size = sc.nextInt();
            inputTemp = new int[size];
            //0号位存储数组编号
            for(int j=0; j<size; j++){
                inputTemp[j] = sc.nextInt();
            }
            lsLinkedList.put(size, inputTemp);
        }

        int queryNum = sc.nextInt();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i<queryNum; i++){
            int concatNum = sc.nextInt();
            int index;
            ArrayList<Integer> queryList = new ArrayList<Integer>();
            for(int j=0; j<concatNum; j++){
                index = sc.nextInt();
                int[] a = lsLinkedList.get(index);
                for(int k=0; k<a.length; k++){
                    queryList.add(a[k]);
                }
            }
            queryList.sort(Comparator.reverseOrder());
            result.add(queryList.get(sc.nextInt() -1));
        }

        sc.close();

        for(int item: result){
            System.out.println(item);
        }
    }
}