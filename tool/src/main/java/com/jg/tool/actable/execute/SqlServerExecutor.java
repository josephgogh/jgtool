package com.jg.tool.actable.execute;

import com.jg.tool.actable.ACTable;
import com.jg.tool.actable.builder.factory.AbstractFieldBuilderFactory;
import com.jg.tool.actable.builder.factory.SqlServerFieldBuilderFactory;
import com.jg.tool.actable.db.AbstractDbExecutor;
import com.jg.tool.actable.db.SqlServerDbExecutor;

/**
 * sqlServer执行者
 * @author gaolj
 * @version 20210205
 */
public class SqlServerExecutor extends AbstractExecutor {

    public SqlServerExecutor(ACTable acTable) {
        super(acTable);
    }

    @Override
    protected AbstractFieldBuilderFactory buildFieldBuilderFactory() {
        return new SqlServerFieldBuilderFactory();
    }

    @Override
    protected AbstractDbExecutor buildDbExecutor() {
        return new SqlServerDbExecutor(acTable.getConnection());
    }

}
