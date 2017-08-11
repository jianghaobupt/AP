package httpbase;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by jianghao on 2017/8/10.
 */
public class HttpHandler {

    public static Response post(Request request) throws Exception{
        Response response = new Response();

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(request.getUrl());

        if(request.getHeader()!=null){
            Set<Map.Entry<String, String>> entries = request.getHeader().entrySet();
            for (Map.Entry<String, String> next : entries) {
                httpPost.addHeader(next.getKey(), next.getValue());
            }
        }

        httpPost.setEntity(new StringEntity(request.getbody().toString()));

        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
//        System.out.println(response.getStatusLine().getStatusCode() + "\n");
        if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            HttpEntity entity = httpResponse.getEntity();
            String responseContent = EntityUtils.toString(entity, request.getCharset());
            System.out.println(responseContent);
            response.setbody(JSONObject.parseObject(responseContent));
        }

        httpResponse.close();
        httpClient.close();

        return response;
    }

    public static Response get(Request request) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Response response = new Response();
        //todo:

        String url = request.getUrl() + "?";
        if(request.getContent()!=null){
            Set<Map.Entry<String, String>>  entries= request.getHeader().entrySet();
            for (Map.Entry<String, String> next : entries) {
                url = url + next.getKey() + "=" + next.getValue() + "&" ;
            }
        }

        HttpGet httpGet = new HttpGet(url);

        if(request.getHeader()!=null){
            Set<Map.Entry<String, String>> entries = request.getHeader().entrySet();
            for (Map.Entry<String, String> next : entries) {
                httpGet.addHeader(next.getKey(), next.getValue());
            }
        }

        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        if(httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            HttpEntity entity = httpResponse.getEntity();
            String responseContent = EntityUtils.toString(entity, request.getCharset());
            System.out.println(responseContent);
            response.setbody(JSONObject.parseObject(responseContent));
        }

        httpResponse.close();
        httpClient.close();

        return response;
    }


}
