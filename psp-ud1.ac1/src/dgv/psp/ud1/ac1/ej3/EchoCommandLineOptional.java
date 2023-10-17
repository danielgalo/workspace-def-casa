package dgv.psp.ud1.ac1.ej3;

public class EchoCommandLineOptional {

	public static void main(String[] args) {
		
		 // Si se proporcionan menos de 3 parámetros, rellenamos con valores predeterminados
        if (args.length < 3) {
            String[] parametrosPredeterminados = {"Predeterminado1", "Predeterminado2"};
            
            // Copiamos los valores predeterminados en los primeros elementos del array args
            for (int i = 0; i < args.length; i++) {
                parametrosPredeterminados[i] = args[i];
            }
            
            // Asignamos el array con los valores rellenados de nuevo a args
            args = parametrosPredeterminados;
        }

        System.out.println("Los parámetros proporcionados son:");
        for (int i = 0; i < args.length; i++) {
            System.out.println("Parámetro " + (i + 1) + ": " + args[i]);
        }
		
	}

}
