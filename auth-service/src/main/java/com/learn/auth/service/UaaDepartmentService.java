package com.learn.auth.service;

import com.learn.auth.domain.UaaDepartment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.auth.dto.UaaDepartmentTreeDto;

import java.util.List;

/**
 * <p>
 * 部门信息 服务类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
public interface UaaDepartmentService extends IService<UaaDepartment> {

    /**
     * Description: 通过组织代码查询岗位树
     * date: 2020/1/1 19:55
     *
     * @author suxi
     * @version V1.0
     * @param officeCode
     * @return java.util.List<com.learn.auth.dto.UaaDepartmentTreeDto>
     */
    List<UaaDepartmentTreeDto> selectDepartmentTree(String officeCode);

}