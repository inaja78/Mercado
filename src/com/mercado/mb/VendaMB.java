package com.mercado.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.mercado.dao.AbstractDAO;
import com.mercado.dao.VendaDAO;
import com.mercado.modelo.ItemVenda;
import com.mercado.modelo.Venda;

@ManagedBean(name="vendaBean")
@SessionScoped
public class VendaMB {
	
	private Venda venda;
	private ItemVenda itemVenda;
	private AbstractDAO<Venda> vendaDAO;
	private List<Venda> vendas;
	private List<ItemVenda> itensVenda;
	private float total;

	
	public ItemVenda getItemVenda() {
		return itemVenda;
	}

	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}

	//private Doubel totalVenda;
	private String erro;
	
	public VendaMB(){
		itemVenda = new ItemVenda();
		venda = new Venda();
		vendaDAO = new VendaDAO();
		setVendas(new ArrayList<Venda>());
		itensVenda = new ArrayList<ItemVenda>();
	}
	
	public String Salvar(){
		try{
			vendaDAO.adicionar(venda);
			this.venda = new Venda();
		} catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}		
		return "sucesso"; //string que leva para pagina de cadastro realizado
	}
	
	public String Excluir(Venda ven){
		try{
			vendas.remove(ven);
			this.venda = new Venda();
		}catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}
		return "sucesso";//string que leva para pagina de exclusao realizado
	}
	
	public String Pesquisar(){
		try{
			this.vendas = vendaDAO.getLista(venda);
		}catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}		
		return "pesquisar"; //string que leva para pagina de pesquisa
	}
	
	public String Index(){
		
		return "index";
	}	
	
	public String Editar(){
		
		return "alterar";
	}
	
	public String IniciaVenda(){
		
		return "iniciaVenda";//string que leva para pagina de exclusao realizado
	}
	
	public void adicionarItens(){
		venda.setValorTotal(venda.getItemVenda().getValor()*venda.getItemVenda().getQtd_venda());
		itensVenda.add(venda.getItemVenda());
	}
	
	public String TotalVenda(){
				
		
		/*venda.setTotal= quantidade * produto.getValorUnitario();*/  
      	
		return "sucesso";//string que leva para pagina de exclusao realizado
	}
	
	public Venda getVenda(){
		
		return venda;
	}
	
	public void setVenda(Venda venda){
		
		this.venda = venda;
	}
		
	public List<Venda> getVendas(){
		vendas = vendaDAO.getLista(venda);
		return vendas;
	}
	
	
	public void setVendas(List<Venda> vendas){
		this.vendas = vendas;
	}
	
	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	public List<ItemVenda> getItensVenda(){
		return itensVenda;
	}

}
