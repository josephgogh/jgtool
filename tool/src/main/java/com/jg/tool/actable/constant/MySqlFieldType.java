package com.jg.tool.actable.constant;

/**
 * mysql字段类型
 * @author gaolj
 */
public interface MySqlFieldType {

    /**
     * 一个很小的整数。有符号的范围是-128到127，无符号的范围是0到255。
     */
    String TINYINT = "tinyint";

    /**
     * 一个小整数。有符号的范围是-32768到32767，无符号的范围是0到65535。
     */
    String SMALLINT = "smallint";

    /**
     * 一个中等大小整数。有符号的范围是-8388608到8388607，无符号的范围是0到16777215。
     */
    String MEDIUMINT = "mediumint";

    /**
     * 有符号的范围是-2147483648到2147483647，无符号的范围是0到4294967295
     */
    String INT = "int";

    /**
     * 有符号的范围是-9223372036854775808到9223372036854775807，无符号的范围是0到18446744073709551615
     */
    String BIGINT = "bigint";

    /**
     * 一个小(单精密)浮点数字。不能无符号。允许的值是-3.402823466E+38到-1.175494351E-38，0 和 1.175494351E-38到3.402823466E+38
     */
    String FLOAT = "float";

    /**
     * 一个正常大小(双精密)浮点数字。不能无符号。
     * 允许的值是-1.7976931348623157E+308到-2.2250738585072014E-308、0和2.2250738585072014E-308到1.7976931348623157E+308
     */
    String DOUBLE = "double";

    /**
     * 这是DECIMAL的一个同义词。
     */
    String NUMERIC = "numeric";

    /**
     * 一个日期。支持的范围是'1000-01-01'到'9999-12-31'。
     * MySQL以'YYYY-MM-DD'格式来显示DATE值,但是允许你使用字符串或数字把值赋给DATE列
     */
    String DATE = "date";

    /**
     * 一个日期和时间组合。支持的范围是'1000-01-01 00:00:00'到'9999-12-31 23:59:59'。
     * MySQL以'YYYY-MM-DD HH:MM:SS'格式来显示DATETIME值，但是允许你使用字符串或数字把值赋给DATETIME的列
     */
    String DATETIME = "datetime";

    /**
     * 一个时间戳记。范围是'1970-01-01 00:00:00'到2037年的某时。
     * MySQL以YYYYMMDDHHMMSS、 YYMMDDHHMMSS、YYYYMMDD或YYMMDD格式来显示TIMESTAMP值，取决于是否M是14（或省略)、12、8或6,
     * 但是允许你使用字符串或数字把值赋给TIMESTAMP列。
     * 一个TIMESTAMP列对于记录一个INSERT或UPDATE操作的日期和时间是有用的，因为如果你不自己给它赋值，它自动地被设置为最近操作的日期和时间。
     * 你以可以通过赋给它一个NULL值设置它为当前的日期和时间。
     */
    String TIMESTAMP = "timestamp";

    /**
     * 一个时间。范围是'-838:59:59'到'838:59:59'。
     * MySQL以'HH:MM:SS'格式来显示TIME值，但是允许你使用字符串或数字把值赋给TIME列。
     */
    String TIME = "time";

    /**
     * 一个2或4位数字格式的年(缺省是4位)。允许的值是1901到2155，和0000（4位年格式），如果你使用2位，1970-2069( 70-69)。
     * MySQL以YYYY格式来显示YEAR值，但是允许你把使用字符串或数字值赋给YEAR列。（YEAR类型在MySQL3.22中是新类型。）
     */
    String YEAR = "year";

    /**
     * 一个定长字符串，当存储时，总是是用空格填满右边到指定的长度。M的范围是 1——255 个字符。
     * 当值被检索时，空格尾部被删除。CHAR值根据缺省字符集以大小写不区分的方式排序和比较，除非给出BINARY关键词。
     * NATIONAL CHAR（短形式NCHAR)是ANSI SQL的方式来定义CHAR列应该使用缺省字符集。这是MySQL的缺省。CHAR是CHARACTER的一个缩写。
     */
    String CHAR = "char";

    /**
     * 一个变长字符串。注意：当值被存储时，尾部的空格被删除(这不同于ANSI SQL规范)。
     * M的范围是 1——65532 个字符,1个或2个字节用来保存字符串长度。
     * VARCHAR值根据缺省字符集以大小写不区分的方式排序和比较，除非给出BINARY关键词值。
     * VARCHAR是CHARACTER VARYING一个缩写。
     */
    String VARCHAR = "varchar";

    /**
     * 一个BLOB列，最大长度为255(2^8-1)个字符
     */
    String TINYBLOB = "tinyblob";

    /**
     * 一个TEXT列，最大长度为255(2^8-1)个字符
     */
    String TINYTEXT = "tinytext";

    /**
     * 一个BLOB列，最大长度为65535(2^16-1)个字符
     */
    String BLOB = "blob";

    /**
     * 一个TEXT列，最大长度为65535(2^16-1)个字符
     */
    String TEXT = "text";

    /**
     * 一个BLOB列，最大长度为16777215(2^24-1)个字符
     */
    String MEDIUMBLOB = "mediumblob";

    /**
     * 一个TEXT列，最大长度为16777215(2^24-1)个字符
     */
    String MEDIUMTEXT = "mediumtext";

    /**
     * 一个BLOB列，最大长度为4294967295(2^32-1)个字符
     */
    String LONGBLOB = "longblob";

    /**
     * 一个TEXT列，最大长度为4294967295(2^32-1)个字符
     */
    String LONGTEXT = "longtext";

}
