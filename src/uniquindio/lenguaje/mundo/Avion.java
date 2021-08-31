package uniquindio.lenguaje.mundo;

public class Avion {

	private String destino;
	private Silla[][] sillasEje = new Silla[2][5];
	private Silla[][] sillasEco = new Silla[7][7];
	public Avion(String destino) {
		super();
		this.destino = destino;
		iniciarSillasEco();
		iniciarSillasEje();
	}
	
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Silla[][] getSillasEje() {
		return sillasEje;
	}
	public void setSillasEje(Silla[][] sillasEje) {
		this.sillasEje = sillasEje;
	}
	public Silla[][] getSillasEco() {
		return sillasEco;
	}
	public void setSillasEco(Silla[][] sillasEco) {
		this.sillasEco = sillasEco;
	}
	
	public void iniciarSillasEje() {
		int con=1;
		for(int i=0;i<sillasEje.length;i++)
		{
			for(int j=0;j<sillasEje[i].length;j++)
			{
				if(j!=2)
				{
					if(j==0 || j == sillasEje[0].length)
					{
						sillasEje[i][j] = new Silla(Clase.EJECUTIVA, Ubicacion.VENTANA, con+"");
						con++;
					}else {
						sillasEje[i][j] = new Silla(Clase.EJECUTIVA, Ubicacion.PASILLO, con+"");
						con++;
					}
					
				}
			}
		}
	}
	public int getSillasOcupadas() {
		int con=0;
		for(int i=0;i<sillasEco.length;i++)
		{
			for(int j=0;j<sillasEco[i].length;j++)
			{
				if(j!=3)
				{
					if(sillasEco[i][j].isOcupada())
					{
						con++;
					}
					
				}
			}
		
		}
		
		
		for(int i=0;i<sillasEje.length;i++)
		{
			for(int j=0;j<sillasEje[i].length;j++)
			{
				if(j!=2)
				{
					if(sillasEje[i][j].isOcupada())
					{
						con++;
					}
				}
			}
			
		}
		return con;
	}
	public void iniciarSillasEco() {
		int con=9;
		for(int i=0;i<sillasEco.length;i++)
		{
			for(int j=0;j<sillasEco[i].length;j++)
			{
				if(j!=3)
				{
					if(j==0 || j == sillasEco[0].length)
					{
						sillasEco[i][j] = new Silla(Clase.EJECUTIVA, Ubicacion.VENTANA, con+"");
						con++;
					}else if(j==1 || j==sillasEco[0].length-1)
					{
						sillasEco[i][j] = new Silla(Clase.EJECUTIVA, Ubicacion.CENTRO, con+"");
						con++;
					}else {
						sillasEco[i][j] = new Silla(Clase.EJECUTIVA, Ubicacion.PASILLO, con+"");
						con++;
					}
					
				}
			}
		}
	}
	
	
	
	
	
	
}
