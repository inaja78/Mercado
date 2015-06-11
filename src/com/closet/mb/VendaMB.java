package com.closet.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.closet.dao.AbstractDAO;
import com.closet.dao.VendaDAO;
import com.closet.modelo.ItemVenda;
import com.closet.modelo.Venda;


@ManagedBean(name="vendaBean")
@SessionScoped
public class VendaMB {
	
	private Venda venda;
	private ItemVenda itemVenda;
	private AbstractDAO<Venda> vendaDAO;
	private List<Venda> vendas;
	//private ArrayList<String> carrinho;
	private List<ItemVenda> itensVenda;
	private float total;
	
	public VendaMB(){
		itemVenda = new ItemVenda();
		venda = new Venda();
		vendaDAO = new VendaDAO();
		setVendas(new ArrayList<Venda>());
		itensVenda = new ArrayList<ItemVenda>();
	}
	
	public ItemVenda getItemVenda() {
		return itemVenda;
	}

	public void setItemVenda(ItemVenda itemVenda) {
		this.itemVenda = itemVenda;
	}

	//private Doubel totalVenda;
	private String erro;
	
	public String salvar(){
		try{
			vendaDAO.adicionar(venda);
			this.venda = new Venda();
		} catch (Exception ex) {
			System.out.println("Erro:" + ex);
			this.erro = ex.getMessage();
			return "erro";
		}		
		return "index"; //string que leva para pagina de cadastro realizado
	}
	
	public void adicionarItens(){
		venda.setValorTotal((venda.getItemVenda().getValor())*(venda.getItemVenda().getQtd_venda()));
		itensVenda.add(venda.getItemVenda());
	}
	
	/*public void adicionarItens(){
		System.out.println("Adicionou");
		this.itemVenda.setValor(itemVenda.getValor()*itemVenda.getProduto().getValor());
		this.itensVenda.add(itemVenda);
		this.total += itemVenda.getValor();
		this.itemVenda = new ItemVenda();
	}*/
	
	public String Excluir(ItemVenda item){
		System.out.println("Removendo...");
		itensVenda.remove(item);
		total -= itemVenda.getValor();
		return "sucesso";//string que leva para pagina de exclusao realizado
	}

    public String finalizarVenda() {
        VendaDAO venDAO = new VendaDAO();
        itemVenda.setVenda(venda);
        venDAO.adicionar(venda);
        venda = new Venda();
        return "venda";
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

	/*public ArrayList getCarrinhoCompras() {
		return carrinhoCompras;
	}

	public void setCarrinhoCompras(ArrayList carrinhoCompras) {
		this.carrinhoCompras = carrinhoCompras;
	}*/

}
