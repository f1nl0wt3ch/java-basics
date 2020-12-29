
public class Varastotieto {
	private String hylly;
	private int lokerikko;
	
	public Varastotieto()
	{
		hylly = "";
		lokerikko =0;
	}
    public Varastotieto(String hylly, int lokerikko)
    {
        this.hylly = hylly;
        this.lokerikko = lokerikko;
     }
    public String getHylly()
    {
    	
    	return this.hylly;
    }
    public int getLokerikko()
    {
    	return this.lokerikko;
    }
    public void setHylly(String hylly)
    {
    	this.hylly = hylly;
    }
    public void setLokerikko(int lokerikko)
    {
    	this.lokerikko = lokerikko;
    }
    public String toString()
    {
    	return "Hylly "+this.hylly+", lokerikko "+this.lokerikko;
    }
}
