###  加密工具使用说明

```
java -jar encrypt-sdk.jar -h          
usage: java -jar encrypt-sdk.jar [-b] [-ck] [-d] [-e] [-h]
 -b    bcrypt user password
 -ck   check password and bcrypted text . like '-ck password,bcrypted_text'
 -d    decrypt database password
 -e    encrypt database password
 -h    usage help
```

- 数据库密码加密

```
java -jar encrypt-sdk.jar -e 'root123'
```

- 数据库密码解密

```
java -jar encrypt-sdk.jar -d 'u/fG65k72dt3NcLSAFUXRQ=='
```

- bcrypt加密用户密码

```
java -jar encrypt-sdk.jar -b 'testpass'
```

- 验证明文密码与密文密码是否匹配

```
java -jar encrypt-sdk.jar -ck 'testpass,$2a$10$/4iqfRtE9Bz8C57w6lM1D.gpzgGcaRh9lbuNahcA0PG6Di2zNsf1.'
```

> 验证密码时密码明文和密文需要使用`，`隔开