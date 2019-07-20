package com.chuangyexia.entity.responseParam;

import com.chuangyexia.entity.CompanyInfoVo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ComInfoDetailResp implements Serializable {

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

    List<CompanyInfoVo> companyInfoVos;
}
