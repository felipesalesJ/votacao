package br.com.atividadevi.Service;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.hibernate.QueryException;

import br.com.atividadevi.Beans.UsuarioBean;
import br.com.atividadevi.Dao.CandidatoDao;
import br.com.atividadevi.Dao.EleitorDao;
import br.com.atividadevi.Dao.PessoaDao;
import br.com.atividadevi.Dao.VotoDao;
import br.com.atividadevi.Exception.Callback;
import br.com.atividadevi.Exception.ErroEmVotoException;
import br.com.atividadevi.Modelo.Candidato;
import br.com.atividadevi.Modelo.Eleitor;
import br.com.atividadevi.Modelo.Pessoa;
import br.com.atividadevi.Modelo.Voto;
import br.com.atividadevi.Util.GeradorComprovante;

@Stateless
public class VotoService {
		
		private static final Logger logger = Logger.getGlobal();
		
		private Integer comprovanteid;
		
		@EJB
		private VotoDao votoDao;		
		
		@EJB
		private EleitorDao eleitorDao;
		
		@Inject
		private UsuarioBean usuarioBean;
		
		@EJB
		private VotoValidaService votoValidaService;
		
		@Inject
		private GeradorComprovante geradorComprovante;
		
		public String gravar(Voto voto, Eleitor eleitor, Candidato candidato, Integer candidatoid, Callback<Pessoa> callback){
			try{
				Pessoa pessoa = usuarioBean.getCurrentUser();
				String cpfEleitor = pessoa.getCpf();
				if(votoDao.findVotoEleitor(cpfEleitor)){
					throw new ErroEmVotoException("Você já votou");
				};
//				votoValidaService.votoJaExistente(votoDao, usuarioBean);
				Pessoa votante = getUsuarioBean().getCurrentUser();
				String cpf = votante.getCpf();
				Integer eleitorid = getEleitorDao().findEleitor(cpf);
				eleitor = getEleitorDao().buscarPorId(eleitorid);
				candidato.setCandidatoId(candidatoid);
				eleitor.setEleitorId(eleitorid);
				voto.setCandidatoid(candidato);
				voto.setEleitorid(eleitor);
				voto.setIdvoto(0);
				comprovanteid = geradorComprovante.geradorid();
				voto.setIdcomprovante(comprovanteid);
				this.getVotoDao().create(voto);
			}catch(Exception sqle){
				logger.log(Level.SEVERE, sqle.getMessage(), sqle);
				callback.onFailure(sqle);
				throw new ErroEmVotoException("Você já votou");
			}
			return "comprovante?faces-redirects=true";
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

		public VotoValidaService getVotoValidaService() {
			return votoValidaService;
		}

		public void setVotoValidaService(VotoValidaService votoValidaService) {
			this.votoValidaService = votoValidaService;
		}

		public VotoDao getVotoDao() {
			return votoDao;
		}

		public void setVotoDao(VotoDao votoDao) {
			this.votoDao = votoDao;
		}
}
