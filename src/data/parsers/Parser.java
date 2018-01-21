package data.parsers;

public interface Parser<SourceType, Result> {
    
    Result parseData(SourceType data);
    SourceType unparseData(Result data);
    
}
