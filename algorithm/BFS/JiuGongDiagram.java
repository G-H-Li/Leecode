package algorithm.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 知识点：深度搜索、广度搜索
 * 此处参考解题思路为广度搜索 
*/

//定义数据结构
class Diagram{
    //来的坐标
    public int comeX;
    public int comeY;
    //点所在的x、y坐标
    public int x;
    public int y;
    //当前步数
    public int step;
    //当前图的样式
    public char[][] diagram;

    Diagram(){
        this.diagram = new char[3][3];
        this.comeX = 0;
        this.comeY = 0;
        this.x = 0;
        this.y = 0;
        this.step =0;
    }

    //根据string生成图
    Diagram(String sDiagram){
        this.diagram = new char[3][3];
        this.step = 0;
        int index = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.diagram[i][j] = sDiagram.charAt(index);
                if(sDiagram.charAt(index) == '.'){
                    this.x = i;
                    this.y = j;
                    this.comeX = i;
                    this.comeY = j;
                }
                index++;
            }
        }
    }

    //判断两个图是否相同
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Diagram){
            Diagram result = (Diagram)obj;
            if(this.x != result.x || this.y != result.y){
                return false;
            }
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(this.diagram[i][j] != result.diagram[i][j]){
                        return false;
                    }
                }
            }
        }else{
            return false;
        }
        return true;
    }

    //图状态的移动
    public ArrayList<Diagram> move(){
        int[][] direction = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};
        ArrayList<Diagram> mResult = new ArrayList<Diagram>();
        for(int k=0; k<4; k++){
            //临时拷贝,注意此处数组的深拷贝
            Diagram temp = new Diagram();
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    temp.diagram[i][j] = this.diagram[i][j];
                }
            }
            temp.x = this.x;
            temp.y = this.y;
            temp.step = this.step;
            temp.comeX = this.comeX;
            temp.comeY = this.comeY;

            int newX = temp.x + direction[k][0];
            int newY = temp.y + direction[k][1];
            //在活动范围内，有效移动
            if(newX>=0 && newX <= 2 && newY >=0 && newY <=2 && (newX != temp.comeX || newY != temp.comeY)){
                temp.diagram[temp.x][temp.y] = temp.diagram[newX][newY];
                temp.diagram[newX][newY] = '.';
                temp.comeX = temp.x;
                temp.comeY = temp.y;
                temp.x = newX;
                temp.y = newY;
                temp.step++;
                mResult.add(temp);
            }
        }
        return mResult;
    }
}

//TODO 目前存在无法找到没有状态转换的情况
public class JiuGongDiagram{
    public static void main(String[] args){
        //读取初始状态和结束状态
        Scanner scanner = new Scanner(System.in);
        String startD = scanner.next();
        String endD = scanner.next();
        scanner.close();
        
        Diagram startDiagram = new Diagram(startD);
        Diagram endDiagram = new Diagram(endD);
        // 开始进行数据处理
        Queue<Diagram> runQ = new LinkedList<Diagram>();
        runQ.offer(startDiagram);
        while(! runQ.isEmpty()){
            Diagram temp = runQ.poll();
            if(endDiagram.equals(temp)){
                System.out.println(temp.step);
                return;
            }
            for(Diagram d: temp.move()){
                runQ.offer(d);
            }
        }

    }
}