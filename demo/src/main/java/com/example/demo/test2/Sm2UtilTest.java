package com.example.demo.test2;
 

import java.util.Base64;
 
/**
 * @author WangJing
 * @Description Sm2Util 的测试类
 * @date 2021/11/24 16:10
 */
public class Sm2UtilTest {
 
    private static String testStr = "{\"merNbr\":\"test1001\",\"orderNbr\":\"20220622\"}";

    private static java.security.PublicKey publicKey = null;
    private static java.security.PrivateKey privateKey = null;

    public static String bcdToStr(byte[] bytes) {
        char[] temp = new char[bytes.length * 2];

        for(int i = 0; i < bytes.length; ++i) {
            char val = (char)((bytes[i] & 240) >> 4 & 15);
            temp[i * 2] = (char)(val > '\t' ? val + 65 - 10 : val + 48);
            val = (char)(bytes[i] & 15);
            temp[i * 2 + 1] = (char)(val > '\t' ? val + 65 - 10 : val + 48);
        }

        return new String(temp);
    }


    public static void main(String[] args) {
        try{
            //生成公私钥对
            String[] keys = KeyUtils.generateSmKey();

            System.out.println("原始字符串：" + testStr);
//            System.out.println("公钥：" + keys[0]);
//            System.out.println("私钥：" + keys[1]);
//            publicKey = KeyUtils.createPublicKey(keys[0]);
//            publicKey = KeyUtils.createPublicKey("MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEUper6CxEIaLXGEPBKyPyDpRayrg4a7faxnIURqS7eiEtTO4862V1J9tRcNOA4ZAEovjov7rO9hX7X62NMxjlJg==");
//            publicKey = KeyUtils.createPublicKey("MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEP2o9v9CD7cKXlUlRk5m609yDtPExWkXtGU1IqFgOrpdln/AvSmMl2eRK+RxasuBL8GInnigH4/tpYlTpepODhQ==");
            publicKey = KeyUtils.createPublicKey("MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEeWqO4vGOQW8Y7eMIB/Z5tdLCt8v7LSYsXe7OLYa8Ah+PzzjGOsUYB0n+F17OZQLJvJNKV60zfidpXKyPKV3+Jw==");
//              publicKey = KeyUtils.createPublicKey("MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAE5JIMxAx+mL2EWFQ0lGtFwL7x82KOoUJfaiXdeKjlLzN+hKv4nXU0QMMQ3K2PfgoOgmhnfUU2IRD7NNRCPtu2bQ==");
//              publicKey = KeyUtils.createPublicKey("MFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEAnFFuDAhAogeKkiVDjz2e+cOYHdaK33UDOFX5pVYVUoNwViwriIzYQPWnXSbC2m0IGRO/kAwvwPiO3oWw9SkDQ==");

//            privateKey = KeyUtils.createPrivateKey(keys[1]);
//            privateKey = KeyUtils.createPrivateKey("MIGTAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBHkwdwIBAQQgtBuJkb4BMB3S2xRaZsFlcc976tzXcH4xQLwYgjwvqwSgCgYIKoEcz1UBgi2hRANCAARSl6voLEQhotcYQ8ErI/IOlFrKuDhrt9rGchRGpLt6IS1M7jzrZXUn21Fw04DhkASi+Oi/us72FftfrY0zGOUm");
//            privateKey = KeyUtils.createPrivateKey("MIGHAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBG0wawIBAQQgy7c2IT92s4lg9V/LEnUKfpDqu4WMgpwMH9XFV5Oune+hRANCAAQ/aj2/0IPtwpeVSVGTmbrT3IO08TFaRe0ZTUioWA6ul2Wf8C9KYyXZ5Er5HFqy4EvwYieeKAfj+2liVOl6k4OF");
            privateKey = KeyUtils.createPrivateKey("MIGHAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBG0wawIBAQQgL/DUSA7nXcXrV4znhTbvpA7YhI/mB9hHojtqg9q7DD6hRANCAAR5ao7i8Y5Bbxjt4wgH9nm10sK3y/stJixd7s4thrwCH4/POMY6xRgHSf4XXs5lAsm8k0pXrTN+J2lcrI8pXf4n");
//              privateKey = KeyUtils.createPrivateKey("MIGHAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBG0wawIBAQQgfiCRAUfYpq3WmlkrzO4QbLqu1zmvGXU3lc1xGDmwBBChRANCAATkkgzEDH6YvYRYVDSUa0XAvvHzYo6hQl9qJd14qOUvM36Eq/iddTRAwxDcrY9+Cg6CaGd9RTYhEPs01EI+27Zt");
//              privateKey = KeyUtils.createPrivateKey("MIGHAgEAMBMGByqGSM49AgEGCCqBHM9VAYItBG0wawIBAQQgk/Aasg2of3jj83wK3al+8HuhH02K964IvluI1nYOW7ShRANCAAQCcUW4MCECiB4qSJUOPPZ75w5gd1orfdQM4VfmlVhVSg3BWLCuIjNhA9addJsLabQgZE7+QDC/A+I7ehbD1KQN");

              System.out.println("公钥：" + publicKey);
            System.out.println("私钥：" + privateKey);
            System.out.println("");


            byte[] encrypt = Sm2Util.encrypt(testStr.getBytes("UTF-8"), publicKey);

//            System.out.println("加密后:"+ bcdToStr(encrypt));
            String encryptBase64Str = Base64.getEncoder().encodeToString(encrypt);
//            encryptBase64Str = "BAqAwwJnWA6UWjO72ITeGtswC3WrPphLEsdFyIb1uy6p5cDA7z3lEm61k2C+ob7JUfhR27ffU2V+JPlaxA56QpQo7X87wK/UpewV8pByTO0zWMhNzRFYmeLyEmZUnROWTBFyOhzJD22dwIlt2ZZyI8dqtakhSDKFg+41RwDegTWYVlXQgrBMAmsQ1AG387ctvU87nCApVkOBtNgkknoUZNGXgyjtEgyb6IdZl88CCTcqt1w2Nyp6BterXjVuJlYcpZA17o2ec8SOTVpw5kBd92vRAkHwGETs8y7LuQ1zaQpbgpCHN/BMbdgaD5fmrD2/bD0=";
            encryptBase64Str = "BIvnygDNMXD1FfQf+k0RrSu8UhenGjb0iB6H6ppbbmQcR30ymOkcX+BrDUb3FVRqnzaMuxDtSYWZLI7D5jbPmePROmD1i9HPTMscqFgkzCFUTsKYuY0JfJutfgmY0z453mkmJ1r/tdwx03mJ3zoYetl0CXkceqTT1OFp5vpMciCQGU0gAYI1AP2n4xA58ayry13MKkcbwdf5ORCWSvqES9wQDfNd93N9N0XxCrLwCaVmDsqgchsikvr8Ne6UmK+0af8Fqyn+1+04bWMS2PZ3vK4CX56x+W9MopXIf8HKEkPeW6dPiIQxy6JuOGT1SHY4EkvC7NcrH8v7FnMLBC/VK2c9zGjurSV2cVcytg==";
            System.out.println("加密数据：" + encryptBase64Str);
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
