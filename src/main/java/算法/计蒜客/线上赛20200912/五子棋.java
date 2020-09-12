package 算法.计蒜客.线上赛20200912;


import java.util.Scanner;

public class 五子棋 {

    /**
     * 当时比赛时没有考虑到   中间下棋左右两边连成一线情况（哎 太久没刷题 人变顿了
     * @param args
     */
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        char[][] data = new char[25][25];
        int back = 0;
        int white = 0;
        for(int i = 0; i < 25; i++){
            String row1 = cin.nextLine();
            for(int j = 0; j < row1.length(); j++){
                if(row1.charAt(j) == 'x'){
                    back ++;
                }
                if(row1.charAt(j) == 'o'){
                    white ++;
                }
                data[i][j] = row1.charAt(j);
            }
        }
        if(back < 4 && white < 4){
            System.out.println("tie");
            return;
        }
        char findValue = back <= white ? 'x' :'o';
        int [][][] dirct = {{{0,-1}, {0,1}},{{-1,0}, {1,0}},{{-1,-1}, {1,1}},{{1,-1}, {-1,1}}};

        boolean hasResult = false;
        for(int i = 0; i < 25; i ++){
                for(int j = 0; j < 25; j ++){
                if(data[i][j] == '.'){
                    for (int[][] ints : dirct) {
                        int dirctV = 0;
                        for (int[] anInt : ints) {
                            int value = dfs(i, j, 0, findValue, anInt[0], anInt[1], data);
                            dirctV += value;
                            if (dirctV >= 4) {
                                System.out.println(i+" "+j);
                                hasResult = true;
                                break;
                            }
                        }
                        if(dirctV >= 4){
                            break;
                        }
                    }
                }
            }
        }
        if(!hasResult){
            System.out.println("tie");
        }

    }

    public static int dfs(int x,int y,int step,char value,int dirct1,int dirct2, char [][] data){
        int result = step;
        if(step >= 4){
            return step ;
        }

        int next_x = x + dirct1;
        int next_y = y + dirct2;
        if(next_x >= 25 || next_x < 0 || next_y >= 25 || next_y < 0){
           return 0;
        }

        if(data[next_x][next_y] == value){
            result = dfs(next_x,next_y,step + 1,value,dirct1,dirct2,data);
        }

        return result;
    }






}
