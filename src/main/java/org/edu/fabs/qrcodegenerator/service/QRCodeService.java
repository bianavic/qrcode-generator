package org.edu.fabs.qrcodegenerator.service;

import org.edu.fabs.qrcodegenerator.entity.ClientWifi;

import java.util.List;

public interface QRCodeService {

    ClientWifi addWifi(ClientWifi clientWifi);

    List<ClientWifi> getClientWifi();

    ClientWifi getById(Long id);

}
