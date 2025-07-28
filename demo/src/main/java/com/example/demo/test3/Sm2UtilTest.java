package com.example.demo.test3;
 
import com.example.demo.test2.KeyUtils;
import com.example.demo.test2.Sm2Util;

import java.util.Base64;
 
/**
 * @author WangJing
 * @Description Sm2Util 的测试类
 * @date 2021/11/24 16:10
 */
public class Sm2UtilTest {

    private static String testStr = "{\"merNbr\":\"999691148121000\",\"orderNbr\":\"NP2206232452649\",\"transAmount\":\"100.00\",\"realAmount\":\"98.00\",\"couponNbr\":\"EQU36d8832a-09f8-496b-818f-2148d137d2f8\",\"couponAmt\":\"2.00\",\"equityClass\":\"0\",\"couponRes\":\"EQUITY\"}";

    private static java.security.PublicKey publicKey = null;
    private static java.security.PrivateKey privateKey = null;


    public static void main(String[] args) {
        try{
            //生成公私钥对
            String[] keys = com.example.demo.test2.KeyUtils.generateSmKey();

            System.out.println("原始字符串：" + testStr);
//            System.out.println("公钥：" + keys[0]);
//            System.out.println("私钥：" + keys[1]);
//            publicKey = KeyUtils.createPublicKey(keys[0]);
//            publicKey = KeyUtils.createPublicKey("MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEUper6CxEIaLXGEPBKyPyDpRayrg4a7faxnIURqS7eiEtTO4862V1J9tRcNOA4ZAEovjov7rO9hX7X62NMxjlJg==");
//            publicKey = com.example.demo.test2.KeyUtils.createPublicKey("MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEP2o9v9CD7cKXlUlRk5m609yDtPExWkXtGU1IqFgOrpdln/AvSmMl2eRK+RxasuBL8GInnigH4/tpYlTpepODhQ==");
            publicKey = com.example.demo.test2.KeyUtils.createPublicKey("MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEeWqO4vGOQW8Y7eMIB/Z5tdLCt8v7LSYsXe7OLYa8Ah+PzzjGOsUYB0n+F17OZQLJvJNKV60zfidpXKyPKV3+Jw==");
//            publicKey = com.example.demo.test2.KeyUtils.createPublicKey("MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE7wFvImxBaUYoM4Ju9uoSAdAkwfEaQHllkDzlbrhO5bHeaZeSbCorDb8Jb+r9NFz7Oyjgd/DsAa4d6DnxBmnPow==");

//            privateKey = KeyUtils.createPrivateKey(keys[1]);
//            privateKey = KeyUtils.createPrivateKey("MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgtBuJkb4BMB3S2xRaZsFlcc976tzXcH4xQLwYgjwvqwSgCgYIKoEcz1UBgi2hRANCAARSl6voLEQhotcYQ8ErI/IOlFrKuDhrt9rGchRGpLt6IS1M7jzrZXUn21Fw04DhkASi+Oi/us72FftfrY0zGOUm");
//            privateKey = KeyUtils.createPrivateKey("MIGHAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBG0wawIBAQQgy7c2IT92s4lg9V/LEnUKfpDqu4WMgpwMH9XFV5Oune+hRANCAAQ/aj2/0IPtwpeVSVGTmbrT3IO08TFaRe0ZTUioWA6ul2Wf8C9KYyXZ5Er5HFqy4EvwYieeKAfj+2liVOl6k4OF");
            privateKey = KeyUtils.createPrivateKey("MIGHAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBG0wawIBAQQgL/DUSA7nXcXrV4znhTbvpA7YhI/mB9hHojtqg9q7DD6hRANCAAR5ao7i8Y5Bbxjt4wgH9nm10sK3y/stJixd7s4thrwCH4/POMY6xRgHSf4XXs5lAsm8k0pXrTN+J2lcrI8pXf4n");
//            privateKey = KeyUtils.createPrivateKey("MIGHAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBG0wawIBAQQgGPaHKB/dk0yALMrmxId+vTa+DkNY5R0w0f8jNJbv25ShRANCAATvAW8ibEFpRigzgm726hIB0CTB8RpAeWWQPOVuuE7lsd5pl5JsKisNvwlv6v00XPs7KOB38OwBrh3oOfEGac+j");
            System.out.println("公钥字符串：" + "MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEeWqO4vGOQW8Y7eMIB/Z5tdLCt8v7LSYsXe7OLYa8Ah+PzzjGOsUYB0n+F17OZQLJvJNKV60zfidpXKyPKV3+Jw==");
            System.out.println("公钥：" + publicKey);

            System.out.println("私钥pkcs8字符串：" + "MIGHAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBG0wawIBAQQgL/DUSA7nXcXrV4znhTbvpA7YhI/mB9hHojtqg9q7DD6hRANCAAR5ao7i8Y5Bbxjt4wgH9nm10sK3y/stJixd7s4thrwCH4/POMY6xRgHSf4XXs5lAsm8k0pXrTN+J2lcrI8pXf4n");
            System.out.println("私钥：" + privateKey);
            System.out.println("");


            byte[] encrypt = com.example.demo.test2.Sm2Util.encrypt(testStr.getBytes("UTF-8"), publicKey);

//            System.out.println("加密后:"+ bcdToStr(encrypt));
            String encryptBase64Str = Base64.getEncoder().encodeToString(encrypt);
            System.out.println("加密数据：" + encryptBase64Str);
//            encryptBase64Str = "EmgM81Q8FTYP8BKm8GabWWI9eNlhCStcvp7VRytVZbWNALQBclT4nZauDskxinB6k68eWYupwBAjovk/xKETzcLmVT6p/7HVLcDI49A8QIcXlGQ+yAN12RWIlYUn3nhZZK6Z5FxppIm+CEehE1bpDo7I0BG821tGTO1WdfCW/gXn4htwoQzmCeoRxrAcdUdO9bL2aoNpjNYfSLv7Oe3IC8345x19QQIOYNMSrOikhpsSZRVnB3Uje4WsPuHksrSlaXYorxs5M9BQ/xD85gzKnyNCYLceylKLEXW5qmtjMyx533INTjox5cQEH0kY2h2/gY7IGcY=";
            byte[] decode = Base64.getDecoder().decode(encryptBase64Str);
            byte[] decrypt = Sm2Util.decrypt(decode, privateKey);
            System.out.println("解密数据：" + new String(decrypt,"UTF-8"));

//            byte[] sign = Sm2Util.signByPrivateKey(testStr.getBytes(), privateKey);
//            System.out.println("数据签名：" + Base64.getEncoder().encodeToString(sign));
//
//            boolean b = Sm2Util.verifyByPublicKey(testStr.getBytes(), publicKey, sign);
//            System.out.println("数据验签：" + b);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
