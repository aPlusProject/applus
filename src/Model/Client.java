package Model;

public class Client implements People{
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String addr;
	private int tel;
	
	
	


	public Client(int id, String nom, String prenom, String email, String addr, int tel) {
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.addr = addr;
		this.tel = tel;
	}
	
	public Client() {
		
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddr() {
		return addr;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}


	public int getTel() {
		return tel;
	}


	public void setTel(int tel) {
		this.tel = tel;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void simuler() {
		// TODO Auto-generated method stub
		
	}


	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}


	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getPrenom() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
