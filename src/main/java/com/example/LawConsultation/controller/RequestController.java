package com.example.LawConsultation.controller;
import com.example.LawConsultation.entity.Request;
import com.example.LawConsultation.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/requests")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @PostMapping("/create")
    @ResponseBody
    public Request createRequest(@RequestParam Long userId, @RequestParam String specialization, @RequestParam String description) {
        return requestService.createRequest(userId, specialization, description);
    }

    @PostMapping("/approve")
    @ResponseBody
    public Request approveRequest(@RequestParam Long requestId, @RequestParam Long approverId) {
        return requestService.approveRequest(requestId, approverId);
    }

    @PostMapping("/reject")
    @ResponseBody
    public Request rejectRequest(@RequestParam Long requestId, @RequestParam Long approverId) {
        return requestService.rejectRequest(requestId, approverId);
    }

    @GetMapping("/getById")
    @ResponseBody
    public Request getById(@RequestParam Long requestId){
        return requestService.getById(requestId);
    }

    @GetMapping("/getAllBySpecialization")
    @ResponseBody
    public List<Request> getAllBySpecialization(@RequestParam String specialization){
        return requestService.getAllBySpecialization(specialization);
    }


}
