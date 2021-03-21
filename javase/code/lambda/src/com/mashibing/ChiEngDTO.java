package com.mashibing;

import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ChiEngDTO {

    String DescENG;
    String DescCHI;

    public ChiEngDTO() {
    }

    public ChiEngDTO(String DescENG, String DescCHI) {
        this.DescCHI = DescCHI;
        this.DescENG = DescENG;
    }

    public ChiEngDTO(Date date) {
        if (null != date) {
            this.DescCHI = DateTimeUtil.dateString(date, DateTimeUtil.DATE_TIME_CN);
            this.DescENG = DateTimeUtil.dateString(date, DateTimeUtil.DATE_SHORT_MONTH_ENG, DateTimeUtil.LOCALE_ENGLISH);
        }
    }

    public void append(List<ChiEngDTO> appendDTOList, String split) {
        if (null != appendDTOList) {
            appendDTOList.stream().forEach(appendDTO -> {
                this.DescCHI += split + appendDTO.getDescCHI();
                this.DescENG += split + appendDTO.getDescENG();
            });

        }
    }

    public static ChiEngDTO newInstanceForMoney(Object number, String prefixChi, String prefixEng) {
        ChiEngDTO data = new ChiEngDTO();
        data.setDescENG(prefixEng + NumberUtil.number2String(number));
        data.setDescCHI(prefixChi + NumberUtil.number2String(number));

        return data;
    }

    public static ChiEngDTO newInstanceForMoney(Object number) {
        return newInstanceForMoney(number, "港元 ", "HK$ ");
    }

    public static ChiEngDTO newInstanceForName(String chineseName, String surName, String givenName) {
        String engName = surName + " " + givenName;
        return new ChiEngDTO(engName, StringUtils.isEmpty(chineseName) ? engName : chineseName);

    }

    public static ChiEngDTO convertListToOne(List<ChiEngDTO> list, String splitChar) {
        if (list == null || list.size() == 0) {
            return null;
        }
        String chi = list.stream().map(x -> x.getDescCHI()).collect(Collectors.joining(splitChar));
        String eng = list.stream().map(x -> x.getDescENG()).collect(Collectors.joining(splitChar));

        return new ChiEngDTO(eng, chi);
    }

    //------------------get set-------------------

    public String getDescENG() {
        return DescENG;
    }

    public void setDescENG(String descENG) {
        DescENG = descENG;
    }

    public String getDescCHI() {
        return DescCHI;
    }

    public void setDescCHI(String descCHI) {
        DescCHI = descCHI;
    }
}
