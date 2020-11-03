package com.springboot.project.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

/**
 * Druid数据库连接池配置
 * @Author:zzh
 * @CreateDate:2020/11/3 10:03
 * @Description:
 */
@Configuration
public class DruidConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String passWord;


    @Bean
    public DataSource dataSource(){
        //创建一个Druid数据库连接池的对象
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(this.driverClassName);
        druidDataSource.setUrl(this.url);
        druidDataSource.setUsername(this.userName);
        druidDataSource.setPassword(this.passWord);
        //设置初始连接个数
        druidDataSource.setInitialSize(5);
        //配置最小连接个数
        druidDataSource.setMinIdle(5);
        //设置最大的连接数量
        druidDataSource.setMaxActive(20);
        //获取连接池连接的最大等待时间，单位为毫秒
        druidDataSource.setMaxWait(60000);
        return druidDataSource;
    }

    /**
     * 注册一个StatViewServlet
     * @return
     */
    @Bean
    public ServletRegistrationBean druidStatViewServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet());
        //设置白名单
        registrationBean.addInitParameter("allow","127.0.0.1");
        registrationBean.addInitParameter("loginUsername","admin");
        registrationBean.addInitParameter("loginPassword","123456");
        //是否能够重置数据
        registrationBean.addInitParameter("resetEnable","false");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
        registrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息
        registrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return registrationBean;
    }

}
