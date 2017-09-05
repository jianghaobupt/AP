package httpbase;

import com.alibaba.fastjson.JSONObject;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by mini on 2017/8/4.
 */
public class APIResponse implements Serializable {

        private static final long serialVersionUID = 2525092903576788036L;

        private Map<String, String> header;

        private JSONObject body;

        private String html;

        private String sign;

        private int timeout = 3000;

        private String charset;

        private int status; //0.成功 1.执行方法失败 2.协议错误 3.网络错误

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

        public int getStatus(){ return status; }
        public void setStatus(int status) { this.status = status; }

        public String getHtml(){ return html; }
        public void setHtml(String html ){ this.html = html; }


}
