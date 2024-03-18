import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {

        Map<Key, String> map = new HashMap<>();
        Key key = new Key(12,"dd");

        System.out.println(key.hashCode());
        map.put(key, "dd");
        key.va = 13;
        System.out.println(key.hashCode());
        System.out.println(map.get(key));
        key.st = "ada";
        System.out.println(key.hashCode());
        System.out.println(map.get(key));
    }
    static class Key {
        Integer va;
        String st;

        public Key(Integer va, String st) {

            this.va = va;
            this.st = st;
        }

        public void setVa(Integer va) {
            this.va = va;
        }

        @Override
        public int hashCode() {
            return 123;
        }
    }
}
