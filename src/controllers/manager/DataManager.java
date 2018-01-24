package controllers.manager;

import model.Response;

import java.util.LinkedList;
import java.util.List;

/**
 * Implement some common functionalities that every Manager should have.
 * @param <DataModel>: The type of the data to be managed
 */
public abstract class DataManager<DataModel> implements Manager<DataModel>{

    private List<DataModel> list;

    DataManager(List<DataModel> list){
        this.list = list;
    }

    public Response remove(DataModel data){
        list.remove(data);
        return new Response(true, "");
    }

    public Response insert(DataModel data){
        list.add(data);
        return new Response(true, "");
    }

    public DataModel get(Comparator<DataModel> comparator){
        for(DataModel model : getList()){
            if(comparator.compareTo(model))
                return model;
        }
        return null;
    }

    public Manager<DataModel> getAll(Comparator<DataModel> Comparator) {
        List<DataModel> list = new LinkedList<>();

        for(DataModel data : getList()){
            if(Comparator.compareTo(data))
                list.add(data);
        }

        return hold(list);
    }

    public abstract Manager<DataModel> hold(List<DataModel> list);

    public abstract void print();

    public List<DataModel> getList(){
        return list;
    }

}
