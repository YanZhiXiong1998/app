package yanzhixiong20170115.myapplicationdindan.presenter;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.IdRes;
import android.widget.RadioGroup;

import com.google.gson.Gson;

import java.util.List;

import yanzhixiong20170115.myapplicationdindan.R;
import yanzhixiong20170115.myapplicationdindan.bean.DataDataBean;
import yanzhixiong20170115.myapplicationdindan.model.MyModule;

/**
 * author:Created by YanZhiXiong on 2018/1/18.
 */

public class MyPresenter implements RadioGroup.OnCheckedChangeListener{
    MyModule myModule = new MyModule();
    Handler handler =new Handler(Looper.getMainLooper());
    ContentListeren contentListeren;

    public void setToast(ContentListeren contentListeren) {
        this.contentListeren =contentListeren;
    }
    public void getData(String uid,String page, final PresenterListeren presenterListeren){
        myModule.getData(uid,page, new MyModule.ModuleListeren() {
            @Override
            public void success(final  String s) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        DataDataBean dataDataBean = new Gson().fromJson(s, DataDataBean.class);
                        List<DataDataBean.DataBean> data = dataDataBean.getData();
                        presenterListeren.success(data);
                    }
                });
            }

            @Override
            public void failed(Exception e) {

            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
        switch (i){
            default:break;
            case R.id.raido01:
                contentListeren.setContent(0);
                break;
            case R.id.raido02:
                contentListeren.setContent(1);
                break;
            case R.id.raido03:
                contentListeren.setContent(2);
                break;
            case R.id.raido04:
                contentListeren.setContent(3);
                break;
        }
    }
    public interface PresenterListeren{
        void success( List<DataDataBean.DataBean> data);
        void failed();

    }
    public interface ContentListeren{
        void setContent(int i);
    }
}
