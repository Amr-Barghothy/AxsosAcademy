package com.example.queriesandjoins.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 3)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "code", nullable = false, length = 3)
    private String code;

    @Size(max = 52)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "name", nullable = false, length = 52)
    private String name;

    @NotNull
    @ColumnDefault("'Asia'")
    @Column(name = "continent", nullable = false)
    private String continent;

    @Size(max = 26)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "region", nullable = false, length = 26)
    private String region;

    @NotNull
    @ColumnDefault("0.00")
    @Column(name = "surface_area", nullable = false)
    private Float surfaceArea;

    @Column(name = "indep_year")
    private Short indepYear;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "population", nullable = false)
    private Integer population;

    @Column(name = "life_expectancy")
    private Float lifeExpectancy;

    @Column(name = "gnp")
    private Float gnp;

    @Column(name = "gnp_old")
    private Float gnpOld;

    @Size(max = 45)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "local_name", nullable = false, length = 45)
    private String localName;

    @Size(max = 45)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "government_form", nullable = false, length = 45)
    private String governmentForm;

    @Size(max = 60)
    @Column(name = "head_of_state", length = 60)
    private String headOfState;

    @Column(name = "capital")
    private Integer capital;

    @Size(max = 2)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "code2", nullable = false, length = 2)
    private String code2;

    @OneToMany(mappedBy = "country")
    private List<City> cities =  new ArrayList<>();

    @OneToMany(mappedBy = "country")
    private List<Language> languages = new ArrayList<>();

}