package application.control;

public interface Filterable<E> {

	void undoFilter();

	void applyFilter(Filter<E> filtro);

}
