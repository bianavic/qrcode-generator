package org.edu.fabs.qrcodegenerator.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.edu.fabs.qrcodegenerator.entity.ClientWifi;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {

    public static void generateQRCode(ClientWifi clientWifi) throws WriterException, IOException {
        String qrCodePath = "./src/main/resources/qrcodes/";
        String qrCodeName = qrCodePath + clientWifi.getWifiName() + clientWifi.getId() + "-QRCODE.png";

        var qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(
                "WIFI NAME: " + clientWifi.getWifiName() + "\n" +
                        "WIFI PASSWORD: " + clientWifi.getWifiPassword(), BarcodeFormat.QR_CODE, 400, 400);

        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

}
