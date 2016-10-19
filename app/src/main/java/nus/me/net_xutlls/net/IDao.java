package nus.me.net_xutlls.net;


import android.content.Context;

import nus.me.net_xutlls.net.xutils.BaseIDao;
import nus.me.net_xutlls.net.xutils.INetResult;


/**
 * 请求基类
 * Created by wds on 2016/10/17.
 */

public abstract class IDao extends BaseIDao {

    public IDao(Context context, INetResult iNetResult) {
        super(context, iNetResult);
    }
}