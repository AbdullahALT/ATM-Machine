package controllers.manager;

import model.Response;

import java.util.List;

public class SearchDecorator<DataModel> implements Manager<DataModel> {

    private Manager<DataModel> manager;
    private Comparator<DataModel> comparator;

    public SearchDecorator(Manager<DataModel> manager, Comparator<DataModel> comparator) {
        this.manager = manager;
        this.comparator = comparator;
    }

    public SearchDecorator(Manager<DataModel> manager) {
        this.manager = manager;
    }

    @Override
    public Response remove(DataModel dataModel) {
        return manager.remove(dataModel);
    }

    @Override
    public Response insert(DataModel dataModel) {
        return manager.insert(dataModel);
    }

    @Override
    public Response update(DataModel updated) {
        return manager.update(updated);
    }

    @Override
    public DataModel get(Comparator<DataModel> Comparator) {
        return manager.get(Comparator);
    }

    @Override
    public Manager<DataModel> getAll(Comparator<DataModel> Comparator) {
        if(this.comparator == null)
            return manager.getAll(Comparator);
        return manager.getAll(this.comparator).getAll(Comparator);
    }

    public Manager<DataModel> getAll(){
        return manager.getAll(this.comparator);
    }

    @Override
    public void print() {
        manager.print();
    }

    @Override
    public List<DataModel> getList() {
        return manager.getList();
    }

    public static class Builder<Model> {

        SearchDecorator<Model> manager;

        public Builder(Manager<Model> manager){
            this.manager = new SearchDecorator<>(manager, model -> true);
        }

        public void addQuery(Comparator<Model> query){
            this.manager = new SearchDecorator<>(this.manager, query);
        }

        public Manager<Model> build(){
            return this.manager.getAll();
        }
    }
}
