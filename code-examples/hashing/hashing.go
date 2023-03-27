package main

import (
    "crypto/sha256"
    "encoding/hex"
    "fmt"
)

func main() {
    stringToHash := "Mensagem que vai ser sumarizada"

    hashObject := sha256.New()             // criando objeto que vai realizar o hash da mensagem (em SHA-256)
    hashObject.Write([]byte(stringToHash)) // Hashing

    hexHash := hex.EncodeToString(hashObject.Sum(nil)) // resgatando o valor do hash em hexadecimal

    fmt.Printf("O hash de '%s' em hexadecimal utilizando SHA-256 é: %s\n", stringToHash, hexHash)
}