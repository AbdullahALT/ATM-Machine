package storage;


import storage.Cryptography.Crypto;
import storage.parsers.Parser;
import storage.sources.DataSource;

/**
 * This class dose not know from where the data are coming, how are they parsed, and how the are encrypted. it just call the responsible objects
 * in the order needed and help making interaction between them.
 *
 * Simply put, it helps encapsulating the way the application interact with shortages
 * @param <SourceType>
 * @param <Result>
 */
public class Storage<SourceType, Result> {

    private DataSource<SourceType> source;
    private Parser<SourceType, Result> parser;
    private Crypto<SourceType> crypto;

    public Storage(DataSource<SourceType> source, Parser<SourceType, Result> parser, Crypto<SourceType> crypto){
        this.source = source;
        this.parser = parser;
        this.crypto = crypto;
    }

    public Storage(DataSource<SourceType> source, Parser<SourceType, Result> parser){
        this.source = source;
        this.parser = parser;

        //Using Nullable Object Pattern
        this.crypto = new Crypto<SourceType>() {
            @Override
            public SourceType encrypt(SourceType data) {
                return data;
            }

            @Override
            public SourceType decrypt(SourceType data) {
                return data;
            }
        };
    }

    public Result read(){

        //Load from a storage storage
        SourceType data = source.importData();

        //Decrypt the storage taken from the storage
        SourceType decryptedData = crypto.decrypt(data);

        //Transform the storage to something we can manipulate
        Result result = parser.parseData(decryptedData);

        return result;

    }

    public void write(Result result){

        //Unparse the result, return it to the form that the storage is familiar with
        SourceType data = parser.unparseData(result);

        //Encrypt the storage
        SourceType encryptedData = crypto.encrypt(data);

        //Export the storage back to the storage
        source.exportData(encryptedData);

    }

}
