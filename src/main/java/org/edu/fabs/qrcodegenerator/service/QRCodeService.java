package org.edu.fabs.qrcodegenerator.service;

import com.google.zxing.WriterException;

import java.awt.image.BufferedImage;

public interface QRCodeService {

    BufferedImage generateQRCode(String text, int width, int height) throws WriterException;
}
