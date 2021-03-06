package io.github.suxil.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaDepartment;
import io.github.suxil.auth.dto.UaaDepartmentDto;
import io.github.suxil.auth.service.UaaDepartmentService;
import io.github.suxil.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 部门信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "部门信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-departments")
public class UaaDepartmentController {

    @Autowired
    private UaaDepartmentService uaaDepartmentService;

    @GetMapping
    @ApiOperation(value = "部门信息 分页查询")
    @Validated
    public ResponseResult list(UaaDepartmentDto uaaDepartmentDto, Page<UaaDepartment> page) {
        QueryWrapper<UaaDepartment> queryWrapper = new QueryWrapper<>();

        IPage<UaaDepartment> pageResult = uaaDepartmentService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "部门信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaDepartmentService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "部门信息 创建")
    public ResponseResult create(@RequestBody UaaDepartmentDto uaaDepartmentDto) {
        return ResponseResult.success(uaaDepartmentService.save(uaaDepartmentDto));
    }

    @PutMapping
    @ApiOperation(value = "部门信息 更新")
    public ResponseResult update(@RequestBody UaaDepartmentDto uaaDepartmentDto) {
        return ResponseResult.success(uaaDepartmentService.update(uaaDepartmentDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "部门信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaDepartmentService.removeById(id));
    }

}
