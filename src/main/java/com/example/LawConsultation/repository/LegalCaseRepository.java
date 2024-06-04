package com.example.LawConsultation.repository;

import com.example.LawConsultation.entity.LegalCase;
import com.example.LawConsultation.entity.User;
import com.example.LawConsultation.enums.CaseStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LegalCaseRepository extends CrudRepository<LegalCase,Long> {
    public List<LegalCase> getAllByCaseTypeAndAndStatus(String caseType, CaseStatus status);
}
