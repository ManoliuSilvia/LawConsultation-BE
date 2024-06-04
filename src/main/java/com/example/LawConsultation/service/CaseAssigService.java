package com.example.LawConsultation.service;

import com.example.LawConsultation.entity.CaseAssignment;
import com.example.LawConsultation.repository.CaseAssigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseAssigService {
    @Autowired
    private CaseAssigRepository caseAssigRepository;

    public List<CaseAssignment> getAllAssignments(){
        return (List<CaseAssignment>) caseAssigRepository.findAll();
    }

    public CaseAssignment getAssignmentById(Long id){
        return caseAssigRepository.getByCaId(id);
    }

    public CaseAssignment saveAssignment(CaseAssignment caseAssignment){
        return caseAssigRepository.save(caseAssignment);
    }
}
