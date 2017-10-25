package br.com.atividadevi.Beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import br.com.atividadevi.Modelo.Eleitor;
import br.com.atividadevi.Modelo.Voto;
import br.com.atividadevi.Modelo.Candidato;
import br.com.atividadevi.Modelo.Pessoa;
import br.com.atividadevi.Dao.EleitorDao;
import br.com.atividadevi.Dao.VotoDao;


@Named("votoBean")
@SessionScoped
public class VotoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Voto voto = new Voto();
	
	private Candidato candidato = new Candidato();

	private Pessoa pessoa = new Pessoa();
	
	private Eleitor	eleitor = new Eleitor();
	
	private List<Candidato> candidatos;
	
	private Integer votoId;
	
	private Integer candidatoid;

	@Inject
	private VotoDao votoDao;
	
	@Inject
	private EleitorDao eleitorDao;
	
	@Inject
	private UsuarioBean usuarioBean;

	public String votar(){
		try{
			Pessoa votante = usuarioBean.getCurrentUser();
			String cpf = votante.getCpf();
			Eleitor eleitor = eleitorDao.findVoto(cpf);
			Integer eleitorid = eleitor.getEleitorId();
			this.candidato.setCandidatoId(candidatoid);
			this.eleitor.setEleitorId(eleitorid);
			this.voto.setCandidatoid(candidato);
			this.voto.setEleitorid(eleitor);
			return "menu?faces-redirects=true";
		}finally{
			this.voto.setIdvoto(0);
			this.candidato = new Candidato();
			this.eleitor = new Eleitor();
		}
	}
	
	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getVotoId() {
		return votoId;
	}

	public void setVotoId(Integer votoId) {
		this.votoId = votoId;
	}

	public Integer getCandidatoid() {
		return candidatoid;
	}

	public void setCandidatoid(Integer candidatoid) {
		this.candidatoid = candidatoid;
	}

	public VotoDao getVotoDao() {
		return votoDao;
	}

	public void setVotoDao(VotoDao votoDao) {
		this.votoDao = votoDao;
	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public EleitorDao getEleitorDao() {
		return eleitorDao;
	}

	public void setEleitorDao(EleitorDao eleitorDao) {
		this.eleitorDao = eleitorDao;
	}
}
