package br.com.atividadevi.Service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.atividadevi.Dao.EleitorDao;
import br.com.atividadevi.Dao.EnderecoDao;
import br.com.atividadevi.Dao.PessoaDao;
import br.com.atividadevi.Dao.TelefoneDao;
import br.com.atividadevi.Modelo.Eleitor;
import br.com.atividadevi.Modelo.Endereco;
import br.com.atividadevi.Modelo.Pessoa;
import br.com.atividadevi.Modelo.Telefone;

@Stateless
public class EleitorService {

	@EJB
	private PessoaDao pessoaDao;
	
	@EJB
	private EleitorDao eleitorDao;
	
	@EJB
	private TelefoneDao telefoneDao;
	
	@EJB
	private EnderecoDao enderecoDao;

	public void gravar(Pessoa pessoa, Eleitor eleitor, Telefone telefone, Endereco endereco, Integer pessoaid, Integer eleitori, Integer telefoneid, Integer enderecoid){
		try{
			pessoa.setIdPessoa(0);
			eleitor.setEleitorId(0);
			eleitor.setPessoa(pessoa);
			endereco.setEnderecoId(0);
			telefone.setTelefoneId(0);
			this.pessoaDao.create(pessoa);
			eleitor.setEndereco(endereco);
			eleitor.setTelefone(telefone);
			this.telefoneDao.create(telefone);
			this.getEnderecoDao().create(endereco);
			this.eleitorDao.create(eleitor);
		}finally{
			pessoa = new Pessoa();
			eleitor = new Eleitor();
			endereco = new Endereco();
			telefone = new Telefone();
			pessoa.setIdPessoa(0);
			eleitor.setEleitorId(0);
			telefone.setTelefoneId(0);
			endereco.setEnderecoId(0);
		}
	}
	
	public PessoaDao getPessoaDao() {
		return pessoaDao;
	}

	public void setPessoDao(PessoaDao pessoaDao) {
		this.pessoaDao = pessoaDao;
	}

	public EleitorDao getEleitorDao() {
		return eleitorDao;
	}

	public void setEleitorDao(EleitorDao eleitorDao) {
		this.eleitorDao = eleitorDao;
	}

	public TelefoneDao getTelefoneDao() {
		return telefoneDao;
	}

	public void setTelefoneDao(TelefoneDao telefoneDao) {
		this.telefoneDao = telefoneDao;
	}

	public EnderecoDao getEnderecoDao() {
		return enderecoDao;
	}

	public void setEnderecoDao(EnderecoDao enderecoDao) {
		this.enderecoDao = enderecoDao;
	}
}
