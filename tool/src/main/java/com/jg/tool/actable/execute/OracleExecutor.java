package com.jg.tool.actable.execute;

import com.jg.tool.actable.ACTable;
import com.jg.tool.actable.builder.factory.FieldBuilderFactory;
import com.jg.tool.actable.builder.factory.OracleFieldBuilderFactory;
import com.jg.tool.actable.db.DbExecutor;
import com.jg.tool.actable.db.OracleDbExecutor;

/**
 * oracle执行者
 */
public class OracleExecutor extends Executor {

    public OracleExecutor(ACTable acTable) {
        super(acTable);
    }

    @Override
    protected FieldBuilderFactory buildFieldBuilderFactory() {
        return new OracleFieldBuilderFactory();
    }

    @Override
    protected DbExecutor buildDbExecutor() {
        return new OracleDbExecutor(acTable.getConnection());
    }

}
