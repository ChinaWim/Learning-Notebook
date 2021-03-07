package 算法.leetcode.algorithms.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * [从第一个节点出发到最后一个节点的受限路径数]
 *
 * 现有一个加权无向连通图。给你一个正整数 n ，表示图中有 n 个节点，并按从 1 到 n 给节点编号；另给你一个数组 edges ，其中每个 edges[i] = [ui, vi, weighti] 表示存在一条位于节点 ui 和 vi 之间的边，这条边的权重为 weighti 。
 *
 * 从节点 start 出发到节点 end 的路径是一个形如 [z0, z1, z2, ..., zk] 的节点序列，满足 z0 = start 、zk = end 且在所有符合 0 <= i <= k-1 的节点 zi 和 zi+1 之间存在一条边。
 *
 * 路径的距离定义为这条路径上所有边的权重总和。用 distanceToLastNode(x) 表示节点 n 和 x 之间路径的最短距离。受限路径 为满足 distanceToLastNode(zi) > distanceToLastNode(zi+1) 的一条路径，其中 0 <= i <= k-1 。
 *
 * 返回从节点 1 出发到节点 n 的 受限路径数 。由于数字可能很大，请返回对 109 + 7 取余 的结果。
 *
 * 输入：n = 5, edges = [[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]
 * 输出：3
 * 解释：每个圆包含黑色的节点编号和蓝色的 distanceToLastNode 值。三条受限路径分别是：
 * 1) 1 --> 2 --> 5
 * 2) 1 --> 2 --> 3 --> 5
 * 3) 1 --> 3 --> 5
 *
 * 考点：最短路径算法 + 图的遍历方式
 * 1.dfs 2.bfs. 3.floyd 4.dijkstra 5.bellmanm(可以解决负权) 6.spfa(bellmanm的改进版本,可以解决负权)
 *
 */
//todo
public class Leetcode5699 {

    static int mod = (int)1e9+7;

    public static void main(String[] args) {
        Leetcode5699 l = new Leetcode5699();
//        [1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]
//        1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10
//        int[][] edges = new int[][]{{1,3,1},{4,1,2},{7,3,4},{2,5,3},{5,6,1},{6,7,2},{7,5,3},{2,6,4}};
        int[][] edges = new int[][]{{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}};
        System.out.println(l.countRestrictedPaths(5, edges));
    }

    public int countRestrictedPaths(int n, int[][] edges) {
        int inf = 9999999;
//        int[][] array = new int[n + 1][n + 1];
        int[][] dArray = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= n; j++){
                if(i == j){
//                    array[i][i] = 0;
                    dArray[i][i] = 0;
                }else {
//                    array[i][j] = inf;
                    dArray[i][j] = inf;
                }
            }
        }
        for(int i = 1; i <= edges.length; i ++){

            int[] edge = edges[i - 1];
            int u1 = edge[0];
            int v1 = edge[1];
            int w1 = edge[2];
//            array[u1][v1] = w1;
//            array[v1][u1] = w1;

            dArray[u1][v1] = w1;
            dArray[v1][u1] = w1;
        }
        int[][]disArray = new int[n+1][n+1];
        int[][] disBox = new int[n + 1][n + 1];
        //init dis
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= n; j ++) {
                disArray[i][j] = dArray[i][j];
            }
        }
        this.dijkstra(n,inf,disArray,disBox,dArray);

//        this.floyd(n,inf,array);
        HashMap<Integer,Integer> indexContMap = new HashMap<>();
        for(int i = 1; i <= n; i ++){
            indexContMap.put(i,disArray[i][n]);
        }
        int[]box = new int[n + 1];
        box[1] = 1;
        int[] memo = new int[n + 1];
        int result = this.dfs(1, n, inf, dArray, box, indexContMap,memo);

        memo = null;
        box = null;
        disArray = null;
        dArray = null;
        indexContMap = null;
        return result;
    }

    //O(n3)
    private void floyd(int n,int inf,int[][] array){
        for(int k = 1; k <= n ; k++ ){
            for(int i = 1; i <= n; i ++){
                for(int j = 1; j <= n; j ++){
                    if(array[i][j] > (array[i][k] + array[k][j]) && array[i][k] < inf && array[k][j] < inf ){
                        array[i][j] = (array[i][k] + array[k][j]);
                    }
                }
            }
        }
    }

    //O(n2)
    private void dijkstra(int n,int inf,int[][] dis,int[][] box,int[][] edge){
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n - 1; i ++){
                //先找出dis的当前最小值
                int min = inf;
                int u = 0;
                for(int j = 1; j <=n ; j++){
                    if(box[k][j] == 0 && dis[k][j] < min){
                        min = dis[k][j];
                        u = j;
                    }
                }
                box[k][u] = 1;
                for(int v = 1; v <= n; v++){
                    if(edge[u][v] < inf && dis[k][v] > edge[u][v] + dis[k][u]){
                        dis[k][v] = edge[u][v] + dis[k][u];
                    }
                }
            }
        }
    }


    //记忆化搜索
    private int  dfs(int cur,int n,int inf, int[][]dArray,int[] box,HashMap<Integer,Integer> indexContMap,int[] memo){
        int sum = 0;
        if(cur == n){
           return 1;
        }
        if(memo[cur] != 0){
            return memo[cur];
        }
        for(int i = 1; i <= n; i ++){
            if(box[i] == 0 && dArray[cur][i] != inf && indexContMap.get(cur) > indexContMap.get(i)){
                box[i] = 1;
                sum = (sum + dfs(i,n,inf,dArray,box,indexContMap,memo)) % mod;
                box[i] = 0;
            }
        }
        memo[cur] = sum % mod;
        return memo[cur];
    }


}
