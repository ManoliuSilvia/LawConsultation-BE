package com.example.LawConsultation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="case_assigs")
public class CaseAssignment {
    @Id
    @Column(name = "ca_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caId;

    @OneToOne
    @JoinColumn(name = "lc_id")
    private LegalCase legalCase;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "price")
    private double price;

    public CaseAssignment() {
    }

    public CaseAssignment(LegalCase legalCase, User user, double price) {
        this.legalCase = legalCase;
        this.user = user;
        this.price = price;
    }
}
