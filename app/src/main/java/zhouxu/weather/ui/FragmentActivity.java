package zhouxu.weather.ui;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import zhouxu.weather.R;
import zhouxu.weather.bean.FragmentPage;

/**
 * @author：Nazgol. Created at 2016/3/20.
 */
public class FragmentActivity extends AppCompatActivity {
    public final static String BUNDLE_KEY_PAGE = "BUNDLE_KEY_PAGE";
    public final static String BUNDLE_KEY_ARGS = "BUNDLE_KEY_ARGS";
    private int mPageValue = -1;
    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_fragment);
        mPageValue = getIntent().getIntExtra(BUNDLE_KEY_PAGE, 0);
        initFromIntent(mPageValue, getIntent());
    }
    protected void initFromIntent(int pageValue, Intent data) {
        if (data == null) {
            throw new RuntimeException(
                    "you must provide a page info to display");
        }
        FragmentPage page = FragmentPage.getPageByValue(pageValue);
        if (page == null) {
            throw  new IllegalArgumentException("can not find page by value:"
                    + pageValue);
        }
        setToolbarTitle(page.getTitle());
        try {
            Fragment fragment = (Fragment) page.getClz().newInstance();
            Bundle args = data.getBundleExtra(BUNDLE_KEY_ARGS);
            if (args != null) {
                fragment.setArguments(args);
            }
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment,"FRAGMENTACTIVITY");
            fragmentTransaction.commitAllowingStateLoss();
        }catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(
                    "generate fragment error. by value:" + pageValue);
        }
    }

    public void setToolbarTitle(int resId) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(resId));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
