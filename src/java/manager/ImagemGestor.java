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
        for (int i = 0; i < imagem.getWidth(); i++) {
            for (int j = 0; j < imagem.getHeight(); j++) {
                int pixel = imagem.getRGB(i, j);
                if (getBinario(pixel) > limiar_tresh) {
                    pixel = this.getBranco();
                } else {
                    pixel = getPreto();
                }
                imagem.setRGB(i, j, pixel);
            }
        }
    }

    public void tons_de_cinza() {
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        ColorConvertOp op = new ColorConvertOp(cs, null);
        imagem = op.filter(imagem, null);

    }

    public void salvar() throws IOException {
        if (imagem != null) {
            ImageIO.write(imagem, "jpg", arquivo_original);
        }
    }

    private int getBranco() {
        //return Alpha+Red+Green+Blue
        return (255 << 24)
             | (255 << 16)
             | (255 << 8 )
             | (255      );
    }

    private int getPreto() {
        return (255 << 24);
    }

    private int getBinario(int color) {
        int blue = color & 255;
        int green = (color >> 8) & 255;
        int red = (color >> 16) & 255;
        return (blue + green + red) / 3;
    }

    public void converter_para_sepia() {

        for (int i = 0; i < imagem.getWidth(); i++) {
            for (int j = 0; j < imagem.getHeight(); j++) {
                imagem.setRGB(i, j, filtro_sepia(imagem.getRGB(i, j)));
                
            }
        }


    }
    public void brilho(int brilho){
        int br;
        for (int i = 0; i < imagem.getWidth(); i++)
            for (int j = 0; j < imagem.getHeight(); j++){
                br = imagem.getRGB(i, j); 
                br = brilho((br    )&255,brilho)     |
                     brilho((br>> 8)&255,brilho)<<  8|
                     brilho((br>>16)&255,brilho)<< 16|
                     255                        << 24;
                imagem.setRGB(i, j, br);
            }
        
    }
    public void contrast(float contraste){
        int cr;
        for (int i = 0; i < imagem.getWidth(); i++)
            for (int j = 0; j < imagem.getHeight(); j++){
                
                cr = imagem.getRGB(i, j); 
                cr = contrast((cr    )&255,contraste)     |
                     contrast((cr>> 8)&255,contraste)<<  8|
                     contrast((cr>>16)&255,contraste)<< 16|
                     255                             << 24;
                imagem.setRGB(i, j, cr);
            }
    }
    
    private int filtro_sepia(int color) {

        int blue = color & 255;
        int green = (color >> 8) & 255;
        int red = (color >> 16) & 255;
        
        blue = red = green = (blue + red + green) / 3;
        blue = contrast(blue, 0.75);
        red = contrast(red, 1.2);
        green = contrast(green, 1.03);

        return (255 << 24)
                | (red << 16)
                | (green << 8)
                | (blue);
    }

    private int contrast(int cor, double valor) {
        Double d = cor * valor;
        cor = d.intValue();
        if (cor > 255) {
            cor = 255;
        } else if (cor < 0) {
            cor = 0;
        }
        return cor;
    }

    private int brilho(int cor, int opt) {
        if (cor + opt > 255) {
            cor = 255;
        } else if (cor + opt < 0) {
            cor = 0;
        } else {
            cor += opt;
        }
        return cor;

    }
}