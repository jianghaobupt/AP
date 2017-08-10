package httpbase;

import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpResponse;

/**
 * Created by jianghao on 2017/8/10.
 */
public class HttpHandler {

    public static Response post(Request request){
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(request.getUrl());
        Response response = new Response();
        try {
            StringEntity s = new StringEntity(request.getbody().toString());
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");
            post.setEntity(s);

            HttpResponse res = client.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                //todo:

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
