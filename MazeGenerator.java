import java.util.*;

public class MazeGenerator {
    private static final int N = 10;
    private static final int M = 10;
    private static char[][] maze = new char[N][M];
    private static boolean[][] visited = new boolean[N][M];
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        generateMaze();
        printMaze();
        solveMaze();
    }

    private static void generateMaze() {
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maze[i][j] = rand.nextInt(4) == 0 ? '#' : ' ';
            }
        }
        maze[0][0] = 'S'; maze[N-1][M-1] = 'E';
    }

    private static void printMaze() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    private static void solveMaze() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            if (x == N-1 && y == M-1) {
                System.out.println("Maze solved!");
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && maze[nx][ny] != '#' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        System.out.println("No path found.");
    }
}