
import org.testng.annotations.*;
/**
 * Created by jianghao on 2017/8/3.
 */
public class APIBaseCase {

    String urlApp = "http://daily.52shangou.com/";
    String urlWeb = "https://dailyka.52shangou.com";

    @Parameters({"testEnv"})
    @BeforeClass
    public void setUp(String testEnv){
        System.out.println("------ Test Environment is " + testEnv + "------");
        if(testEnv.equals("daily")){
            urlApp = "http://daily.52shangou.com/";
            urlWeb = "https://dailyka.52shangou.com";
        } else if(testEnv.equals("gray")){
            urlApp = "http://gray.52shangou.com/";
            urlWeb = "https://grayka.52shangou.com";
        } else if(testEnv.equals("online")){
            urlApp = "http://www.52shangou.com/";
            urlWeb = "https://ka.52shangou.com/";
        }

    }

    @Test
    public void test(){

    }

}
