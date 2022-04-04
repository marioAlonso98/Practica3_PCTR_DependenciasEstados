package src.p03.c01;

public class SistemaLanzador {
	public static void main(String[] args) {
		
		final int aforo = 50;
		final int nPuertas = 2;
		
		IParque parque = new Parque();
		char letra_puerta = 'A';
		
		System.out.println("¡Parque abierto!");
		
		for (int i = 0; i < Integer.parseInt(args[0]); i++) {
			
			String puerta = ""+((char) (letra_puerta++));
			
			// Creación de hilos de entrada
			ActividadEntradaPuerta entradas = new ActividadEntradaPuerta(puerta, parque);
			new Thread (entradas).start();
			
			// Creación de hilos de Salida
			ActividadSalidaPuerta salidas = new ActividadSalidaPuerta(puerta, parque);
			new Thread (salidas).start();
			
			
		}
	}	
}
