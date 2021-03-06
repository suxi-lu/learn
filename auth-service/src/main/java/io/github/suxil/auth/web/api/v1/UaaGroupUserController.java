package io.github.suxil.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaGroupUser;
import io.github.suxil.auth.dto.UaaGroupUserDto;
import io.github.suxil.auth.service.UaaGroupUserService;
import io.github.suxil.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 组-用户信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "组-用户信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-group-users")
public class UaaGroupUserController {

    @Autowired
    private UaaGroupUserService uaaGroupUserService;

    @GetMapping
    @ApiOperation(value = "组-用户信息 分页查询")
    @Validated
    public ResponseResult list(UaaGroupUserDto uaaGroupUserDto, Page<UaaGroupUser> page) {
        QueryWrapper<UaaGroupUser> queryWrapper = new QueryWrapper<>();

        IPage<UaaGroupUser> pageResult = uaaGroupUserService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "组-用户信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaGroupUserService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "组-用户信息 创建")
    public ResponseResult create(@RequestBody UaaGroupUserDto uaaGroupUserDto) {
        return ResponseResult.success(uaaGroupUserService.save(uaaGroupUserDto));
    }

    @PutMapping
    @ApiOperation(value = "组-用户信息 更新")
    public ResponseResult update(@RequestBody UaaGroupUserDto uaaGroupUserDto) {
        return ResponseResult.success(uaaGroupUserService.update(uaaGroupUserDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "组-用户信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaGroupUserService.removeById(id));
    }

}
