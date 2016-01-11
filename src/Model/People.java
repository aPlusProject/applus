package Model;

import java.sql.SQLException;

public interface People {

	public abstract int getID();
	public abstract String getNom();
	public abstract String getPrenom();
	
	public abstract int simuler(int typePret, int montantPret, int dureePret) throws ClassNotFoundException, SQLException;
	
}
