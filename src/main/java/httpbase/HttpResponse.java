package httpbase;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by mini on 2017/8/4.
 */
public class HttpResponse implements Serializable {

        private static final long serialVersionUID = 2525092903576788036L;

        private String url;

        private Map<String, String> header;

        private JSONObject body;

        private String sign;

        private int timeout = 3000;

        private String charset;

        public String getUrl() {
            return url;
        }

        public Map<String, String> getHeader() {
            return header;
        }

        public JSONObject getbody() {
            return body;
        }

        public int getTimeout() {
            return timeout;
        }

        public String getCharset() {
            return charset;
        }

        public void setCharset(String charset) {
            this.charset = charset;
        }
    
}
