package controllers.manager;

import controllers.CurrentUser;
import model.Response;
import model.UserModel;

import java.util.List;

/**
 * Both the Account and User Managers have the same set of rules for defining remove, insert, and update
 * Using the Protection Proxy pattern save us from duplicate codes
 * @param <Model>
 */
public class UserProxy<Model extends UserModel> implements Manager<Model> {

    private Manager<Model> manager;

    public UserProxy(Manager<Model> manager) {
        this.manager = manager;
    }

    @Override
    public Response remove(Model data) {
        //The user must be an admin.
        if(!CurrentUser.instance().get().getLogin().equals("admin"))
            return new Response(false, "You don't seem to be an admin");
        //The storage must be exist.
        if(manager.get(user -> user.getUserId() == data.getUserId()) == null)
            return new Response(false, "The account you try to remove dose not exist");
        //The storage should not be the same user
        if(CurrentUser.instance().get().getUserId() == data.getUserId())
            return new Response(false, "Umm, you can't delete yourself... obviously");

        return manager.remove(data);
    }

    @Override
    public Response insert(Model data) {
        //The user must be an admin.
        if(!CurrentUser.instance().get().getLogin().equals("admin"))
            return new Response(false, "You don't seem to be an admin");

        return manager.insert(data);
    }

    @Override
    public Response update(Model updated) {
        //The storage must be exist
        if(manager.get(user -> user.getUserId() == updated.getUserId()) == null)
            return new Response(false, "The account you try to remove dose not exist");

        return manager.update(updated);
    }

    @Override
    public Manager<Model> getAll(Comparator<Model> Comparator) {
        return manager.getAll(Comparator);
    }

    @Override
    public Model get(Comparator<Model> comparator) {
        return manager.get(comparator);
    }

    @Override
    public void print() {
        manager.print();
    }

    @Override
    public List<Model> getList() {
        return manager.getList();
    }
}
