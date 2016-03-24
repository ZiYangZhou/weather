package zhouxu.weather.util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * @author：Nazgol. Created at 2016/3/21.
 */
public class JsonUtil {

    /**
     *根据和风天气API返回的数据构造JSON对象
     * @param paramJsonStr
     * @return
     * @throws JSONException
     * @throws Exception
     */
    private static final String JSONARRAYNAME = "HeWeather data service 3.0";
    public static JSONObject getJSON(String paramJsonStr) {
        JSONObject result = null;
        try {
            result = new JSONObject(paramJsonStr);
            result = result.getJSONArray(JSONARRAYNAME).getJSONObject(0);
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }


//    public static JSONObject getAQIJsonObject(JSONArray jsonArray) {
//        if (jsonArray == null) {
//            return null;
//        }
//        JSONObject result = null;
//        try {
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        } finally {
//
//        }
//    }
}
