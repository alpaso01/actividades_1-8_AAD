import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Main extends Filtro {
    public Main(String extension) {
        super(extension);
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String directorio = "";
        int menu = 0;

        System.out.println("A que actividad deseas acceder?");
        int act = teclado.nextInt();
        teclado.nextLine();

        /* ACTIVIDAD 1 */
        if (act == 1) {
            System.out.println("introduce el nombre directorio que deseas");
            directorio = teclado.nextLine();
            System.out.println("Tu directorio es " + directorio);
        }

        /* ACTIVIDAD 2 */
        if (act == 2) {
            System.out.println("introduce el nombre directorio que deseas");
            directorio = teclado.nextLine();
            File ruta = new File(directorio);
            System.out.println("Tu directorio es " + ruta);

            System.out.println("--CARACTERISTICAS DE INTERES DEL DIRECTORIO--");
            System.out.println(ruta.getName());
            System.out.println(ruta.getPath());
            System.out.println(ruta.getAbsolutePath());
            System.out.println(ruta.exists());
            System.out.println(ruta.canWrite());
            System.out.println(ruta.canRead());
            System.out.println(ruta.isFile());
            System.out.println(ruta.isDirectory());
            System.out.println(ruta.isAbsolute());
            System.out.println(ruta.length());
            System.out.println(ruta.mkdir());
            System.out.println(ruta.delete());
            System.out.println(ruta.getParent());
        }

        /* ACTIVIDAD 3 */
        if (act == 3) {
            System.out.println("introduce el nombre directorio que deseas");
            directorio = teclado.nextLine();
            File ruta = new File(directorio);
            System.out.println("Tu directorio es " + ruta);

            System.out.println("--CARACTERISTICAS DE INTERES DEL DIRECTORIO--");
            System.out.println(ruta.getName());
            System.out.println(ruta.getPath());
            System.out.println(ruta.getAbsolutePath());
            System.out.println(ruta.exists());
            System.out.println(ruta.canWrite());
            System.out.println(ruta.canRead());
            System.out.println(ruta.isFile());
            System.out.println(ruta.isDirectory());
            System.out.println(ruta.isAbsolute());
            System.out.println(ruta.length());
            System.out.println(ruta.mkdir());
            System.out.println(ruta.delete());
            System.out.println(ruta.getParent());

            System.out.println("¿EXISTE EL DIRECTORIO?");
            System.out.println(ruta.exists());
        }

        /* ACTIVIDAD 4 */
        if (act == 4) {
            System.out.println("introduce el nombre directorio que deseas");
            directorio = teclado.nextLine();
            File ruta = new File(directorio);

            if (ruta.exists()) {
                System.out.println("TU DIRECTORIO ES CORRECTO. " + ruta);
            } else {
                System.out.println("NO SE ENCONTRÓ NINGUN DIRECTORIO CON ESE NOMBRE");
            }
        }

        /* ACTIVIDAD 5 */
        if (act == 5) {
            System.out.println("INTRODUCE UN DIRECTORIO");
            directorio = teclado.nextLine();
            File ruta = new File(directorio);

            if (!ruta.isDirectory()) {
                System.out.println("el directorio no existe");
                return;
            }

            File[] archivo = ruta.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(extension);
                }
            });

            if (archivo != null && archivo.length > 0) {
                for (File a : archivo) {
                    System.out.println(a.getName());
                }
            } else {
                System.out.println("No hay archivos con esa extension");
            }
        }

        /* ACTIVIDAD 6 */
        if (act == 6) {
            System.out.println("INTRODUCE UN DIRECTORIO");
            directorio = teclado.nextLine();
            File ruta = new File(directorio);

            if (ruta.exists()) {
                if (!ruta.isDirectory()) {
                    System.out.println("El directorio NO existe!");
                    return;
                }

                File[] archivo;
                if (extension.isEmpty()) {
                    archivo = ruta.listFiles();
                } else {
                    archivo = ruta.listFiles(new FilenameFilter() {
                        @Override
                        public boolean accept(File dir, String name) {
                            return name.endsWith(extension);
                        }
                    });
                }

                if (archivo != null && archivo.length > 0) {
                    for (File a : archivo) {
                        System.out.println(a.getName());
                    }
                } else {
                    System.out.println("No se encontraron ficheros");
                }
            } else {
                System.out.println("la ruta no existe");
            }
        }

        /* ACTIVIDAD 7 */
        if (act == 7) {
            System.out.println("INTRODUCE UN DIRECTORIO");
            directorio = teclado.nextLine();
            File ruta = new File(directorio);

            if (ruta.exists()) {
                if (!ruta.isDirectory()) {
                    System.out.println("el directorio no existe");
                    return;
                }
                System.out.println("Introduce extensiones separadas por espacios");
                String[] extensiones = teclado.nextLine().split(" ");
                File[] archivos = ruta.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        for (String extension : extensiones) {
                            if (name.endsWith(extension)) {
                                return true;
                            }
                        }
                        return false;
                    }
                });

                if (archivos != null && archivos.length > 0) {
                    for (File archivo : archivos) {
                        System.out.println(archivo.getName());
                    }
                } else {
                    System.out.println("NO SE ENCONTRARON FICHEROS");
                }
            } else {
                System.out.println("LA RUTA NO EXISTE");
            }
        }

        /* ACTIVIDAD 8 */
        if (act == 8) {
            System.out.println("INTRODUCE UN DIRECTORIO");
            directorio = teclado.nextLine();
            File ruta = new File(directorio);

            if (ruta.exists() && ruta.isDirectory()) {
                System.out.println("Introduce el nombre del archivo que quieres copiar");
                String nombreArchivo = teclado.nextLine();
                File archivoOriginal = new File(ruta, nombreArchivo);

                if (archivoOriginal.exists() && archivoOriginal.isFile()) {
                    try {
                        // para Crear una copia del archivo
                        String copia = "copia_" + archivoOriginal.getName();
                        File archivoCopia = new File(ruta, copia);
                        Files.copy(archivoOriginal.toPath(), archivoCopia.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("archivo copiado: " + archivoCopia.getName());

                        // para Borrar el archivo original
                        if (archivoOriginal.delete()) {
                            System.out.println("archivo original borrado: " + archivoOriginal.getName());
                        } else {
                            System.out.println("No se pudo borrar el archivo original");
                        }
                    } catch (IOException e) {
                        System.out.println("Error al copiar el archivo: " + e.getMessage());
                    }
                } else {
                    System.out.println("El archivo no existe o no es un archivo válido");
                }
                } else {
                    System.out.println("LA RUTA NO EXISTE O NO ES UN DIRECTORIO");
            }
        }

        teclado.close();
    }
}
