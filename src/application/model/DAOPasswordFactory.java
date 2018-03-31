package application.model;

//factoring for many support of storage, example text file, db or other
//in according to Password entit
public class DAOPasswordFactory implements DAOFactory<Password>{
	private String sql;
	
	@Override
	public DAO<Password> get(String type) {
		switch (type) {
		case "mysql" : return new PasswordFromMysql(sql);
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
