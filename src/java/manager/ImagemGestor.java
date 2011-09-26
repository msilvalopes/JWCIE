package manager;

//import java.awt.*;
//import java.awt.color.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

public class ImagemGestor {

    private File arquivo_original;
    private BufferedImage imagem;

    public ImagemGestor(File arquivo) throws IOException {
        arquivo_original = arquivo;
        if (null != arquivo_original && arquivo_original.exists()) {
            imagem = ImageIO.read(arquivo_original);
        } else {
            imagem = null;
        }
    }

    public boolean valida() {
        return null != imagem;
    }
    public void binarizar(int limiar_tresh) {
        for(int i =0; i < imagem.getWidth();i++)
            for(int j =0; j < imagem.getHeight();j++){
                int pixel = imagem.getRGB(i,j);
                if(getBinario(pixel) > limiar_tresh)
                    pixel = this.getBranco();
                else
                    pixel = getPreto();
                imagem.setRGB(i, j,pixel);
            }
    }
    
    public void tons_de_cinza() {
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp op = new ColorConvertOp(cs, null);
        imagem = op.filter(imagem, null);

    }
    

    public void salvar() throws IOException {
        if(imagem!= null){
            ImageIO.write(imagem, "jpg", arquivo_original);
        }
    }

    private int getBranco() {
        //return Alpha+Red+Green+Blue
        return (255/*Blue*/ + 255*256/*Green*/+ 255*256*256/*Red*/+ 255*256*256*256/*Alpha*/+ 255*256*256*256);
    }

    private int getPreto() {
        //return Alpha+Red+Green+Blue
        return (0/*Blue*/ + 0*256/*Green*/+ 0*256*256/*Red*/+ 0*256*256*256/*Alpha*/+ 255*256*256*256);
    }

    private int getBinario(int pixel) {
        if(pixel<0)
            pixel = -pixel;
        int r = 0;
        for(int i=0;i<3;i++){
            r    += pixel % 256;
            pixel = pixel / 256;
        }
        if(r < 0)
            r = -r;
           
        return r / 3;
    }

    public void converter_para_sepia() {
        int c;
        for(int i =0; i < imagem.getWidth();i++)
            for(int j =0; j < imagem.getHeight();j++){
                c = imagem.getRGB(i,j);
                c = (getBinario(c));
                c = (((255*256+c)*256+c)*256+c);
                imagem.setRGB(i, j, c);
            }
                
            
    }

    private int filtro_sepia(int color) {
        int cor = color % 256;
        
        int res = 255;
        if(cor<60){
            Double f = (cor * 0.6);
            cor = f.intValue();
            if(cor<0)
                cor=0;
            res = (((res*256+cor)*256+cor)*256+cor);
        }else if(cor < 190){
            if(cor<0)
                cor=0;
            
            Double f = (cor * 0.7);
            
            res = (((res*256+cor)*256+cor)*256+f.intValue());
        }else{
            Double f = (cor * 1.1);
            Double f2 = (cor * 0.7);
            cor = f.intValue();
            if(cor > 255)
                cor = 255;
            else if(cor<0)
                cor=0;
            
            res = (((res*256+cor)*256+cor)*256+ 0);
            cor = f2.intValue();
            if(cor > 255)
                cor = 255;
            else if(cor<0)
                cor=0;
            res += cor;
        }
        return res;
    }
}