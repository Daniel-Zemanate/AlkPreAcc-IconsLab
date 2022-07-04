package com.example.icons.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "icon")
public class IconEntity {

    @Id
    @SequenceGenerator(name = "sec_icon", sequenceName = "sec_icon", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_icon")
    @Column(name = "id_icon")
    private Long idIcon;

    @Column(name = "path_image")
    private String image;

    @Column(name = "denomination")
    private String denomination;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;

    @Column(name = "altitude")
    private Long altitude;

    @Column(name = "history")
    private String history;

    @Column(name = "delete_state")
    private Boolean deleteState = Boolean.FALSE;

    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<CountryEntity> countryList = new ArrayList<>();


//    Add and remove countries
    public void addCountry(CountryEntity country){
        countryList.add(country);
    }

    public void removeCountry(CountryEntity country){
        countryList.remove(country);
    }
}
