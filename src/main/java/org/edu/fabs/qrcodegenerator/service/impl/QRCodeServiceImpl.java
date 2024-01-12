package org.edu.fabs.qrcodegenerator.service.impl;

import lombok.RequiredArgsConstructor;
import org.edu.fabs.qrcodegenerator.entity.ClientWifi;
import org.edu.fabs.qrcodegenerator.repository.QRCodeRepository;
import org.edu.fabs.qrcodegenerator.service.QRCodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QRCodeServiceImpl implements QRCodeService {

    private final QRCodeRepository wifiRepository;

    @Override
    public ClientWifi addWifi(ClientWifi clientWifi) {
        return wifiRepository.save(clientWifi);
    }

    @Override
    public List<ClientWifi> getClientWifi() {
        return wifiRepository.findAll();
    }

    @Override
    public ClientWifi getById(Long id) {
        return wifiRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wifi not found"));
    }

}
