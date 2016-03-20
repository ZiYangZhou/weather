package zhouxu.weather.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zhouxu.weather.R;

/**
 * @author：Nazgol. Created at 2016/3/20.
 */
public class MainFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater layoutInflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return layoutInflater.inflate(R.layout.fragment_main, container, false);
    }
}
