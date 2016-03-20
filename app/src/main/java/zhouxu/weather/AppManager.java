package zhouxu.weather;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.util.Stack;

/**
 * @author：Nazgol. Created at 2016/3/19.
 */
public class AppManager {
    private static Stack<AppCompatActivity> activityStack;
    private static AppManager instance;

    /**
     * 获取单一实例
     */
    public static AppManager getAppManager() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    /**
     * 添加新的activity到activity栈
     * @param aty
     */
    public void addActivity(AppCompatActivity aty) {
        if (activityStack == null) {
            activityStack = new Stack<AppCompatActivity>();
        }
        activityStack.push(aty);
    }

    /**
     * 获取当前的activity
     * @return
     */
    public AppCompatActivity getCurrentActivity() {
        AppCompatActivity aty = activityStack.lastElement();
        return aty;
    }

    /**
     * 结束当前activity
     */
    public void finishCurrentActivity() {
        AppCompatActivity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(AppCompatActivity activity) {
        if (activity != null && !activity.isFinishing()) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (AppCompatActivity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    /**
     * 结束所有的activity
     * @param
     */
    public void finishAllActivity() {
        for (int i = 0; i < activityStack.size(); ++i) {
            if (null == activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 结束当前程序的进程
     * @param
     */
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            // 杀死该应用进程
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
        }
    }
}
