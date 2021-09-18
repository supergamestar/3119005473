import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Thesischecking {

    /*将txt文本转换为字符串*/
    public static String textToString(String inFilePath) {
        String str = "";
        File file = new File(inFilePath);
        if (!file.exists()) {
            System.out.println(inFilePath + "This File does not exist");
            System.exit(0);
        }

        long length = file.length();
        byte[] content = new byte[(int) length];

        try {
            FileInputStream in = new FileInputStream(file);
            in.read(content);
            in.close();
            str = new String(content, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /*将字符串转换成文本*/
    public static void stringToText(String outFilePath, String result) {
        File file = new File(outFilePath);

        try {
            FileWriter fw = new FileWriter(file);
            char[] cr = result.toCharArray();
            fw.write(cr);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
