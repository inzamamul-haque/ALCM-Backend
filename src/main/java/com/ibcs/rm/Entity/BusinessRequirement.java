package com.ibcs.rm.Entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "business")
@EntityListeners(AuditingEntityListener.class)
@Data

public class BusinessRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brId;
    private String name;
    private String brTitle;
    @OneToOne
    Project project;
    private String Description;
    Date createdDate;
}
