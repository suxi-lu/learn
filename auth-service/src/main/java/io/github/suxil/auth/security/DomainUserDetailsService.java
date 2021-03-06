package io.github.suxil.auth.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.suxil.auth.domain.UaaUser;
import io.github.suxil.auth.repository.UaaUserRepository;
import io.github.suxil.core.exception.GlobalCommonException;
import io.github.suxil.core.security.AuthoritiesConstants;
import io.github.suxil.core.util.MessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final UaaUserRepository uaaUserRepository;

    public DomainUserDetailsService(UaaUserRepository uaaUserRepository) {
        this.uaaUserRepository = uaaUserRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Authenticating {}", username);

        UaaUser uaaUser = null;
        if (new EmailValidator().isValid(username, null)) {
            QueryWrapper<UaaUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.or(true, qw -> qw.eq(UaaUser.EMAIL, username));

            uaaUser = uaaUserRepository.selectOne(queryWrapper);
            if (uaaUser == null) {
                throw new GlobalCommonException(MessageUtils.getMessage("error.not.user", username));
            }
        } else {
            QueryWrapper<UaaUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.or(true, qw -> qw.eq(UaaUser.LOGIN_NAME, username));
            queryWrapper.or(true, qw -> qw.eq(UaaUser.USER_CODE, username));
            queryWrapper.or(true, qw -> qw.eq(UaaUser.MOBILE, username));

            uaaUser = uaaUserRepository.selectOne(queryWrapper);
            if (uaaUser == null) {
                throw new GlobalCommonException(MessageUtils.getMessage("error.not.user", username));
            }
        }

        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(AuthoritiesConstants.USER));

        return DomainUserDetails.builder()
                .userCode(uaaUser.getUserCode())
                .username(uaaUser.getUserName())
                .jp(uaaUser.getJp())
                .loginName(uaaUser.getLoginName())
                .password(uaaUser.getPassword())
                .mobile(uaaUser.getMobile())
                .email(uaaUser.getEmail())
                .admin(uaaUser.getAdmin())
                .authorities(Collections.unmodifiableSet(DomainUserDetails.sortAuthorities(authorityList)))
                .build();
    }

}
