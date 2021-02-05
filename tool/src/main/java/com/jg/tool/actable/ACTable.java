package com.jg.tool.actable;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.db.DbUtil;
import cn.hutool.log.LogFactory;
import com.jg.tool.actable.annotation.Table;
import com.jg.tool.actable.constant.AutoType;
import com.jg.tool.actable.enums.DbType;
import com.jg.tool.actable.execute.AbstractExecutor;
import com.jg.tool.empty.EmptyObject;
import com.jg.tool.exception.ACTableException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Set;

/**
 * 自动建表
 * @author gaolj
 */
public class ACTable {

    /**
     * 数据源
     */
    private DataSource dataSource;

    /**
     * 数据库连接
     */
    private Connection connection;

    /**
     * 数据库元数据信息
     */
    private DatabaseMetaData databaseMetaData;

    /**
     * 数据库类型
     */
    private DbType dbType;

    /**
     * 基础包路径
     */
    private String basePackage;

    /**
     * Table注释的类
     */
    private Set<Class<?>> classSet;

    /**
     * 模式默认：插入模式
     */
    private String autoType = AutoType.INSERT;

    public ACTable(DataSource dataSource, String basePackage) {
        try {
            this.buildDbData(dataSource);
            this.buildPackageData(basePackage);
            this.execute();
        } catch (Exception e) {
            LogFactory.get().error(e);
            throw new ACTableException(e);
        } finally {
            DbUtil.close(this.connection);
        }
    }

    public ACTable(DataSource dataSource, String basePackage, String autoType) {
        try {
            this.autoType = autoType;
            this.buildDbData(dataSource);
            this.buildPackageData(basePackage);
            this.execute();
        } catch (Exception e) {
            LogFactory.get().error(e);
            throw new ACTableException(e);
        } finally {
            DbUtil.close(this.connection);
        }
    }

    /**
     * 执行
     */
    private void execute() {
        AbstractExecutor abstractExecutor = AbstractExecutor.getExecutor(this);
        for (Class<?> cls : EmptyObject.set(classSet)) {
            abstractExecutor.execute(cls);
        }
    }

    /**
     * 构建基础包数据
     * @param basePackage 基础包
     */
    private void buildPackageData(String basePackage) {
        this.basePackage = basePackage;
        this.classSet = ClassUtil.scanPackage(basePackage, aClass -> aClass.isAnnotationPresent(Table.class));
    }

    /**
     * 构建数据库数据
     * @param dataSource    数据源
     */
    private void buildDbData(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        this.connection = dataSource.getConnection();
        this.databaseMetaData = dataSource.getConnection().getMetaData();
        this.buildDbType(this.databaseMetaData);
    }

    /**
     * 构建数据库类型
     * @param databaseMetaData  源数据
     */
    private void buildDbType(DatabaseMetaData databaseMetaData) throws SQLException {
        String driverName = databaseMetaData.getDriverName().toLowerCase();
        if (driverName.contains("mysql")) {
            this.dbType = DbType.MYSQL;
        } else if (driverName.contains("oracle")) {
            this.dbType = DbType.ORACLE;
        } else if (driverName.contains("sql server")) {
            this.dbType = DbType.SQLSERVER;
        } else {
            throw new ACTableException("This database is not currently supported！");
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public DatabaseMetaData getDatabaseMetaData() {
        return databaseMetaData;
    }

    public void setDatabaseMetaData(DatabaseMetaData databaseMetaData) {
        this.databaseMetaData = databaseMetaData;
    }

    public DbType getDbType() {
        return dbType;
    }

    public void setDbType(DbType dbType) {
        this.dbType = dbType;
    }

    public Set<Class<?>> getClassSet() {
        return classSet;
    }

    public void setClassSet(Set<Class<?>> classSet) {
        this.classSet = classSet;
    }

    public String getAutoType() {
        return autoType;
    }

    public void setAutoType(String autoType) {
        this.autoType = autoType;
    }
}
