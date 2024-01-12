package org.edu.fabs.qrcodegenerator.service;

import org.edu.fabs.qrcodegenerator.entity.ClientWifi;
import org.edu.fabs.qrcodegenerator.repository.QRCodeRepository;
import org.edu.fabs.qrcodegenerator.service.impl.QRCodeServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("QR Code Service test")
@ExtendWith(MockitoExtension.class)
public class QRCodeServiceTest {

    @InjectMocks
    QRCodeServiceImpl qrCodeServiceImpl;
    private ClientWifi clientWifi1;
    private ClientWifi clientWifi2;
    List<ClientWifi> wifiList;

    @Mock
    QRCodeRepository qrCodeRepository;

    @BeforeEach
    public void setUp() {
        wifiList = new ArrayList<>();
        clientWifi1 = new ClientWifi(1L, "Grandpa Home", "1234");
        clientWifi2 = new ClientWifi(2L, "Mamas Home", "wifi009");
        wifiList.add(clientWifi1);
        wifiList.add(clientWifi2);
    }

    @AfterEach
    public void tearDown() {
        clientWifi1 = clientWifi2 = null;
        wifiList = null;
    }

    @Test
    @DisplayName("Should add wifi successfully and return status 200")
    public void givenAddWifiShouldRegisterWifiInformation() {
        when(qrCodeRepository.save(any())).thenReturn(clientWifi1);
        qrCodeServiceImpl.addWifi(clientWifi1);
        verify(qrCodeRepository, times(1)).save(any());
    }

    @Test
    @DisplayName("Should fetch successfully a list of all registered wi-fis and return status 200")
    public void givenGetClientWifiShouldReturnListOfAllClients() {
        qrCodeRepository.save(clientWifi1);
        when(qrCodeRepository.findAll()).thenReturn(wifiList);

        List<ClientWifi> clientWifiList1 = qrCodeServiceImpl.getClientWifi();
        assertEquals(clientWifiList1, wifiList);
        verify(qrCodeRepository, times(1)).save(clientWifi1);
        verify(qrCodeRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should fetch successfully a registered wi-fi by its ID and return status 200")
    public void givenIDThenShouldReturnWifiOfThatID() {
        when(qrCodeRepository.findById(1L)).thenReturn(Optional.ofNullable(clientWifi1));
        assertThat(qrCodeServiceImpl.getById(clientWifi1.getId())).isEqualTo(clientWifi1);
    }

}
