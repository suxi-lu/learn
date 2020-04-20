package com.learn.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.auth.domain.UaaUserPermission;
import com.learn.auth.repository.UaaUserPermissionRepository;
import com.learn.auth.service.UaaUserPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-权限信息 服务实现类
 * </p>
 *
 * @author generate
 * @since 2019-12-22
 */
@Service
@Slf4j
public class UaaUserPermissionServiceImpl extends ServiceImpl<UaaUserPermissionRepository, UaaUserPermission> implements UaaUserPermissionService {

}
