package lanqiaocup.CupSix;

import java.util.ArrayList;
import java.util.List;

public class Age {
    public static void main(String[] args) {
        List<Integer> candles = new ArrayList<Integer>();
        candles.add(0);
        for(int i=1; i<=50; i++){
            candles.add(candles.get(i-1)+i);
        }
        for(int i:candles){
            for(int j:candles){
                if(Math.abs(i-j) == 236){
                    System.out.printf("%d %d\n", i, j);
                    System.out.printf("%d %d\n", candles.indexOf(i), candles.indexOf(j));
                    break;
                }
            }
        }
    }
    
}
