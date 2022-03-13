import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        System.out.println("test");
//        test();
//        System.out.println("test2");
//        List<String> list = new ArrayList<>();
//        list.add("bb");
//        System.out.println(list);
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 1, 10, TimeUnit.MINUTES, new ArrayBlockingQueue(10));
        ExecutorService executorService2 = new ThreadPoolExecutor(2, 1, 10, TimeUnit.MINUTES, new LinkedBlockingQueue<>(10),new ThreadPoolExecutor.DiscardOldestPolicy());
        executorService.submit(()->{
            return 1;
        });

    }

    private static void test() {
        FileOutputStream fos = null;
        File tmp = null;
        try {
             tmp = File.createTempFile("tmp", ".tmp", new File("./log"));
            fos = new FileOutputStream(tmp, false);
            fos.write("test".getBytes(StandardCharsets.UTF_8));
            fos.flush();
            tmp.delete();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                tmp.deleteOnExit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
