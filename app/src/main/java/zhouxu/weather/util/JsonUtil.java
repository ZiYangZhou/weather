package zhouxu.weather.util;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * @author：Nazgol. Created at 2016/3/21.
 */
public class JsonUtil {

    /**
     *
     * @param paramJsonStr
     * @return
     * @throws JSONException
     * @throws Exception
     */
    public static JSONObject getJSON(String paramJsonStr) {
        try {
            return new JSONObject(paramJsonStr);
        } catch (JSONException e) {

        } finally {
            return null;
        }

    }

}
