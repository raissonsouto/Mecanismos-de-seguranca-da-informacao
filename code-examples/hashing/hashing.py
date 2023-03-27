import hashlib

string_to_hash = "Mensagem que vai ser sumarizada"

hash_object = hashlib.sha256()  # criando objeto que vai realizar o hash da mensagem (em SHA-256)
hash_object.update(string_to_hash.encode())  # Hashing

hex_hash = hash_object.hexdigest()  # resgatando o valor do hash em hexadecimal

print(f"O hash de '{string_to_hash}' em hexadecimal utilizando SHA-256 é: {hex_hash}")