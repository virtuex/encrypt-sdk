package com.xudean.bcrypt;

import cn.hutool.crypto.digest.DigestUtil;
import org.apache.commons.cli.*;

/**
 * @author : xudean
 * @version V1.0
 * @Description: TODO
 * @date Date : 2022年08月04日 下午5:12
 */
public class BcryptHandler {

    public String hash(String password) {
        String sha256Hex = DigestUtil.sha256Hex(password);
        String bcrypt = DigestUtil.bcrypt(sha256Hex);
        return bcrypt;
    }

    public boolean check(String password, String hashed) {
        return DigestUtil.bcryptCheck( DigestUtil.sha256Hex(password),hashed);
    }

}
