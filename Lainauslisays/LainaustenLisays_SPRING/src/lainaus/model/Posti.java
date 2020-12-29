package lainaus.model;

public interface Posti {
	public abstract String getPostinro();
	
	public abstract String getPostitmp();
	
	public abstract void setPostinro(String nro);
	
	public abstract void setPostitmp(String tmp);
	
	public abstract String toString();
}
