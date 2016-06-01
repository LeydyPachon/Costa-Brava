package pruebasUnitarias;

import junit.framework.TestCase;
import CostaBravaMUNDO.Hotel;
import CostaBravaMUNDO.Huesped;
import CostaBravaMUNDO.Habitacion;

public class TestContarHabitaciones extends TestCase {
	
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
    
  //Cuenta las habitaciones premium ocupadas
    public void testContarHabitacionesPremiumOcupadas1( )
    {

        //Configura los datos de prueba
        setupEscenario2( );

        //Inicialmente las habitaciones premium ocupadas son:  1
        assertEquals( 1, hotel.contarHabitacionesPremiumOcupadas( ) );

        //Asignando otros dos huéspedes
        hotel.asignarHabitacion( Habitacion.CLASE_PREMIUM, Habitacion.SINVISTA, h3 );
        hotel.asignarHabitacion( Habitacion.CLASE_PREMIUM, Habitacion.JARDIN, h4 );

        //Ahora el número de habitaciones ocupadas es 3
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

        //Asignando otros dos huéspedes
        s = hotel.asignarHabitacion( Habitacion.CLASE_SUITEPRESIDENCIAL, Habitacion.PISCINA, h3 );
        if( s == null )
            fail( "Debió asignar alguna habitación 1" );

        s = hotel.asignarHabitacion( Habitacion.CLASE_SUITEPRESIDENCIAL, Habitacion.JARDIN, h4 );
        if( s == null )
            fail( "Debió asignar alguna habitación 2" );

        //Ahora el número de habitaciones ocupadas es 3
        assertEquals( 3, hotel.contarHabitacionesSuitePresidencialOcupadas( ) );
    }
}
