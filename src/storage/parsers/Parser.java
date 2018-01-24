package storage.parsers;

/**
 * Parsing SourceType to Result, where SourceType is not recognized or unmanageable and Result is class model that helps interacting with it.
 * In the context of the ATM machine the SourceType is a String and the unmanageable data is of the form id;name;etc.
 * but it could be anything like a Json or XML
 * @param <SourceType>: The type of the unmanageable data
 * @param <Result>: The type of the class model
 */
public interface Parser<SourceType, Result> {
    
    Result parseData(SourceType data);
    SourceType unparseData(Result data);
    
}
