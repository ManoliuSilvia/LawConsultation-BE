package com.example.LawConsultation.service;

import com.example.LawConsultation.entity.LegalCase;
import com.example.LawConsultation.entity.Request;
import com.example.LawConsultation.entity.User;
import com.example.LawConsultation.enums.CaseStatus;
import com.example.LawConsultation.enums.RequestStatus;
import com.example.LawConsultation.enums.UserType;
import com.example.LawConsultation.repository.LegalCaseRepository;
import com.example.LawConsultation.repository.RequestRepository;
import com.example.LawConsultation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LegalCaseService {
    @Autowired
    private LegalCaseRepository legalCaseRepository;

    @Autowired
    private UserRepository userRepository;

    public LegalCase createCase(Long userId, String caseType,String description) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        User user = optionalUser.get();
        LegalCase legalCase = new LegalCase(user, caseType, description);
        legalCase.setStatus(CaseStatus.PENDING);
        return legalCaseRepository.save(legalCase);
    }

    public List<LegalCase> getAllByCaseType(String caseType){
        return this.legalCaseRepository.getAllByCaseTypeAndAndStatus(caseType, CaseStatus.PENDING);
    }

    public LegalCase changeStatus(LegalCase legalCase){
        legalCase.setStatus(CaseStatus.IN_PROGRESS);
        return this.legalCaseRepository.save(legalCase);
    }

}
