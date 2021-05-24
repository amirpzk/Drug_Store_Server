package com.Prana.Latifi.repository;


import com.Prana.Latifi.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProfileRepo extends JpaRepository<Profile, Long>, JpaSpecificationExecutor<Profile> {


}
