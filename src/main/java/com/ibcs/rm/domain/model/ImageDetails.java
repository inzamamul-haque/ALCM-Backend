package com.ibcs.rm.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "imageDetails")

public class ImageDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "imageId")
    @JsonIgnore
    private Long imageId;


    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "url")
    private String imageUrl;

}
