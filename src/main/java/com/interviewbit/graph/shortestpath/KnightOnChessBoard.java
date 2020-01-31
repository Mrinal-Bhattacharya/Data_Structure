package com.interviewbit.graph.shortestpath;


import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoard {
    public int knight(int A, int B, int C, int D, int E, int F) {
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
        Queue<Coordinate> q = new LinkedList<>();
        q.offer(new Coordinate(C, D, 0));
        boolean visit[][] = new boolean[A + 1][B + 1];
        visit[C][D] = true;
        Coordinate temp;
        int x, y;
        while (!q.isEmpty()) {
            temp = q.poll();
            if (temp.x == E && temp.y == F) {
                return temp.dis;
            }
            for (int i = 0; i < 8; i++) {
                x = temp.x + dx[i];
                y = temp.y + dy[i];
                if (isInside(x, y, A, B) && !visit[x][y]) {
                    visit[x][y] = true;
                    q.add(new Coordinate(x, y, temp.dis + 1));
                }
            }
        }

        return -1;
    }

    private boolean isInside(final int x, final int y, final int A, final int B) {
        if (x >= 1 && x <= A && y >= 1 && y <= B) return true;
        return false;
    }

    static class Coordinate {
        int x, y;
        int dis;

        public Coordinate(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}