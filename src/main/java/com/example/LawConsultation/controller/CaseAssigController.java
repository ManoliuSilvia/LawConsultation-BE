package com.example.LawConsultation.controller;

import com.example.LawConsultation.entity.CaseAssignment;
import com.example.LawConsultation.service.CaseAssigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/case_assigs")
public class CaseAssigController {
    @Autowired
    private CaseAssigService caseAssignmentService;

    @GetMapping("/getAll")
    public List<CaseAssignment> getAllAssignments() {
        return caseAssignmentService.getAllAssignments();
    }

    @GetMapping("/getById")
    public CaseAssignment getAssignmentById(@RequestParam Long id) {
        return caseAssignmentService.getAssignmentById(id);
    }

    @PostMapping("/create")
    public CaseAssignment createAssignment(@RequestBody CaseAssignment caseAssignment) {
        return caseAssignmentService.saveAssignment(caseAssignment);
    }
}
