import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {

        work(args[0],args[1],args[2]);

    }

    public static void work(String s1, String s2, String s3) {

        String originString = Thesischecking.textToString(s1);
        String copyString = Thesischecking.textToString(s2);
        double ans =Cos_Main.Cos_Main(originString,copyString);
        String ansString = Main.process(ans);
        Thesischecking.stringToText(s3,"origintextpath : "+s1+"\n"+"copytextpath : "+s2+"\n"+"answertextpath : "+s3+"\n"+"论文重复率 : "+ansString+"%");
        System.out.println("论文重复率 :"+ansString+"%"+"\n");

    }

    /*四舍五入保留两位小数*/
    public static String process(double ans) {
        BigDecimal decimal = new BigDecimal(ans * 100.0D);
        String Ans = decimal.setScale(2, RoundingMode.HALF_UP).toPlainString();
        return Ans;
    }
}
