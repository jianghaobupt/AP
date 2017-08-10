package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javafx.tools.doclets.internal.toolkit.util.Group;

/**
 * Created by jianghao on 2017/8/7.
 */
public class JsonHandler {

    /*
    初始化json对象
     */
    public static JSONObject initJson() {
        JSONObject json = new JSONObject();
        return json;
    }

    /*
    插入json字段
     */
    public static JSONObject inputParam(JSONObject json, String key, Object param){
        json.put(key, param);
        return json;
    }

    /*
    序列化
     */
    public static String encode(JSONObject json, Group group){
        return json.toJSONString(group);
    }

}
