package com.ibcs.rm.Entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "functional")
@EntityListeners(AuditingEntityListener.class)
@Data
public class FunctionalRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String frId;
    private String name;
    private String frTitle;
    @OneToOne
    Project project;
    private String Description;
}

