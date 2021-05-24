package com.Prana.Latifi.response.mapper;

import com.Prana.Latifi.entity.CompanyDetail;
import com.Prana.Latifi.response.CompanyDetailResponse;

import java.util.ArrayList;
import java.util.List;

public class CompanyDetailMapper {

  public static CompanyDetailResponse convert(CompanyDetail companyDetail) {
    if (companyDetail == null){
      return null;
    }
    return new CompanyDetailResponse(
        companyDetail.getId(),
        companyDetail.getIntroduceCode(),
        companyDetail.isAnyThingDiscounted(),
        CategoryMapper.conertAll(companyDetail.getCategories()),
        companyDetail.getCategoryDiscount(),
        ItemMapper.convertAll(companyDetail.getItems()),
        companyDetail.getItemDiscount());
  }

  public static List<CompanyDetailResponse> convertAll(List<CompanyDetail> companyDetails) {
    List<CompanyDetailResponse> responses = new ArrayList<>();
    for (CompanyDetail companyDetail : companyDetails) {
      responses.add(convert(companyDetail));
    }
    return responses;
  }
}
