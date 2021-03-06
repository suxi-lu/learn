package io.github.suxil.auth.domain;

import io.github.suxil.mybatis.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>
 * 菜单页面元素表
 * </p>
 *
 * @author generate
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaMenuElement对象", description="菜单页面元素表")
@Entity
@Table(name = "uaa_menu_element", catalog = "菜单页面元素表")
public class UaaMenuElement extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String MENU_ID = "menu_id";
    public static final String SEQ = "seq";
    public static final String MENU_ELEMENT_CODE = "menu_element_code";
    public static final String MENU_ELEMENT_NAME = "menu_element_name";
    public static final String DESCRIPTION = "description";

    @ApiModelProperty(name = "menu_id", value = "菜单id")
    @Column(name = "menu_id")
    private String menuId;

    @ApiModelProperty(name = "seq", value = "序号")
    @Column(name = "seq")
    private Integer seq;

    @ApiModelProperty(name = "menu_element_code", value = "菜单元素代码")
    @Column(name = "menu_element_code")
    private String menuElementCode;

    @ApiModelProperty(name = "menu_element_name", value = "菜单元素名称")
    @Column(name = "menu_element_name")
    private String menuElementName;

    @ApiModelProperty(name = "description", value = "描述")
    @Column(name = "description")
    private String description;


}
