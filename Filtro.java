import java.io.File;
import java.io.FilenameFilter;

public class Filtro implements FilenameFilter {
    static String extension;
    public Filtro(String extension){
        this.extension = extension;
    }
    @Override
    public boolean accept(File dir, String name) {
        //return false;
        return name.endsWith(extension);
    }

}
