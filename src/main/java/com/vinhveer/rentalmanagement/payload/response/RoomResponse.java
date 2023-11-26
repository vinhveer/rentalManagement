package com.vinhveer.rentalmanagement.payload.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponse {
    private long id;

    private int room_number;

    private String room_type;

    private String description;

    private String status;

    private long water_id;

    private long electrical_id;

    private long price_id;

    private long internet_id;
}
