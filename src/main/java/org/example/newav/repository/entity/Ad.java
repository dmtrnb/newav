package org.example.newav.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "ad")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ad {

    @Id
    @Column(name = "ad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @Column(name = "main_photo")
    private String mainPhoto;
    private double price;
    private String description;
//    private List<String> otherPhotos;
    @Column(name = "creation_date")
    private Timestamp dateCreation;
}
