package org.example.newav.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.net.URI;
import java.util.Date;
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
//    private URI mainPhoto;
    private double price;
    private String description;
//    private List<URI> otherPhotos;
//    private Date dateCreation;
}
