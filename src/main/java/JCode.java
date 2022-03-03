import java.util.ArrayList;
import java.util.List;

public class JCode {
    public String Encode(String in, int drift) {
        int size = in.length();
        String input = StrToBinstr(in);
        String output = String.format("%s%s", input.substring(drift), input.substring(0, drift));
        return output;
    }

    public String Decode(String in, int drift) {
        int size = in.length();
        String input = String.format("%s%s", in.substring(size - drift), in.substring(0, size - drift));
        List<String> binaryStrList = CutBinaryStrList(input);
        StringBuilder stringBuilder = new StringBuilder();
        binaryStrList.forEach(item -> {
            stringBuilder.append((char) Integer.parseInt(item, 2));
        });
        return stringBuilder.toString();
    }

    private static String StrToBinstr(String str) {
        char[] strChar = str.toCharArray();
        String result = "";
        for (int i = 0; i < strChar.length; i++) {
            result += String.format("%8s", Integer.toBinaryString(strChar[i])).replaceAll("\\s", "0");
        }
        return result;
    }

    private static List<String> CutBinaryStrList(String in) {
        List<String> result = new ArrayList<>();
        int size = 8;
        for (int i = 0; i < in.length() / size; i++) {
            result.add(in.substring(i * size, (i + 1) * size));
        }
        return result;
    }

    private static String CutBinaryStr(String in) {
        String result = "";
        int size = 8;
        for (int i = 0; i < in.length() / size; i++) {
            result += in.substring(i * size, (i + 1) * size) + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        JCode jCode = new JCode();
        String message = "admin";
        System.out.println("原始数据:"+message);
        String in = jCode.Encode(message, 2);
        System.out.println("加密后:"+in);
        String out = jCode.Decode(in, 2);
        System.out.println("解密后:"+out);
    }
}


