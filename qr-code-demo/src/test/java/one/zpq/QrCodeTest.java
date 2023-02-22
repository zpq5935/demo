package one.zpq;

public class QrCodeTest {

    public static void main(String[] args) throws Exception {
        // 存放在二维码中的内容
//        String text = "我是小铭";
        String text = "www.baidu.com";
        // 嵌入二维码的图片路径
        String imgPath = "E:/img/portrait.png";
        // 生成的二维码的路径及名称
        String destPath = "E:/img/qrcode/jam.jpg";
        // 生成二维码
        QRCodeUtil.encode(text, imgPath, destPath, true);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);

    }

}
