package 牛客网的骚题目.迷宫问题;

import java.util.*;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
   static List<List<Idx>> result = new ArrayList();
    public static void main(String[] args) {
      //  Scanner in = new Scanner(System.in);
       
      //  while (in.hasNextInt()) {
//            int a = in.nextInt();
////            int b = in.nextInt();
////            int matrx[][] = new int[a][b];
////            for(int i=0;i<matrx.length;i++){
////                for(int j=0;j<matrx[0].length;j++){
////                    //matrx[i][j]=in.nextInt();
////                }
////            }
        int tt[] = new int[10000];
            int matrx[][] = {
                    {0,1,0,0,0},
                    {0,1,0,1,0},
                    {0,0,0,1,0},
                    {0,1,1,1,0},
                    {0,0,0,1,0}
            };
//            matrx = new int[][]{
//                    {0, 1, 0},
//                    {0,1,0},
//                    {0,0,0}
//            };
            List<Idx> list = new ArrayList();
            list.add(new Idx(0,0));
            boolean bol[][] = new boolean[5][5];
            add(matrx,list,bol);
            int size = 0;
            for(int i=0;i<result.size();i++){
                if(result.get(i).size()>size){
                    size = result.get(i).size();
                }
            }

      //  }
    }

    public static void add(int m[][], List<Idx> list, boolean b[][]){
        Idx idx = list.get(list.size()-1);
        b[idx.x][idx.y]=true;
        if(idx.judge(m.length-1,m[0].length-1)){
            result.add(new ArrayList(list));
            return;
        }
        boolean canMove = false;
        if(idx.x+1<m.length&&m[idx.x+1][idx.y]!=1&&!b[idx.x+1][idx.y]){
            list.add(new Idx(idx.x+1,idx.y));
            add(m,list,b);
            list.remove(list.size()-1);
            b[idx.x+1][idx.y]=false;
            canMove=true;
        }
        if(idx.x-1>=0&&m[idx.x-1][idx.y]!=1&&!b[idx.x-1][idx.y]){
            list.add(new  Idx(idx.x-1,idx.y));
            add(m,list,b);
            list.remove(list.size()-1);
            b[idx.x-1][idx.y]=false;
            canMove=true;
        }
        if(idx.y+1<m[0].length&&m[idx.x][idx.y+1]!=1&!b[idx.x][idx.y+1]){
            list.add(new Idx(idx.x,idx.y+1));
            add(m,list,b);
            list.remove(list.size()-1);
            b[idx.x][idx.y+1]=false;
            canMove=true;
        }
        if(idx.y-1>=0&&m[idx.x][idx.y-1]!=1&&!b[idx.x][idx.y-1]){
            list.add(new Idx(idx.x,idx.y-1));
            add(m,list,b);
            list.remove(list.size()-1);
            b[idx.x][idx.y-1]=false;
            canMove=true;
        }

    }
}
class Idx{
    int x;
    int y;
    public Idx(int x,int y){
        this.x=x;
        this.y=y;
    }
    public boolean judge(int mx,int my){
        if(this.x==mx&&this.y==my){
            return true;
        }
        return false;
    }
}