package com.example.icons.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "continent")
public class ContinentEntity {

    @Id
    @SequenceGenerator(name = "sec_continent", sequenceName = "sec_continent", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_continent")
    @Column(name = "id_continent")
    private Long idContinent;

    @Column(name = "path_image")
    private String image;

    @Column(name = "denomination")
    private String denomination;


}
