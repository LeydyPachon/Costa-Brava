package pruebasUnitarias;

import junit.framework.TestCase;
import CostaBravaMUNDO.Hotel;
import CostaBravaMUNDO.Huesped;
import CostaBravaMUNDO.Habitacion;

public class TestContarHabitaciones extends TestCase {
	
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
    
  //Cuenta las habitaciones premium ocupadas
    public void testContarHabitacionesPremiumOcupadas1( )
    {

        //Configura los datos de prueba
        setupEscenario2( );

        //Inicialmente las habitaciones premium ocupadas son:  1
        assertEquals( 1, hotel.contarHabitacionesPremiumOcupadas( ) );

        //Asignando otros dos hu�spedes
        hotel.asignarHabitacion( Habitacion.CLASE_PREMIUM, Habitacion.SINVISTA, h3 );
        hotel.asignarHabitacion( Habitacion.CLASE_PREMIUM, Habitacion.JARDIN, h4 );

        //Ahora el n�mero de habitaciones ocupadas es 3
        assertEquals( 3, hotel.contarHabitacionesPremiumOcupadas( ) );
    }
    
  //Cuenta las habitaciones suite presidencial ocupadas
    public void testContarHabitacionesSuitepresidencialOcupadas1( )
    {

        Habitacion s;

        //Configura los datos de prueba
        setupEscenario2( );

        //Inicialmente las habitaciones suite presidencial ocupadas son: 1
        assertEquals( 1, hotel.contarHabitacionesSuitePresidencialOcupadas( ) );

        //Asignando otros dos hu�spedes
        s = hotel.asignarHabitacion( Habitacion.CLASE_SUITEPRESIDENCIAL, Habitacion.PISCINA, h3 );
        if( s == null )
            fail( "Debi� asignar alguna habitaci�n 1" );

        s = hotel.asignarHabitacion( Habitacion.CLASE_SUITEPRESIDENCIAL, Habitacion.JARDIN, h4 );
        if( s == null )
            fail( "Debi� asignar alguna habitaci�n 2" );

        //Ahora el n�mero de habitaciones ocupadas es 3
        assertEquals( 3, hotel.contarHabitacionesSuitePresidencialOcupadas( ) );
    }
}
