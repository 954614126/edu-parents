package com.definesys.edu.bean.query;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @author: shuaishuai.li
 * @since: 2021/05/03 16:44
 * @history: 1.2021/05/03 created by shuaishuai.li
 */
@Api("讲师查询条件")
@Data
public class TeacherQuery {
    @ApiModelProperty("讲师名称")
    private String name ;
    @ApiModelProperty("讲师级别")
    private Integer level;
    @ApiModelProperty("开始时间")
    private String startTime;
    @ApiModelProperty("结束时间")
    private String endTime;

}