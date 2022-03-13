import java.util.Scanner;

public class StringFormat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        //this,is,an,eggplant,of,our,beautifull,sweety,baby
        int num = sc.nextInt();
        String[] split = line.split(",");
        int end = 0;
        int start = 0;
        while (start < split.length) {
            String[] format = format(num, split, start, end, 0);
            start = start + format.length;
            end = start;
            if (end != split.length) {
                print(num, format);
            }
            int count = 0;
            for (int j = 0; j < format.length; j++) {
                System.out.println(format[j]);
                System.out.println("*");
                count += format[j].length() + 1;
            }
            System.out.println();
        }

    }

    private static void print(int num, String[] format) {
        int len = 0;
        for (int i = 0; i < format.length; i++) {
            len += format[i].length();
        }
        int xinNum = (num - len);
        int yu = 0;
        if (format.length > 1) {
            xinNum = (num - len) / (format.length - 1);
            yu = (num - len) % (format.length - 1);
        }
        int count = 0;
        for (int i = 0; i < format.length; i++) {
            System.out.print(format[i]);
            count += format[i].length();
            for (int j = 0; j < xinNum && i < format.length - 1; j++) {
                System.out.print("*");
                count++;
            }
            if (yu != 0) {
                System.out.print("*");
                count++;
                yu--;
            }
        }
        if (count < num) {
            int x = num - count;
            for (int j = 0; j < x; j++) {
                System.out.print("*");
            }
        }
        System.out.println();
    }

    public static String[] format(int n, String[] words, int start, int end, int length) {
        if (end == words.length || length + words[end].length() > n - 1) {
            String[] spWords = new String[end - start];
            System.arraycopy(words, start, spWords, 0, spWords.length);
            return spWords;
        }
        return format(n, words, start, end + 1, length + words[end].length());
    }
}
