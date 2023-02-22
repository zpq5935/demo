package one.zpq;

public class BarCodeTest {

    public static void main(String[] args) throws Exception {
        String code = BarCodeUtil.getBarCode2("D1415202770591686656", 50, 50);
        System.out.println(code);
    }

}
