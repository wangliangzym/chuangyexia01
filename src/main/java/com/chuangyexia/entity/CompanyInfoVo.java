package com.chuangyexia.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class CompanyInfoVo {

    private Long id;

    private String companyName;

    private String companyTel;

    private String companyTip;

    private String companyType;

    private String label1;

    private String label2;

    private BigDecimal joinPrice;

    private Integer applicationCount;

    private Float goodEvaluate;

    private Integer shopCount;

    private String bigPicUrl;

    private String smallPicUrl;

    private String companyProfile;
}
