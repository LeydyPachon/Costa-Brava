package pruebasUnitarias;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAsignarDesasignar.class, TestBuscarHabitacion.class, TestBuscarHuesped.class,
		TestCalcularPorcentaje.class, TestContarHabitaciones.class })
public class SuiteTest {

}
