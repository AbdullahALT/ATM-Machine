package data.sources;

public interface DataSource<SourceTye> {

    SourceTye importData();
    void exportData(SourceTye data);

}
