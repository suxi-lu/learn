package com.learn.auth.web.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaGroupUser;
import com.learn.auth.service.UaaGroupUserService;
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
 * 组-用户信息 前端控制器 测试用例
 * </p>
 *
 * @author generate
 * @since 2019-11-24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles({"dev"})
public class UaaGroupUserControllerTest {

    @Autowired
    private UaaGroupUserService uaaGroupUserService;

    @Test
    public void list() {
        Page<UaaGroupUser> page = new Page<>();
        page.setPages(0);
        page.setSize(1);

        QueryWrapper<UaaGroupUser> queryWrapper = new QueryWrapper<>();

        IPage<UaaGroupUser> pageResult = uaaGroupUserService.page(page, queryWrapper);

        Assert.assertNotNull(pageResult);
    }

    @Test
    @Rollback
    public void load() {
        String id = "";
        UaaGroupUser uaaGroupUser = uaaGroupUserService.getById(id);

        Assert.assertNotNull(uaaGroupUser);
    }

    @Test
    @Rollback
    public void create() {
        UaaGroupUser uaaGroupUser = new UaaGroupUser();
        uaaGroupUserService.saveOrUpdate(uaaGroupUser);

    }

    @Test
    @Rollback
    public void update() {
        UaaGroupUser uaaGroupUser = new UaaGroupUser();
        uaaGroupUserService.saveOrUpdate(uaaGroupUser);

    }

    @Test
    @Rollback
    public void delete() {
        String id = "";
        uaaGroupUserService.removeById(id);

    }

}