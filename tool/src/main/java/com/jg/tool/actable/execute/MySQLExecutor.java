package com.jg.tool.actable.execute;

import com.jg.tool.actable.ACTable;
import com.jg.tool.actable.builder.factory.FieldBuilderFactory;
import com.jg.tool.actable.builder.factory.MySQLFieldBuilderFactory;
import com.jg.tool.actable.db.DbExecutor;
import com.jg.tool.actable.db.MySQLDbExecutor;

/**
 * mysql执行者
 */
public class MySQLExecutor extends Executor {

    public MySQLExecutor(ACTable acTable) {
        super(acTable);
    }

    @Override
    protected FieldBuilderFactory buildFieldBuilderFactory() {
        return new MySQLFieldBuilderFactory();
    }

    @Override
    protected DbExecutor buildDbExecutor() {
        return new MySQLDbExecutor(acTable.getConnection());
    }

}
