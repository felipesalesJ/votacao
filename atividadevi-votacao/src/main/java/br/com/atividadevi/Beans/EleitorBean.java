package br.com.atividadevi.Beans;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.atividadevi.Service.EleitorService;
import br.com.atividadevi.Exception.Callback;
import br.com.atividadevi.Modelo.Eleitor;
import br.com.atividadevi.Modelo.Pessoa;
import br.com.atividadevi.Modelo.Telefone;
import br.com.atividadevi.Modelo.Endereco;
import static br.com.atividadevi.Util.ExcepctionUtil.getExceptionCauseMessage;

@Named("eleitorBean")
@SessionScoped
public class EleitorBean extends Beans{

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();
	
	private Eleitor eleitor = new Eleitor();
	
	private Telefone telefone = new Telefone();
	
	private Endereco endereco = new Endereco();
	
	private Integer pessoaId;
	
	private Integer eleitorId;
	
	private Integer telefoneId;
	
	private Integer enderecoId;
	
	@EJB
	private EleitorService eleitorSevice;
	
//	@Inject
//	private PessoaDao pessoaDao;
//	
//	@Inject
//	private EleitorDao eleitorDao;
//	
//	@Inject
//	private TelefoneDao telefoneDao;
//	
//	@Inject
//	private EnderecoDao enderecoDao;
	
//	public void gravar(){
//		try{
//			this.pessoa.setIdPessoa(0);
//			this.eleitor.setEleitorId(0);
//			this.eleitor.setPessoa(pessoa);
//			this.endereco.setEnderecoId(0);
//			this.telefone.setTelefoneId(0);
//			this.pessoaDao.create(pessoa);
//			this.eleitor.setEndereco(endereco);
//			this.eleitor.setTelefone(telefone);
//			this.telefoneDao.create(this.telefone);
//			this.enderecoDao.create(this.endereco);
//			this.eleitorDao.create(eleitor);
//		}finally{
//			this.pessoa = new Pessoa();
//			this.eleitor = new Eleitor();
//			this.endereco = new Endereco();
//			this.telefone = new Telefone();
//			this.eleitor.setEleitorId(0);
//			this.pessoa.setIdPessoa(0);
//			this.endereco.setEnderecoId(0);
//			this.telefone.setTelefoneId(0);
//		}
//	}

	public void gravar(){
		eleitorSevice.gravar(pessoa, eleitor, telefone, endereco, new Callback<Pessoa>() {
			
			@Override
			public void onSuccess(Pessoa object) {
				addMensageInfo(String.format("Eleitor cadastrado com sucesso"));
			}
			@Override
			public void onFailure(Exception e) {
				addMensageError(getExceptionCauseMessage(e));
			}
		});
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Eleitor getEleitor() {
		return eleitor;
	}

	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}

	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

	public Integer getEleitorId() {
		return eleitorId;
	}

	public void setEleitorId(Integer eleitorId) {
		this.eleitorId = eleitorId;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Integer getTelefoneId() {
		return telefoneId;
	}

	public void setTelefoneId(Integer telefoneId) {
		this.telefoneId = telefoneId;
	}

	public Integer getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}
	
}
