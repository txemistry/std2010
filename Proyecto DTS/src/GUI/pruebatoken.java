package GUI;

public class pruebatoken {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name="Hola;;me;;aburro;;hehe;;kiki;;wewe";
		String[] nuevoname=name.split(";;");
		for (int x=0; x<nuevoname.length; x++)
		{
			System.out.println(nuevoname[x]);
		}
		
		// TODO Auto-generated method stub

	}

}
