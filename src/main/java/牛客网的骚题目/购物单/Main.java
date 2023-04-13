package 牛客网的骚题目.购物单;
/**
 * https://www.nowcoder.com/practice/f9c6f980eeec43ef85be20755ddbeaf4?tpId=37&tqId=21239&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D37%26type%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 */

/**
 * 4500 12
 * 100 3 0
 * 400 5 0
 * 300 5 0
 * 1400 2 0
 * 500 2 0
 * 800 2 4
 * 1400 5 4
 * 300 5 0
 * 1400 3 8
 * 500 2 0
 * 1800 4 0
 * 440 5 10
 */

import java.util.Scanner;
import java.util.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        while (in.hasNextInt()) { 
            int N = in.nextInt();
            int m = in.nextInt();
            Wu w[] = new Wu[m];
            Map<Integer, Wu> map = new HashMap<>();
            List<Wu> ll = new ArrayList<>();
            
            for(int i=0;i<m;i++){
                int v = in.nextInt();
                int p = in.nextInt();
                int q = in.nextInt();
                w[i]=new Wu(v, p, q);
                map.put(i, w[i]);
            }
            for(int i=0;i<m;i++){
                if(w[i].q!=0){
                    map.get(w[i].q-1).list.add(w[i]);
                }
            }
            for(int i=0;i<m;i++){
                if(w[i].q==0){
                    w[i].cal();
                    ll.add(w[i]);
                }
            }
            int result[][] = new int[N+1][ll.size()];
            for(int i=0;i<=N;i++){
                Wu w1 = ll.get(0);
                List<Integer> listVal = w1.listVal;
                List<Integer> price = w1.price;
                for(int j=0;j<price.size();j++){
                    if(i>=price.get(j)&&listVal.get(j)>result[i][0]){
                        result[i][0]=listVal.get(j);
                    }
                }
            }
            for(int i=1;i<=N;i++){
                for(int j=1;j<ll.size();j++){
                    int tmp = result[i][j-1];
                    Wu w1=ll.get(j);
                    List<Integer> listVal = w1.listVal;
                    List<Integer> price = w1.price;
                    for(int k=0;k<price.size();k++){
                        if(i>=price.get(k)){
                            int tt = result[i-price.get(k)][j-1]+listVal.get(k);
                            if(tt>tmp&&tt>result[i][j]){
                                result[i][j]=tt;
                            }else if(tt<tmp){
                                result[i][j]=tmp;
                            }
                        }
                    }
                }
            }
            System.out.println(result[N][ll.size()-1]);
        }
    }
static class Wu{
    int v;
    int p;
    int q;
    List<Wu> list = new ArrayList<>();
    List<Integer> listVal = new ArrayList<>();
    List<Integer> price = new ArrayList<>();
    public Wu(int v, int p, int q){
        this.v = v;
        this.p = p;
        this.q = q;
    }
    void cal(){

        int tol = 0;
        int priT = 0;
        listVal.add(this.p*this.v+tol);
        price.add(priT+this.v);
        if(list.size()==0){
            return;
        }
        for(Wu w:list){
            tol = tol+w.v*w.p;
            priT = priT+w.v;
            listVal.add(w.v*w.p+this.v*this.p);
            price.add(w.v+this.v);
        }
        listVal.add(this.p*this.v+tol);
        price.add(priT+this.v);


    }
}
}
