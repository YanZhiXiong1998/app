package yanzhixiong20170115.myapplicationdindan.presenter;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import yanzhixiong20170115.myapplicationdindan.bean.DataChangeBean;
import yanzhixiong20170115.myapplicationdindan.model.ModuleChange;

/**
 * author:Created by YanZhiXiong on 2018/1/18.
 */

public class PresenterChange {
    private ModuleChange moduleChange = new ModuleChange();
    PresenterChangeListener presenterChangeListener;

    public PresenterChange(PresenterChangeListener presenterChangeListener) {
        this.presenterChangeListener = presenterChangeListener;
    }

    private Handler handler = new Handler(Looper.getMainLooper());
    public void getData(String status,String id){
        moduleChange.getData(status, id, new ModuleChange.ModuleChangeListener() {
            @Override
            public void success(final String s) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        DataChangeBean dataChangeBean = new Gson().fromJson(s, DataChangeBean.class);
                        if(presenterChangeListener !=null){

                            presenterChangeListener.mySuccess(dataChangeBean);

                        }
                    }
                });

            }
        });
    }
    public interface PresenterChangeListener{
        void mySuccess(DataChangeBean dataChangeBean);
    }
}
