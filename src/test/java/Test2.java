import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Test2 {


    public static void main(String[] args) {
        String text = "{ \"a\": 1, \"b\": { \"c\": 2, \"d\": [3,4] } }";
        JSONObject jsonObject = JSON.parseObject(text);
        System.out.println(jsonObject);
        Map<String, String> map = getMap(jsonObject);
        System.out.println(map);
        int i =0;
        System.out.println(i++);
        System.out.println(++i);
    }

    private static Map<String, String> getMap(JSONObject jsonObject) {
        Map<String, String> map = new HashMap<>();
        Set<String> keySet = jsonObject.keySet();
        for (String s : keySet) {
            JSONObject json = null;
            try {
                json = jsonObject.getJSONObject(s);
            } catch (Exception e) {

            }
            if (Objects.nonNull(json)) {
                Map<String, String> map1 = getMap(json);
                for (String s1 : map1.keySet()) {
                    map.put(s + "." + s1, map1.get(s1));
                }
            }else {
                String string = jsonObject.getString(s);
                map.put(s, string);
            }
        }
        return map;
    }
}

/*
JSON格式转换
在某个特定应用场景中，我们有一个从JSON获取的内容，比如：
m = { "a": 1, "b": { "c": 2, "d": [3,4] } }
现在需要把这个层级的结构做展开，只保留一层key/value结构。对于上述输入，需要得到的结构是：
o = {"a": 1, "b.c": 2, "b.d": [3,4] }
也就是说，原来需要通过 m["b"]["c"] 访问的值，在展开后可以通过 o["b.c"] 访问。
请实现这个“层级结构展开”的代码。
输入：任意JSON（或者map/dict）
输出：展开后的JSON（或者map/dict）*/
