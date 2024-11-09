import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

    static int[][]  map;
    static int endx,endy;
    static int[][] isVisited;
    static int N;
    static int Area;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for(int k = 0; k < N; k++) {
            Area = sc.nextInt();
            int startx = sc.nextInt();
            int starty = sc.nextInt();
            endx = sc.nextInt();
            endy = sc.nextInt();

            map = new int[Area][Area];
            isVisited = new int[Area][Area];
            for (int i = 0; i < Area; i++) {
                Arrays.fill(isVisited[i], -1);  // 각 행을 -1로 채움
            }

            System.out.println(bfs(startx,starty));
        }
        sc.close();

    }

    public static int bfs(int startx, int starty) {

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {startx,starty});
        isVisited[startx][starty] =0;

        while(!que.isEmpty()) {
            int[] qstart = que.poll();
            int qx = qstart[0];
            int qy = qstart[1];
            if(qx == endx && qy == endy) {
                return isVisited[qx][qy];
            }
            int[][] arr = {{qx + 2, qy + 1},{qx + 2, qy -1},{qx - 2, qy + 1},{qx - 2, qy -1},{qx + 1, qy + 2},{qx - 1, qy + 2},{qx + 1, qy - 2},{qx - 1, qy - 2}};
            for(int[] i : arr) {
                int a = i[0];
                int b = i[1];
                if(a >= 0 && a < Area && b >= 0 && b < Area && isVisited[a][b] == -1) {
                    que.add(new int[] {a,b});
                    isVisited[a][b] = isVisited[qx][qy] + 1;

                }
            }
        }

        return -1;
    }

}
