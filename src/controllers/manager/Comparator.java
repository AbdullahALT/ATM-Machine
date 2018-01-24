package controllers.manager;

/**
 * Helps define the way we look for items in a list
 * @param <Model>
 */
public interface Comparator<Model> {
    boolean compareTo(Model Model);
}
