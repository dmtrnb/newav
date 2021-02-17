package org.example.newav.repository.entity;

import lombok.*;

import javax.persistence.*;
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

    private String title;

    private double price;
    private String description;

    @ElementCollection
    @CollectionTable(name = "photos", joinColumns=@JoinColumn(name = "ad_id"))
    private List<String> photos;

    @Column(name = "creation_date")
    private Timestamp creationDate;
}
