package 탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Location {

    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

}

public class 문제2_미로탈출 {

    public static int n, m;
    public static int[][] graph = new int[201][201];

    // 이동할 4가지 방향      ( 상, 하 , 좌, 우)
    // 하가 좌우보다 먼저 있기 때문에 큐에 빨리 쌓여서 우선순위가 있다.
    public static int dx[] = {-1, 1, 0, 0};
    public static int dy[] = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        Queue<Location> q = new LinkedList<>();

        q.offer(new Location(x, y));

        while (!q.isEmpty()) {
            Location location = q.poll();
            x = location.getX();
            y = location.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로 맵 외부로 빠져 나가면 안됨
                if (nx < 0 || nx > n || ny < 0 || ny > m) continue;

                // 괴물이 있을때
                if (graph[nx][ny] == 0) continue;

                // 하가 좌우보다 먼저 있기 때문에 큐에 빨리 쌓여서 우선순위가 있다.
                if (graph[nx][ny] == 1) {
                    System.out.println(graph[nx][ny]);
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Location(nx, ny));
                }

            }
        }

        // 가장 오른쪽 하단으로 최단거리
        return graph[n - 1][m - 1];

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();  // 버퍼 초기화

        // 미로 맵 만들기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();

            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';

            }
        }

        System.out.println(bfs(0, 0));

    }
}
