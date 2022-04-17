# SPRING 101

# JASYPT

Comando para criptografar dados no application.properties

```bash
java -cp ~/.m2/repository/org/jasypt/jasypt/1.9.3/jasypt-1.9.3.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input="conteudo-para-criptografar" password=123456 algorithm=PBEWITHMD5ANDDES
```

Funcão ENC() com chave criptografada como valor da propriedade

```text
app.api.climatempo.token=ENC(CHAVE-CRIPTOGRAFADA-MUITO-SEGURA)
```

# Apis

- IP Api - https://ip-api.com/
- Clima Tempo - https://advisor.climatempo.com.br/
