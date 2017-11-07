package br.com.atividadevi.Beans;

import static br.com.atividadevi.Util.ExcepctionUtil.getExceptionCauseMessage;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.hibernate.QueryException;

import br.com.atividadevi.Dao.EleitorDao;
import br.com.atividadevi.Dao.VotoDao;
import br.com.atividadevi.Exception.Callback;
import br.com.atividadevi.Exception.ErroEmVotoException;
import br.com.atividadevi.Modelo.Candidato;
import br.com.atividadevi.Modelo.Eleitor;
import br.com.atividadevi.Modelo.Pessoa;
import br.com.atividadevi.Modelo.Voto;
import br.com.atividadevi.Service.CandidatoService;
import br.com.atividadevi.Service.VotoService;


@Named("votoBean")
@SessionScoped
public class VotoBean extends Beans{

	private static final long serialVersionUID = 1L;

	private Voto voto = new Voto();
	
	private Candidato candidato = new Candidato();

	private Pessoa pessoa = new Pessoa();
	
	private Eleitor	eleitor = new Eleitor();
	
	private List<Candidato> candidatos;
	
	private Integer votoId;
	
	private Integer candidatoid;

//	@Inject
//	private VotoDao votoDao;
//	
//	@Inject
//	private EleitorDao eleitorDao;
//	
//	@Inject
//	private UsuarioBean usuarioBean;
//	 
	@EJB
	private VotoService votoService;

	@EJB
	private CandidatoService candidatoService;
	
//	public String votar(){
//		try{
//			Pessoa votante = usuarioBean.getCurrentUser();
//			String cpf = votante.getCpf();
//			Integer eleitorid = eleitorDao.findEleitor(cpf);
//			Eleitor eleitor = eleitorDao.buscarPorId(eleitorid);
//			this.candidato.setCandidatoId(candidatoid);
//			this.eleitor.setEleitorId(eleitorid);
//			this.voto.setCandidatoid(candidato);
//			this.voto.setEleitorid(eleitor);
//			this.voto.setIdvoto(0);
//			this.votoDao.create(voto);
//			return "menu?faces-redirects=true";
//		}finally{
//			this.candidato = new Candidato();
//			this.eleitor = new Eleitor();
//		}
//	}
	
	public String votar(){
			votoService.gravar(voto, eleitor, candidato, candidatoid, new Callback<Pessoa>() {
	
				@Override
				public void onSuccess(Pessoa object) {
					addMensageInfo(String.format("Voto realizado com sucesso"));	
					
					}
	
				@Override
				public void onFailure(Exception e) {
					addMensageError(getExceptionCauseMessage (e));
				}
			});
			return "menu?faces-redirects=true";
	}
	
	public void buscaCandidato(AjaxBehaviorEvent e){
		if (candidatoid != 0){
			candidato = candidatoService.getCandidatoDao().buscarPorId(candidatoid);
		}else{
			candidato = new Candidato();
			candidato.setPessoa(new Pessoa());
			
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

//	public VotoDao getVotoDao() {
//		return votoDao;
//	}
//
//	public void setVotoDao(VotoDao votoDao) {
//		this.votoDao = votoDao;
//	}

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

//	public EleitorDao getEleitorDao() {
//		return eleitorDao;
//	}
//
//	public void setEleitorDao(EleitorDao eleitorDao) {
//		this.eleitorDao = eleitorDao;
//	}
}
