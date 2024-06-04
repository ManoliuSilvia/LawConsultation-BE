package com.example.LawConsultation.repository;

import com.example.LawConsultation.entity.Request;
import com.example.LawConsultation.enums.RequestStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestRepository extends CrudRepository<Request,Long> {
    public Optional<Request> findByRequestId(Long id);
    public List<Request>getAllBySpecializationAndStatus(String specialization, RequestStatus status);
}
