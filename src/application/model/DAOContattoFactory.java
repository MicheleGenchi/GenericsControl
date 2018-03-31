package application.model;

// factoring for many support of storage, example text file, db or other
// in according to Contatto entity
public class DAOContattoFactory implements DAOFactory<Contatto>{
	private String sql;
	
	@Override
	public DAO<Contatto> get(String type) {
		switch (type) {
		case "mysql" : return new ContattoFromMysql(sql);
		// use for supporting  other storage type
		}
		return null;
	}

	@Override
	public String getSql() {
		return sql;
	}

	@Override
	public void setSql(String sql) {
		this.sql = sql;
	}
}