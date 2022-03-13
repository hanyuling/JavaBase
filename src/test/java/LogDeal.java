import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LogDeal {

    Map<Long, Map<String, Integer>> second = new HashMap<>();
    Map<Long, Map<String, Integer>> danger = new HashMap<>();
    Long minDangerTime = null;
    Long minTime = null;

    private void deal(String path) {
        try (FileInputStream fileInputStream = new FileInputStream(path);
             LineNumberReader lr = new LineNumberReader(new InputStreamReader(fileInputStream))) {
            String line = null;
            while ((line = lr.readLine()) != null) {
                String[] split = line.split("\t", -1);
                dealLine(split);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dealLine(String[] split) {
        Long time = Long.parseLong(split[1]);
        String orgId = split[0];
        if (Objects.isNull(minTime) || time - minTime > 1) {
            minTime = time;
        }
        if (time - minTime <= 1) {
            Map<String, Integer> map = second.getOrDefault(minTime, new HashMap<>());
            Integer count = map.getOrDefault(orgId, 0) + 1;
            map.put(orgId, count);
            second.put(minTime, map);
            if (count > 50) {
                if (Objects.isNull(minDangerTime) || minTime - minDangerTime > 60) {
                    minDangerTime = minTime;
                }
                Map<String, Integer> dangerSix = danger.getOrDefault(minDangerTime, new HashMap<>());
                Integer dangerCount = dangerSix.getOrDefault(orgId, 0) + 1;
                dangerSix.put(orgId, dangerCount);
                danger.put(minDangerTime, dangerSix);
                if (dangerCount > 40) {
                    System.out.println(orgId + "异常活跃");
                }
            }
        }

    }


}
