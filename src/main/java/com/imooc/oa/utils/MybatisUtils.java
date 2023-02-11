package com.imooc.oa.utils;

import java.io.IOException;
import java.io.Reader;
import java.util.function.Function;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
  private static SqlSessionFactory sqlSessionFactory = null;
  static {
    Reader reader = null;
    try {
      reader = Resources.getResourceAsReader("mybatis-config.xml");
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    } catch (IOException e) {
      e.printStackTrace();
      //初始化错误时,通过抛出异常ExceptionInInitializerError通知调用者
      throw new ExceptionInInitializerError(e);
    }
  }

  /**
   * 创建一个新的session对象
    * @return
   */
  public static SqlSession openSession() {
    return sqlSessionFactory.openSession();
  }

  /**
   * 关闭session
   * @param session
   */
  public static void closeSession(SqlSession session) {
    if(session != null) {
      session.close();
    }
  }

  public static Object executeQuery(Function<SqlSession, Object> func) {
    SqlSession session = sqlSessionFactory.openSession();
    try {
      Object result = func.apply(session);
      return result;
    } finally {
      session.close();
    }

  }
}

