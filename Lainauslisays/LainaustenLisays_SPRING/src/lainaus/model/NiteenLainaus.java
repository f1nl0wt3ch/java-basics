package lainaus.model;

import java.util.Date;

public interface NiteenLainaus {
	public abstract Nide getNide() ;
	public abstract void setNide(Nide nide) ;
	public abstract Date getPalautusPvm() ;
	public abstract void setPalautusPvm(Date palautusPvm) ;
	public abstract String toString();
}
