package httpbase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianghao on 2017/8/3.
 */
public class InitRequest {

    public static APIRequest initRequest(String url){
        APIRequest APIRequest = initRequest(null,url);

        return APIRequest;
    }

    public static APIRequest initRequest(String apiName, String url){
        Map<String, String> header = new HashMap<String ,String>();
        APIRequest APIRequest = new APIRequest();
        if(url == null){
            System.out.println("url should not be NULL !");
            return null;
        }
        if(apiName != null){
            APIRequest.setUrl(url + apiName);
        }else
            APIRequest.setUrl(url);

        /*--
        set header
         --*/
        header.put("Client-Agent", "TYYD_Android_4_0_1024_800_HW_C8812_JAVA_2_9_8/480*640/public");
        header.put("Content-type","application/json; charset=utf-8");
        header.put("Accept", "application/json");
        APIRequest.setHeader(header);

        APIRequest.setCharset("utf-8");
        APIRequest.setTimeout(3000);

        return APIRequest;
    }
}
