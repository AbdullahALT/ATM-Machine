package storage.Cryptography;

public interface Crypto<SourceType> {
    SourceType encrypt(SourceType data);
    SourceType decrypt(SourceType data);
}
