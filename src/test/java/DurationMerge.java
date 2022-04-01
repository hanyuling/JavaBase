import java.util.ArrayList;
import java.util.Arrays;

public class DurationMerge {


//    int[][] = {{0,2}, {4,8}, {1,6} , {5,6}};
//    int mergeClips(int[][] , int duration);

    public static void main(String[] args) {
        int[][] nums ={{0,2}, {4,8}, {1,6} , {9,10}};
        int[][] ints = mergeDuration(nums);
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }

        System.out.println();
        int duration = 8;
        for (int[] num : ints) {
            System.out.println(Arrays.toString(num));
        }
    }

    public static int[][] mergeDuration(int[][] dura) {

        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < dura.length; i++) {
            for (int j = i+1; j < dura.length; j++) {
                if (dura[i][0] < dura[j][1] && dura[i][1] > dura[j][0]) {
                    if (dura[i][0] < dura[j][0]) {
                        dura[j][0] = dura[i][0];
                    }
                    if (dura[j][1] < dura[i][1]) {
                        dura[j][1] = dura[i][1];
                    }
                    dura[i][0] = -1;
                    dura[i][1] = -1;
                }
            }
        }
        for (int i = 0; i < dura.length; i++) {
            if (dura[i][0] == -1 && dura[i][1] == -1) {
                continue;
            }
            result.add(dura[i]);
        }
        return result.toArray(new int[0][]);
    }
}
