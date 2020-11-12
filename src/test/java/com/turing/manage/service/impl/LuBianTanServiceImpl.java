package com.turing.manage.service.impl;

import com.turing.manage.service.ILuBianTanService;
import org.springframework.stereotype.Component;

@Component("lbt")
public class LuBianTanServiceImpl implements ILuBianTanService {
    @Override
    public void maiLengMian(Integer money, Integer danqian, Integer changdddqian) {
        System.out.println("冷面："+money+"元，加蛋："+(money+danqian)+"，加肠："+(money+danqian+changdddqian));
    }

    @Override
    public void maiKaoChuan(Integer money) {
        System.out.println("烤串："+money);
//        throw new NullPointerException();
    }

    @Override
    public void maiShuiGuo(Integer money) {
        try {
            System.out.println("水果："+money);
        } catch (Exception e) {
            System.out.println("买水果 Exception");
            e.printStackTrace();
        }finally {
            System.out.println("买水果finally");
        }
    }

    @Override
    public void maiRoujiamo(Integer money) {
        System.out.println("肉夹馍："+money);
    }
}
