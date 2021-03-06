package io.github.suxil.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaPermission;
import io.github.suxil.auth.dto.UaaPermissionDto;
import io.github.suxil.auth.service.UaaPermissionService;
import io.github.suxil.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 权限信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "权限信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-permissions")
public class UaaPermissionController {

    @Autowired
    private UaaPermissionService uaaPermissionService;

    @GetMapping
    @ApiOperation(value = "权限信息 分页查询")
    @Validated
    public ResponseResult list(UaaPermissionDto uaaPermissionDto, Page<UaaPermission> page) {
        QueryWrapper<UaaPermission> queryWrapper = new QueryWrapper<>();

        IPage<UaaPermission> pageResult = uaaPermissionService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "权限信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaPermissionService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "权限信息 创建")
    public ResponseResult create(@RequestBody UaaPermissionDto uaaPermissionDto) {
        return ResponseResult.success(uaaPermissionService.save(uaaPermissionDto));
    }

    @PutMapping
    @ApiOperation(value = "权限信息 更新")
    public ResponseResult update(@RequestBody UaaPermissionDto uaaPermissionDto) {
        return ResponseResult.success(uaaPermissionService.update(uaaPermissionDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "权限信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaPermissionService.removeById(id));
    }

}
