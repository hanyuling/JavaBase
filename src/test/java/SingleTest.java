import java.util.HashMap;
import java.util.Map;

public class SingleTest {

    private static volatile SingleTest single= null;

    private SingleTest(){

    }

    public static SingleTest getSingleTest() {
        if (single == null) {
            synchronized (SingleTest.class) {
                if (single == null) {
                    single = new SingleTest();
                }
            }
        }
        return single;
    }
}

//1. 寻找最小子字符串
//    1. 给出一个大字符串str1以及一个独立的小字符串str2，您需要从这个大字符串str1里找到包含独立小字符串str2中所有字符的最小子字符串str3；
//    2. 例如，给出一个大字符串"liepin2022"和一个子字符串"i2p"，那么您给出的答案就应该是"pin2"；
//    3. 注意，str1可能更长，里面有多个包含str2的子字符串
