package br.com.fiap.ws.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;


import br.com.fiap.ws.dao.BebidaDAO;
import br.com.fiap.ws.dao.impl.BebidaDAOImpl;
import br.com.fiap.ws.entity.Bebida;
import br.com.fiap.ws.exception.CommitException;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/bebida")
public class BebidaResource {

	private BebidaDAO bebidaDao;

	public BebidaResource() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		bebidaDao = new BebidaDAOImpl(em);
	}
	
	//Buscar 
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Bebida buscar(@PathParam("id") int codigo) {
		return bebidaDao.read(codigo);
	}

	//Listar Bebidas
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bebida> listar(){
		return bebidaDao.list();
	}

	//Registrar Bebida
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Bebida bebida, @Context UriInfo url) {
		try {
			bebidaDao.create(bebida);
			bebidaDao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		//cria a url para acessar o recurso criado
		UriBuilder b = url.getAbsolutePathBuilder();
		b.path(String.valueOf(bebida.getCodigo()));
		return Response.created(b.build()).build();
	}

	//Atualizar Bebida
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response atualizar(Bebida bebida, @PathParam("id") int codigo) {
		try {
			bebida.setCodigo(codigo);
			bebidaDao.update(bebida);
			bebidaDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
	}

	//Deletar
	@DELETE
	@Path("{id}")
	public void remover(@PathParam("id") int codigo) {
		try {
			bebidaDao.delete(codigo);
			bebidaDao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);	
		}
	}
}
