import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        HashMap map = new HashMap();
        map.put("a", "d");

        List<MapTest> list = new ArrayList<>();
        MapTest mapTest = new MapTest("a", "a");
        MapTest mapTest2 = new MapTest("a", "b");
        MapTest mapTest3 = new MapTest("b", "b");
        MapTest mapTest4 = new MapTest("c", "c");
        MapTest mapTest5 = new MapTest("d", "d");
        list.add(mapTest5);
        list.add(mapTest2);
        list.add(mapTest3);
        list.add(mapTest4);
        list.add(mapTest);
        Map<String, MapTest> collect = list.stream().collect(Collectors.toMap(MapTest::getKey, a -> a, (a, b) -> a));
        System.out.println(collect);

    }


}

class ReflactTest {
    private String t = "aa";
}

class MapTest {
    String key;
    String value;

    public MapTest(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MapTest{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

class MyExecption extends Exception {
    String ms = "adfadsf";

    public MyExecption(String ms) {
        super(ms);
        this.ms = ms;
    }
}
