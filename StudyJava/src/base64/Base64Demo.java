package base64;

import java.util.Base64;

/**
 * @Description:
 * @Author: huangjj24
 * @CreateDate: 2021-4-14 15:20
 **/
public class Base64Demo {
    public static void main(String[] args) {
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();
        String plainText = "我喜欢你！";
        byte[] cipherText = encoder.encode(plainText.getBytes());
        System.out.println(new String(cipherText));
        System.out.println(new String(decoder.decode(cipherText)));
        System.out.println("你爸爸");
    }
}
