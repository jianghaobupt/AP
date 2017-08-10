package httpbase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianghao on 2017/8/3.
 */
public class InitRequest {

    public static Request initRequest(String url){
        Request request = initRequest(null,url);

        return request;
    }

    public static Request initRequest(String apiName, String url){
        Map<String, String> header = new HashMap<String ,String>();
        Request request = new Request();

        if(url != null){
            if(apiName != null){
                request.setUrl(url+apiName);
            }
            request.setUrl(url);
        }
        request.setCharset("utf-8");
        request.setTimeout(3000);
        request.setHeader(header);
        header.put("Client-Agent", "TYYD_Android_4_0_1024_800_HW_C8812_JAVA_2_9_8/480*640/public");
        return request;
    }
}
