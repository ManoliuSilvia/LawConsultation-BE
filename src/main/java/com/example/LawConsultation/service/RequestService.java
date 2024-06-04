package com.example.LawConsultation.service;

import com.example.LawConsultation.entity.Request;
import com.example.LawConsultation.entity.User;
import com.example.LawConsultation.enums.RequestStatus;
import com.example.LawConsultation.enums.UserType;
import com.example.LawConsultation.repository.RequestRepository;
import com.example.LawConsultation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;

    public Request createRequest(Long userId, String specialization,String description) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        User user = optionalUser.get();
        Request request = new Request(user, specialization, description);
        return requestRepository.save(request);
    }

    public Request approveRequest(Long requestId, Long approverId) {
        Optional<Request> optionalRequest = requestRepository.findById(requestId);
        if (optionalRequest.isEmpty()) {
            throw new RuntimeException("Request not found!");
        }

        Optional<User> optionalApprover = userRepository.findById(approverId);
        if (optionalApprover.isEmpty() || optionalApprover.get().getType() != UserType.LAWYER) {
            throw new RuntimeException("Approving user must unauthorized!");
        }

        Request request = optionalRequest.get();

        request.setStatus(RequestStatus.APPROVED);

        User user = request.getUser();
        user.setType(UserType.LAWYER);
        user.setSpecialization(request.getSpecialization());
        userRepository.save(user);

        return requestRepository.save(request);
    }

    public Request rejectRequest(Long requestId, Long approverId) {
        Optional<Request> optionalRequest = requestRepository.findById(requestId);
        if (optionalRequest.isEmpty()) {
            throw new RuntimeException("Request not found!");
        }

        Optional<User> optionalApprover = userRepository.findById(approverId);
        if (optionalApprover.isEmpty() || optionalApprover.get().getType() != UserType.LAWYER) {
            throw new RuntimeException("Approving user must be a lawyer!");
        }

        Request request = optionalRequest.get();
        User user = request.getUser();
        user.setType(UserType.CLIENT);
        request.setStatus(RequestStatus.REJECTED);
        userRepository.save(user);
        return requestRepository.save(request);
    }
    public Request getById(long id){
        Optional<Request> optionalRequest = requestRepository.findByRequestId(id);
        if( optionalRequest.isEmpty()){
            throw new RuntimeException("user not found!");
        }
        return optionalRequest.get();
    }

    public List<Request> getAllBySpecialization(String specialization){
        return this.requestRepository.getAllBySpecializationAndStatus(specialization, RequestStatus.PENDING);
    }
}
