package zhouxu.weather.http;

import java.net.URL;

import zhouxu.weather.util.NetwirkUtil;

/**
 * @author：Nazgol. Created at 2016/3/21.
 */
public class HttpRequest {
    private static HttpRequest instance = null;
    private HttpRequest() {}

    public static HttpRequest getInstance() {
        if (instance == null) {
            instance = new HttpRequest();
        }
        return instance;
    }

    public String getJsonByCityId(String cityID) {
        String jsonResult = null;
        String httpUrl = NetwirkUtil.httpUrlHead + cityID + NetwirkUtil.key;
        /**
         * to do
         */
        try {
            URL url = new URL(httpUrl);

        }catch (Exception e) {

        }
        return jsonResult;
    }
}
