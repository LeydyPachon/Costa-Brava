package CostaBravaGUI;
			
import java.awt.*;
import javax.swing.*;
import CostaBravaMUNDO.*;

//REPRESENTACIÓN GRAFICA DE UNA HABITACIÓN DEL HOTEL	

public class HabitacionGrafica extends JPanel
{
    //Atributos de Interfaz
	//Imagen de la habitación
    private ImageIcon imagen;

    //CONSTRUCTORES
    
    //Crea la representación gráfica de la habitación
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
    
    //MÉTODOS
    
    //Dibuja la imagen de la habitación
    public void paint( Graphics grafica )
    {
        grafica.drawImage( imagen.getImage( ), 5, 0, null, null );
        super.paint( grafica );
    }
}