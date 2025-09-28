import javax.swing.*;
HashMap<String,Usuario> usuarios = new HashMap<String,Usuario>();
void main() {
//    AdministradorContenido obj_admin1 = new AdministradorContenido("oasfof-w2-9wqb-9fqw","Juan","du90--h-","test","dec","activa",
//            false, false, false, true, true, false);
//    System.out.println(obj_admin1.getPermisosDeEdicion());
    Duena Cabra = new Duena("baaa","Cabrita Sakura", "Balls", "Presidente", "01/01/25","Activa","AAAAAAAAAAAAAAAAAA","01/01/25");
    usuarios.put("Cabrita Sakura",Cabra);
    electorBase();
}
void electorBase(){
    Object[] opciones= {"Login", "Registrar", "Salir"};
    int inp;
    JOptionPane.showMessageDialog(null, "Bienvenido, eliga una accion");
    inp= JOptionPane.showOptionDialog(null, "Seleccione su accion deseada", "Principal", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null, opciones, opciones[2]);
//    inp=JOptionPane.showInputDialog(null, "Escriba la opcion deseada: login , registrar, salir");

    switch (inp) {
        case 0: {
            login();
            electorBase();
            break;
        }
        case 1: {
            electorBase();
            break;
        }
        case 2: {
            break;
        }



    }

}
void login(){
    String username;
    String password;
    int retry;
    username=JOptionPane.showInputDialog(null, "Nombre");
    if (usuarios.containsKey(username))
    {
        System.out.println(usuarios.get(username).getPasswordHash());
        password=JOptionPane.showInputDialog(null, "Contrasena");

        if (password.compareTo(usuarios.get(username).getPasswordHash())==0){

            System.out.println("CORRECTo");
            accionUsuario(usuarios.get(username));
        }
        else
            JOptionPane.showMessageDialog(null, "Contrasena incorrecta");
    }
    else {
        retry = JOptionPane.showConfirmDialog(null, "Ese usuario no existe, quiere intentar de nuevo?");
        if (retry == JOptionPane.YES_OPTION){
            login();
        }

    }
}
void accionUsuario(Usuario u){
    if (u.getClass()==Duena.class);
    {
        System.out.println("THIS IS STUPID");
    }

}