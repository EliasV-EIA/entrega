import javax.swing.*;
HashMap<String,Usuario> usuarios = new HashMap<String,Usuario>();
void main() {

    Duena Cabra = new Duena("baaa","Cabrita Sakura", "jhadfvasdeofjhojh", "Presidente", "01/01/25","Activa","AAAAAAAAAAAAAAAAAA","01/01/25");
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
            registar();
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
    if (u.getClass()==Duena.class){
        System.out.println("Menu cabra");

    }
    else if (u.getClass()==AdministradorContenido.class){
        System.out.println("(menu admincontenido");
    }
    else if (u.getClass()==AdministradorUsuario.class) {
        System.out.println("AdminUsuario");
    }
    else
        throw new RuntimeException("Tipo de usuario no encontrado");

}

void registar(){
    Object[] opciones = {"Cliente", "AdminUsuario", "AdminContenido"};
    int tipo;
    String id;
    String nombre;
    String pass;
    String fecha;
    String estado;
    String rol;
    tipo=JOptionPane.showOptionDialog(null, "Seleccione tipo de cuenta", "Registrar", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null, opciones, opciones[0]);
    nombre=JOptionPane.showInputDialog(null,"Nombre");
    id=JOptionPane.showInputDialog(null,"ID");
    pass=JOptionPane.showInputDialog(null,"Contrasena");
    fecha=JOptionPane.showInputDialog(null,"Fecha de registro(automatica en el futuro)");
    estado=JOptionPane.showInputDialog(null,"Estado");
    rol=JOptionPane.showInputDialog(null,"Rol");
    if (tipo==0){
        System.out.println("Creacion cliente");

    }
    else if (tipo==1){
        int nivel = Integer.parseInt(JOptionPane.showInputDialog(null, "Nivel de acceso"));
        usuarios.put(nombre, new AdministradorUsuario(id,nombre,pass,rol,fecha,estado,nivel));

    }
    else if (tipo==2) {
        usuarios.put(nombre, new AdministradorContenido(id,nombre,pass,rol,fecha,estado,
                Boolean.parseBoolean(Integer.toString(JOptionPane.showConfirmDialog(null, "Tiene este usuario permiso para editar nombres?","Permisos",JOptionPane.YES_NO_OPTION))),
                Boolean.parseBoolean(Integer.toString(JOptionPane.showConfirmDialog(null, "Tiene este usuario permiso para editar categorias?","Permisos",JOptionPane.YES_NO_OPTION))),
                Boolean.parseBoolean(Integer.toString(JOptionPane.showConfirmDialog(null, "Tiene este usuario permiso para editar descripciones?","Permisos",JOptionPane.YES_NO_OPTION))),
                Boolean.parseBoolean(Integer.toString(JOptionPane.showConfirmDialog(null, "Tiene este usuario permiso para editar precios?","Permisos",JOptionPane.YES_NO_OPTION))),
                Boolean.parseBoolean(Integer.toString(JOptionPane.showConfirmDialog(null, "Tiene este usuario permiso para editar stocks?","Permisos",JOptionPane.YES_NO_OPTION))),
                Boolean.parseBoolean(Integer.toString(JOptionPane.showConfirmDialog(null, "Tiene este usuario permiso para editar fechas de lanzamiento?","Permisos",JOptionPane.YES_NO_OPTION)))));

    }

}