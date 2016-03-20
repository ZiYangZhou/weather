package zhouxu.weather.ui;


import android.app.Activity;
import android.os.Bundle;

import zhouxu.weather.R;

/**
 * @author：Nazgol. Created at 2016/3/20.
 */
public class FragmentActivity extends Activity {
    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_fragment);
    }
}
