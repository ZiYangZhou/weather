package zhouxu.weather.util;

import android.content.Context;
import android.content.Intent;

import zhouxu.weather.bean.FragmentPage;
import zhouxu.weather.ui.FragmentActivity;

/**
 * @author：Nazgol. Created at 2016/3/20.
 */
public class UIHelper {
    public static void showAboutFragment(Context context){
        showFragmentPage(context, FragmentPage.ABOUT);
    }
    public static void showFragmentPage(Context context, FragmentPage page) {
        Intent intent = new Intent(context, FragmentActivity.class);
        intent.putExtra(FragmentActivity.BUNDLE_KEY_PAGE, page.getValue());
        context.startActivity(intent);
    }
}
