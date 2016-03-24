package zhouxu.weather.bean;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import zhouxu.weather.util.JsonUtil;

/**
 * @author：Nazgol. Created at 2016/3/23.
 */
public class WeatherBean {
    /**
     * 未来7天的天气状态和温度
     */
    private static ArrayList<ArrayList<String>> temperature;
    private static ArrayList<String> weatherStatus;
    /**
     * 现在的天气情况
     */
    private static String nowTemperature;
    private static String nowWeatherStatus;
    private static String updateTime;
    private static String humidity;
    private static String wind;
    private static JSONObject jsonObject;
    public WeatherBean() {
        temperature = new ArrayList<ArrayList<String>>();
        weatherStatus = new ArrayList<String>();
    }
    public void setWeatherBeanByJson(JSONObject json) {
        if (json == null) {
            return;
        }
        Log.d("Json","进入setWeatherBean");
        this.jsonObject = json;
        try {
            JSONArray forcast = jsonObject.getJSONArray("daily_forecast");
            JSONObject now = jsonObject.getJSONObject("now");
            JSONObject windObject = now.getJSONObject("wind");
            /**
             * 设置当前的天气状况
             */
            this.nowTemperature = now.getString("tmp");
            this.nowWeatherStatus = now.getJSONObject("cond").getString("txt");
            this.updateTime = jsonObject.getJSONObject( "basic").getJSONObject("update").getString("loc");
            this.humidity = now.getString("hum") + "%";
            this.wind = windObject.getString("dir") + windObject.getString("sc") + "级";
            /**
             * 设置未来七天的天气状况
             */
            for (int i = 0; i < 7; ++i) {
                ArrayList<String> tmp = new ArrayList<String>();
                JSONObject day = forcast.getJSONObject(i);
                weatherStatus.add(day.getJSONObject("cond").getString("txt_d"));
                tmp.add(day.getJSONObject("tmp").getString("max"));
                tmp.add(day.getJSONObject("tmp").getString("min"));
                temperature.add(tmp);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            for (int i = 0; i < 7; ++i) {
                Log.d("WeekJson: Max:", temperature.get(i).get(0));
                Log.d("WeekJson: Min:", temperature.get(i).get(1));
            }
            return;
        }
    }

    /**
     *
     * @return
     */
    public String getNowTemperature() {
        return this.nowTemperature;
    }

    /**
     *
     * @return
     */
    public String getNowWeatherStatus() {
        return this.nowWeatherStatus;
    }

    /**
     *
     * @return
     */
    public String getUpdateTime() {
        return this.updateTime;
    }

    /**
     *
     * @return
     */
    public String getHumidity() {
        return this.humidity;
    }

    /**
     *
     * @return
     */
    public String getWind() {
        return this.wind;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> forcastWeatherStatus() {
        return this.weatherStatus;
    }

    /**
     *
     * @return
     */
    public ArrayList<ArrayList<String>> forcastTemperature() {
        return this.temperature;
    }

}
