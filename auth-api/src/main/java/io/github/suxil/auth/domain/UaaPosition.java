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
 * 岗位表
 * </p>
 *
 * @author generate
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UaaPosition对象", description="岗位表")
@Entity
@Table(name = "uaa_position", catalog = "岗位表")
public class UaaPosition extends BaseDomain {

    private static final long serialVersionUID = 1L;

    public static final String PARENT_ID = "parent_id";
    public static final String SEQ = "seq";
    public static final String LEVEL = "level";
    public static final String FULL_PATH = "full_path";
    public static final String POSITION_CODE = "position_code";
    public static final String POSITION_NAME = "position_name";
    public static final String DESCRIPTION = "description";

    @ApiModelProperty(name = "parent_id", value = "父岗位id")
    @Column(name = "parent_id")
    private String parentId;

    @ApiModelProperty(name = "seq", value = "序号")
    @Column(name = "seq")
    private Integer seq;

    @ApiModelProperty(name = "level", value = "岗位层级")
    @Column(name = "level")
    private Integer level;

    @ApiModelProperty(name = "full_path", value = "岗位全路径")
    @Column(name = "full_path")
    private String fullPath;

    @ApiModelProperty(name = "position_code", value = "岗位代码")
    @Column(name = "position_code")
    private String positionCode;

    @ApiModelProperty(name = "position_name", value = "岗位名称")
    @Column(name = "position_name")
    private String positionName;

    @ApiModelProperty(name = "description", value = "描述")
    @Column(name = "description")
    private String description;


}
