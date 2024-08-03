package com.algaworks.contatos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.algaworks.model.Contato;
import com.algaworks.repository.Contatos;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.WildcardTypePermission;

public class ContatosXML implements Contatos {

	private Map<String, String> contatosEmCache = new HashMap<>();
	
	@SuppressWarnings("unchecked")
    public ContatosXML(String... nomesArquivos) {
        XStream xstream = new XStream();
        
        xstream.addPermission(NoTypePermission.NONE);
        xstream.addPermission(new WildcardTypePermission(new String[] {"com.algaworks.model.Contato"}));
        xstream.addPermission(new WildcardTypePermission(new String[] {"java.util.*"}));

        xstream.alias("contatos", List.class);
        xstream.alias("contato", Contato.class);

        for (String nomeArquivo : nomesArquivos) {
            System.out.println("Carregando arquivo: " + nomeArquivo);
            List<Contato> contatosCarregados = (List<Contato>) xstream.fromXML(this.getClass().getResourceAsStream("/" + nomeArquivo));
            for (Contato contato : contatosCarregados) {
                contatosEmCache.put(contato.getEmail(), contato.getNome());
            }
        }
    }

    @Override
    public String buscarPor(String email) {
        return contatosEmCache.get(email);
    }
}