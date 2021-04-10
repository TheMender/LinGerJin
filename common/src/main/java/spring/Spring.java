package spring;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Title:
 * Desc:
 *
 * @author: linyongchao
 * Date: 2021/4/101:03 PM
 */
public class Spring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-test.xml");
        Person bean = (Person) ctx.getBean("person");
//        bean.setAge(18);
//        bean.setWeight(130);
//        bean.setHeight(170);
//        System.out.println(bean.toString());
        System.out.println(ToStringBuilder.reflectionToString(bean, ToStringStyle.JSON_STYLE));
    }
}
