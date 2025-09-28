public class Cliente extends Usuario{
    private String direccionEnvio;
    private String telefono;

    public Cliente(String id, String nombre, String passwordHash, String fechaRegistro, String estadoCuenta) {
        super(id, nombre, passwordHash, "Cliente", fechaRegistro, estadoCuenta);

    }
}
