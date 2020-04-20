package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaMenu;
import com.learn.auth.service.UaaMenuService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-04-20
 */
@Slf4j
@Api(value = "菜单表 接口")
@RestController
@RequestMapping("/api/v1/uaa-menus")
public class UaaMenuController {

    @Autowired
    private UaaMenuService uaaMenuService;

    @GetMapping
    @ApiOperation(value = "菜单表 分页查询")
    @Validated
    public ResponseResult list(UaaMenu uaaMenu, Page<UaaMenu> page) {
        QueryWrapper<UaaMenu> queryWrapper = new QueryWrapper<>();

        IPage<UaaMenu> pageResult = uaaMenuService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "菜单表 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaMenuService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "菜单表 创建")
    public ResponseResult create(@RequestBody UaaMenu uaaMenu) {
        uaaMenuService.saveOrUpdate(uaaMenu);
        return ResponseResult.success(uaaMenu);
    }

    @PutMapping
    @ApiOperation(value = "菜单表 更新")
    public ResponseResult update(@RequestBody UaaMenu uaaMenu) {
        uaaMenuService.saveOrUpdate(uaaMenu);
        return ResponseResult.success(uaaMenu);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "菜单表 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaMenuService.removeById(id));
    }

}
