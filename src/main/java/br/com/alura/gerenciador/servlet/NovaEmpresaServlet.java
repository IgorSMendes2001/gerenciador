package br.com.alura.gerenciador.servlet;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost/*service*/(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova Empresa");
		String nomeEmpresa=request.getParameter("nome");
		Empresa empresa=new Empresa();
		empresa.setNome(nomeEmpresa);
		Banco banco=new Banco();
		banco.adiciona(empresa);
		
		//chamar o JPS
		RequestDispatcher rd=request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("empresa", empresa.getNome());
		rd.forward(request, response);
	}

}
