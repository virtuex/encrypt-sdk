package com.xudean.encrypt;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.symmetric.AES;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author : xudean
 * @version V1.0
 * @Description: TODO
 * @date Date : 2022年07月28日 下午5:07
 */
public class EncryptHandler {
    /**
     * 定义一个默认的IV:1234567812345678
     */
    private static final byte[] IV = new byte[]{0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08,0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08};

    private static final String KEY = "root@12345678";
    private AES aes;

    public EncryptHandler() {
        init();
    }

    public void init() {
        byte[] key = DigestUtil.md5(KEY.getBytes(Charset.defaultCharset()));
        // 构建
        aes = new AES("CBC","PKCS5Padding",key,IV);
    }

    public String encrypt(String plain) {
        byte[] encrypt = aes.encrypt(plain);
        return Base64.encode(encrypt);
    }

    public String decrypt(String cihper) {
        byte[] decrypt = aes.decrypt(Base64.decode(cihper));
        return StrUtil.str(decrypt, Charset.defaultCharset());
    }

//    public static void main(String[] args) {
//
//        EncryptHandler encryptHandler = new EncryptHandler();
//        encryptHandler.encrypt("root123");
//        byte[] key = DigestUtil.md5(KEY.getBytes(Charset.defaultCharset()));
//        System.out.println(Arrays.toString(IV));
//        System.out.println(Base64.encode(IV));
//    }
}
