package com.wecureit.wecureit_service.repository;

import com.wecureit.wecureit_service.model.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Integer> {
}
