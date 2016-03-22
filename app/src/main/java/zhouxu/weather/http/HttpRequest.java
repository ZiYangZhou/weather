package zhouxu.weather.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import zhouxu.weather.util.NetworkUtil;
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

    /**
     * 如果未得到返回数据则返回空
     * @param cityID
     * @return
     */
    public String getJsonByCityId(String cityID) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        String httpUrl = NetworkUtil.httpUrlHead + cityID + NetworkUtil.key;
        /**
         * to do
         */
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {

        }
        return result;
    }
}
