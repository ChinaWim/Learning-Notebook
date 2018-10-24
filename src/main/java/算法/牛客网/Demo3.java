package 算法.牛客网;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 队列实现
 *
 * @author m969130721@163.com
 * @date 18-6-14 下午8:21
 */
public class Demo3 {
    static int box[][] = new int[1000][1000];
    static int desc[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N;
    static int min = Integer.MAX_VALUE;
    static char[][] array;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        N = cin.nextInt();
        array = new char[N][N];
        for (int i = 0; i < array.length; i++) {
            String line = cin.next();
            for (int j = 0; j < line.length(); j++) {
                array[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == '@') {
                    int step = bfs(i, j);
                    box = new int[N][N];
                    if (step < min && step != -1) {
                        min = step;
                    }
                }
            }
        }
        System.out.println(min);
    }


    static int bfs(int x, int y) {
        LinkedList<Node> queue = new LinkedList<>();
        Node headNode = new Node(x, y, 0);
        queue.add(headNode);
        while (!queue.isEmpty()) {
            Node node = queue.pop();
            if (array[node.x][node.y] == '*') {
                return node.step;
            }
            for (int i = 0; i < desc.length; i++) {
                int next_x = node.x + desc[i][0];
                int next_y = node.y + desc[i][1];
                if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= N) {
                    continue;
                }

                if (box[next_x][next_y] == 1 || array[next_x][next_y] == '#') {
                    continue;
                }
                box[next_x][next_y] = 1;
                Node newNode = new Node(next_x, next_y, node.step + 1);
                queue.add(newNode);
            }
        }
        return -1;
    }


}

class Node {
    int x;
    int y;
    int step;

    Node(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}
