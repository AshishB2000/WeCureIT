package com.wecureit.wecureit_service.repository;

import com.wecureit.wecureit_service.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository  extends JpaRepository<Facility, Integer> {
}
