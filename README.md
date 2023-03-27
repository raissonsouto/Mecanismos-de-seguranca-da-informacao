# Mecanismos de Segurança da Informação

Esse material foi inicialmente produzido durante a monitoria da disciplina de sistemas distribuídos (2022.1) e busca ensinar sobre conceitos básicos de segurança como criptografia e hashing.

## 1. Introdução

### Termos Chave

O NIST (National Institute of Standards and Technology) é uma agência do governo dos Estados Unidos responsável por desenvolver e promover padrões para diversas áreas, incluindo a segurança da informação. Suas recomendações são amplamente adotadas no mercado e por isso vão ser utilizadas como referência.

```Confidencialidade``` é a proteção de informações confidenciais ou sensíveis de pessoas ou organizações, impedindo que sejam acessadas ou divulgadas por indivíduos não autorizados.

```Integridade``` é a proteção de informações para garantir que elas não sejam alteradas, danificadas ou destruídas por indivíduos não autorizados.

```Disponibilidade``` refere-se à capacidade de garantir que as informações estejam acessíveis e utilizáveis quando necessárias. Isso envolve a garantia de que sistemas e serviços estejam disponíveis e operacionais para atender às necessidades dos usuários.

```Privacidade vs Anonimato:``` Privacidade refere-se ao direito de uma pessoa controlar o acesso e o uso de informações pessoais que pertencem a ela. Por outro lado, anonimato é a capacidade de se manter oculto ou desconhecido, sem ter que revelar sua identidade. Enquanto a privacidade se concentra no controle sobre o uso de informações pessoais, o anonimato se concentra em permanecer desconhecido.

```Security Strength``` é a medida de quão difícil é para um adversário mal-intencionado quebrar a segurança de um sistema criptográfico. Ela depende de diversos fatores, como o algoritmo criptográfico utilizado, o tamanho da chave criptográfica, o tamanho e complexidade da entrada e a resistência do sistema a diferentes tipos de ataques. Geralmente, é medida em bits e é um fator crítico na escolha e avaliação de algoritmos criptográficos e sistemas de segurança.

```Números aleatórios``` são cruciais para manter a segurança da informação em muitos sistemas criptográficos e protocolos de segurança. Números aleatórios são usados para gerar chaves criptográficas, proteger contra ataques de replay e fornecer variedade para algoritmos de criptografia. No entanto, a geração de números verdadeiramente aleatórios é difícil em sistemas computacionais, sendo necessário utilizar geradores de números pseudoaleatórios. É importante garantir a qualidade dos números aleatórios gerados para evitar vulnerabilidades e explorações maliciosas.

### Links úteis

