package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.Country;
import peaksoft.enums.SizeOfClothes;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "details")
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "details_seq")
    @SequenceGenerator(name = "details_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private SizeOfClothes sizeOfClothes;
    private Country.SizeOfShouse sizeOfShouse;
    private String note;
    private String hobby;
    private String whatsapp;
    private String telegram;
    private String instagram;
    private String facebook;
    private Country country;
    private String photo;

}