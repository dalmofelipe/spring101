# SPRING 101

# JASYPT

### Encriptar

```bash
# LINUX
java -cp ~/.m2/repository/org/jasypt/jasypt/1.9.3/jasypt-1.9.3.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="conteudo-para-criptografar" password=123456 algorithm=PBEWITHMD5ANDDES

# WINDOWS
java -cp C:\Users\Dalmo\.m2\repository\org\jasypt\jasypt\1.9.3\jasypt-1.9.3.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="conteudo-para-criptografar" password=123456 algorithm=PBEWITHMD5ANDDES

```

O comando acima vai gerar a hash => Pisrq7/YKoNZXGUPrFgRY1dcrK29mR14a7CFUADxrsquO8D9pyFmmA==


### Decriptar

```bash
# LINUX
java -cp ~/.m2/repository/org/jasypt/jasypt/1.9.3/jasypt-1.9.3.jar org.jasypt.intf.cli.JasyptPBEStringDecryptionCLI input="Pisrq7/YKoNZXGUPrFgRY1dcrK29mR14a7CFUADxrsquO8D9pyFmmA==" password=123456 algorithm=PBEWITHMD5ANDDES

# WINDOWS
java -cp C:\Users\Dalmo\.m2\repository\org\jasypt\jasypt\1.9.3\jasypt-1.9.3.jar org.jasypt.intf.cli.JasyptPBEStringDecryptionCLI input="Pisrq7/YKoNZXGUPrFgRY1dcrK29mR14a7CFUADxrsquO8D9pyFmmA==" password=123456 algorithm=PBEWITHMD5ANDDES
```


Funcão ENC() com chave criptografada como valor da propriedade no arquivo application.properties

```text
app.api.climatempo.token=ENC(CHAVE-CRIPTOGRAFADA-MUITO-SEGURA)
```


###  Add Senha para Jasypt VMOptions 

```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <jvmArguments>
            -Djasypt.encryptor.password=xxxxxx
        </jvmArguments>
    </configuration>
</plugin>
```

informar em VM Options ```-Djasypt.encryptor.password=xxxxxx```


# Apis

- IP Api - https://ip-api.com/
- Clima Tempo - https://advisor.climatempo.com.br/
