package com.xudean;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.xudean.bcrypt.BcryptHandler;
import com.xudean.encrypt.EncryptHandler;
import org.apache.commons.cli.*;

/**
 * @author : xudean
 * @version V1.0
 * @Description: 实现功能为主，不考虑代码规范
 * @date Date : 2022年08月04日 下午5:12
 */
public class Application {
    public static void main(String[] args) throws ParseException {
        EncryptHandler encryptHandler = new EncryptHandler();
        BcryptHandler bcryptHandler = new BcryptHandler();
        //定义阶段
        Options options = new Options();
        options.addOption("h", false, "usage help");
        options.addOption("e", false, "encrypt database password");
        options.addOption("d", false, "decrypt database password");
        options.addOption("b", false, "bcrypt user password");
        Option opt_R = Option
                .builder("ck")
                .desc("check password and bcrypted text . like '-ck password,bcrypted_text'")
                .build();
        options.addOption(opt_R);
        //解析阶段
        CommandLineParser paraer = new BasicParser();
        CommandLine cmdLine = paraer.parse(options, args);
        if(cmdLine.getArgList().size()>1){
            System.out.println("Don't support operation because length of args > 1");
            System.exit(0);
        }
        if(cmdLine.hasOption("e")&& CollectionUtil.isNotEmpty(cmdLine.getArgList())){
            System.out.println(encryptHandler.encrypt(cmdLine.getArgList().get(0)));
            System.exit(0);
        }
        if(cmdLine.hasOption("d")&& CollectionUtil.isNotEmpty(cmdLine.getArgList())){
            System.out.println(encryptHandler.decrypt(cmdLine.getArgList().get(0)));
            System.exit(0);
        }
        if(cmdLine.hasOption("b")&& CollectionUtil.isNotEmpty(cmdLine.getArgList())){
            System.out.println(bcryptHandler.hash(cmdLine.getArgList().get(0)));
            System.exit(0);
        }
        if(cmdLine.hasOption("ck")&& CollectionUtil.isNotEmpty(cmdLine.getArgList())){
            System.out.println(cmdLine.getArgList());
            String[] cks = cmdLine.getArgs()[0].split(",");
            System.out.println(bcryptHandler.check(cks[0],cks[1]));
            System.exit(0);
        }
        //询问阶段
        if (cmdLine.hasOption("help") || cmdLine.hasOption("h")) {
            /*usage(); //这里作者自定义了帮助信息，其实可以使用helpFormat直接输出的*/
            HelpFormatter hf = new HelpFormatter();
            hf.setWidth(110);
            hf.printHelp("java -jar encrypt-sdk.jar", options, true);
        }

    }
}
