package storage.sources;

public interface DataSource<SourceTye> {

    SourceTye importData();
    void exportData(SourceTye data);

}
