package yanzhixiong20170115.myapplicationdindan.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * author:Created by YanZhiXiong on 2018/1/18.
 */

public class MyViewpagerAdapter extends FragmentPagerAdapter {
    List<Fragment> data;
    public MyViewpagerAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        this.data=data;

    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
