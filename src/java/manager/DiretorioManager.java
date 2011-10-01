/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

//import ;
//import java.io.FilePermission;
//import com.sun.org.apache.xerces.internal.xs.StringList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import org.apache.commons.fileupload.FileItemStream;

/**
 *
 * @author Marcel
 */
public final class DiretorioManager extends File {

    public DiretorioManager(String pathname) {
        super("d:/imagens/".concat(pathname).concat("/"));
        System.gc();
    }

    public void preparar() {
        System.gc();
        this.mkdirs();
    }

    public void eliminar_diretorio() {
        System.gc();
        if (!this.canWrite()) {
            return;
        }
        File[] arquivos = this.listFiles();
        for (int i = 0; i < arquivos.length; i++) {
            System.gc();
            arquivos[i].delete();
            System.gc();
        }
        System.gc();
        this.delete();


    }
    public String add_file(FileInputStream item,String original) throws FileNotFoundException, IOException {
        System.gc();
        String nome = this.getNewName(original);
        
        File file = new File(this.getAbsoluteFile(), nome);
        FileOutputStream output = new FileOutputStream(file);
        
        byte[] buffer = new byte[2048];
        int nLidos;
        while ((nLidos = item.read(buffer)) >= 0) {
            output.write(buffer, 0, nLidos);
        }
        output.flush();
        output.close();
        
        return nome;
    }

    public String add_file(FileItemStream item) throws FileNotFoundException, IOException {
        System.gc();
        String nome = this.getNewName(item.getName());


        File file = new File(this.getAbsoluteFile(), nome);

        FileOutputStream output = new FileOutputStream(file);

        InputStream is = item.openStream();

        byte[] buffer = new byte[2048];
        int nLidos;
        while ((nLidos = is.read(buffer)) >= 0) {
            output.write(buffer, 0, nLidos);
        }
        output.flush();
        output.close();
        
        return nome;
    }

    private String getNewName(String oldname) {
        int i = oldname.length() - 1;
        Integer name = -1;
        boolean do_more = true;
        String file_name, extencao;
        File arquivo;
        while (i > 0 && oldname.charAt(i) != '.') {
            i--;
        }
        extencao = oldname.substring(i + 1).toLowerCase();
        while (do_more) {
            name += 1;
            file_name = name.toString().concat(".".concat(extencao));
            arquivo = new File(this.getAbsoluteFile(), file_name);
            do_more = arquivo.exists();
        }
        return name.toString().concat(".".concat(extencao));
    }

    public Vector getListagem() {
        Vector a = new Vector();
        File[] arquivos = this.listFiles();
        for (int i = 0; i < arquivos.length; i++) {
            a.add(arquivos[i].getName());
        }
        return a;
    }

    public FileInputStream getImagemFile(String nome) throws FileNotFoundException {
        //return new FileInputStream(new File(this.getGetDirNoFile(), "404.jpg"));
        File file = null;
        try{
            file = new File( this.getAbsoluteFile() , nome );
        }catch(Exception e){
            file = null;
        }
        if (file != null && file.exists()) {
            return new FileInputStream(file);
        } else {
            return new FileInputStream(new File(this.getGetDirNoFile(), "404.jpg"));
        }
        // */
    }

    public String getGetDirNoFile() {
        return "d:/imagens/";
    }

    public File getFile(String nome) {
        File file = null;
        try{
            file = new File( this.getAbsoluteFile() , nome );
        }catch(Exception e){
            file = null;
        }
        return file;
    }

    public boolean fileExists(String arquivo) {
        File file = null;
        try{
            file = new File( this.getAbsoluteFile() , arquivo );
        }catch(Exception e){
            file = null;
        }
        if(file!=null){
            return true;
        }
        return false;
    }

    public boolean deleteFile(String arquivo) {
        System.gc();
        return getFile(arquivo).delete();
    }
}

/*
public StringList retornar_arquivos(String extencao) {

StringList lista;
lista = new StringList();
if(null==extencao)
extencao="";

return lista;
}*/
