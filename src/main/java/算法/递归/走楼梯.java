package 算法.递归;

public class 走楼梯 {

    public static void main(String[] args) {
        while(true){
            System.out.println(1);
        }
//        System.out.println(dfs(0,9));
    }


    public static int dfs(int step, int n) {
        if (n == 1) {
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return dfs(step + 1, n - 1) + dfs(step + 2, n - 2);
    }

}
