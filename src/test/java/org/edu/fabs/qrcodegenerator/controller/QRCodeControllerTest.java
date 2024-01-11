package org.edu.fabs.qrcodegenerator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.edu.fabs.qrcodegenerator.entity.ClientWifi;
import org.edu.fabs.qrcodegenerator.service.impl.QRCodeServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@DisplayName("QR Code Controller test")
@ExtendWith(MockitoExtension.class)
public class QRCodeControllerTest {

    @Mock
    private QRCodeServiceImpl qrCodeServiceImpl;
    private ClientWifi clientWifi;
    private List<ClientWifi> clientWifiList;

    @InjectMocks
    private QRCodeController qrCodeController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        clientWifi = new ClientWifi(1L, "Home Wifi", "123wifi");
        clientWifiList = List.of(clientWifi);
        mockMvc = MockMvcBuilders.standaloneSetup(qrCodeController).build();
    }

    @AfterEach
    public void tearDown() {
        clientWifi = null;
        clientWifiList = null;
    }

    @DisplayName("Should successfully add a new wifi and return status 201 Created")
    @Test
    public void postMappingOfWifi() throws Exception {
        when(qrCodeServiceImpl.addWifi(any())).thenReturn(clientWifi);
        mockMvc.perform(post("/v1/wifi")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(clientWifi)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());
        verify(qrCodeServiceImpl, times(1)).addWifi(any());
    }

    @DisplayName("Should successfully retrieve all registered wi-fis and return status 200 OK")
    @Test
    public void getMappingOfAllRegisteredWifis() throws Exception {
        when(qrCodeServiceImpl.getClientWifi()).thenReturn(clientWifiList);
        mockMvc.perform(get("/v1/wifi")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(clientWifi)))
                .andDo(MockMvcResultHandlers.print());
        verify(qrCodeServiceImpl).getClientWifi();
        verify(qrCodeServiceImpl, times(1)).getClientWifi();
    }

    private String asJsonString(final ClientWifi clientWifi) {
        try {
            return new ObjectMapper().writeValueAsString(clientWifi);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
