package storage.Cryptography;

/**
 * Classes implementing this interface decrypts and encrypts data in the way they see fit,
 * in the ATM Machine context this is SwapCrypt, but it could be anything advanced like SHA512
 * @param <SourceType>: The type of data to be encrypted
 */
public interface Crypto<SourceType> {
    SourceType encrypt(SourceType data);
    SourceType decrypt(SourceType data);
}
