package io.github.suxil.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaGroupPermission;
import io.github.suxil.auth.dto.UaaGroupPermissionDto;
import io.github.suxil.auth.service.UaaGroupPermissionService;
import io.github.suxil.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 组-权限信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "组-权限信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-group-permissions")
public class UaaGroupPermissionController {

    @Autowired
    private UaaGroupPermissionService uaaGroupPermissionService;

    @GetMapping
    @ApiOperation(value = "组-权限信息 分页查询")
    @Validated
    public ResponseResult list(UaaGroupPermissionDto uaaGroupPermissionDto, Page<UaaGroupPermission> page) {
        QueryWrapper<UaaGroupPermission> queryWrapper = new QueryWrapper<>();

        IPage<UaaGroupPermission> pageResult = uaaGroupPermissionService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "组-权限信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaGroupPermissionService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "组-权限信息 创建")
    public ResponseResult create(@RequestBody UaaGroupPermissionDto uaaGroupPermissionDto) {
        return ResponseResult.success(uaaGroupPermissionService.save(uaaGroupPermissionDto));
    }

    @PutMapping
    @ApiOperation(value = "组-权限信息 更新")
    public ResponseResult update(@RequestBody UaaGroupPermissionDto uaaGroupPermissionDto) {
        return ResponseResult.success(uaaGroupPermissionService.update(uaaGroupPermissionDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "组-权限信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaGroupPermissionService.removeById(id));
    }

}
