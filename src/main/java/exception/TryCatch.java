package exception;

import org.junit.Test;

/**
 * @author m969130721@163.com
 * @date 18-7-16 下午5:33
 */
public class TryCatch {
    public static int method() {
        int i = 10;
        try {
            int b = 1 / 0;
        } catch (Exception e) {
            i = i+10;
            return i+10;
        } finally {
            i = i+100;
        }
        return i;
    }

   @Test
    public void test1(){
       System.out.println(method());
   }

}
