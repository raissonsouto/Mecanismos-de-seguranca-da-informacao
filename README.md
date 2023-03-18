# Mecanismos de Segurança da Informação

Esse material foi produzido durante a monitoria da disciplina de sistemas distribuídos (2022.1) e busca ensinar sobre conceitos básicos de segurança como criptografia e hashing.

## 1. Introdução
### Termos Chave

O NIST (National Institute of Standards and Technology) é uma agência do governo dos Estados Unidos responsável por desenvolver e promover padrões para diversas áreas, incluindo criptografia.

Confidencialidade
Integridade
Disponibilidade

Privacidade vs Anonimato

- [Vídeo sobre introudção a conceitos de segurança da informação](https://www.youtube.com/watch?v=KBXA3CqaVeI)

## 2. Criptografia Simétrica

### Termos Chave

**Criptografia simétrica** é um método de criptografia que usa a mesma chave para criptografar e descriptografar dados. Isso significa que a chave compartilhada deve ser mantida em segredo para garantir a segurança dos dados.

**Cifra de fluxo** é um tipo de criptografia que opera em bits individuais em uma sequência de dados, enquanto a **cifra de bloco** criptografa blocos fixos de dados. A cifra de fluxo funciona gerando uma corrente de bits pseudoaleatórios (chave de fluxo) que é combinada com os dados originais para criptografar e descriptografar. A cifra de bloco opera em blocos fixos de dados e geralmente requer ```padding``` para preencher o último bloco, que pode não estar cheio.

**Modos de operação** são métodos que especificam como a cifra de bloco deve ser usada para criptografar dados maiores que um bloco. Existem vários modos de operação, incluindo ECB (Electronic Codebook), CBC (Cipher Block Chaining), CTR (Counter), GCM (Galois/Counter Mode), etc. Cada modo tem seus prós e contras em termos de segurança, eficiência e facilidade de implementação.

**Padding** é o processo de preencher os dados para atender ao tamanho necessário do bloco da cifra de bloco. Quando os dados não são um múltiplo inteiro do tamanho do bloco (por exemplo um algoritmo com bloco de 8 bits e o dado tem 14 bits), o último bloco pode ser menor que o tamanho do bloco (no exemplo passado o ultimo bloco ficaria com 6 bits, falando 2 para poder fechar o bloco). Isso pode ser resolvido adicionando bits extras, geralmente zeros, ao final dos dados para preencher o último bloco. O padding também pode ser usado para preencher dados com um determinado padrão antes da cifração, como no caso do padding PKCS#7.

### Recomendações de uso

O NIST recomenda para o uso de criptografia simétrica o algoritmo [AES (Advanced Encryption Standard)](). O AES é um algoritmo de criptografia simétrica amplamente utilizado, que oferece segurança forte e desempenho eficiente. O mesmo também indica o uso de chaves de pelo menos 128 bits para AES, embora chaves de 192 e 256 bits também possam ser utilizadas. Além disso, o NIST também fornece orientações sobre os modos de operação da cifra de bloco, sendo tanto o modo Cipher Block Chaining (CBC) quanto o modo Counter (CTR).

A escolha entre o modo CBC e o modo CTR depende da aplicação específica e dos requisitos de segurança. O CBC pode ser preferido quando a segurança contra ataques de bit-flipping é uma prioridade, enquanto o modo CTR pode ser preferido quando o paralelismo e o desempenho são considerações importantes. É importante considerar cuidadosamente as necessidades específicas de segurança e desempenho do sistema ao escolher um modo de operação para cifras de bloco.

### Links úteis

Vídeos<br />

- [Video sobre criptografia simétrica - Raisson Souto](https://www.youtube.com/watch?v=Ba0tfsuTgoY)
- [AES Explained (Advanced Encryption Standard) - Computerphile](https://www.youtube.com/watch?v=O4xNJsjtN6E)

Atividade práticas

- [Colab sobre Criptografia Simétrica](https://github.com/raissonsouto/Mecanismos-de-seguranca-da-informacao/blob/main/colabs/Criptografia_sim%C3%A9trica_com_Python.ipynb)

## 3. Hashing

### Termos Chave

**Hashing** é o processo de converter dados de tamanho arbitrário em uma sequência de bytes de tamanho fixo, geralmente com um comprimento fixo de 128, 256 ou 512 bits, usando uma função de hash. A função de hash transforma os dados originais em uma sequência de caracteres alfanuméricos (conhecido como hash) que é única para aquele conjunto de dados.

**Salted hashes** referem-se ao uso de uma string aleatória (salt) que é adicionada ao dado original antes de serem hashados. Isso aumenta a segurança da função de hash, pois torna mais difícil para um invasor usar tabelas de busca pré-computadas ([rainbow tables]()) para descobrir senhas ou dados originais a partir do hash.

**Password hashing** é uma técnica específica de hashing usada para armazenar senhas de forma segura. Como senhas são um dos dados mais valiosos e atacados por hackers, password hashing é uma técnica essencial para proteger a privacidade dos usuários. Password hashing geralmente inclui salting e uma função de hash de chave lenta, que requer um grande número de iterações para produzir um hash.

**Message Authentication Codes (MACs)** são valores curtos usados para verificar a autenticidade e integridade de uma mensagem. Eles são frequentemente usados em sistemas de comunicação seguros para garantir que uma mensagem não foi modificada ou falsificada durante a transmissão. A função de hash é usada para gerar um MAC, que é anexado à mensagem original. O destinatário pode verificar a autenticidade da mensagem recalculando o MAC usando a mesma função de hash e verificando se ele coincide com o valor enviado junto com a mensagem.

- [Vídeo sobre hashing](https://www.youtube.com/watch?v=nH2fQVVdUK8)
- [Colab sobre Hashing](https://github.com/raissonsouto/Mecanismos-de-seguranca-da-informacao/blob/main/colabs/Hashing_com_Python.ipynb)
- [Colab sobre Password Hashing](https://github.com/raissonsouto/Mecanismos-de-seguranca-da-informacao/blob/main/colabs/Salted_hashes_com_Python.ipynb)

### Recomendações de uso

O NIST recomenda o uso de SHA-256

### Links úteis

Vídeos em inglês sobre o tema<br />

- [Hashing Algorithms and Security - Computerphile](https://www.youtube.com/watch?v=b4b8ktEV4Bg)
- [SHA: Secure Hashing Algorithm - Computerphile](https://www.youtube.com/watch?v=DMtFhACPnTY)
- [How NOT to Store Passwords! - Computerphile](https://www.youtube.com/watch?v=8ZtInClXe1Q)
- [Securing Stream Ciphers (HMAC) - Computerphile](https://www.youtube.com/watch?v=wlSG3pEiQdc)

Outros<br />

- [Simulador de funções hash](https://emn178.github.io/online-tools/sha256.html)

## 4. Criptografia Assimétrica
- [Vídeo sobre criptografia simétrica](https://www.youtube.com/watch?v=MdqYbgdxHCQ)
- [Colab sobre criptografia assimétrica](https://github.com/raissonsouto/Mecanismos-de-seguranca-da-informacao/blob/main/colabs/Criptografia_assim%C3%A9trica_com_Python.ipynb)<br />

### Links úteis
Vídeos em inglês sobre o tema<br />

- [Public Key Cryptography - Computerphile](https://www.youtube.com/watch?v=GSIDS_lvRv4)

## 5. Assinaturas/Certificados Digitais
[Colab sobre assinaturas digitais](https://github.com/raissonsouto/Mecanismos-de-seguranca-da-informacao/blob/main/colabs/Assinaturas_digitais_com_Python.ipynb)<br />

### Links úteis
Vídeos em inglês sobre o tema<br />

- [What are Digital Signatures? - Computerphile](https://www.youtube.com/watch?v=s22eJ1eVLTU)
- [Prime Numbers & RSA Encryption Algorithm - Computerphile](https://www.youtube.com/watch?v=JD72Ry60eP4)
