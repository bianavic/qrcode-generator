package org.edu.fabs.qrcodegenerator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ClientWifi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String wifiName;
    private String wifiPassword;

    public ClientWifi(String wifiName, String wifiPassword) {
        this.wifiName = wifiName;
        this.wifiPassword = wifiPassword;
    }

}
