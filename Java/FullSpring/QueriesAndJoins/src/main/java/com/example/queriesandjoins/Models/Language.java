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
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 3)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "country_code", nullable = false, length = 3)
    private String countryCode;

    @Size(max = 30)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "language", nullable = false, length = 30)
    private String language;

    @NotNull
    @ColumnDefault("'F'")
    @Column(name = "is_official", nullable = false)
    private String isOfficial;

    @NotNull
    @ColumnDefault("0.0")
    @Column(name = "percentage", nullable = false)
    private Float percentage;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

}