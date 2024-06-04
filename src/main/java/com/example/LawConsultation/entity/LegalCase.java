package com.example.LawConsultation.entity;

import com.example.LawConsultation.enums.CaseStatus;
import com.example.LawConsultation.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="legal_cases")
public class LegalCase {
    @Id
    @Column(name = "lc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "lc_type")
    private String caseType;

    @Column(name = "lc_description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "lc_status")
    private CaseStatus status;

    public LegalCase() {
    }

    public LegalCase(User user, String caseType, String description) {
        this.user = user;
        this.caseType = caseType;
        this.description = description;
    }
}
