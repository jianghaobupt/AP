package httpbase;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by mini on 2017/8/4.
 */
public class Request implements Serializable {

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

        public void setUrl(String url) {
            this.url = url;
        }

        public Map<String, String> getHeader() {
            return header;
        }

        public void setHeader(Map<String, String> header) {
            this.header = header;
        }

        public JSONObject getbody() {
            return body;
        }

        public void setbody(JSONObject body) {
            this.body = body;
        }

        public int getTimeout() {
            return timeout;
        }

        public void setTimeout(int timeout) {
            this.timeout = timeout;
        }

        public String getCharset() {
            return charset;
        }

        public void setCharset(String charset) {
            this.charset = charset;
        }

}
