package io.github.suxil.auth.converter;

import io.github.suxil.auth.domain.UaaMenuElementRole;
import io.github.suxil.auth.dto.UaaMenuElementRoleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * 菜单菜单页面元素-角色息
 * </p>
 *
 * @author generate
 * @since 2020-05-03
 */
@Mapper
public interface UaaMenuElementRoleConverter {

    UaaMenuElementRoleConverter INSTANCE = Mappers.getMapper(UaaMenuElementRoleConverter.class);

    UaaMenuElementRole convert(UaaMenuElementRoleDto item);

    UaaMenuElementRoleDto convertDto(UaaMenuElementRole item);

    List<UaaMenuElementRole> convert(List<UaaMenuElementRoleDto> list);

    List<UaaMenuElementRoleDto> convertDto(List<UaaMenuElementRole> list);

}
