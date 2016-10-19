package nus.me.net_xutlls.net;

/**
 * 网路配置
 * Created by wds on 2016/10/17.
 */

public class HttpConfig {

    // 服务器IP
    public final static String IP = "http://tsp20.chinatsp.com/";


    /**
     * URL 通用的拼接函数
     * @return
     */
    public static String appendString() {

        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(HttpConfig.IP);
        strBuilder.append("100");

        return strBuilder.toString();
    }
}
