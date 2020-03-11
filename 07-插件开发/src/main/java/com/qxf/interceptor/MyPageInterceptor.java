package com.qxf.interceptor;

import com.qxf.pojo.MyPage;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Auther: qiuxinfa
 * @Date: 2020/3/8
 * @Description: com.qxf.interceptor
 */
//表示拦截StatementHandler类的prepare方法
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class,Integer.class})})
public class MyPageInterceptor implements Interceptor{

    private Integer defaultPageSize;     //默认每页的大小
    private Integer defaultCurrentPage;  //默认页数
    //实现拦截逻辑
    public Object intercept(Invocation invocation) throws Throwable {
        //获取目标对象
        StatementHandler  statementHandler = (StatementHandler) invocation.getTarget();
        //获取元数据
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        //获取绑定的sql
        BoundSql boundSql = (BoundSql) metaObject.getValue("delegate.boundSql");
        //获取参数对象
        Object parameterObject = boundSql.getParameterObject();
        //获取传入分页参数
        MyPage myPage = this.getPage(parameterObject);
        String sql = (String) metaObject.getValue("delegate.boundSql.sql");
        boolean isSelect = sql.trim().toLowerCase().startsWith("select");
        //如果不是查询语句，则直接进入下一个操作
        if(!isSelect){
            return invocation.proceed();
        }
        System.out.println("原来的sql："+sql);
        //修改sql
        String page_sql = "select * from ("+sql+") page_table limit ?,?";
        //设置修改过的sql
        metaObject.setValue("delegate.boundSql.sql",page_sql);
        //如果没有传入相应的分页参数，则设置为默认值
        if (myPage.getCurrentPage() == null){
            //设置默认值
            myPage.setCurrentPage(this.defaultCurrentPage);
        }
        if (myPage.getPageSize() == null){
            //设置默认值
            myPage.setPageSize(this.defaultPageSize);
        }
        //获取参数
        PreparedStatement ps = (PreparedStatement) invocation.proceed();
        // 获取sql的总参数个数
        int paramCount = ps.getParameterMetaData().getParameterCount();
        // 设置分页参数
        ps.setInt(paramCount - 1, (myPage.getCurrentPage() - 1) * myPage.getPageSize());
        ps.setInt(paramCount, myPage.getPageSize());
        return ps;
    }

    //返回被拦截对象的代理对象
    public Object plugin(Object target) {
        System.out.println("开始包装目标对象");
        return Plugin.wrap(target,this);
    }

    //设置插件配置的参数
    public void setProperties(Properties properties) {
        this.defaultCurrentPage = Integer.valueOf(properties.getProperty("default.currentPage", "1"));
        this.defaultPageSize = Integer.valueOf(properties.getProperty("default.pageSize", "3"));
    }


    /**
     * 获取分页参数
     *
     * @param parameterObject
     * @return
     */
    private MyPage getPage(Object parameterObject) {
        if (parameterObject == null) {
            return null;
        }

        if (parameterObject instanceof Map) {
            // 如果传入的参数是map类型的，则遍历map取出Page对象
            Map<String, Object> parameMap = (Map<String, Object>) parameterObject;
            Set<String> keySet = parameMap.keySet();
            for (String key : keySet) {
                Object value = parameMap.get(key);
                if (value instanceof MyPage) {
                    // 返回MyPage对象
                    return (MyPage) value;
                }
            }
        } else if (parameterObject instanceof MyPage) {
            // 如果传入的是Page类型，则直接返回该对象
            return (MyPage) parameterObject;
        }

        // 初步判断并没有传入MyPage类型的参数，返回null
        return null;
    }

}
