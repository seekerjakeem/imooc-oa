import com.imooc.oa.utils.MybatisUtils;
import org.junit.Test;

public class MybatisUtilsTester {
  @Test
  public void testCase1() {
    MybatisUtils.executeQuery(session -> {
      String out = (String)session.selectOne("test.sample");
      System.out.println(out);
      return out;
    });




  }
}
