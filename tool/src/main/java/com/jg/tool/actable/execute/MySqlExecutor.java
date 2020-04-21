package com.jg.tool.actable.execute;

import com.jg.tool.actable.ACTable;
import com.jg.tool.actable.builder.factory.AbstractFieldBuilderFactory;
import com.jg.tool.actable.builder.factory.MySqlFieldBuilderFactory;
import com.jg.tool.actable.db.AbstractDbExecutor;
import com.jg.tool.actable.db.MySqlDbExecutor;

/**
 * mysql执行者
 * @author gaolj
 */
public class MySqlExecutor extends AbstractExecutor {

    public MySqlExecutor(ACTable acTable) {
        super(acTable);
    }

    @Override
    protected AbstractFieldBuilderFactory buildFieldBuilderFactory() {
        return new MySqlFieldBuilderFactory();
    }

    @Override
    protected AbstractDbExecutor buildDbExecutor() {
        return new MySqlDbExecutor(acTable.getConnection());
    }

}
