package httpbase;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.StatusLine;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by mini on 2017/8/4.
 */
public class Response implements Serializable {

        private static final long serialVersionUID = 2525092903576788036L;

        private Map<String, String> header;

        private JSONObject body;

        private String sign;

        private int timeout = 3000;

        private String charset;

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

        public String getCharset() {
            return charset;
        }
        public void setCharset(String charset) {
            this.charset = charset;
        }


}
