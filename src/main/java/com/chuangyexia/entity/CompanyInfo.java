package com.chuangyexia.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class CompanyInfo {

    private Long id;

    private String companyName;

    private String companyTel;

    private String companyTip;

    private String companyType;

    private BigDecimal joinPrice;

    private Integer applicationCount;

    private Float goodEvaluate;

    private Integer shopCount;

    private String bigPicUrl;

    private String smallPicUrl;

    private String companyProfile;

    private Date createTime;

    private Boolean delFlag;

    /**
     * 加盟最大金额
     */
    private BigDecimal maxPrice;

    /**
     * 加盟最小金额
     */
    private BigDecimal minPrice;
}
