package yanzhixiong20170115.myapplicationdindan.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import yanzhixiong20170115.myapplicationdindan.utils.OkHttpUtils;

/**
 * author:Created by YanZhiXiong on 2018/1/18.
 */

public class MyModule {
    public void getData(String uid,String page, final ModuleListeren moduleListeren){

        Map<String,String> map = new HashMap<>();
        map.put("uid",uid);
        map.put("page",page);
        map.put("source","android");

        OkHttpUtils.getInstance().doPost("https://www.zhaoapi.cn/product/getOrders", map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if(moduleListeren !=null){
                    moduleListeren.failed(e);
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                if(moduleListeren!=null){
                    moduleListeren.success(string);
                }
            }
        });
    }
    public interface ModuleListeren{
        void success(String s);
        void failed(Exception e);
    }
}
