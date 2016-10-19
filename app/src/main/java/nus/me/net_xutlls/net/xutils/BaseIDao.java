package nus.me.net_xutlls.net.xutils;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;


/**
 * Created by wds on 2016/10/18.
 */

public abstract class BaseIDao {
    private INetResult mINetResult;
    private Context mContext;

    public BaseIDao(Context context, INetResult iNetResult) {
        this.mContext = context;
        this.mINetResult = iNetResult;
    }

    /**
     * 得到结果后，对结果处理逻辑
     *
     * @param result
     * @param requestCode
     * @throws java.io.IOException
     */
    public abstract void onRequestSuccess(String result, int requestCode);


    /**
     * get请求网络，本方法提供结果的分发
     *
     * @param url
     * @param requestCode
     */
    public void getRequest(String url, final int requestCode) {
        LogUtil.v("URL："+url);
        RequestCallBack<String> callBack = new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                LogUtil.v("返回数据："+responseInfo.result);
                String respStatus = null;
                try {
                    JSONObject jsonObject = new JSONObject(responseInfo.result);
                    respStatus = jsonObject.get("resp_status").toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if ("OK".equals(respStatus))
                    onRequestSuccess(responseInfo.result, requestCode);

                mINetResult.onRequestSuccess(requestCode);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                mINetResult.onRequestFailed(e.getMessage(),s);
                LogUtil.v("错误信息："+s);
            }
        };

        RequestHttp.request(url, callBack, null);
    }

    /**
     * post 请求网络，本地方法提供结果的分发
     *
     * @param url
     * @param params
     * @param requestCode
     */
    public void postRequest(String url, RequestParams params, final int requestCode) {
        RequestCallBack<String> callBack = new RequestCallBack<String>() {

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                LogUtil.v("返回数据："+responseInfo.result);
                String respStatus = null;
                try {
                    JSONObject jsonObject = new JSONObject(responseInfo.result);
                    respStatus = jsonObject.get("resp_status").toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if ("OK".equals(respStatus))
                    onRequestSuccess(responseInfo.result, requestCode);

                mINetResult.onRequestSuccess(requestCode);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                mINetResult.onRequestFailed(e.getMessage(),s);
                LogUtil.v("错误信息："+s);
            }
        };

        RequestHttp.request(url, callBack, params);
    }
}
