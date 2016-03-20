package zhouxu.weather.bean;

import zhouxu.weather.R;
import zhouxu.weather.fragment.AboutFragment;

/**
 * @author：Nazgol. Created at 2016/3/20.
 */
public enum  FragmentPage {
    ABOUT(1, R.string.about, AboutFragment.class);
    private int title;
    private Class<?> clz;
    private int value;
    private FragmentPage(int value, int title, Class<?> clz) {
        this.value = value;
        this.title = title;
        this.clz = clz;
    }

}
