package com.ezan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Short gender;
    private String image;
    private Short job;
    private LocalDate entrydate;        //LocalDate：包含年月日
    private Integer deptId;
    private LocalDateTime createTime;       //LocalDateTime：包含年月日+时分秒
    private LocalDateTime updateTime;
}
