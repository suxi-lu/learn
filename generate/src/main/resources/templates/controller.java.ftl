package ${package.Controller};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.suxil.auth.domain.${table.entityName};
import ${package.Entity?replace("domain","dto")}.${entity}Dto;
import io.github.suxil.auth.service.${table.entityName}Service;
import io.github.suxil.core.common.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Slf4j
@Api(value = "${table.comment!} 接口")
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("/api/v1/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}s<#else>${table.entityPath}s</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    private ${table.entityName}Service ${table.entityName?uncap_first}Service;

    @GetMapping
    @ApiOperation(value = "${table.comment!} 分页查询")
    @Validated
    public ResponseResult list(${table.entityName}Dto ${table.entityName?uncap_first}Dto, Page<${table.entityName}> page) {
        QueryWrapper<${table.entityName}> queryWrapper = new QueryWrapper<>();

        IPage<${table.entityName}> pageResult = ${table.entityName?uncap_first}Service.page(page, queryWrapper);
        return ResponseResult.success(pageResult);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "${table.comment!} 详情")
    public ResponseResult load(@PathVariable String id) {
        return ResponseResult.success(${table.entityName?uncap_first}Service.getById(id));
    }

    @PostMapping
    @ApiOperation(value = "${table.comment!} 创建")
    public ResponseResult create(@RequestBody ${table.entityName}Dto ${table.entityName?uncap_first}Dto) {
        return ResponseResult.success(${table.entityName?uncap_first}Service.save(${table.entityName?uncap_first}Dto));
    }

    @PutMapping
    @ApiOperation(value = "${table.comment!} 更新")
    public ResponseResult update(@RequestBody ${table.entityName}Dto ${table.entityName?uncap_first}Dto) {
        return ResponseResult.success(${table.entityName?uncap_first}Service.update(${table.entityName?uncap_first}Dto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "${table.comment!} 删除")
    public ResponseResult delete(@PathVariable String id) {
        return ResponseResult.success(${table.entityName?uncap_first}Service.removeById(id));
    }

}
</#if>
