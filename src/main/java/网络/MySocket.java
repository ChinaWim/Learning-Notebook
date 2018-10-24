package 网络;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author m969130721@163.com
 * @date 18-8-3 上午9:46
 */


public class MySocket {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 10001);
        OutputStream outputStream = socket.getOutputStream();
        Scanner cin = new Scanner(System.in);
        String data = cin.nextLine();
        outputStream.write(data.getBytes());
        socket.shutdownOutput();
        InputStream socketInputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while((length = socketInputStream.read(buffer)) != -1){
            System.out.println(new String(buffer,0,length));
        }

    }


}
