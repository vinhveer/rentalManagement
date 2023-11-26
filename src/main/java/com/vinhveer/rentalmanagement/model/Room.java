package com.vinhveer.rentalmanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private int room_number;

    @Column
    private String room_type;

    @Column
    private String description;

    @Column
    private String status;

    @Column
    private long water_id;

    @Column
    private long electrical_id;

    @Column
    private long price_id;

    @Column
    private long internet_id;
}
