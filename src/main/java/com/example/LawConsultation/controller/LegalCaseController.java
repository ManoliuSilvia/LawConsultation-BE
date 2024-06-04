package com.example.LawConsultation.controller;

import com.example.LawConsultation.entity.LegalCase;
import com.example.LawConsultation.entity.Request;
import com.example.LawConsultation.service.LegalCaseService;
import com.example.LawConsultation.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/l_cases")
public class LegalCaseController {
    @Autowired
    private LegalCaseService legalCaseService;

    @PostMapping("/create")
    @ResponseBody
    public LegalCase createRequest(@RequestParam Long userId, @RequestParam String caseType, @RequestParam String description) {
        return legalCaseService.createCase(userId, caseType, description);
    }

    @GetMapping("/getAllByCaseType")
    @ResponseBody
    public List<LegalCase> getAllByCaseType(@RequestParam String caseType){
        return legalCaseService.getAllByCaseType(caseType);
    }

    @PostMapping("/changeStatus")
    @ResponseBody
    public LegalCase changeStatus(@RequestBody LegalCase legalCase){
        return this.legalCaseService.changeStatus(legalCase);
    }
}
