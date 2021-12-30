import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

public class BianMaTest {
    public static void main(String[] args) {

        String s1 = "001|@|2021-12-20 12:47:06|@|1|@|11101|@||@|";
        String s2 = "001|@|2021-12-20 12:47:06|@|1|@||@||@|";
        String s3 = "001|@|2021-12-20 12:47:06|@|1|@|11101|@|2|@|";
        String s4 = "001|2021-12-20 12:47:06|1|11101|||";

        String[] split1 = s1.split("\\|@\\|",-1);
        String[] split2 = s2.split("\\|@\\|",-1);
        String[] split3 = s3.split("\\|@\\|",-1);
        String[] split4 = s4.split("\\|",-1);
        System.out.println(split1.length);
        System.out.println(Arrays.toString(split1));
        System.out.println(split2.length);
        System.out.println(Arrays.toString(split2));
        System.out.println(split3.length);
        System.out.println(Arrays.toString(split3));
        System.out.println(split4.length);
        System.out.println(Arrays.toString(split4));


//        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("/Users/hanyuling/Desktop/28hao/G1UH1_101018_000000000_EI_EMPE_ADD_20211227_0001.dat")), StandardCharsets.UTF_8); LineNumberReader lr = new LineNumberReader(isr)) {
//
//            int length = 0;
//            String line = null;
//            while ((line = lr.readLine())!=null){
//                String[] split = line.split("\\|@\\|");
//                System.out.println(split.length);
//                if (length!= split.length) {
//                    System.out.println(split.length);
//                    System.out.println(line);
//                    length = split.length;
//                }
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
