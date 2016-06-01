package pruebasUnitarias;

import junit.framework.TestCase;
import CostaBravaMUNDO.Hotel;
import CostaBravaMUNDO.Huesped;
import CostaBravaMUNDO.Habitacion;

public class TestBuscarHuesped extends TestCase {
	
	//ATRIBUTOS

    //Hotel
    private Hotel hotel;
    
    //Huésped 1
    private Huesped h1;
    
    //Huésped 2
    private Huesped h2;
    
    // Huésped 3
    private Huesped h3;
    
    //Huésped 4
    private Huesped h4;
    
    //Nombre del Huésped 1
    private String nombre1;
    
    // Cédula del Huésped 1
    private int cedula1;
    
    // Nombre del Huésped 2
    private String nombre2;
    
    //Cédula del Huésped 2
    private int cedula2;
	
    //MÉTODO PARA CREAR ESCENARIOS
    
    private void setupEscenario1( )
    {
        //Crea el avión
        hotel = new Hotel( );

        //Prepara los nombres y cédulas
        nombre1 = "Camilo Pérez";
        cedula1 = 12345;
        nombre2 = "Fernando Santander";
        cedula2 = 23456;

        //Crea los huéspedes
       h1 = new Huesped( cedula1, nombre1 );
       h2 = new Huesped( cedula2, nombre2 );

        //Asigna el primer huésped en una habitación suite presidencial del jardín
        hotel.asignarHabitacion( Habitacion.CLASE_SUITEPRESIDENCIAL, Habitacion.JARDIN, h1 );

        //Asigna al segundo huésped en una habitacion premium con vista a la piscina
        hotel.asignarHabitacion( Habitacion.CLASE_PREMIUM, Habitacion.PISCINA, h2 );

    }

    //Prepara los datos de prueba para probar el hotel
    //Se crean dos huéspedes, uno de ellos se asigna a una habitación suite presidencial y el otro a una habitación premium.
    private void setupEscenario2( )
    {
        String nombre;
        int cedula;

        //Usa el escenario 1
        setupEscenario1( );

        //Crea los huéspedes
        nombre = "Clara Martínez";
        cedula = 34567;
       h3 = new Huesped( cedula, nombre );
        nombre = "Sonia Osorio";
        cedula = 56789;
       h4 = new Huesped( cedula, nombre );

    }
    
  //Verifica la búsqueda de un huésped económico que existe
    public void testBuscarHuesped1( )
    {
        Huesped h;
        Habitacion s;

        //Configura los datos de prueba
        setupEscenario1( );

        s = hotel.buscarHuespedPremium( h2 );
        if( s == null )
            fail( "El huésped debería existir" );
        else
        {
            h = s.darHuesped( );
            assertEquals( cedula2, h.darCedula( ) );
            assertEquals( nombre2, h.darNombre( ) );
        }
    }
    
  //Verifica la búsqueda de un huésped prtemium que no existe
    public void testBuscarHuesped2( )
    {
        Habitacion s;

        //Configura los datos de prueba
        setupEscenario1( );

        s = hotel.buscarHuespedPremium( h1 );
        if( s == null )
            assertTrue( true );
        else
        {
            fail( "El huésped NO debería existir" );
        }
    }
    
  //Verifica la búsqueda de un huésped ejecutivo que existe
    public void testBuscarHuesped3( )
    {
        Huesped h;
        Habitacion s;

        //Configura los datos de prueba
        setupEscenario1( );

        s = hotel.buscarHuespedSuitepresidencial( h1 );
        if( s == null )
            fail( "El huésped debería existir" );
        else
        {
            h = s.darHuesped( );
            assertEquals( cedula1, h.darCedula( ) );
            assertEquals( nombre1, h.darNombre( ) );
        }
    }
    
 // Verifica la búsqueda de un huésped suite presidencial que no existe
    public void testBuscarHuesped4( )
    {
        Habitacion s;

        //Configura los datos de prueba
        setupEscenario1( );

        s = hotel.buscarHuespedSuitepresidencial( h2 );
        if( s == null )
            assertTrue( true );
        else
        {
            fail( "El huésped NO debería existir" );
        }
    }

}
