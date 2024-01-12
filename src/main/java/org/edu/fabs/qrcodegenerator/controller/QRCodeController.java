package org.edu.fabs.qrcodegenerator.controller;

import com.google.zxing.WriterException;
import lombok.RequiredArgsConstructor;
import org.edu.fabs.qrcodegenerator.entity.ClientWifi;
import org.edu.fabs.qrcodegenerator.service.QRCodeService;
import org.edu.fabs.qrcodegenerator.utils.QRCodeGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("v1/wifi")
@RequiredArgsConstructor
public class QRCodeController {

    private final QRCodeService QRCodeService;

    @GetMapping
    public ResponseEntity<List<ClientWifi>> getAllHomeWifi() throws IOException, WriterException {
        List<ClientWifi> clientWifiList = QRCodeService.getClientWifi();
        if (!clientWifiList.isEmpty()) {
            for (ClientWifi clientWifi : clientWifiList) {
                QRCodeGenerator.generateQRCode(clientWifi);
            }
        }
        return ResponseEntity.ok(clientWifiList);
    }

    @GetMapping("/{id}")
    public ClientWifi getById(@PathVariable("id") Long id) {
        return QRCodeService.getById(id);
    }

    @PostMapping
    public ResponseEntity<ClientWifi> addWifi(@RequestBody ClientWifi clientWifi) {
        ClientWifi saveClientWifi = QRCodeService.addWifi(clientWifi);
        return new ResponseEntity<>(saveClientWifi, HttpStatus.CREATED);
    }

}
