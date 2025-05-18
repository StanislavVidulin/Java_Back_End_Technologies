package de.ait.tasks.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(of="id")
@Setter
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING) // для enum
    @Column(name = "priority")
    private Priority priority;
    @ManyToOne
    @JoinColumn(name = "programmer_id")
    private Programmer programmer;
}
