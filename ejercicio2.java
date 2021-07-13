package ejerciciosunidad7;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.util.Iterator;

public class ejercicio2 {
	
	public static void main(String[] args) {
		
		ArrayList<Double> lista = nuevaarraylist();
		
		generar(lista);
		
		pagar(lista);
		
	}
		
	public static ArrayList<Double> nuevaarraylist() {
		
		ArrayList<Double> lista = new ArrayList<>();
		
		double precio;
		
			String preciobeta = JOptionPane.showInputDialog("Introduzca un precio nuevo");
			
			precio = Double.parseDouble(preciobeta);
			
			do {
				precio = Double.parseDouble(JOptionPane.showInputDialog("Introduzca un precio nuevo o 1234567890 para salir)"));
				
				if (precio != 1234567890) {
					
					lista.add(precio);
				}
		
			} while (precio != 1234567890);
			
			return lista;
			
		}
	
	public static void generar(ArrayList<Double> lista) {
		
		double precioconiva = precioconiva(lista);
		
		double preciobruto = preciobruto(lista);
		
		int cantidadarticulos = cantidaddearticulos(lista);
		
		JOptionPane.showMessageDialog(null, "!Aplicando IVA del 21%!(Presione OK para visualizar su precio)");
		
		JOptionPane.showMessageDialog(null, "Comprando " + cantidadarticulos +  " articulos , su precio sin IVA es de  " + preciobruto + "€, su precio con IVA es de " + precioconiva);
		
	}

	public static void pagar(ArrayList<Double> lista) {
		
		String dineropagadobeta = JOptionPane.showInputDialog("Tienes a pagar " + precioconiva(lista) + "€.");
		
		double dineropagado = Double.parseDouble(dineropagadobeta);
		
		double precioconiva = precioconiva(lista); 
		
		if (dineropagado < precioconiva) {
			
			JOptionPane.showMessageDialog(null, "No tienes suficiente dinero!");
			
			pagar(lista);
			
		} else if (dineropagado >= precioconiva) {
			
			JOptionPane.showMessageDialog(null, " el cambio es de " + (dineropagado - precioconiva) + "€");
		}
		
	}
	
	public static double preciobruto(ArrayList<Double> lista) {	
		
		Iterator<Double> it = lista.iterator();
		
		double precio = 0;
		
		while (it.hasNext()) {
			
			precio += it.next();
		}
		
		return precio;
		
	}
	
	public static double precioconiva(ArrayList<Double> lista) {
		
		double preciobruto = preciobruto(lista);
		
		double preciobrutoiva = preciobruto + (preciobruto * 0.21);
		
		return preciobrutoiva;
		
	}
	
	public static int cantidaddearticulos(ArrayList<Double>lista ) {
		
		return lista.size();
		
	}

}