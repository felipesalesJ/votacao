package br.com.atividadevi.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.atividadevi.Beans.UsuarioBean;
import br.com.atividadevi.Dao.CandidatoDao;
import br.com.atividadevi.Dao.EleitorDao;
import br.com.atividadevi.Dao.PessoaDao;
import br.com.atividadevi.Dao.VotoDao;
import br.com.atividadevi.Exception.Callback;
import br.com.atividadevi.Modelo.Candidato;
import br.com.atividadevi.Modelo.Eleitor;
import br.com.atividadevi.Modelo.Pessoa;
import br.com.atividadevi.Modelo.Voto;

@Stateless
public class VotoService {
		
		private static final Logger logger = Logger.getGlobal();
		@EJB
		private VotoDao votoDao;
		
		@EJB
		private EleitorDao eleitorDao;
		
		@Inject
		private UsuarioBean usuarioBean;
		
		@EJB
		private PessoaValidaService pessoaValidaService;
		
		public void gravar(Voto voto, Eleitor eleitor, Candidato candidato, Integer candidatoid, Callback<Pessoa> callback){
			try{
				Pessoa votante = getUsuarioBean().getCurrentUser();
				String cpf = votante.getCpf();
				Integer eleitorid = getEleitorDao().findEleitor(cpf);
				eleitor = getEleitorDao().buscarPorId(eleitorid);
				candidato.setCandidatoId(candidatoid);
				eleitor.setEleitorId(eleitorid);
				voto.setCandidatoid(candidato);
				voto.setEleitorid(eleitor);
				voto.setIdvoto(0);
				this.getVotoDao().create(voto);
			}catch(Exception e){
				logger.log(Level.SEVERE, e.getMessage(), e);
				callback.onFailure(e);
			}finally{
				candidato = new Candidato();
				eleitor = new Eleitor();
			}
		}

		public EleitorDao getEleitorDao() {
			return eleitorDao;
		}

		public void setEleitorDao(EleitorDao eleitorDao) {
			this.eleitorDao = eleitorDao;
		}

		public UsuarioBean getUsuarioBean() {
			return usuarioBean;
		}

		public void setUsuarioBean(UsuarioBean usuarioBean) {
			this.usuarioBean = usuarioBean;
		}

		public PessoaValidaService getPessoaValidaService() {
			return pessoaValidaService;
		}

		public void setPessoaValidaService(PessoaValidaService pessoaValidaService) {
			this.pessoaValidaService = pessoaValidaService;
		}

		public VotoDao getVotoDao() {
			return votoDao;
		}

		public void setVotoDao(VotoDao votoDao) {
			this.votoDao = votoDao;
		}
}
