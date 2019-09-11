//package 项目;
//
//import org.csource.fastdfs.*;
//
//import java.io.IOException;
//
///**
// * @author m969130721@163.com
// * @date 18-12-10 下午9:31
// */
//public class FastDFSDemo {
//
//
//    public static void main(String[] args) throws Exception {
//        //第一步初始化配置文件 要写配置文件的绝对路径
//        ClientGlobal.init("/home/ming/Project/JavaBase/src/main/resources/fdfs_client.conf");
//        //第二步: 创建TrackerClient
//        TrackerClient trackerClient = new TrackerClient();
//        //第三步: 获取TrackerServer
//        TrackerServer trackerServer = trackerClient.getConnection();
//        //第四步: 创建StorageClient
//        StorageServer storageServer = null;
//        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//        //第五步上传文件 第一个参数为原文件名全路径，第二个为扩展名，第三个为描述信息
//        String[] file = storageClient.upload_file("/home/ming/Pictures/Wallpapers/367dae718b3fb0429f808c8678b8e556.png", "png", null);
//        for (String string : file) {
//            System.out.println(string);
//        }
//
//
//    }
//}
