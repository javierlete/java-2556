import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.time.*;

public class Fechas {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Java 1.0
		Date ahora = new Date();
		System.out.println(ahora);
		
		Date principioCurso = new Date(2023 - 1900, 6 - 1, 13, 8, 15);
		System.out.println(principioCurso);
		
		int anyo = principioCurso.getYear() + 1900;
		int mes = principioCurso.getMonth() + 1;
		int dia = principioCurso.getDate();

		System.out.println(anyo + "-" + mes + "-" + dia);
		
		// Java 1.1
		GregorianCalendar gc = new GregorianCalendar(2023, 6, 13);
		
		anyo = gc.get(Calendar.YEAR);
		mes = gc.get(Calendar.MONTH);
		dia = gc.get(Calendar.DATE);
		
		System.out.println(gc);
		System.out.println(anyo + "-" + mes + "-" + dia);
		
		// Java 8
		LocalDate ld = LocalDate.of(2023, 6, 13);
		
		System.out.println(ld);
		System.out.println(ld.getYear() + "-" + ld.getMonthValue() + "-" + ld.getDayOfMonth());
	}
}
