package nus.me.net_xutlls.net.xutils;

/**
 * Activity 访问网络接口
 *
 * Created by wds on 2016/10/17.
 */

public interface INetResult {

    /**
     * 访问网络成功后更新UI
     *
     * @param requestCode 网络请求顺序号，第一个请求，NetRequestOrderNum=0,处理第一条请求的结果。如果等于1,
     *                    表示处理此页面的第二条请求
     */
    void onRequestSuccess(int requestCode);

    /**
     * 访问网络失败
     * @param errorNo
     * @param errorMessage
     */
    void onRequestFailed(String errorNo, String errorMessage);

    /**
     * 访问网络结束
     */
    void onFinished();

    /**
     * 无网络连接
     */
    void onNoConnect();

}
