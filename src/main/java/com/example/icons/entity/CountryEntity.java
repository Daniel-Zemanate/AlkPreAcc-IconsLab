package com.example.icons.entity;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "country")
public class CountryEntity {

    @Id
    @SequenceGenerator(name = "sec_country", sequenceName = "sec_country", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_country")
    @Column(name = "id_country")
    private Long idCountry;

    @Column(name = "path_image")
    private String image;

    @Column(name = "denomination")
    private String denomination;

    @Column(name = "population")
    private Long population;

    @Column(name = "land_area")
    private Long landArea;

    @Column(name = "continent_id", nullable = false)
    private Long continentId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "continent_id", insertable = false, updatable = false)
    private ContinentEntity continent;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "country_icon",
    joinColumns = @JoinColumn(name = "country_id"), inverseJoinColumns = @JoinColumn(name = "icon_id"))
    private Set<IconEntity> icons = new HashSet<>();

}
