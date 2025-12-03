package com.example.queriesandjoins.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 35)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "name", nullable = false, length = 35)
    private String name;

    @Size(max = 3)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "country_code", nullable = false, length = 3)
    private String countryCode;

    @Size(max = 20)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "district", nullable = false, length = 20)
    private String district;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "population", nullable = false)
    private Integer population;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

}