package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaGroupRole;
import com.learn.auth.service.UaaGroupRoleService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 组-角色表 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-04-20
 */
@Slf4j
@Api(value = "组-角色表 接口")
@RestController
@RequestMapping("/api/v1/uaa-group-roles")
public class UaaGroupRoleController {

    @Autowired
    private UaaGroupRoleService uaaGroupRoleService;

    @GetMapping
    @ApiOperation(value = "组-角色表 分页查询")
    @Validated
    public ResponseResult list(UaaGroupRole uaaGroupRole, Page<UaaGroupRole> page) {
        QueryWrapper<UaaGroupRole> queryWrapper = new QueryWrapper<>();

        IPage<UaaGroupRole> pageResult = uaaGroupRoleService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "组-角色表 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaGroupRoleService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "组-角色表 创建")
    public ResponseResult create(@RequestBody UaaGroupRole uaaGroupRole) {
        uaaGroupRoleService.saveOrUpdate(uaaGroupRole);
        return ResponseResult.success(uaaGroupRole);
    }

    @PutMapping
    @ApiOperation(value = "组-角色表 更新")
    public ResponseResult update(@RequestBody UaaGroupRole uaaGroupRole) {
        uaaGroupRoleService.saveOrUpdate(uaaGroupRole);
        return ResponseResult.success(uaaGroupRole);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "组-角色表 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaGroupRoleService.removeById(id));
    }

}