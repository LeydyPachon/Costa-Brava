package pruebasUnitarias;

import junit.framework.TestCase;
import CostaBravaMUNDO.Hotel;
import CostaBravaMUNDO.Huesped;
import CostaBravaMUNDO.Habitacion;

public class TestBuscarHabitacion extends TestCase {
	
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
    
  //Busca la siguiente habitación premium libre
    public void testBuscarHabitacionPremiumLibre1( )
    {
        Habitacion s;

        //Configura los datos de prueba
        setupEscenario1( );

        //La siguiente habitación premium de con vista a las piscinas libre es la 12
        s = hotel.buscarHabitacionPremiumLibre( Habitacion.PISCINA );
        assertEquals( 12, s.darNumero( ) );

        //La siguiente habitación premium de jardín libre es la 9
        s = hotel.buscarHabitacionPremiumLibre( Habitacion.JARDIN );
        assertEquals( 9, s.darNumero( ) );

        //La siguiente habitación premium sin vista libre es la 10
        s = hotel.buscarHabitacionPremiumLibre( Habitacion.PISCINA );
        assertEquals( 12, s.darNumero( ) );
    }
    
    //Busca la siguiente habitación suite presidencial libre
    public void testBuscarHabitacionSuitePresidencialLibre1( )
    {
        Habitacion s;

        //Configura los datos de prueba
        setupEscenario1( );

        //La siguiente habitación suite presidencial con vista a las piscinas libre es la 2
        s = hotel.buscarhabitacionSuitePresidencialLibre( Habitacion.PISCINA );
        assertEquals( 2, s.darNumero( ) );

        //La siguiente habitación suite presidencial con vista al jardín libre es la 4
        s = hotel.buscarhabitacionSuitePresidencialLibre( Habitacion.JARDIN );
        assertEquals( 4, s.darNumero( ) );

    }

}
