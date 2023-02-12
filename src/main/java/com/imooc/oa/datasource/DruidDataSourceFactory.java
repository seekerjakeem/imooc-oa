package com.imooc.oa.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

public class DruidDataSourceFactory extends UnpooledDataSourceFactory {
  public DruidDataSourceFactory() {
    this.dataSource = new DruidDataSource();
  }

  @Override
  public DataSource getDataSource() {
    try {
      ((DruidDataSource)this.dataSource).init();
    } catch (SQLException e) {
      e.printStackTrace();

    }
    return  this.dataSource;
  }
}
