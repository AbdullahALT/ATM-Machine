package controllers.manager;

import java.util.List;

public interface Manager<Model> {
    Response remove(Model model);
    Response insert(Model model);
    Response update(Model updated);
    Model get(Comparator<Model> Comparator);
    Manager<Model> getAll(Comparator<Model> Comparator);
    List<Model> getList();
    void print();
}
