package Model;

public class Client implements People{
	private int ID_Client;
	private String Nom_Client;
	private String Prenom_Client;
	private String Email;
	private String Addr;
	private int Tel;
	
	
	public Client(int iD_Client, String nom_Client, String prenom_Client,
			String email, String addr, int tel) {
		super();
		ID_Client = iD_Client;
		Nom_Client = nom_Client;
		Prenom_Client = prenom_Client;
		Email = email;
		Addr = addr;
		Tel = tel;
	}


	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddr() {
		return Addr;
	}


	public void setAddr(String addr) {
		Addr = addr;
	}


	public int getTel() {
		return Tel;
	}


	public void setTel(int tel) {
		Tel = tel;
	}
	
	public int getID() {
		// TODO Auto-generated method stub
		return ID_Client;
	}


	public String getNom() {
		// TODO Auto-generated method stub
		return Nom_Client;
	}


	public String getPrenom() {
		// TODO Auto-generated method stub
		return Prenom_Client;
	}


	public void simuler() {
		// TODO Auto-generated method stub
		
	}
	
	
}
