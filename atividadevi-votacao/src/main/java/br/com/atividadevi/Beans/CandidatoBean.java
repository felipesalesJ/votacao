package br.com.atividadevi.Beans;

import java.util.List;
import java.util.logging.Handler;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import br.com.atividadevi.Exception.Callback;
import br.com.atividadevi.Modelo.Candidato;
import br.com.atividadevi.Modelo.Pessoa;
import br.com.atividadevi.Modelo.Voto;
import br.com.atividadevi.Service.CandidatoService;
import static br.com.atividadevi.Util.ExcepctionUtil.getExceptionCauseMessage;

@Named("candidatoBean")
@SessionScoped
public class CandidatoBean extends Beans{

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();

	private Candidato candidato = new Candidato();
	
	private Voto voto = new Voto();

	private Integer pessoaId;
	
	private Integer idCandidato;
	
	private List<Candidato> candidatos;
	
	@EJB
	private CandidatoService candidatoService;
	
	public void gravar(){
		candidatoService.gravar(pessoa, candidato, new Callback<Pessoa>() {
			
			@Override
			public void onSuccess(Pessoa object) {
				addMensageInfo(String.format("Candidato cadastrado com sucesso"));
			}
			@Override
			public void onFailure(Exception e) {
				addMensageError(getExceptionCauseMessage(e));
			}
		});
	}
	
	public String buscarPorId(){
		candidato = candidatoService.listarPorId(candidato, candidato.getCandidatoId());
		return candidato.getCandidatoId().toString(); 
	}

	public void deletar(){
		candidatoService.deletar(voto, pessoa, candidato, idCandidato, new Callback<Pessoa>(){

			@Override
			public void onSuccess(Pessoa object) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onFailure(Exception e) {
				// TODO Auto-generated method stub
				
			}
			
//			return "login?faces-redirect=true";
		});
		
		

//		return "menu?faces-redirect=true";
	}
	
	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Integer getCandidatoId() {
		return idCandidato;
	}

	public void setCandidatoId(Integer idCandidato) {
		this.idCandidato = idCandidato;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public List<Candidato> getCandidatos() {
		this.candidatos = candidatoService.readTodos();
		return candidatos;
	}
}
