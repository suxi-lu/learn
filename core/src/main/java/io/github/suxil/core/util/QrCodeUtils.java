package io.github.suxil.core.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.extern.slf4j.Slf4j;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @Author: luxq
 * @Description:
 * @Date: Created in 2018/4/29 0029 23:50
 */
@Slf4j
public final class QrCodeUtils {

    private static final String FORMAT = "png";
    private static final int WH = 300;

    private QrCodeUtils() {
    }

    /**
     * 生成默认宽高html可识别二维码
     * @param contents
     * @return
     */
    public static String qrCode(String contents) {
        return qrCode(contents, WH);
    }

    /**
     * 生成正方形html可识别二维码
     * @param contents
     * @param wh
     * @return
     */
    public static String qrCode(String contents, int wh) {
        return qrCode(contents, wh, wh);
    }

    /**
     * 生成html识别码二维码
     * @param contents
     * @param width
     * @param height
     * @return
     */
    public static String qrCode(String contents, int width, int height) {
        return CaptchaUtils.generateDataImg(qrCodeBytes(contents, width, height));
    }

    /**
     * 转换成byte数组
     * @param contents
     * @param width
     * @param height
     * @return
     */
    public static byte[] qrCodeBytes(String contents, int width, int height) {
        Path tempFile = null;
        BufferedImage bImage = null;
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix matrix = qrCodeWriter.encode(contents, BarcodeFormat.QR_CODE, width, height);
            tempFile = Files.createTempFile(null, "." + FORMAT);
            MatrixToImageWriter.writeToPath(matrix, FORMAT, tempFile, new MatrixToImageConfig());
            bImage = ImageUtils.getBufferedImage(tempFile.toFile());

        } catch (WriterException e) {
            log.error("qrCodeBytes WriterException: " + e.getMessage());
        } catch (IOException e) {
            log.error("qrCodeBytes IOException: " + e.getMessage());
        } finally {
            try {
                if (tempFile != null) {
                    Files.delete(tempFile);
                }
            } catch (IOException e) {
                log.error("qrCodeBytes finally IOException: " + e.getMessage());
            }
        }
        return CaptchaUtils.imageBufToByte(bImage);
    }

}
