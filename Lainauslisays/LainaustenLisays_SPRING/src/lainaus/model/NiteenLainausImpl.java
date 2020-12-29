package lainaus.model;

import java.util.Date;


public class NiteenLainausImpl implements NiteenLainaus{
	private Nide nide;
	private Date palautusPvm;
	
	public NiteenLainausImpl()
	{
		super();
	}
	public NiteenLainausImpl(Nide nide, Date palautuspvm)
	{
		this.nide = nide;
		this.setPalautusPvm (palautuspvm);
	}
	public Nide getNide() {
		return nide;
	}
	public void setNide(Nide nide) {
		this.nide = nide;
	}
	public Date getPalautusPvm() {
		Date apu = null;
		
		if (palautusPvm != null)
			apu = (Date)palautusPvm.clone();
		return apu;
	}
	public void setPalautusPvm(Date palautusPvm) {
		this.palautusPvm = null;
		if (palautusPvm != null)
			this.palautusPvm =(Date)palautusPvm.clone();
	}
	public String toString()
	{
		return nide + " " + palautusPvm;
	}
	
}
