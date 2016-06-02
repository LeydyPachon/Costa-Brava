package CostaBravaGUI;
			
import java.awt.*;
import javax.swing.*;
import CostaBravaMUNDO.*;

//REPRESENTACI�N GRAFICA DE UNA HABITACI�N DEL HOTEL	

public class HabitacionGrafica extends JPanel
{
    //Atributos de Interfaz
	//Imagen de la habitaci�n
    private ImageIcon imagen;

    //CONSTRUCTORES
    
    //Crea la representaci�n gr�fica de la habitaci�n
    public HabitacionGrafica( Habitacion habitacion )
    {
        super( new BorderLayout( ) );
        JLabel lHabitacion = new JLabel( );
        if( habitacion.darClase( ) == Habitacion.CLASE_SUITEPRESIDENCIAL && habitacion.habitacionAsignada( ) )
            imagen = new ImageIcon( "Imagenes/habitacion-suitpres-asig.gif" );
        else if( habitacion.darClase( ) == Habitacion.CLASE_SUITEPRESIDENCIAL && !habitacion.habitacionAsignada( ) )
            imagen = new ImageIcon( "Imagenes/habitacion-suitpres-libre.gif" );
        else if( habitacion.darClase( ) == Habitacion.CLASE_PREMIUM && habitacion.habitacionAsignada( ) )
            imagen = new ImageIcon( "Imagenes/habitacion-prem-asig.gif" );
        else if( habitacion.darClase( ) == Habitacion.CLASE_PREMIUM && !habitacion.habitacionAsignada( ) )
        {
            imagen = new ImageIcon( "Imagenes/habitacion-prem-libre.gif" );
            lHabitacion.setForeground( Color.black );
        }
        setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        setOpaque( false );
        lHabitacion.setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        lHabitacion.setText( "" + habitacion.darNumero( ) );
        lHabitacion.setHorizontalAlignment( SwingConstants.CENTER );
        add( lHabitacion );
    }
    
    //M�TODOS
    
    //Dibuja la imagen de la habitaci�n
    public void paint( Graphics grafica )
    {
        grafica.drawImage( imagen.getImage( ), 5, 0, null, null );
        super.paint( grafica );
    }
}