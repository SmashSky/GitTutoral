package web_group3;

public class Keyword {
	public String name;
	public int count;
	public String url;
	
	public Keyword(String name, int count ,String url) {
		this.name = name;
		this.count = count;
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "[" + name + "," + url + ","+ (-1*count) +"]";
	}

}