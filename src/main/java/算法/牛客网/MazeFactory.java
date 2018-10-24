package 算法.牛客网;

import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author m969130721@163.com
 * @date 18-7-27 下午1:27
 */
class Maze{
    private String mode;
    Maze(String mode){
        this.mode = mode;
    }
    void setXY(String point,String[][] strArray){
        String[] oo = point.split(" ");
        String o1 = oo[0];
        String[] xy1 = o1.split(",");
        int x1 = Integer.parseInt(xy1[0]);
        int y1 = Integer.parseInt(xy1[1]);
        String o2 = oo[1];
        String[] xy2 = o2.split(",");
        int x2 = Integer.parseInt(xy2[0]);
        int y2 = Integer.parseInt(xy2[1]);
        int rX1 = (x1)*2 + 1;
        int rX2 = (x2)*2 + 1;
        int rY1 = (y1)*2 + 1;
        int rY2 = (y2)*2 + 1;
        if (rX1 == rX2) {
            int max = Math.max(rY1, rY2);
            strArray[rX1][max - 1] = "[R]";
        }else if(rY1 == rY2){
            int max = Math.max(rX1, rX2);
            strArray[max - 1][rY1] = "[R]";
        }
    }

    public String render(){
        StringBuilder sb = new StringBuilder();
        String[] split = mode.split("#");
        String command1 = split[0];
        String command2 = split[1];
        int row = 0;
        int col = 0;
        String[] commandSplit1 = command1.split(" ");

        try{
            Integer numberRow = Integer.parseInt(commandSplit1[0]);
            Integer numberCol = Integer.parseInt(commandSplit1[1]);
            if(0 == numberRow || 0 == numberCol){
               return "";
            }
            row = 3 + (numberRow - 1) * 2;
            col = 3 + (numberCol - 1) * 2;
            String[][] strArray = new String[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if ((i + 1) % 2 == 0 && (j + 1) % 2 == 0) {
                        strArray[i][j] = "[R]";
                    } else {
                        strArray[i][j] = "[W]";
                    }
                }
            }
            String[] commandSplit2 = command2.split(";");
            if(commandSplit2 == null){
                setXY(command2,strArray);
            }else{
                for (String point : commandSplit2) {
                    setXY(point,strArray);
                }
            }
            for(int i = 0; i <strArray.length; i ++){
                for(int j = 0; j <strArray[0].length; j ++){
                    sb.append(strArray[i][j]);
                }
                sb.append("\n");
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        return sb.toString();
    }
}

public class MazeFactory {

    public Maze create(String command){
        return new Maze(command);
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String command = "";
        for (int i = 2; i > 0; i--) {
            if(i == 2) {
                command += cin.nextLine() +"#";
            }else{
                command += cin.nextLine();
            }
        }
        MazeFactory mazeFactory = new MazeFactory();
        Maze maze = mazeFactory.create(command);
        System.out.println(maze.render());
    }

}
