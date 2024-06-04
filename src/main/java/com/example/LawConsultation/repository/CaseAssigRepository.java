package com.example.LawConsultation.repository;

import com.example.LawConsultation.entity.CaseAssignment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseAssigRepository extends CrudRepository<CaseAssignment,Long> {
    public CaseAssignment getByCaId(Long caId);
}
