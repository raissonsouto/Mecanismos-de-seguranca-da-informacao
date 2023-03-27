import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {
    public static void main(String[] args) {
        String textoPlano = "olá mundo";

        try {
            // Cria um objeto MessageDigest para hash SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Calcula o valor de hash do texto plano
            byte[] hashBytes = md.digest(textoPlano.getBytes());

            // Converte os bytes de hash para uma string hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            String hashHex = sb.toString();

            // Imprime o valor de hash
            System.out.println("O valor de hash SHA-256 de \"" + textoPlano + "\" é:");
            System.out.println(hashHex);
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Erro: algoritmo SHA-256 não encontrado.");
            e.printStackTrace();
        }
    }
}
