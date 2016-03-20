package zhouxu.weather;

import android.app.Application;

/**
 * @author：Nazgol. Created at 2016/3/19.
 */
public class AppContext extends Application {
    private static AppContext instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /**
     * 获取AppContext的实例
     * @return
     */
    public static AppContext getInstance() {
        return instance;
    }

    /**
     * 一些初始化操作，应该会用于初始化网络请求
     * @return
     */
    private void init() {
        /**
         * to do
         */
    }

    /**
     * 设置属性
     */
    public void setProperty(String key, String value) {
        /**
         * to do
         */
    }

    /**
     * 获取属性
     */
    public String getProperty(String key) {
        String value = null;
        /**
         * to do
         */
        return value;
    }
}
