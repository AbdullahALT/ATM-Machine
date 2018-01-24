package storage.sources;

/**
 * This interface help as importing and exporting data a data source, in the context
 * of ATM machine this data source is a file, but it could be anything like a database
 * @param <SourceTye>
 */
public interface DataSource<SourceTye> {

    SourceTye importData();
    void exportData(SourceTye data);

}
