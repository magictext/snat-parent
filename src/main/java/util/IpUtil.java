package util;

import org.apache.log4j.spi.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.logging.Logger;

public class IpUtil {

    public static void main(String[] args) {
        String localIp = getLocalIp(4);
        System.out.println(localIp);
        System.out.println(getLocalIp(6));
    }

    public static String getLocalIp(int version) {
            String clientIP = null;
            Enumeration<NetworkInterface> networks = null;
            try {
                //获取所有网卡设备
                networks = NetworkInterface.getNetworkInterfaces();
                if (networks == null) {
                    //没有网卡设备 打印日志  返回null结束
                    Logger.getLogger("IPUtil").warning("there is none networkinterface");
                    return null;
                }
            } catch (SocketException e) {
                System.out.println(e.getMessage());
            }
            InetAddress ip;
            Enumeration<InetAddress> addrs;
            // 遍历网卡设备
            while (networks.hasMoreElements()) {
                NetworkInterface ni = networks.nextElement();
                try {
                    //过滤掉 loopback设备、虚拟网卡
                    if (!ni.isUp() || ni.isLoopback() || ni.isVirtual()) {
                        continue;
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }
                addrs = ni.getInetAddresses();
                if (addrs == null) {
                    continue;
                }
                // 遍历InetAddress信息
                while (addrs.hasMoreElements()) {
                    ip = addrs.nextElement();
                    if (!ip.isLoopbackAddress() && !ip.isSiteLocalAddress()) {
                        try {
                            String address = ip.getHostAddress();
                            if(version==6){
                                if (address.contains(":")&&!address.contains("fe80")) {
                                    return address;
                                }
                            }else if(version==4){
                                if(!address.contains(":"))
                                    return address;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            clientIP = null;
                        }
                    }
                }
            }
            return clientIP;
        }
}

