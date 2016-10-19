package nus.me.net_xutlls.presenter;

import android.content.Context;
import android.util.Log;

import nus.me.net_xutlls.bean.NewsService;
import nus.me.net_xutlls.net.HttpConfig;
import nus.me.net_xutlls.net.xutils.BaseIDao;
import nus.me.net_xutlls.net.xutils.INetResult;

/**
 * Created by nus on 16-10-19.
 */

public class NewsPresentDao extends BaseIDao{


    private NewsService mNewsService;
    private Context mContext;
    private String Key ="f59e84b6381469d83e947ab566890987";
    private int CODE_WEATHER_SERVICE = 0;

    public NewsPresentDao(Context context, INetResult iNetResult) {
        super(context, iNetResult);
        mContext = context;
    }


    public NewsService getmNewsService(String type) {
    StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HttpConfig.IP);
        stringBuilder.append("type="+type);
        stringBuilder.append("&");
        stringBuilder.append("key="+Key);
        getRequest(stringBuilder.toString(), CODE_WEATHER_SERVICE);

        return mNewsService;
    }



    @Override
    public void onRequestSuccess(String result, int requestCode) {
        Log.e("result",result);

    }


}
