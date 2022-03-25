package solution;

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] map = new int[n][2];
        for(int i=0;i<n;i++){
            String[] tmp = sc.nextLine().split(" ");
            int[] tmpPos = new int[2];
            tmpPos[0] = Integer.valueOf(tmp[0]);
            tmpPos[1] = Integer.valueOf(tmp[1]);
            map[i] = tmpPos;
        }
        Arrays.sort(map, (x, y) -> (x[0]-y[0]));
        for(int[] m: map){
            System.out.println(m[0]);
        }
        int pos = 0;
        if(n%2==0){
            pos = (map[n/2][1] + map[n/2-1][0])/2;
        }else{
            pos = map[n/2][0];
        }
        int res = 0;
        for(int i=0;i<n;i++){
            res += Math.abs(map[i][0]-pos);
        }
        System.out.println(res);
    }
}