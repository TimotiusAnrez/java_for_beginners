
public class Food {
	// atribut/ data yang diminta
	String id;
	String name;
	String type;
	int price;
	
	// constructor -> inisialisasi data/ atribut
	// parameter -> berdasarkan atribut yang ada
	public Food(String id, String name, String type, int price) {
		// inisialisasi
		// this -> mengacu ke atribut kelas
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
	}

	// getters (ambil value dari atribut)
	// setters (update value atribut
	// alt shift s r (windows)
	// klik kanan -> source -> generate getters and setters (mac)

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
