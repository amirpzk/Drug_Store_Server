package com.Prana.Latifi.repository;

import com.Prana.Latifi.entity.CompanyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompanyDetailRepo extends JpaRepository<CompanyDetail, Long>, JpaSpecificationExecutor<CompanyDetail> {

    CompanyDetail findByIntroduceCode(String introduceCode);

}
