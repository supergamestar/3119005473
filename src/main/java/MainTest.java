import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainTest {
    @Before
    public void before() throws Exception {
        System.out.println("开始测试："+"\n");
    }

    @After
    public void after() throws Exception {
        System.out.println("测试结束。"+"\n");
    }

    @Test
    public void selftest() throws Exception {
        Main.work("src/test/thesis/orig.txt","src/test/thesis/orig.txt","src/result/selftest1");
    }
    
    @Test
    public void test0() throws Exception {
        Main.work("src/test/thesis/orig.txt","src/test/thesis/empty.txt","src/result/test0");
    }

    @Test
    public void test1() throws Exception {
        Main.work("src/test/thesis/orig.txt","src/test/thesis/orig_0.8_add.txt","src/result/test1");
    }

    @Test
    public void test2() throws Exception {
        Main.work("src/test/thesis/orig.txt","src/test/thesis/orig_0.8_del.txt","src/result/test2");
    }

    @Test
    public void test3() throws Exception {
        Main.work("src/test/thesis/orig.txt","src/test/thesis/orig_0.8_dis_1.txt","src/result/test3");
    }

    @Test
    public void test4() throws Exception {
        Main.work("src/test/thesis/orig.txt","src/test/thesis/orig_0.8_dis_10.txt","src/result/test4");
    }

    @Test
    public void test5() throws Exception {
        Main.work("src/test/thesis/orig.txt","src/test/thesis/orig_0.8_dis_15.txt","src/result/test5");
    }

    @Test
    public void test6() throws Exception {
        Main.work("src/test/thesis/orig.txt","src/test/thesis/orig_0.8_dis_15.txt","src/result/test5");
    }

    @Test
    public void test7() throws Exception {
        Main.work("src/test/thesis/orig.txt","src/test/thesis/orig_0.8_dis_20","src/result/test6");
    }
}
