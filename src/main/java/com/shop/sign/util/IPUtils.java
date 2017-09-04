package main.java.com.shop.sign.util;

import org.apache.commons.lang3.StringUtils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Pattern;

/**
 * IP工具类
 * 
 * <p>暂时只支持 IPv4 地址</p>
 * 
 * @author sunaolin
 * 
 */
public abstract class IPUtils {

    /**
     * IP地址校验规则
     */
    private static final Pattern REGX_IP = Pattern.compile("([1-9]|[1-9]\\d|1\\d{2}|2[0-1]\\d|22[0-3])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}");

    /**
     * 本地地址校验规则
     */
    private static final Pattern REGX_LOCAL_IP = Pattern.compile("127(\\.0{1,3}){2}\\.0{0,2}1");

    /**
     * 获取本地地址
     */
    private static final String LOCAL_IP = "127.0.0.1";

    /**
     * 本地地址缓存
     */
    private static String localIp;

    /**
     * 获取本机真实IP地址
     * 
     * @return 返回本机IP地址
     */
    public static String getLocalAddr() {
        if (localIp != null) {
            return localIp;
        }

        try {
            localIp = getLocalNetWorkIp();
        }
        catch (SocketException ex) {
            localIp = LOCAL_IP;
        }

        return localIp;
    }

    /**
     * 获取本机真实IP地址
     * 
     * @return 返回本机IP地址
     * 
     * @throws SocketException
     */
    private static String getLocalNetWorkIp() throws SocketException {
        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();

        while (netInterfaces.hasMoreElements()) {
            NetworkInterface ni = netInterfaces.nextElement();

            // 如果是回环和虚拟网络地址的话继续
            if (ni.isLoopback() || ni.isVirtual()) {
                continue;
            }

            Enumeration<InetAddress> addresss = ni.getInetAddresses();
            while (addresss.hasMoreElements()) {
                String localIp = getRealAddr(addresss.nextElement().getHostAddress());

                if (StringUtils.isNotBlank(localIp) && !REGX_LOCAL_IP.matcher(localIp).matches()) {
                    return localIp;
                }
            }
        }

        return LOCAL_IP;
    }

    /**
     * 获取真实IP地址
     * 
     * @param realIp IP地址
     * 
     * @return 返回真实IP地址
     */
    private static String getRealAddr(String realIp) {
        String[] ips = StringUtils.trimToEmpty(realIp).split(",");

        for (String ip : ips) {
            if (REGX_IP.matcher(ip).matches()) {
                return ip;
            }
        }
        return StringUtils.EMPTY;
    }
}