- [Vídeo sobre introudção a conceitos de segurança da informação](https://www.youtube.com/watch?v=KBXA3CqaVeI)

## 2. Criptografia Simétrica

### Termos Chave

```Criptografia simétrica``` é um método de criptografia que usa a mesma chave para criptografar e descriptografar dados. Isso significa que a chave compartilhada deve ser mantida em segredo para garantir a segurança dos dados.

```Cifra de fluxo``` é um tipo de criptografia que opera em bits individuais em uma sequência de dados, enquanto a ```cifra de bloco``` criptografa blocos fixos de dados. A cifra de fluxo funciona gerando uma corrente de bits pseudoaleatórios (chave de fluxo) que é combinada com os dados originais para criptografar e descriptografar. A cifra de bloco opera em blocos fixos de dados e geralmente requer _padding_ para preencher o último bloco, que pode não estar cheio.

```Modos de operação``` são métodos que especificam como a cifra de bloco deve ser usada para criptografar dados maiores que um bloco. Existem vários modos de operação, incluindo ECB (Electronic Codebook), CBC (Cipher Block Chaining), CTR (Counter), GCM (Galois/Counter Mode), etc. Cada modo tem seus prós e contras em termos de segurança, eficiência e facilidade de implementação.

```Padding``` é o processo de preencher os dados para atender ao tamanho necessário do bloco da cifra de bloco. Quando os dados não são um múltiplo inteiro do tamanho do bloco (por exemplo um algoritmo com bloco de 8 bits e o dado tem 14 bits), o último bloco pode ser menor que o tamanho do bloco (no exemplo passado o ultimo bloco ficaria com 6 bits, falando 2 para poder fechar o bloco). Isso pode ser resolvido adicionando bits extras, geralmente zeros, ao final dos dados para preencher o último bloco. O padding também pode ser usado para preencher dados com um determinado padrão antes da cifração, como no caso do padding PKCS#7.

### Recomendações de uso

O NIST recomenda para o uso de criptografia simétrica o algoritmo [AES (Advanced Encryption Standard)](). O AES é um algoritmo de criptografia simétrica amplamente utilizado, que oferece segurança forte e desempenho eficiente. O mesmo também indica o uso de chaves de pelo menos 128 bits para AES, embora chaves de 192 e 256 bits também possam ser utilizadas. Além disso, o NIST também fornece orientações sobre os modos de operação da cifra de bloco, sendo tanto o modo Cipher Block Chaining (CBC) quanto o modo Counter (CTR).

A escolha entre o modo CBC e o modo CTR depende da aplicação específica e dos requisitos de segurança. O CBC pode ser preferido quando a segurança contra ataques de bit-flipping é uma prioridade, enquanto o modo CTR pode ser preferido quando o paralelismo e o desempenho são considerações importantes. É importante considerar cuidadosamente as necessidades específicas de segurança e desempenho do sistema ao escolher um modo de operação para cifras de bloco.

### Links úteis

Vídeos<br />

- [Video sobre criptografia simétrica - Raisson Souto](https://www.youtube.com/watch?v=Ba0tfsuTgoY) :brazil:
- [AES Explained (Advanced Encryption Standard) - Computerphile](https://www.youtube.com/watch?v=O4xNJsjtN6E) :uk:

Atividade práticas

- [Colab sobre Criptografia Simétrica](https://github.com/raissonsouto/Mecanismos-de-seguranca-da-informacao/blob/main/colabs/Criptografia_sim%C3%A9trica_com_Python.ipynb)

## 3. Hashing

### Termos Chave

```Hashing``` é o processo de converter dados de tamanho arbitrário em uma sequência de bytes de tamanho fixo, geralmente com um comprimento fixo de 128, 256 ou 512 bits, usando uma função de hash. A função de hash transforma os dados originais em uma sequência de caracteres alfanuméricos (conhecido como hash) que é única para aquele conjunto de dados.

```Salted hashes``` referem-se ao uso de uma string aleatória (salt) que é adicionada ao dado original antes de serem hashados. Isso aumenta a segurança da função de hash, pois torna mais difícil para um invasor usar tabelas de busca pré-computadas ([rainbow tables]()) para descobrir senhas ou dados originais a partir do hash.

```Password hashing``` é uma técnica específica de hashing usada para armazenar senhas de forma segura. Como senhas são um dos dados mais valiosos e atacados por hackers, password hashing é uma técnica essencial para proteger a privacidade dos usuários. Password hashing geralmente inclui salting e uma função de hash de chave lenta, que requer um grande número de iterações para produzir um hash.

```Message Authentication Codes (MACs)``` são valores curtos usados para verificar a autenticidade e integridade de uma mensagem. Eles são frequentemente usados em sistemas de comunicação seguros para garantir que uma mensagem não foi modificada ou falsificada durante a transmissão. A função de hash é usada para gerar um MAC, que é anexado à mensagem original. O destinatário pode verificar a autenticidade da mensagem recalculando o MAC usando a mesma função de hash e verificando se ele coincide com o valor enviado junto com a mensagem.

### Recomendações de uso

O NIST recomenda o uso de algoritmos de hashing criptográficos fortes, como SHA-256, SHA-384 ou SHA-512. Esses algoritmos produzem valores de hash de tamanho fixo e são projetados para serem resistentes a colisões e a ataques de preenchimento.

O NIST também recomenda o uso de funções de hash criptográficas projetadas especificamente para senhas, como PBKDF2, bcrypt, scrypt ou argon2. Esses algoritmos são projetados para serem deliberadamente lentos e consumir muitos recursos computacionais, o que dificulta o trabalho de um atacante que tenta adivinhar senhas usando força bruta.

Por fim, o NIST recomenda o uso de algoritmos de autenticação de mensagem (MACs) baseados em criptografia de bloco, como AES-CMAC, ou em funções de hash criptográficas, como HMAC-SHA256. Esses algoritmos são usados para garantir a integridade e autenticidade de mensagens em ambientes de comunicação seguros.

### Links úteis

Vídeos
- [Vídeo sobre hashing - Raisson Souto](https://www.youtube.com/watch?v=nH2fQVVdUK8) :brazil:
- [Hashing Algorithms and Security - Computerphile](https://www.youtube.com/watch?v=b4b8ktEV4Bg) :uk:
- [SHA: Secure Hashing Algorithm - Computerphile](https://www.youtube.com/watch?v=DMtFhACPnTY) :uk:
- [How NOT to Store Passwords! - Computerphile](https://www.youtube.com/watch?v=8ZtInClXe1Q) :uk:
- [Securing Stream Ciphers (HMAC) - Computerphile](https://www.youtube.com/watch?v=wlSG3pEiQdc) :uk:

Outros<br />

- [Simulador de funções hash](https://emn178.github.io/online-tools/sha256.html)
- [Colab sobre Hashing](https://github.com/raissonsouto/Mecanismos-de-seguranca-da-informacao/blob/main/colabs/Hashing_com_Python.ipynb)
- [Colab sobre Password Hashing](https://github.com/raissonsouto/Mecanismos-de-seguranca-da-informacao/blob/main/colabs/Salted_hashes_com_Python.ipynb)

## 4. Criptografia Assimétrica

### Termos chave

Chave pública: uma chave de criptografia que é distribuída publicamente e pode ser usada para criptografar mensagens que só podem ser decodificadas com a chave privada correspondente.

Chave privada: uma chave de criptografia que é mantida em segredo e pode ser usada para decodificar mensagens criptografadas com a chave pública correspondente.
Criptografia de chave pública: um método de criptografia que usa um par de chaves, uma pública e uma privada, para criptografar e decodificar mensagens.

Algoritmo de criptografia assimétrica: um conjunto de regras e procedimentos matemáticos que são usados para criptografar e decodificar mensagens usando chaves públicas e privadas.

### Links úteis

Vídeos

- [Vídeo sobre criptografia assimétrica - Raisson Souto](https://www.youtube.com/watch?v=MdqYbgdxHCQ) :brazil:
- [Public Key Cryptography - Computerphile](https://www.youtube.com/watch?v=GSIDS_lvRv4) :uk:

Outros

- [Colab sobre criptografia assimétrica](https://github.com/raissonsouto/Mecanismos-de-seguranca-da-informacao/blob/main/colabs/Criptografia_assim%C3%A9trica_com_Python.ipynb)<br />

## 5. Assinaturas/Certificados Digitais

### Termos chave

Assinatura digital: um código criptografado que é adicionado a uma mensagem para verificar a identidade do remetente e garantir a integridade da mensagem.

Certificado digital: um arquivo digital que contém informações sobre a identidade de um indivíduo ou organização, incluindo a chave pública correspondente, que é usado para verificar a identidade e autenticidade de um remetente.

Autoridade Certificadora (CA): uma organização ou entidade confiável que emite certificados digitais e garante a identidade e autenticidade dos usuários.

Infraestrutura de chave pública (PKI): um sistema de tecnologia e políticas que são usados para gerenciar a segurança de comunicações eletrônicas, incluindo a emissão e verificação de certificados digitais.



### Links úteis

- [Tutorial básico de OpenSSL]()
- [Colab sobre assinaturas digitais](https://github.com/raissonsouto/Mecanismos-de-seguranca-da-informacao/blob/main/colabs/Assinaturas_digitais_com_Python.ipynb)

Vídeos

- [Vídeo sobre assinaturas digitais](https://www.youtube.com/watch?v=Zg9Y-zeh7So)
- [Vídeo sobre certificados digitais](https://www.youtube.com/watch?v=U17Wi4dlTCM)
- [What are Digital Signatures? - Computerphile](https://www.youtube.com/watch?v=s22eJ1eVLTU) :uk:
- [Prime Numbers & RSA Encryption Algorithm - Computerphile](https://www.youtube.com/watch?v=JD72Ry60eP4) :uk:
