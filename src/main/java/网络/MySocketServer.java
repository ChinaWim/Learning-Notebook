package 网络;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author m969130721@163.com
 * @date 18-8-3 上午9:46
 */
public class MySocketServer {
    private static ConcurrentHashMap<String, Socket> client = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10001);
        ExecutorService executorService =
                new ThreadPoolExecutor(1, 10, 10L,
                        TimeUnit.HOURS, new ArrayBlockingQueue<Runnable>(1024));
        executorService.execute(() -> {
            Scanner cin = new Scanner(System.in);
            while (cin.hasNext()) {
                String message = cin.nextLine();
                Set<Map.Entry<String, Socket>> entries = client.entrySet();
                for (Map.Entry<String, Socket> entry : entries) {
                    Socket socket = entry.getValue();
                    System.out.println(entry.getKey());
                    if (socket.isClosed()) {
                        System.out.println(entry.getKey()+" socket is closed");
                        client.remove(entry.getKey());
                        continue;
                    }
                    OutputStream socketOutputStream = null;
                    try {
                        socketOutputStream = socket.getOutputStream();
                        socketOutputStream.write(message.getBytes());
                    } catch (IOException e) {
                        client.remove(entry.getKey());
                    }
                }
            }
        });

        int p = 0;
        while (true) {
            System.out.println("-----------------阻塞-----------------");
            Socket socket = serverSocket.accept();
            ReadSubSocket subSocket = new ReadSubSocket(socket);
            client.put(String.valueOf(socket.getInetAddress())+(p++), socket);
            FutureTask futureTask = new FutureTask(subSocket);
            new Thread(futureTask).start();
        }
    }

}

class ReadSubSocket implements Callable {
    private Socket socket;

    ReadSubSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public Object call() throws Exception {
        InputStream socketInputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = socketInputStream.read(buffer)) != -1) {
            System.out.println(new String(buffer, 0, length));
        }
        System.out.println("跳出循环");
        return new Object();
    }
}


