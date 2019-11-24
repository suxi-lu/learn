package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaOperate;
import com.learn.auth.service.UaaOperateService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 操作信息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-11-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaOperateControllerTest {

    @Autowired
    private UaaOperateService uaaOperateService;

    @Test
    public void list() {
        Page<UaaOperate> page = new Page<>();
        page.setPages(0);
        page.setSize(1);

        QueryWrapper<UaaOperate> queryWrapper = new QueryWrapper<>();

        IPage<UaaOperate> pageResult = uaaOperateService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaOperate uaaOperate = uaaOperateService.getById(id);

        Assert.assertNotNull(uaaOperate);
    }

    @Test
    @Rollback
    public void create() {
        UaaOperate uaaOperate = new UaaOperate();
        uaaOperateService.saveOrUpdate(uaaOperate);

    }

    @Test
    @Rollback
    public void update() {
        UaaOperate uaaOperate = new UaaOperate();
        uaaOperateService.saveOrUpdate(uaaOperate);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaOperateService.removeById(id);

    }

}