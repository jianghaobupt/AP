package httpbase;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by jianghao on 2017/8/10.
 */
public class HttpHandler {

    public static APIResponse post(APIRequest APIRequest) throws Exception{
        APIResponse response = new APIResponse();

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(APIRequest.getUrl());

        if(APIRequest.getHeader()!=null){
            Set<Map.Entry<String, String>> entries = APIRequest.getHeader().entrySet();
            for (Map.Entry<String, String> next : entries) {
                httpPost.addHeader(next.getKey(), next.getValue());
            }
        }

        httpPost.setEntity(new StringEntity(APIRequest.getbody().toString()));

        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
//        System.out.println(response.getStatusLine().getStatusCode() + "\n");
        if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            HttpEntity entity = httpResponse.getEntity();
            String responseContent = EntityUtils.toString(entity, APIRequest.getCharset());
            System.out.println(responseContent);
            response.setbody(JSONObject.parseObject(responseContent));
        }

        httpResponse.close();
        httpClient.close();

        return response;
    }

    public static APIResponse get(APIRequest APIRequest) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        APIResponse response = new APIResponse();
        //todo:

        String url = APIRequest.getUrl() + "?";
        if(APIRequest.getContent()!=null){
            Set<Map.Entry<String, String>>  entries= APIRequest.getHeader().entrySet();
            for (Map.Entry<String, String> next : entries) {
                url = url + next.getKey() + "=" + next.getValue() + "&" ;
            }
        }

        HttpGet httpGet = new HttpGet(url);

        if(APIRequest.getHeader()!=null){
            Set<Map.Entry<String, String>> entries = APIRequest.getHeader().entrySet();
            for (Map.Entry<String, String> next : entries) {
                httpGet.addHeader(next.getKey(), next.getValue());
            }
        }

        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            HttpEntity entity = httpResponse.getEntity();
            String responseContent = EntityUtils.toString(entity, APIRequest.getCharset());
            System.out.println(responseContent);
            response.setbody(JSONObject.parseObject(responseContent));
        }

        httpResponse.close();
        httpClient.close();

        return response;
    }


}
