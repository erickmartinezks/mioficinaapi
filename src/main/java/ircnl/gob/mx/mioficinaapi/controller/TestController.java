package ircnl.gob.mx.mioficinaapi.controller;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@CrossOrigin(origins = {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/{barcodeText}", produces = MediaType.IMAGE_PNG_VALUE)
    // public ResponseEntity<BufferedImage> barcode(@PathVariable("barcodeText") String barcodeText)
    public String  barcode(@PathVariable("barcodeText") String barcodeText)
    throws Exception {
    	
    	QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);

        File outputfile = new File("C:\\\\Users\\erick.martinez\\Documents\\Procesos\\Gafetes\\imagenes\\qrPrueba.png");
	    ImageIO.write(MatrixToImageWriter.toBufferedImage(bitMatrix), "png", outputfile);
	    
        // return ResponseEntity.ok(MatrixToImageWriter.toBufferedImage(bitMatrix));
        
        return "OK";
    }
}
