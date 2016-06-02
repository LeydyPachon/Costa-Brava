package pruebasUnitarias;

import junit.framework.TestCase;
import CostaBravaMUNDO.Hotel;
import CostaBravaMUNDO.Huesped;
import CostaBravaMUNDO.Habitacion;

public class TestAsignarDesasignar extends TestCase {
	
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
        //Crea el hotel
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
    
  //Verifica que la asignaci�n de una habitaci�n suite presidencial haya sido correcta
    public void testAsignarHabitacion1( )
    {
        Habitacion habitacionH1;
        Huesped h;

        //Configura los datos de prueba
        setupEscenario1( );

        habitacionH1 = hotel.buscarHuesped( h1 );

        //El hu�sped 1 se hospeda en suite presidencial
        assertEquals( Habitacion.CLASE_SUITEPRESIDENCIAL, habitacionH1.darClase( ) );

        //El hu�sped 1 se hospeda con vista al jard�n
        assertEquals( Habitacion.JARDIN, habitacionH1.darUbicacion( ) );

        //La primera habitaci�n suite presidencial en jard�n es la n�mero 1
        assertEquals( 1, habitacionH1.darNumero( ) );

        //El hu�sped debe ser el mismo
        h = habitacionH1.darHuesped( );
        assertTrue( h1.igualA( h ) );

    }
    
  //Verifica que la asignaci�n de una habitaci�n premium haya sido correcta
    public void testAsignarHabitacion( )
    {
        Habitacion habitacionH2;
        Huesped h;

        //Configura los datos de prueba
        setupEscenario1( );

        habitacionH2 = hotel.buscarHuesped( h2 );

        //El hu�sped 2 reserva en premium
        assertEquals( Habitacion.CLASE_PREMIUM, habitacionH2.darClase( ) );

        //El hu�sped 2 reserva con vista  a la piscina
        assertEquals( Habitacion.PISCINA, habitacionH2.darUbicacion( ) );

        //La primera habitaci�n premium en con vista a las piscinas es la n�mero 11
        assertEquals( 11, habitacionH2.darNumero( ) );

        //El hu�sped debe ser el mismo
        h = habitacionH2.darHuesped( );
        assertTrue( h2.igualA( h ) );

    }
    
  //Verifica la desasignaci�n de habitaciones
    public void testDesasignarHabitacion1( )
    {
        Habitacion s;

        //Configura los datos de prueba
        setupEscenario1( );

        hotel.desasignarHabitacion( h1 );

        //Ya el hu�sped no debe estar en el hotel
        s = hotel.buscarHuesped( h1 );

        if( s == null )
            assertTrue( true );
        else
            fail( "El hu�sped no deber�a estar" );
    }
}
