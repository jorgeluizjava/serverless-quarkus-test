package br.com.jorge.quarkus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TesteJorge {

    private Logger LOG = Logger.getLogger(TesteJorge.class);

    private static List<Pessoa> pessoas;

    static {
        pessoas = new ArrayList<Pessoa>();
        pessoas.add(new Pessoa("Jorge Galvão", "jorgeluizjava@gmail.com"));
        pessoas.add(new Pessoa("Eliete Silva Galvão", "eli71@gmail.com"));
    }

    @GET
    @Path("/all")
    public String lista() throws JsonProcessingException {
        LOG.info("Listando pessoas.");

        List<PessoaDTO> collect = pessoas.stream().map(PessoaDTO::new).collect(toList());

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(collect);
    }


    @GET
    @Path("/one")
    public String lista1() throws JsonProcessingException {
        LOG.info("Listando uma pessoa.");

        List<PessoaDTO> collect = pessoas.stream().map(PessoaDTO::new).collect(toList());

        ObjectMapper mapper = new ObjectMapper();


        return mapper.writeValueAsString(collect.get(0));
    }


}
