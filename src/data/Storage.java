package data;


import data.Cryptography.Crypto;
import data.parsers.Parser;
import data.sources.DataSource;

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

        //Load from a data source
        SourceType data = source.importData();

        //Decrypt the data taken from the source
        SourceType decryptedData = crypto.decrypt(data);

        //Transform the data to something we can manipulate
        Result result = parser.parseData(decryptedData);

        return result;

    }

    public void write(Result result){

        //Unparse the result, return it to the form that the source is familiar with
        SourceType data = parser.unparseData(result);

        //Encrypt the data
        SourceType encryptedData = crypto.encrypt(data);

        //Export the data back to the source
        source.exportData(encryptedData);

    }

}
