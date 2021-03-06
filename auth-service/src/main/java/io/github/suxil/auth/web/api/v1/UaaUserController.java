package io.github.suxil.auth.web.api.v1;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.UaaUser;
import io.github.suxil.auth.dto.UaaUserDto;
import io.github.suxil.auth.service.UaaUserService;
import io.github.suxil.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Slf4j
@Api(value = "用户信息 接口")
@RestController
@RequestMapping("/api/v1/uaa-users")
public class UaaUserController {

    @Autowired
    private UaaUserService uaaUserService;

    @GetMapping
    @ApiOperation(value = "用户信息 分页查询")
    @Validated
    public ResponseResult list(UaaUserDto uaaUserDto, Page<UaaUser> page) {
        QueryWrapper<UaaUser> queryWrapper = new QueryWrapper<>();

        IPage<UaaUser> pageResult = uaaUserService.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "用户信息 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(uaaUserService.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "用户信息 创建")
    public ResponseResult create(@RequestBody UaaUserDto uaaUserDto) {
        return ResponseResult.success(uaaUserService.save(uaaUserDto));
    }

    @PutMapping
    @ApiOperation(value = "用户信息 更新")
    public ResponseResult update(@RequestBody UaaUserDto uaaUserDto) {
        return ResponseResult.success(uaaUserService.update(uaaUserDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "用户信息 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(uaaUserService.removeById(id));
    }

}
