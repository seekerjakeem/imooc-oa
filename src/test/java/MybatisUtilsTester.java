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

  @Test
  public void testCase2() {
    String out = (String) MybatisUtils.executeQuery(session -> session.selectOne("test.sample"));
    System.out.println(out);
  }
}
