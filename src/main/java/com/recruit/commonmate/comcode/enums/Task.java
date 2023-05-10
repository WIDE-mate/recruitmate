package com.recruit.commonmate.comcode.enums;

import com.recruit.commonmate.comcode.dto.EnumMapper;

public enum Task implements EnumMapper{
    FINANCE("재무/회계"),
    HR("인사/총무"),
    SALES("영업"),
    MARKETING("마케팅"),
    SUPPORT("고객지원"),
    OPERATION("운영/제조"),
    LOGISTICS("물류/무역"),
    RESEARCH("연구/개발"),
    EDUCATION("교육/강사"),
    HEALTH("보건/의료"),
    LEGAL("법무"),
    MEDIA("미디어/출판"),
    ART("디자인"),
    IT("IT");

    private String title;

    Task(String  title){
        this.title = title;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getCode() {
        return name();
    }
}
