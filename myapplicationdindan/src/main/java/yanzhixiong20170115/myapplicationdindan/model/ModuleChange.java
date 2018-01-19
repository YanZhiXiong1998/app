package yanzhixiong20170115.myapplicationdindan.model;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import yanzhixiong20170115.myapplicationdindan.utils.OkHttpUtils;

/**
 * author:Created by YanZhiXiong on 2018/1/18.
 */

public class ModuleChange {
    public void getData(String status, String id, final ModuleChangeListener moduleChangeListener){
        OkHttpUtils.getInstance().doGet("http://120.27.23.105/product/updateOrder?uid=1600&status="+status+"&orderId="+id, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                moduleChangeListener.success(string);
            }
        });
    }
    public interface ModuleChangeListener{
        void success(String s);
    }
}
