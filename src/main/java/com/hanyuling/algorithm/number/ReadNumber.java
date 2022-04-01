package com.hanyuling.algorithm.number;

public class ReadNumber {


    public static void main(String[] args) {
        int num = 600003405;
//        int num = Integer.MAX_VALUE;
        System.out.println(num);
        System.out.println(readNumber(num));
        System.out.println(read2(num));
    }

    public static String read2(int num) {
        StringBuilder sb = new StringBuilder();
        String sNum = String.valueOf(num);
        int u = sNum.length();

        boolean flag = false;
        for (int i = 0; i < sNum.length(); i++) {
            char c = sNum.charAt(i);
            String number = getNumber2(c);
            if (c == '0') {
                u--;
                if (u % 4 == 0) {
                    sb.append(getBig(u / 4));
                    continue;
                }
                if (!flag) {
                    sb.append(number);
                }
                flag = true;
                continue;
            }
            sb.append(number);
            String unit = getUnit2(u % 4);
            sb.append(unit);
            u--;
            if (u % 4 == 0) {
                sb.append(getBig(u / 4));
            }
            flag = false;
        }
        return sb.toString();
    }

    public static String readNumber(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        StringBuilder sb = new StringBuilder();
        int c = chars.length;
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            char n = chars[i];
            if (n == '0') {
                if (c % 4 == 1) {
                    c--;
                    if (sb.charAt(sb.length() - 1) == '零' && sb.charAt(sb.length() - 2) != '亿') {
                        sb = sb.deleteCharAt(sb.length() - 1);
                        flag = false;
                    } else if (sb.charAt(sb.length() - 1) != '零') {
                        String big = getBig(c / 4);
                        sb.append(big);
                    }
                } else {
                    if (!flag) {
                        sb.append(getNumber2(n));
                    }
                    c--;
                    flag = true;
                }
                continue;
            }
            sb.append(getNumber2(n));
            String unit = getUnit2(c % 4);
            sb.append(unit);
            c--;
            if (c % 4 == 0) {
                String big = getBig(c / 4);
                sb.append(big);
            }
            flag = false;
        }
        return sb.toString();
    }


    private static String getNumber2(char single) {
        String number = "";
        switch (single) {
            case '1':
                number = "一";
                break;
            case '2':
                number = "二";
                break;
            case '3':
                number = "三";
                break;
            case '4':
                number = "四";
                break;
            case '5':
                number = "五";
                break;
            case '6':
                number = "六";
                break;
            case '7':
                number = "七";
                break;
            case '8':
                number = "八";
                break;
            case '9':
                number = "九";
                break;
            default:
                number = "零";
                break;
        }
        return number;
    }

    private static String getBig(int i) {
        String unit = "";
        switch (i) {
            case 1:
                unit = "万";
                break;
            case 2:
                unit = "亿";
                break;
            default:
                break;
        }
        return unit;
    }

    private static String getUnit2(int i) {
        String unit = "";
        switch (i) {
            case 1:
                break;
            case 2:
                unit = "十";
                break;
            case 3:
                unit = "百";
                break;
            case 0:
                unit = "千";
                break;
            default:
                break;
        }
        return unit;
    }

    public static String read(int num) {
        StringBuilder builder = new StringBuilder();
        int tmp = num;
        boolean flag = false;
        for (int i = 10; i < num * 10; i *= 10) {
            int single = tmp % i;
            int ss = single * 10 / i;
            String unit = getUnit(i);
            String n = getNumber(ss);
            if (ss == 0) {
                if (!flag) {
                    builder.append(n);
                }
                flag = true;
                continue;
            }
            builder.append(unit);
            builder.append(n);
            flag = false;
        }

        return builder.reverse().toString();
    }

    private static String getNumber(int single) {
        String number = "";
        switch (single) {
            case 1:
                number = "一";
                break;
            case 2:
                number = "二";
                break;
            case 3:
                number = "三";
                break;
            case 4:
                number = "四";
                break;
            case 5:
                number = "五";
                break;
            case 6:
                number = "六";
                break;
            case 7:
                number = "七";
                break;
            case 8:
                number = "八";
                break;
            case 9:
                number = "九";
                break;
            default:
                number = "零";
                break;
        }
        return number;
    }

    private static String getUnit(int i) {
        String unit = "";
        switch (i) {
            case 10:
                break;
            case 100:
                unit = "十";
                break;
            case 1000:
                unit = "百";
                break;
            case 10000:
                unit = "千";
                break;
            case 100000:
                unit = "万";
                break;
            case 1000000:
                unit = "十万";
                break;
            default:
                break;
        }
        return unit;
    }
}
