package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaRolePermission;
import com.learn.auth.service.UaaRolePermissionService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色-权限表 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-04-20
 */
@Slf4j
@Api(value = "角色-权限表 接口")
@RestController
@RequestMapping("/api/v1/uaa-role-permissions")
public class UaaRolePermissionController {

    @Autowired
    private UaaRolePermissionService uaaRolePermissionService;

    @GetMapping
    @ApiOperation(value = "角色-权限表 分页查询")
    @Validated
    public ResponseResult list(UaaRolePermission uaaRolePermission, Page<UaaRolePermission> page) {
        QueryWrapper<UaaRolePermission> queryWrapper = new QueryWrapper<>();

        IPage<UaaRolePermission> pageResult = uaaRolePermissionService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "角色-权限表 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaRolePermissionService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "角色-权限表 创建")
    public ResponseResult create(@RequestBody UaaRolePermission uaaRolePermission) {
        uaaRolePermissionService.saveOrUpdate(uaaRolePermission);
        return ResponseResult.success(uaaRolePermission);
    }

    @PutMapping
    @ApiOperation(value = "角色-权限表 更新")
    public ResponseResult update(@RequestBody UaaRolePermission uaaRolePermission) {
        uaaRolePermissionService.saveOrUpdate(uaaRolePermission);
        return ResponseResult.success(uaaRolePermission);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "角色-权限表 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaRolePermissionService.removeById(id));
    }

}