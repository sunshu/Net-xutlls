package nus.me.net_xutlls.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import nus.me.net_xutlls.R;
import nus.me.net_xutlls.base.BaseActivity;
import nus.me.net_xutlls.presenter.NewsPresentDao;

public class MainActivity extends BaseActivity {


    NewsPresentDao newsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsDao = new NewsPresentDao(this,this);
        newsDao.getmNewsService("top");




    }




    @Override
    public void onRequestFailed(String errorNo, String errorMessage) {
        super.onRequestFailed(errorNo, errorMessage);
        Log.e("i","success"+errorMessage+"---"+errorNo);
    }

    @Override
    public void onRequestSuccess(int requestCode) {
        super.onRequestSuccess(requestCode);

        Log.e("i","success");
    }
}
