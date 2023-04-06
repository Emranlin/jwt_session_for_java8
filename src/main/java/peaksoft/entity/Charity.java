package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.Category;
import peaksoft.enums.Condition;
import peaksoft.enums.SubCategory;

@Getter
@Setter
@Entity
@Table(name = "charity")
public class Charity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "charity_seq")
    @SequenceGenerator(name = "charity_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    private String photo;
    private String title;
    private String description;
    private Category category;
    private SubCategory subCategory;
    private Condition condition;



}