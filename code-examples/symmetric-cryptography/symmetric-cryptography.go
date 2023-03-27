package main
// @todo edit example and translate it to portuguese
import (
    "crypto/aes"
    "crypto/cipher"
    "crypto/rand"
    "fmt"
)

func main() {
    plaintext := []byte("hello, world!") // message to be encrypted

    // Generate a new random key
    key := make([]byte, 32)
    if _, err := rand.Read(key); err != nil {
        panic(err)
    }

    // Create a new AES cipher block using the random key
    block, err := aes.NewCipher(key)
    if err != nil {
        panic(err)
    }

    // Generate a new initialization vector (IV)
    iv := make([]byte, aes.BlockSize)
    if _, err := rand.Read(iv); err != nil {
        panic(err)
    }

    // Create a new cipher block mode of operation using the AES cipher in CTR mode
    mode := cipher.NewCTR(block, iv)

    // Encrypt the plaintext using the cipher
    ciphertext := make([]byte, len(plaintext))
    mode.XORKeyStream(ciphertext, plaintext)

    // Print the ciphertext and IV
    fmt.Printf("Ciphertext: %x\n", ciphertext)
    fmt.Printf("IV: %x\n", iv)

    // Create a new cipher block mode of operation for decryption
    decrypter := cipher.NewCTR(block, iv)

    // Decrypt the ciphertext using the cipher
    decrypted := make([]byte, len(ciphertext))
    decrypter.XORKeyStream(decrypted, ciphertext)

    // Print the decrypted plaintext
    fmt.Printf("Decrypted plaintext: %s\n", decrypted)
}
