package application.model;

// supporting different table in db
// example show in table sql on table password or contatto;

public interface DAOFactory<T> {
	public DAO<T> get(String type);
	void setSql(String sql);
	String getSql();
}
