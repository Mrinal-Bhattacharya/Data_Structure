package com.interviewbit.graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ValidPath {
    //These will cover all 8 side of cell
    static int[] x = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] y = {-1, 1, 0, -1, 1, 0, 1, -1};

    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        int[][] valid = new int[A + 1][B + 1];
        //int n =C;
        //int r = D;
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int z = 0; z < C; z++) {
                    if (Math.sqrt(Math.pow(E.get(z) - i, 2) + Math.pow(F.get(z) - j, 2)) <= D) valid[i][j] = -1;
                }
            }
        }
        if (valid[0][0] == -1 || valid[A][B] == -1) return "NO";
        //System.out.println("startng ending no problem");
        boolean[][] v = new boolean[A + 1][B + 1];
        v[0][0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        while (!q.isEmpty()) {
            int i = q.poll();
            int j = q.poll();
            for (int z = 0; z < 8; z++) {
                int ix = i + x[z];
                int iy = j + y[z];
                //System.out.println(ix+" "+iy);
                if (!(ix < 0 || iy < 0 || ix >= A + 1 || iy >= B + 1) && !v[ix][iy] && valid[ix][iy] != -1) {
                    //System.out.println(ix+"valid"+iy);
                    if (ix == A && iy == B) {
                        return "YES";
                    }
                    q.add(ix);
                    q.add(iy);
                    v[ix][iy] = true;
                }
            }
        }
        return "NO";
    }
}
