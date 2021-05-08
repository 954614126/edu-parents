package com.definesys.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: shuaishuai.li
 * @since: 2021/05/06 14:03
 * @history: 1.2021/05/06 created by shuaishuai.li
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /*
     *  类需要加@Component注解
     *  自动填充的属性上需要加注解
     *  属性的填充给,用java字段名即可
     **/
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreate",new Date(),metaObject);
        this.setFieldValByName("gmtModified",new Date(),metaObject);
//        this.setFieldValByName("version",1,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }
}