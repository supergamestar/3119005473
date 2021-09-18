import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import java.util.*;


public class Cos_Main {
    public static double Cos_Main(String s1, String s2) {

        Map<String, Vector<Integer>>thesis1= new TreeMap<String, Vector<Integer>>();//按照词的升序进行排序
        Map<String,Vector<Integer>>thesis2= new TreeMap<String, Vector<Integer>>();
        List<Term> termList = HanLP.segment(s1);//使用Hanlp分词器分词

        int pos=0;
        for (Term term : termList) {
            String s = term.toString();
            StringBuilder news = new StringBuilder();
            for (int i = 0, len=s.length(); i<len ; i++) {
                char c = s.charAt(i);
                if (String.valueOf(c).matches("[\u4e00-\u9fa5]")) {
                    news.append(c);
                }
            }

            if(thesis1.get(news.toString())==null){
                Vector<Integer>off= new Vector<Integer>(50);
                off.add(pos);
                thesis1.put(news.toString(),off);
            }

            thesis1.get(news.toString()).add(pos);
            pos++;

        }

        //相同方式处理第二个文本
        termList = HanLP.segment(s2);
        pos=0;
        for (Term term : termList) {
            String s = term.toString();
            StringBuilder news = new StringBuilder();
            for (int i = 0, len=s.length(); i<len; i++) {
                char c = s.charAt(i);
                if (String.valueOf(c).matches("[\u4e00-\u9fa5]")) {
                    news.append(c);
                }
            }

            if(thesis2.get(news.toString())==null){
                Vector<Integer>off=new Vector<Integer>(50);
                off.add(pos);
                thesis2.put(news.toString(),off);
            }

            thesis2.get(news.toString()).add(pos);
            pos++;
        }

        //算余弦
        int cnt=0;
        double Multiplier = 0, r1 = 0, r2 = 0,result=0;
        for(String key:thesis1.keySet()){

            Vector<Integer>off1=thesis1.get(key);
            Vector<Integer>off2=thesis2.get(key);

            if(off2!=null){//第二个文本中也存在这个词，计算向量
                Multiplier=r1=r2=0;
                for(int i=0;i<off1.size()&&i<off2.size();i++){
                    Multiplier+= off1.elementAt(i)*off2.elementAt(i);
                    r1+= off1.elementAt(i)*off1.elementAt(i);
                    r2+=off2.elementAt(i)*off2.elementAt(i);
                }

                r1 = Math.sqrt(r1);
                r2 = Math.sqrt(r2);
                double r = r1 * r2;
                if(r!=0){
                    result+=Multiplier/r;
                }
            }
            cnt++;
        }
        return result/cnt;
    }

}