/**
 *
 * @author itbegin
 * @version 1.0
 * 文件名称: H2DBServerStartListener.java
 * 类说明：实现数据库表结构及数据初始化
 *
 */
package com.itbegin.init;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.h2.tools.Server;


import com.itbegin.utils.DbUtil;

@WebListener
public class H2DBServerStartListener implements ServletContextListener {
    //H2数据库服务器启动实例
    private Server server;

    @Override
    public void contextInitialized(ServletContextEvent sec) {
        try {
            System.out.println("正在启动h2数据库...");
            //使用org.h2.tools.Server这个类创建一个H2数据库的服务并启动服务，由于没有指定任何参数，
            //那么H2数据库启动时默认占用的端口就是8082
            server = Server.createTcpServer().start();
            System.out.println("h2数据库启动成功...");
            initDbTable();
            importData();
        } catch (SQLException e) {
            System.out.println("启动h2数据库出错：" + e.toString());
            e.printStackTrace();

        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        if (this.server != null) {
            // 停止H2数据库
            this.server.stop();
            this.server = null;
        }

    }
    //初始化表结构
    private void initDbTable(){

        Connection conn = null;
        try	{
            conn =  DbUtil.getConnection();
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("drop table if exists user;");
            stmt.executeUpdate("drop table if exists employee;");
            stmt.executeUpdate("create table user (id int auto_increment,name varchar(50) not null ,email varchar(50) not null,pwd varchar(50) not null,PRIMARY KEY (id));");
            stmt.executeUpdate(employeeTableSql());
            stmt.close();

        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null) {
                try{
                    conn.close();
                }catch(SQLException sex){
                    sex.printStackTrace();
                }

            }
        }
    }

    private String employeeTableSql(){
        StringBuffer sb = new StringBuffer();
        sb.append("create table employee (id int auto_increment,job_number varchar(20) not null,name varchar(50) not null,");
        sb.append("sex varchar(10) not null,status varchar(10) not null,birthday datetime ,nation varchar(20),marriage varchar(10),");
        sb.append("work_day datetime,school varchar(100),education varchar(20),phone varchar(100) not null,email varchar(100),");
        sb.append("work_vita varchar(1000),PRIMARY KEY (id));");
        System.out.println(sb.toString());
        return sb.toString();
    }
    //初始化数据
    private void importData(){

        Connection conn = null;
        try	{
            conn = DbUtil.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into user (id,name,email,pwd) values (1001,'itbegin','test@itbegin.com','123');");

            stmt.close();


        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            if(conn!=null) {
                try{
                    conn.close();
                }catch(SQLException sex){
                    sex.printStackTrace();
                }

            }
        }
    }




}

