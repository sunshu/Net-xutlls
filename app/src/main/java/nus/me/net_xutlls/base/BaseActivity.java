package nus.me.net_xutlls.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import nus.me.net_xutlls.net.xutils.INetResult;

/**
 * Created by nus on 16-10-19.
 */

public class BaseActivity extends AppCompatActivity implements INetResult {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }

    @Override
    public void onRequestSuccess(int requestCode) {

    }

    @Override
    public void onRequestFailed(String errorNo, String errorMessage) {

    }

    @Override
    public void onFinished() {

    }

    @Override
    public void onNoConnect() {

    }
}
