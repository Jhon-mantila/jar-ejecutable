

import java.awt.event.*;
import java.net.URL;
import java.awt.*;
import javax.swing.*;

public class Multiples_fuentes_eventos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Multiples_Eventos mimarco = new Multiples_Eventos();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
///prueba comentario
class Multiples_Eventos extends JFrame {
	
	public Multiples_Eventos() {
		
		setTitle("Multiples fuentes de eventos");
		
		setBounds(500,100,500,500);
		
		Lamina_Multiples_Envento lamina = new Lamina_Multiples_Envento();
				
		add(lamina);
		
		setVisible(true);
		
	}
}

class Lamina_Multiples_Envento extends JPanel  {
	
	public Lamina_Multiples_Envento() {
		
		URL ruta_boton = Lamina_Multiples_Envento.class.getResource("bolaAmarilla.png");
		
		URL ruta_boton_Azul = Lamina_Multiples_Envento.class.getResource("bolaAzul.png");
		
		URL ruta_boton_Rojo = Lamina_Multiples_Envento.class.getResource("bolaRoja.png");
		
		ImageIcon IconAmarillo = new ImageIcon(ruta_boton);
		
		AccionColor accionAmarillo = new AccionColor("Amarillo", IconAmarillo, Color.YELLOW);
		
		AccionColor accionAzul = new AccionColor("Azul", new ImageIcon(ruta_boton_Azul), Color.BLUE);
		
		AccionColor accionRojo = new AccionColor("Rojo", new ImageIcon(ruta_boton_Rojo), Color.RED);
		
		
		JButton btn_amarillo = new JButton(accionAmarillo);
		
		add(btn_amarillo);
		
		//add(new JButton(accionAmarillo));
		
		add(new JButton(accionAzul));
		
		add(new JButton(accionRojo));
		
		/*JButton btn_azul = new JButton("Azul");
		
		JButton btn_amarillo = new JButton("Amarillo");
		
		JButton btn_verde = new JButton("Verde");
		
		add(btn_azul);
		add(btn_amarillo);
		add(btn_verde);*/
		
		InputMap mapa_entrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		KeyStroke teclaAmarilla = KeyStroke.getKeyStroke("ctrl A");
		
		mapa_entrada.put(teclaAmarilla, "FONDO_AMARILLO");
		
		mapa_entrada.put(KeyStroke.getKeyStroke("ctrl B"), "FONDO_AZUL");
		
		//mapa_entrada.put(KeyStroke.getKeyStroke("ctrl O"), "FONDO_AZUL");
		
		mapa_entrada.put(KeyStroke.getKeyStroke("ctrl R"), "FONDO_ROJO");
		
		ActionMap mapaAccion = getActionMap();
		
		mapaAccion.put("FONDO_AMARILLO", accionAmarillo);
		
		mapaAccion.put("FONDO_AZUL", accionAzul);
		
		mapaAccion.put("FONDO_ROJO", accionRojo);
		
	}
	
	private class AccionColor extends AbstractAction{

		public AccionColor(String nombre_btn, Icon icono, Color color_btn) {
			
			putValue(Action.NAME, nombre_btn);
			
			putValue(Action.SMALL_ICON, icono);
			
			putValue(Action.SHORT_DESCRIPTION, "Poner la lamina de color: " + nombre_btn);
			
			putValue("COLOR_DE_FONDO", color_btn);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Color c = (Color) getValue("COLOR_DE_FONDO");
			
			setBackground(c);
			
			String descripcion = (String)getValue(Action.SHORT_DESCRIPTION);
			
			System.out.println("Nombre: " + getValue(Action.NAME) + " Descripción: " + descripcion);
		}
		
	}
	
}




