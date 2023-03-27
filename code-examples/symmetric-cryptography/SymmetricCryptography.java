import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class SymmetricCryptography {

    public static void main(String[] args) throws Exception {
        // Gerar uma chave e um nonce aleatórios usando a classe SecureRandom
        SecureRandom random = new SecureRandom();
        byte[] keyBytes = new byte[16];
        random.nextBytes(keyBytes);
        SecretKey key = new SecretKeySpec(keyBytes, "AES");
        byte[] nonce = new byte[16];
        random.nextBytes(nonce);

        // Inicializar o objeto Cipher com a chave e nonce
        Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(nonce));

        // Criptografar um texto simples
        byte[] textoSimples = "Este é o meu segredo.".getBytes("UTF-8");
        byte[] textoCifrado = cipher.doFinal(textoSimples);

        // Criar um objeto decryptor
        cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(nonce));

        // Descriptografar o texto cifrado
        byte[] textoDescriptografado = cipher.doFinal(textoCifrado);

        // Imprimir os resultados
        System.out.println("Texto simples: " + new String(textoSimples, "UTF-8"));
        System.out.println("Texto cifrado: " + new String(textoCifrado, "UTF-8"));
        System.out.println("Texto descriptografado: " + new String(textoDescriptografado, "UTF-8"));
    }
}