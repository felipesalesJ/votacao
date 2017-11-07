package br.com.atividadevi.Service;

import javax.ejb.Stateless;

import br.com.atividadevi.Beans.UsuarioBean;
import br.com.atividadevi.Dao.VotoDao;
import br.com.atividadevi.Exception.ErroEmVotoException;
import br.com.atividadevi.Modelo.Pessoa;

@Stateless
public class VotoValidaService {

//	public void votoJaExistente(VotoDao votoDao, UsuarioBean usuarioBean){
//
//		if(votoDao.findVotoEleitor(cpfEleitor)){
//			throw new ErroEmVotoException("Você já votou");
//		}
//	}
}
