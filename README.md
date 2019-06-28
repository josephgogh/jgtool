# valid(对象校验模块)
## java bean校验模块
校验方式：  
1. ValidUtil.valid(object);
2. java bean对象继承类AbstractValid  
    调用object.valid()方法实现校验;
    
#### @Empty
1. 使用方式  
   @Empty(message="错误信息")  
   private String test;
2. 参数说明  
    message： 异常信息
3. 校验说明：字段为null或者字段为空字符串

#### @NotEmpty
1. 使用方式  
   @NotEmpty(message="错误信息")  
   private String test;
2. 参数说明  
    message： 异常信息
3. 校验说明：字段不为null并且字段不为空字符串

#### @Null
1. 使用方式  
   @Null(message="错误信息")  
   private String test;
2. 参数说明  
    message： 异常信息
3. 校验说明：字段必须为null

#### @NotNull
1. 使用方式  
   @NotNull(message="错误信息")  
   private String test;
2. 参数说明  
    message： 异常信息
3. 校验说明：字段必须不为null

#### @Number
1. 使用方式  
   @Number(message="错误信息", ignoreNull=true)  
   private String test;
2. 参数说明  
    ignoreNull: 是否忽略校验null对象(默认false)  
    message： 异常信息
3. 校验说明：字段必须为数值或者可转换为数值的字符串

#### @IsPhoneNum
1. 使用方式  
   @IsPhoneNum(ignoreEmpty=true, message="错误信息")  
   private String test;
2. 参数说明
    ignoreEmpty: 是否忽略校验空字符串或null(默认false)
    message： 异常信息
3. 校验说明：字段必须为电话号码格式

#### @LessThan
1. 使用方式  
   @LessThan(value=100, ignoreNull = true, message="错误信息")  
   private String test;
2. 参数说明
    value: double类型的数值  
    ignoreNull: 是否忽略校验null(默认false)  
    message： 异常信息
3. 校验说明：字段值必须小于{value}

#### @Max
1. 使用方式  
   @Max(value=100, ignoreNull=true, message="错误信息")  
   private String test;
2. 参数说明
    value: double类型的数值    
    ignoreNull: 是否忽略校验null对象(默认false)   
    message： 异常信息
3. 校验说明：字段值必须小等于{value}

#### @Min
1. 使用方式  
   @Min(value=0, ignoreNull=true, message="错误信息")  
   private String test;
2. 参数说明
    value: double类型的数值  
    ignoreNull: 是否忽略校验null对象(默认false)  
    message： 异常信息
3. 校验说明：字段值必须大等于{value}

#### @MoreThan
1. 使用方式  
   @MoreThan(value=0, ignoreNull = true, message="错误信息")  
   private String test;
2. 参数说明
    value: double类型的数值  
    ignoreNull: 是否忽略校验null(默认false)  
    message： 异常信息
3. 校验说明：字段值必须大于{value}

#### @NumIn
1. 使用方式  
   @NumIn(value={0, 1, 2}, ignoreNull=true, message="错误信息")  
   private String test;
2. 参数说明
    value: double数值数组  
    ignoreNull: 是否忽略校验null对象(默认false)  
    message： 异常信息
3. 校验说明：字段数值必须为{value}中的其中一个

#### @StrIn
1. 使用方式  
   @NumIn(value={"1", "2", "3"},ignoreNull=true, message="错误信息")  
   private String test;
2. 参数说明
    value: 字符串数组  
    ignoreNull: 是否忽略校验null对象(默认false)  
    message： 异常信息
3. 校验说明：字段字符串必须为{value}中的其中一个

#### @Pattern
1. 使用方式  
   @Pattern(regexp = "^(.+)@(.+)$", ignoreNull=true,ignoreEmpty=true, message="错误信息")  
   private String test;
2. 参数说明
    regexp: 正则表达式  
    ignoreNull: 是否忽略校验null对象(默认false)  
    ignoreEmpty: 是否忽略校验空对象(默认false)  
    message： 异常信息
3. 校验说明：字段必须符合正则表达式{regexp}

#### @Size
1. 使用方式  
   @Size(min=0, max=6, ignoreNull=true, ignoreEmpty=true, message="错误信息")  
   private String test;
2. 参数说明
    min: 参数最小长度(默认0)
    max: 参数最大长度(默认Integer.MAX_VALUE)  
    ignoreNull: 是否忽略校验null对象(默认false)   
    ignoreEmpty: 是否忽略校验空对象(默认false)    
    message： 异常信息
3. 校验说明：参数长度必须在{min}-{max}之间

## 常规字段校验模块
校验方式：ValidUtil.method();直接调用方法

#### notNull
1. 使用方式    
    ValidUtil.notNull(obj, errorMsg)
2. 参数说明   
    Object obj: 校验对象  
    String errorMsg: 异常信息
3. 校验说明：对象不能为null，为null则抛出异常

#### isNull
1. 使用方式    
    ValidUtil.isNull(obj, errorMsg)
2. 参数说明   
    Object obj: 校验对象  
    String errorMsg: 异常信息
3. 校验说明：对象必须为null，不为null则抛出异常

#### notEmpty
1. 使用方式    
    ValidUtil.notEmpty(obj, errorMsg)
2. 参数说明   
    Object obj: 校验对象  
    String errorMsg: 异常信息
3. 校验说明：对象不能为null并且不能为空字符串，为null或空字符串则抛出异常

#### isEmpty
1. 使用方式    
    ValidUtil.isEmpty(obj, errorMsg)
2. 参数说明   
    Object obj: 校验对象  
    String errorMsg: 异常信息
3. 校验说明：对象必须为null或空字符串，不为null并且不为空字符串则抛出异常

#### isPhoneNum
1. 使用方式    
    ValidUtil.isPhoneNum(phoneNum, errorMsg)
2. 参数说明   
    String phoneNum: 校验对象(电话号码)  
    String errorMsg: 异常信息
3. 校验说明：校验对象必须为电话号码格式，否则抛出异常

#### isBlank
1. 使用方式    
    ValidUtil.isBlank(object, errorMsg)
2. 参数说明   
    Object object: 校验对象    
    String errorMsg: 异常信息  
3. 校验说明：校验对象为空，否则抛出异常
             
#### isNotBlank
1. 使用方式    
    ValidUtil.isNotBlank(object, errorMsg)
2. 参数说明   
    Object object: 校验对象  
    String errorMsg: 异常信息  
3. 校验说明：校验对象不为空，否则抛出异常

#### isBlank
1. 使用方式    
    ValidUtil.isBlank(object)
2. 参数说明   
    Object object: 校验对象    
3. 校验说明：校验对象为null：true;    
             校验对象为String类型时，object="":true;  
             校验对象为集合或者数组类型时，object的长度<=0:true;  
             其他:false;
             
#### isNotBlank
1. 使用方式    
    ValidUtil.isNotBlank(object)
2. 参数说明   
    Object object: 校验对象  
3. 校验说明：校验对象为null：false;    
             校验对象为String类型时，object="":false;  
             校验对象为集合或者数组类型时，object的长度<=0:false;  
              其他:true;