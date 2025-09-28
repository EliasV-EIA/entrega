import javax.swing.*;
HashMap<String,Usuario> usuarios = new HashMap<String,Usuario>();
void main() {
//    AdministradorContenido obj_admin1 = new AdministradorContenido("oasfof-w2-9wqb-9fqw","Juan","du90--h-","test","dec","activa",
//            false, false, false, true, true, false);
//    System.out.println(obj_admin1.getPermisosDeEdicion());
    Duena Cabra = new Duena("baaa","Cabrita Sakura", "o0qwocjw393aopw303r", "Presidente", "01/01/25","Activa","AAAAAAAAAAAAAAAAAA","01/01/25");
    usuarios.put("Cabrita Sakura",Cabra);
    electorBase();
}
void electorBase(){
    String inp;
    JOptionPane.showMessageDialog(null, "Bienvenido, eliga una accion");
    inp=JOptionPane.showInputDialog(null, "Escriba la opcion deseada: login , registrar, salir");
    switch (inp.toLowerCase()) {
        case "login": {
            login();
            electorBase();
            break;
        }
        case "registrar": {
            electorBase();
            break;
        }
        case "salir": {
            break;
        }
        default:{
            JOptionPane.showMessageDialog(null,"Eleccion imposible, intente de nuevo");
            electorBase();
            break;
        }
    }

}
void login(){
    String username;
    int retry;
    username=JOptionPane.showInputDialog(null, "Nombre");
    if (usuarios.containsKey(username))
    {
        if (JOptionPane.showInputDialog(null, "Contrasena")==usuarios.get(username).getPasswordHash()){

        }
    }
    else {
        retry = JOptionPane.showConfirmDialog(null, "Ese usuario no existe, quiere intentar de nuevo?");
        if (retry == JOptionPane.YES_OPTION){
            login();
        }

    }
}
void accionUsuario(){}