package com.learn.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.learn.mybatis.domain.BaseDomain;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
public class DefaultGlobalMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.debug("insert fill.");
        String id = UUID.randomUUID().toString().replace("-", "");
        this.setFieldValByName(BaseDomain.ID, id, metaObject);
        this.setFieldValByName(BaseDomain.TENANT_ID, "1", metaObject);
        this.setFieldValByName(BaseDomain.OFFICE_CODE, "1", metaObject);
        this.setFieldValByName(BaseDomain.CREATED_BY, "admin", metaObject);
        this.setFieldValByName(BaseDomain.CREATED_AT, LocalDateTime.now(), metaObject);
        this.setFieldValByName(BaseDomain.DELETED, 0, metaObject);
        this.setFieldValByName(BaseDomain.UPDATED_BY, "admin", metaObject);
        this.setFieldValByName(BaseDomain.UPDATED_AT, LocalDateTime.now(), metaObject);
        this.setFieldValByName(BaseDomain.VERSION, 0L, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.debug("update fill.");
        this.setFieldValByName(BaseDomain.UPDATED_BY, "admin", metaObject);
        this.setFieldValByName(BaseDomain.UPDATED_AT, LocalDateTime.now(), metaObject);
    }

}
