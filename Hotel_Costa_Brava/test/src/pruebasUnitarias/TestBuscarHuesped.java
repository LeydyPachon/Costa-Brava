package pruebasUnitarias;

import junit.framework.TestCase;
import CostaBravaMUNDO.Hotel;
import CostaBravaMUNDO.Huesped;
import CostaBravaMUNDO.Habitacion;

public class TestBuscarHuesped extends TestCase {
	
	//ATRIBUTOS

    //Hotel
    private Hotel hotel;
    
    //Hu�sped 1
    private Huesped h1;
    
    //Hu�sped 2
    private Huesped h2;
    
    // Hu�sped 3
    private Huesped h3;
    
    //Hu�sped 4
    private Huesped h4;
    
    //Nombre del Hu�sped 1
    private String nombre1;
    
    // C�dula del Hu�sped 1
    private int cedula1;
    
    // Nombre del Hu�sped 2
    private String nombre2;
    
    //C�dula del Hu�sped 2
    private int cedula2;
	
    //M�TODO PARA CREAR ESCENARIOS
    
    private void setupEscenario1( )
    {
        //Crea el avi�n
        hotel = new Hotel( );

        //Prepara los nombres y c�dulas
        nombre1 = "Camilo P�rez";
        cedula1 = 12345;
        nombre2 = "Fernando Santander";
        cedula2 = 23456;

        //Crea los hu�spedes
       h1 = new Huesped( cedula1, nombre1 );
       h2 = new Huesped( cedula2, nombre2 );

        //Asigna el primer hu�sped en una habitaci�n suite presidencial del jard�n
        hotel.asignarHabitacion( Habitacion.CLASE_SUITEPRESIDENCIAL, Habitacion.JARDIN, h1 );

        //Asigna al segundo hu�sped en una habitacion premium con vista a la piscina
        hotel.asignarHabitacion( Habitacion.CLASE_PREMIUM, Habitacion.PISCINA, h2 );

    }

    //Prepara los datos de prueba para probar el hotel
    //Se crean dos hu�spedes, uno de ellos se asigna a una habitaci�n suite presidencial y el otro a una habitaci�n premium.
    private void setupEscenario2( )
    {
        String nombre;
        int cedula;

        //Usa el escenario 1
        setupEscenario1( );

        //Crea los hu�spedes
        nombre = "Clara Mart�nez";
        cedula = 34567;
       h3 = new Huesped( cedula, nombre );
        nombre = "Sonia Osorio";
        cedula = 56789;
       h4 = new Huesped( cedula, nombre );

    }
    
  //Verifica la b�squeda de un hu�sped econ�mico que existe
    public void testBuscarHuesped1( )
    {
        Huesped h;
        Habitacion s;

        //Configura los datos de prueba
        setupEscenario1( );

        s = hotel.buscarHuespedPremium( h2 );
        if( s == null )
            fail( "El hu�sped deber�a existir" );
        else
        {
            h = s.darHuesped( );
            assertEquals( cedula2, h.darCedula( ) );
            assertEquals( nombre2, h.darNombre( ) );
        }
    }
    
  //Verifica la b�squeda de un hu�sped prtemium que no existe
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
            fail( "El hu�sped NO deber�a existir" );
        }
    }
    
  //Verifica la b�squeda de un hu�sped ejecutivo que existe
    public void testBuscarHuesped3( )
    {
        Huesped h;
        Habitacion s;

        //Configura los datos de prueba
        setupEscenario1( );

        s = hotel.buscarHuespedSuitepresidencial( h1 );
        if( s == null )
            fail( "El hu�sped deber�a existir" );
        else
        {
            h = s.darHuesped( );
            assertEquals( cedula1, h.darCedula( ) );
            assertEquals( nombre1, h.darNombre( ) );
        }
    }
    
 // Verifica la b�squeda de un hu�sped suite presidencial que no existe
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
            fail( "El hu�sped NO deber�a existir" );
        }
    }

}
