package dataFactory;

import pojo.UsuarioPojo;

public class UsuarioDataFactory {
    public static UsuarioPojo logarUsuario(){
        UsuarioPojo usuario = new UsuarioPojo();
        usuario.setUsuarioLogin("reh");
        usuario.setUsuarioSenha("reh");

        return usuario;
    }
}
