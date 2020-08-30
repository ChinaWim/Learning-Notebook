package 算法.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * todo
 */
public class Leetcode120 {
    /**
     * 方法一：dfs 走两步
     * 方法二：dp
     *
     */
    int min = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
             return 0;
        }
        return this.dfs(triangle,0,0,0,triangle.get(0).get(0));
    }

    private int dfs(List<List<Integer>> triangle, int x, int y, int step,int dataSum) {
        if (x == triangle.size() - 1) {
            min = Math.min(min,dataSum);
            return triangle.get(x).get(y);
        }

        int sum = 0;
        if (x + 1 < triangle.size() && y + 1 < triangle.get(x + 1).size() ) {
            if(dataSum+triangle.get(x + 1).get(y) >= min && dataSum+triangle.get(x + 1).get(y+1) < min){
                sum = triangle.get(x).get(y) + dfs(triangle, x + 1, y + 1, step + 1,dataSum+triangle.get(x + 1).get(y + 1));
            }else if(dataSum+triangle.get(x + 1).get(y) < min && dataSum+triangle.get(x + 1).get(y+1) >= min){
                sum = triangle.get(x).get(y) +  dfs(triangle, x + 1, y, step + 1,dataSum+triangle.get(x + 1).get(y));
            }else {
                sum = triangle.get(x).get(y) +  Math.min(dfs(triangle, x + 1, y, step + 1,dataSum+triangle.get(x + 1).get(y)),
                        dfs(triangle, x + 1, y + 1, step + 1,dataSum+triangle.get(x + 1).get(y + 1)));
            }

        }
        return sum;
    }


//[[1],[2,3]]
//    [[-1],[2,3],[1,-1,-1]]
//    [[2],[3,4],[6,5,7],[4,1,8,3]]
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        System.out.println(a.remove(3));


//        Leetcode120 leetcode120 = new Leetcode120();
//        List<List<Integer>> triangle = new ArrayList<>();
//        List<Integer> row1 = new ArrayList<>();
//        List<Integer> row2 = new ArrayList<>();
//        List<Integer> row3 = new ArrayList<>();
//        List<Integer> row4 = new ArrayList<>();
//        row1.add(2);
//        row2.add(3);
//        row2.add(4);
//        row3.add(6);
//        row3.add(5);
//        row3.add(7);
//        row4.add(4);
//        row4.add(1);
//        row4.add(8);
//        row4.add(3);
//
//
//        triangle.add(row1);
//        triangle.add(row2);
//        triangle.add(row3);
//        triangle.add(row4);
//        System.out.println(leetcode120.minimumTotal(triangle));
    }


}
