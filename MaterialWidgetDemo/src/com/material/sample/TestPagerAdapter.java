package com.material.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.material.widget.TabIndicator;

/**
 * Created by IntelliJ IDEA.
 * User: keith.
 * Date: 14-9-24.
 * Time: 16:10.
 */
public class TestPagerAdapter extends FragmentPagerAdapter implements TabIndicator.TabTextProvider {

    protected static final String[] CONTENT = new String[]{"PAGE01", "PAGE02", "PAGE03", "PAGE04", "PAGE05"};

    private int mCount = CONTENT.length;

    public TestPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return WidgetFragment.newInstance(R.layout.widget_layout1);
        }
        if (position == 1) {
            return WidgetFragment.newInstance(R.layout.widget_layout2);
        } else {
            return TestFragment.newInstance(CONTENT[position]);
        }
    }

    @Override
    public String getText(int position) {
        return TestPagerAdapter.CONTENT[position % CONTENT.length];
    }

    @Override
    public int getCount() {
        return mCount;
    }
}
