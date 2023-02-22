package one.zpq;



import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * 条形码工具类
 * @author zagwk
 * @version 1.0
 * @date 2021/9/10 14:56
 */
public class BarCodeUtil {

    /**
     * 给前端产生一个条形码
     *
     * @param number 编码
     * @param width  宽度
     * @param height 高度
     */
    public static String getCode(String number, Integer width, Integer height) {
        // 生成条形码
        BufferedImage image = getBarCode(number, width, height);
        // 使用流的方式
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", out);
        } catch (Exception e) {
            // log.error("generate code error! error message:{}", "出现问题！");
            e.printStackTrace();
        }
        // 将流转成数组
        byte[] bytes = out.toByteArray();
        BASE64Encoder encoder = new BASE64Encoder();
        // 把生成的编码返回去
        return "data:image/png;base64," + encoder.encodeBuffer(bytes).trim();
    }

    /**
     * 产生条形码的方法
     *
     * @param number 编码
     * @param width  宽度
     * @param height 高度
     */
    public static BufferedImage getBarCode(String number, Integer width, Integer height) {
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(number, BarcodeFormat.CODE_128, width, height);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 产生条形码的方法 并将条码转换为base64格式
     *
     * @param number 编码
     * @param width  宽度
     * @param height 高度
     */
    public static String getBarCode2(String number, Integer width, Integer height) {
        String code = getCode(number, width, height);
        return code;
    }

    /**
     * 调用测试
     */
    public static void main(String[] args) {
        String code = getBarCode2("D1415202770591686656", 50, 50);
        System.out.println(code);
    }
}