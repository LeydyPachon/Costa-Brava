package pruebasUnitarias;

import junit.framework.TestCase;
import CostaBravaMUNDO.Hotel;
import CostaBravaMUNDO.Huesped;
import CostaBravaMUNDO.Habitacion;

public class TestAsignarDesasignar extends TestCase {
	
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
        //Crea el hotel
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
    
  //Verifica que la asignación de una habitación suite presidencial haya sido correcta
    public void testAsignarHabitacion1( )
    {
        Habitacion habitacionH1;
        Huesped h;

        //Configura los datos de prueba
        setupEscenario1( );

        habitacionH1 = hotel.buscarHuesped( h1 );

        //El huésped 1 se hospeda en suite presidencial
        assertEquals( Habitacion.CLASE_SUITEPRESIDENCIAL, habitacionH1.darClase( ) );

        //El huésped 1 se hospeda con vista al jardín
        assertEquals( Habitacion.JARDIN, habitacionH1.darUbicacion( ) );

        //La primera habitación suite presidencial en jardín es la número 1
        assertEquals( 1, habitacionH1.darNumero( ) );

        //El huésped debe ser el mismo
        h = habitacionH1.darHuesped( );
        assertTrue( h1.igualA( h ) );

    }
    
  //Verifica que la asignación de una habitación premium haya sido correcta
    public void testAsignarHabitacion( )
    {
        Habitacion habitacionH2;
        Huesped h;

        //Configura los datos de prueba
        setupEscenario1( );

        habitacionH2 = hotel.buscarHuesped( h2 );

        //El huésped 2 reserva en premium
        assertEquals( Habitacion.CLASE_PREMIUM, habitacionH2.darClase( ) );

        //El huésped 2 reserva con vista  a la piscina
        assertEquals( Habitacion.PISCINA, habitacionH2.darUbicacion( ) );

        //La primera habitación premium en con vista a las piscinas es la número 11
        assertEquals( 11, habitacionH2.darNumero( ) );

        //El huésped debe ser el mismo
        h = habitacionH2.darHuesped( );
        assertTrue( h2.igualA( h ) );

    }
    
  //Verifica la desasignación de habitaciones
    public void testDesasignarHabitacion1( )
    {
        Habitacion s;

        //Configura los datos de prueba
        setupEscenario1( );

        hotel.desasignarHabitacion( h1 );

        //Ya el huésped no debe estar en el hotel
        s = hotel.buscarHuesped( h1 );

        if( s == null )
            assertTrue( true );
        else
            fail( "El huésped no debería estar" );
    }
}
