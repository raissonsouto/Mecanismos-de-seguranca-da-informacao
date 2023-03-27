import secrets
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend

# Gerar uma chave e um nonce aleatórios usando a biblioteca secrets
key = secrets.token_bytes(16)
nonce = secrets.token_bytes(16)

# Inicializar o objeto Cipher com a chave e nonce
cipher = Cipher(algorithms.AES(key), modes.CTR(nonce), backend=default_backend())

# Criar um objeto encryptor
encryptor = cipher.encryptor()

# Criptografar um texto simples
texto_simples = b'Este é o meu segredo.'
texto_cifrado = encryptor.update(texto_simples) + encryptor.finalize()

# Criar um objeto decryptor
decryptor = cipher.decryptor()

# Descriptografar o texto cifrado
texto_descriptografado = decryptor.update(texto_cifrado) + decryptor.finalize()

# Imprimir os resultados
print(f"Texto simples: {texto_simples}")
print(f"Texto cifrado: {texto_cifrado}")
print(f"Texto descriptografado: {texto_descriptografado}")