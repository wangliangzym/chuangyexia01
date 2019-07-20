package com.chuangyexia.enums;

import com.alibaba.druid.util.StringUtils;
import lombok.Getter;

@Getter
public enum MoneyDomainEnum {

    Domain1("1","0-2000"),
    Domain2("2","2000-4000"),
    Domain3("3","4000-6000"),
    Domain4("4","6000-8000"),
    Domain5("5","8000-10000");

    private String code;
    private String area;

    MoneyDomainEnum(String code, String area) {
        this.code = code;
        this.area = area;
    }

   public static MoneyDomainEnum getByCode(String code) {
       for (MoneyDomainEnum moneyDomain : MoneyDomainEnum.values()) {
           if (StringUtils.equals(code.trim(), moneyDomain.getCode())) {
               return moneyDomain;
           }
       }
       return null;
   }
}


