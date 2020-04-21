package com.jg.tool.actable.constant;

/**
 * oracle字段类型
 * @author gaolj
 */
public interface OracleFieldType {

    /**
     *  一个定长字符串，当位数不足自动用空格填充来达到其最大长度。
     *  如非NULL的CHAR(12)总是包含12字节信息。
     *  CHAR字段最多可以存储2,000字节的
     */
    String CHAR = "char";

    /**
     *   目前这也是VARCHAR 的同义词。
     *   这是一个变长字符串，与CHAR 类型不同，它不会用空格填充至最大长度
     *   VARCHAR2最多可以存储4,000 字节的信息
     */
    String VARCHAR2 = "varchar2";

    /**
     * 根据字符集而定的固定长度字符串    最大长度2000    bytes
     */
    String NCHAR = "nchar";

    /**
     * 根据字符集而定的可变长度字符串    最大长度4000    bytes
     */
    String NVARCHAR2 = "nvarchar2";

    /**
     * 日期（日-月-年）    DD-MM-YY（HH-MI-SS）    经过严格测试，无千虫问题
     */
    String DATE = "date";

    /**
     * 超长字符串    最大长度2G（231-1）    足够存储大部头著作
     */
    String LONG = "long";

    /**
     * 固定长度的二进制数据    最大长度2000    bytes      可存放多媒体图象声音等
     */
    String RAW = "raw";

    /**
     * LONG    RAW    可变长度的二进制数据    最大长度2G    同上
     */
    String LONG_RAW = "long raw";

    /**
     *   二进制数据    最大长度4G
     */
    String BLOB = "blob";

    /**
     *  字符数据    最大长度4G
     */
    String CLOB = "clob";

    /**
     * 根据字符集而定的字符数据    最大长度4G
     */
    String NCLOB = "nclob";

    /**
     * NUMBER(P,S)    数字类型    P为整数位，S为小数位
     */
    String NUMBER = "number";

    /**
     * 整数类型    小的整数
     */
    String INTEGER = "integer";

    /**
     * 单精度浮点数类型    NUMBER(38)，双精度
     */
    String FLOAT = "float";

    /**
     * 双精度浮点数类型    NUMBER(63)，精度更高
     */
    String REAL = "real";

    /**
     * 单精度浮点数类型    NUMBER(38)，双精度
     */
    String BINARY_FLOAT = "binary_float";

    /**
     * 双精度浮点数类型    NUMBER(63)，精度更高
     */
    String BINARY_DOUBLE = "binary_double";

}
