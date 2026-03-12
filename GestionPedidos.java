public class GestionPedidos {
    private PilaManual pilaPrincipal = new PilaManual();
    private PilaManual pilaSecundaria = new PilaManual();

    public void registrarPedido(Pizza p) {
        pilaPrincipal.push(p);
        // Al registrar algo nuevo, el historial de "rehacer" suele limpiarse
        pilaSecundaria = new PilaManual(); 
        System.out.println("Pedido registrado con éxito.");
    }

    public void undo() {
        if (!pilaPrincipal.isEmpty()) {
            Pizza deshecho = pilaPrincipal.pop();
            pilaSecundaria.push(deshecho);
            System.out.println("Deshecho: " + deshecho);
        } else {
            System.out.println("No hay pedidos para deshacer.");
        }
    }

    public void redo() {
        if (!pilaSecundaria.isEmpty()) {
            Pizza recuperado = pilaSecundaria.pop();
            pilaPrincipal.push(recuperado);
            System.out.println("Rehecho: " + recuperado);
        } else {
            System.out.println("No hay nada que rehacer.");
        }
    }

    public void mostrarActual() {
        Pizza actual = pilaPrincipal.peek();
        if (actual != null) {
            System.out.println("Pedido actual en preparación: " + actual);
        } else {
            System.out.println("No hay pedidos activos.");
        }
    }
}
