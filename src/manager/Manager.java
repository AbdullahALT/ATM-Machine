package manager;

import model.Response;

import java.util.List;

/**
 * Manages a list of <Model>. In the context of ATM Machine, we can easily manage changes on the
 * files without writing and reading each time, it will simply simulate the files. In other words, it helps
 * making changes on the RAM, not in the permanent storage.
 * @param <Model>: The type of data to be managed
 */
public interface Manager<Model> {

    Response remove(Model model);
    Response insert(Model model);
    Response update(Model updated);
    Model get(Comparator<Model> Comparator);
    Manager<Model> getAll(Comparator<Model> Comparator);
    List<Model> getList();
    void print();
}
