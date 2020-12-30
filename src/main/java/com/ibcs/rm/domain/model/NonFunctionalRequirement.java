package com.ibcs.rm.domain.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "nonFunctional")
@EntityListeners(AuditingEntityListener.class)
@Data
public class NonFunctionalRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nonFrId;
    private String name;
    private String nonFrTitle;
    @OneToOne
    BusinessRequirement businessRequirement;
    private String Description;
    private String fileUrl;

}
