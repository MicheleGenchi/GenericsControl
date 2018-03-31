package application.model;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// Separate logic program to storage Contatto in mysql DB
public class ContattoFromMysql implements DAO<Contatto> {
	private String sql;
	private List<Contatto> data = new ArrayList<>();
	private Set<String> dataFilter = new TreeSet<>();
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	
	private void closeConnection() {
		try {
			conn.close();
			st.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ContattoFromMysql(String sql) {
		this.sql = sql;
		rs=getResultSet();
	}

	private ResultSet getResultSet() {
		DBConnector.setDataBaseName("rubrica");
		conn = DBConnector.connectToDb();
		if (conn != null)
			try {
				st = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
				rs = st.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return rs;
	}

	@Override
	public boolean leggi() {
		boolean success = false;
		Contatto record = null;
		if (rs != null) {
			try {
				while (rs.next()) {
					ContattoBuilder bd = new ContattoBuilder();
					bd.setId(rs.getInt("id")).
					setNome(rs.getString("nome")).
					setCognome(rs.getString("cognome")).
					setRecapito(rs.getInt("recapito"));
					record = bd.build();
					data.add(record);
				}
				success = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}

		}
		return success;
	}

	@Override
	public void scrivi() {
		if (rs != null) {
			deleteAll();
			data.forEach(e -> scriviRecord(rs, e));
		}
		closeConnection();
	}

	private void scriviRecord(ResultSet rs, Contatto e) {
		try {
			rs.moveToInsertRow();
			for (Field field : e.getClass().getDeclaredFields()) {
				rs.updateObject(field.getName(), field.get(e));
			}
		} catch (SQLException | IllegalArgumentException | IllegalAccessException err) {
			err.printStackTrace();
		}
	}

	public String getSql() {
		return sql;
	}

	public ObservableList<Contatto> getData() {
		return FXCollections.observableArrayList(data);
	}

	public ObservableList<String> getDataFilter() {
		return FXCollections.observableArrayList(dataFilter);
	}
	
	public void setSql(String sql) {
		this.sql = sql;
	}

	@Override
	public void setData(List<Contatto> data) {
		this.data = data;
	}

	private void deleteAll() {
		try {
			while (rs.next()) {
				rs.deleteRow();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Class<Contatto> getEntity() {
		return Contatto.class;
	}

}
