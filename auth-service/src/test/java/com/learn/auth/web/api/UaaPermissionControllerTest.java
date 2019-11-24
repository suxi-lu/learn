package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaPermission;
import com.learn.auth.service.UaaPermissionService;
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
 * 权限信息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-11-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaPermissionControllerTest {

    @Autowired
    private UaaPermissionService uaaPermissionService;

    @Test
    public void list() {
        Page<UaaPermission> page = new Page<>();
        page.setPages(0);
        page.setSize(1);

        QueryWrapper<UaaPermission> queryWrapper = new QueryWrapper<>();

        IPage<UaaPermission> pageResult = uaaPermissionService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaPermission uaaPermission = uaaPermissionService.getById(id);

        Assert.assertNotNull(uaaPermission);
    }

    @Test
    @Rollback
    public void create() {
        UaaPermission uaaPermission = new UaaPermission();
        uaaPermissionService.saveOrUpdate(uaaPermission);

    }

    @Test
    @Rollback
    public void update() {
        UaaPermission uaaPermission = new UaaPermission();
        uaaPermissionService.saveOrUpdate(uaaPermission);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaPermissionService.removeById(id);

    }

}