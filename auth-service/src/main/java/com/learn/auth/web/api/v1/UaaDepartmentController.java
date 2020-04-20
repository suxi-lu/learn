package com.learn.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.auth.domain.UaaDepartment;
import com.learn.auth.service.UaaDepartmentService;
import com.learn.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-04-20
 */
@Slf4j
@Api(value = "部门表 接口")
@RestController
@RequestMapping("/api/v1/uaa-departments")
public class UaaDepartmentController {

    @Autowired
    private UaaDepartmentService uaaDepartmentService;

    @GetMapping
    @ApiOperation(value = "部门表 分页查询")
    @Validated
    public ResponseResult list(UaaDepartment uaaDepartment, Page<UaaDepartment> page) {
        QueryWrapper<UaaDepartment> queryWrapper = new QueryWrapper<>();

        IPage<UaaDepartment> pageResult = uaaDepartmentService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "部门表 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaDepartmentService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "部门表 创建")
    public ResponseResult create(@RequestBody UaaDepartment uaaDepartment) {
        uaaDepartmentService.saveOrUpdate(uaaDepartment);
        return ResponseResult.success(uaaDepartment);
    }

    @PutMapping
    @ApiOperation(value = "部门表 更新")
    public ResponseResult update(@RequestBody UaaDepartment uaaDepartment) {
        uaaDepartmentService.saveOrUpdate(uaaDepartment);
        return ResponseResult.success(uaaDepartment);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "部门表 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaDepartmentService.removeById(id));
    }

}