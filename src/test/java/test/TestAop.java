package test;

import com.turing.manage.service.ILuBianTanService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("xml/applicationContext.xml");
        ILuBianTanService lbt = (ILuBianTanService) context.getBean("lbt");
        lbt.maiKaoChuan(10);
        lbt.maiRoujiamo(8);
        lbt.maiShuiGuo(20);
        lbt.maiLengMian(5,1,1);

    }
}
