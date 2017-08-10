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
        httpPost.setEntity(new StringEntity(request.getbody().toString()));

        if(request.getHeader()!=null){
            Set<Map.Entry<String, String>> entries = request.getHeader().entrySet();
            for (Map.Entry<String, String> next : entries) {
                httpPost.addHeader(next.getKey(), next.getValue());
            }
        }

        CloseableHttpResponse httpresponse = httpClient.execute(httpPost);
//        System.out.println(response.getStatusLine().getStatusCode() + "\n");
        if(httpresponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            HttpEntity entity = httpresponse.getEntity();
            String responseContent = EntityUtils.toString(entity, "UTF-8");
            System.out.println(responseContent);
            response.setbody(JSONObject.parseObject(entity.getContent().toString()));
        }
        httpresponse.close();
        httpClient.close();

//        HttpClient client = new DefaultHttpClient();
//        HttpPost post = new HttpPost(request.getUrl());
//        Response response = new Response();
//        try {
//            StringEntity s = new StringEntity(request.getbody().toString());
//            s.setContentEncoding(request.getCharset());
//            s.setContentType("application/json");
//            post.setEntity(s);
//
//            HttpResponse res = client.execute(post);
//            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
//                //todo:
//
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        return response;
    }

    public static Response get(Request request){
        Response response = new Response();
        //todo:
        HttpGet httpGet = new HttpGet(request.getUrl());


        return response;
    }


}
