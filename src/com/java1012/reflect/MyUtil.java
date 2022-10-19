package com.java1012.reflect;

import java.lang.reflect.Field;

/**
 * @author lannisite
 * @program MyUtil
 * @description 描述
 * @date 2022/10/12 10:53
 */

public class MyUtil {

    /**
     * 反射实现不同对象相同属性的拷贝方法
     * 思路：获取到class对象，进而获取成员变量，关闭安全检查，然后一一比较，是否有相同名称，
     * P.S. 这里暂时先不考虑继承父类成员的问题; 且成员变量均为基本类型
     */
    public static <S,T> T copyProperties(S source,T target) throws Exception {

        Class sourceClass = source.getClass();
        Class targetClass = target.getClass();

        Field[] sourceFields = sourceClass.getDeclaredFields();
        for(Field sourceField:sourceFields){

            sourceField.setAccessible(true);
            String sourceFieldName = sourceField.getName();
            Object sourceValue = sourceField.get(source);
            Class sourceFieldClass = sourceField.getType();

            Field targetField;

            //  如果属性值为空，则不需要进行复制
            if(sourceValue == null){
                continue;
            }

            //  查找是否有相同名称的属性
            try{
                targetField = targetClass.getDeclaredField(sourceFieldName);
            }catch (Exception e){
                //  如果没有找到说明不需要拷贝该属性，循环继续
                continue;
            }
            targetField.setAccessible(true);

            //  判断两个属性是否具有相同类型,类型不同的话则continue到下一个属性
            if(!targetField.getType().getName().equals(sourceFieldClass.getName())){
                continue;
            }
            targetField.set(target,sourceValue);
        }

        return target;
    }
}
