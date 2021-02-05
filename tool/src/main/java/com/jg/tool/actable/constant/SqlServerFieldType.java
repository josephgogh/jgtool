package com.jg.tool.actable.constant;

/**
 * sql server字段类型
 * @author gaolj
 * @version 20210205
 */
public interface SqlServerFieldType {

    /**
     * 整型，取值范围[0,1,null]，用于存取布尔值
     */
    String BIT = "bit";

    /**
     * 整型，取值范围[0~256)
     */
    String TINYINT = "tinyint";

    /**
     * 整型，取值范围[-215~215)
     */
    String SMALLINT = "smallint";

    /**
     * 整型，取值范围[-231~231)
     */
    String INT = "int";

    /**
     * 整型，取值范围[-264~264)
     */
    String BIGINT = "bigint";

    /**
     * 精确数值型 ，示例：decimal(8,4); //共8位，小数点右4位
     */
    String DECIMAL = "decimal";

    /**
     * 与decimal类似
     */
    String NUMERIC = "numeric";

    /**
     * 货币型
     */
    String SMALLMONEY = "smallmoney";

    /**
     * 货币型
     */
    String MONEY = "money";

    /**
     * 近似数值型
     */
    String FLOAT = "float";

    /**
     * 近似数值型
     */
    String REAL = "real";

    /**
     * 日期时间型，表示从1900年1月1日到2079年6月6日间的日期和时间，精确到一分钟
     */
    String SMALLDATETIME = "smalldatetime";

    /**
     * 日期类型
     */
    String DATE = "date";

    /**
     * 日期时间型，从1753年1月1日到9999年12月31日间所有的日期和时间数据， 精确到三百分之一秒或3.33毫秒
     */
    String DATETIME = "datetime";

    /**
     * 特殊数据型，用来创建一个数据库范围内的唯一数码， 一个表中只能有一个timestamp列，每次插入或修改一行时，timestamp列的值都会改变。
     */
    String TIMESTAMP = "timestamp";

    /**
     * 特殊数据型，存储一个全局唯一标识符，即GUID
     */
    String UNIQUEIDENTIFIER = "uniqueidentifier";

    /**
     * 字符型，存储指定长度的定长非统一编码型的数据，必须指定列宽，列宽最大为8000 个字符
     */
    String CHAR = "char";

    /**
     * 字符型，存储非统一编码型字符数据，数据类型为变长，要指定该列的最大长度，存储的长度不是列长，而是数据的长度
     */
    String VARCHAR = "varchar";

    /**
     * text：字符型，存储大量的非统一编码型字符数据
     */
    String TEXT = "text";

    /**
     * 统一编码字符型，存储定长统一编码字符型数据，能存储4000种字符，统一编码用双字节结构来存储每个字符
     */
    String NCHAR = "nchar";

    /**
     * 统一编码字符型，用作变长的统一编码字符型数据
     */
    String NVARCHAR = "nvarchar";

    /**
     * 统一编码字符型，用来存储大量的统一编码字符型数据
     */
    String NTEXT = "ntext";

    /**
     * 二进制数据类型，存储可达8000 字节长的定长的二进制数据
     */
    String BINARY = "binary";

    /**
     * 二进制数据类型，用来存储可达8000 字节长的变长的二进制数据
     */
    String VARBINARY = "varbinary";

    /**
     * 二进制数据类型，用来存储变长的二进制数据
     */
    String IMAGE = "image";

}
