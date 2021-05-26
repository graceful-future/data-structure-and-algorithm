package com.gracefulfuture.data.structure.map;

import java.util.Map;
import java.util.jar.Attributes;

/**
* @description      Attributes测试类
* @author           chenkun
* @create           2021/5/25 19:15
* @version          1.0
*/
public class AttributesTest {
    public static void main(String[] args) {
        //属性名为字母、数字、下划线和连字符，不允许是其他的字符
        //属性名长度大于0小于等于70
        Attributes attributes = new Attributes(10);
//        attributes.putValue("&12","Tomcat");
        attributes.putValue("_name","GlassFish");
        attributes.putValue("123-","WebLogic");
        attributes.put(new Attributes.Name("qq"),"Tencent");
//        String attributeName = "1211111111111111111111111111111111111111111111111222222222222222222222222222222222222222222222222222222222222";
//        attributes.putValue(attributeName,"too long");
        attributes.put(new Attributes.Name("xxx"),"empty");
        attributes.putValue("xxx","not blank");
//        System.out.println(attributes.size());
        System.out.println(attributes.containsKey(new Attributes.Name("xxx")));
        for(Map.Entry entry : attributes.entrySet()){
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }
}
