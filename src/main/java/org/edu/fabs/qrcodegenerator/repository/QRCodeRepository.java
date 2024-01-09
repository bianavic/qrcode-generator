package org.edu.fabs.qrcodegenerator.repository;

import org.edu.fabs.qrcodegenerator.entity.ClientWifi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QRCodeRepository extends JpaRepository<ClientWifi, Long> {
}
