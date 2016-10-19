package nus.me.net_xutlls.net.xutils;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class RequestHttp {
    static HttpUtils httpUtils = null;

    private RequestHttp() {

    }

    /**
     * 访问后台服务器获取数据
     *
     * @param paramUrl      访问后台的URL地址
     * @param paramCallBack 回调方法
     * @param params        请求访问的参数
     */
    public synchronized static void request(String paramUrl, RequestCallBack<String> paramCallBack, RequestParams params) {

        if (httpUtils == null) {
            httpUtils = new HttpUtils();
        }
        // 设置超时时间
        httpUtils.configCurrentHttpCacheExpiry(1000 * 8);// 连接超时时间
        httpUtils.configSoTimeout(5 * 1000);// 获取数据超时  //指的是连接上一个url，获取response的返回等待时间
        // 设置线程数
        httpUtils.configRequestThreadPoolSize(1);
        httpUtils.configResponseTextCharset("utf-8");
        if (params == null) {
            httpUtils.send(HttpMethod.GET, paramUrl, paramCallBack);
        } else {
            httpUtils.send(HttpMethod.POST, paramUrl, params, paramCallBack);
        }

    }

}
