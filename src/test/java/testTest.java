import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import util.JsonHandler;

/**
 * Created by jianghao on 2017/8/4.
 */
public class testTest extends APIBaseCase{

    @Test
    public void testtest(){
        JSONObject json = JsonHandler.initJson();
        String key = "user";
        Long param = 11929920l;
        String key2 = "weight";
        String param2 = "10公斤";

        JSONObject addr = JsonHandler.initJson();
        addr = JsonHandler.inputParam(addr, "road","文三路");
        addr = JsonHandler.inputParam(addr, "number", "No.125号");
        json = JsonHandler.inputParam(json,"address", addr);
        json = JsonHandler.inputParam(json,key,param);
        json = JsonHandler.inputParam(json,key2, param2);

        String jsonStr = json.toJSONString();
        System.out.println(jsonStr);

    }
}
