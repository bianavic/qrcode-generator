package org.edu.fabs.qrcodegenerator.controller;

import com.google.zxing.WriterException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "QRCode Generator", description = "QRCode management APIs")
@RestController
@RequestMapping("v1/wifi")
@RequiredArgsConstructor
public class QRCodeController {

    private final QRCodeService QRCodeService;

    @Operation(
            summary = "Retrieve all registered wi-fis and generate QRCode file inside resources directory",
            description = "Get a ClientWifi object. The response is ClientWifi object with id, wifiName and wifiPassword")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = ClientWifi.class), mediaType = "application/json")})
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

    @Operation(
            summary = "Retrieve one registered wi-fi by ID",
            description = "Get a ClientWifi object by specifying its ID. The response is ClientWifi object with id, wifiName and wifiPassword")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = ClientWifi.class), mediaType = "application/json")})
    @GetMapping("/{id}")
    public ClientWifi getById(@PathVariable("id") Long id) {
        return QRCodeService.getById(id);
    }

    @Operation(
            summary = "Add a new wi-fi",
            description = "Add a ClientWifi object. The response is ClientWifi object with id, wifiName and wifiPassword")
    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = ClientWifi.class), mediaType = "application/json")})
    @PostMapping
    public ResponseEntity<ClientWifi> addWifi(@RequestBody ClientWifi clientWifi) {
        ClientWifi saveClientWifi = QRCodeService.addWifi(clientWifi);
        return new ResponseEntity<>(saveClientWifi, HttpStatus.CREATED);
    }

}
