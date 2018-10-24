package 项目;

import org.apache.commons.net.ntp.*;
import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author m969130721@163.com
 * @date 18-7-20 下午3:34
 */
public class NtpDemo {

    public  String getDateTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        try {
            NTPUDPClient timeClient = new NTPUDPClient();
            InetAddress timeServerAddress = InetAddress.getByName("cn.pool.ntp.org");
            TimeInfo timeInfo = timeClient.getTime(timeServerAddress);
            TimeStamp timeStamp = timeInfo.getMessage().getTransmitTimeStamp();
            return dateFormat.format(timeStamp.getDate());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return dateFormat.format(new Date());
        } catch (IOException e) {
            e.printStackTrace();
            return dateFormat.format(new Date());
        }
    }

    public void dateTimeSynchronization(){
            String datetime = getDateTime();
            System.out.println(datetime);
            String date = datetime.substring(0, 10);
            String time = datetime.substring(11);
//            Runtime.getRuntime().exec("cmd /c date " + date); //修改应用服务器年月日
//            Runtime.getRuntime().exec("cmd /c time " + time);//修改应用服务器时分秒
    }


    @Test
    public void ntp(){
//        dateTimeSynchronization();
        try {
            NTPUDPClient timeClient = new NTPUDPClient();
            String timeServerUrl = "192.168.0.133";
            InetAddress timeServerAddress = InetAddress.getByName(timeServerUrl);
            TimeInfo timeInfo = timeClient.getTime(timeServerAddress);
            TimeStamp timeStamp = timeInfo.getMessage().getTransmitTimeStamp();
            Date date = timeStamp.getDate();
            System.out.println(date);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            System.out.println(dateFormat.format(date));

            System.out.println(new Date());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
