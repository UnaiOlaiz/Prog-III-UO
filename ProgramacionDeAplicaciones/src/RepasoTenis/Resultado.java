package RepasoTenis;

public class Resultado {
	
	@Override
	public String toString() {
		return "Resultado [torneo=" + torneo + ", año=" + año + ", ganador=" + ganador + ", subcampeon=" + subcampeon
				+ ", ranking_Ganador=" + ranking_Ganador + ", ranking_Subcampeon=" + ranking_Subcampeon
				+ ", resultado_Final=" + resultado_Final + "]";
	}
	public Resultado(Torneo torneo, int año, String ganador, String subcampeon, String ranking_Ganador,
			String ranking_Subcampeon, String resultado_Final) {
		super();
		this.torneo = torneo;
		this.año = año;
		this.ganador = ganador;
		this.subcampeon = subcampeon;
		this.ranking_Ganador = ranking_Ganador;
		this.ranking_Subcampeon = ranking_Subcampeon;
		this.resultado_Final = resultado_Final;
	}
	public Torneo getTorneo() {
		return torneo;
	}
	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public String getGanador() {
		return ganador;
	}
	public void setGanador(String ganador) {
		this.ganador = ganador;
	}
	public String getSubcampeon() {
		return subcampeon;
	}
	public void setSubcampeon(String subcampeon) {
		this.subcampeon = subcampeon;
	}
	public String getRanking_Ganador() {
		return ranking_Ganador;
	}
	public void setRanking_Ganador(String ranking_Ganador) {
		this.ranking_Ganador = ranking_Ganador;
	}
	public String getRanking_Subcampeon() {
		return ranking_Subcampeon;
	}
	public void setRanking_Subcampeon(String ranking_Subcampeon) {
		this.ranking_Subcampeon = ranking_Subcampeon;
	}
	public String getResultado_Final() {
		return resultado_Final;
	}
	public void setResultado_Final(String resultado_Final) {
		this.resultado_Final = resultado_Final;
	}
	protected Torneo torneo;
	protected int año;
	protected String ganador, subcampeon, ranking_Ganador, ranking_Subcampeon, resultado_Final;
	

}
