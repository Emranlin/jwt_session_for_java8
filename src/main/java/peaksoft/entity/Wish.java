package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "wish")
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wish_seq")
    @SequenceGenerator(name = "wish_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    private String photo;
    private String title;
    private LocalDate dateOfHoliday;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "holiday_id")
    private Holiday holiday;

}