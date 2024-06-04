package com.example.LawConsultation.entity;

import com.example.LawConsultation.enums.CaseStatus;
import com.example.LawConsultation.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="requests")
public class Request {
    @Id
    @Column(name = "request_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "r_description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "r_status")
    private RequestStatus status;

    public Request() {
    }

    public Request(User user, String specialization, String description) {
        this.user = user;
        this.specialization = specialization;
        this.description = description;
        this.status = RequestStatus.PENDING;
    }
}
