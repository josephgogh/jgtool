package com.jg.tool.actable.execute;

import com.jg.tool.actable.ACTable;
import com.jg.tool.actable.builder.factory.AbstractFieldBuilderFactory;
import com.jg.tool.actable.builder.factory.OracleFieldBuilderFactory;
import com.jg.tool.actable.db.AbstractDbExecutor;
import com.jg.tool.actable.db.OracleDbExecutor;

/**
 * oracle执行者
 * @author gaolj
 */
public class OracleExecutor extends AbstractExecutor {

    public OracleExecutor(ACTable acTable) {
        super(acTable);
    }

    @Override
    protected AbstractFieldBuilderFactory buildFieldBuilderFactory() {
        return new OracleFieldBuilderFactory();
    }

    @Override
    protected AbstractDbExecutor buildDbExecutor() {
        return new OracleDbExecutor(acTable.getConnection());
    }

}
