import texture.TextureProvider;
import texture.VanillaTextures;
import texture.SodiumTextures;
import texture.Sodium19Textures;
import texture.Vanilla12Textures;
import texture.Vanilla21_1Textures;

public class Main {

    public static final int xMin = -8000, xMax = 8000;
    public static final int zMin = -8000, zMax = 8000;
    public static final int yMin = 10    , yMax = 60;
    public static final int threads = 12;
    public static final TextureProvider mode = new Vanilla21_1Textures();
    //                                         new SodiumTextures();
    //                                         new Sodium19Textures();
    //                                         new Vanilla12Textures();
    //                                         new VanillaTextures();

    //goto TextureFinder class to configure rotations
    public static void main(String[] args) {

        int xtotal = xMax - xMin;
        int perX = xtotal/threads;

        for (int start = xMin; start < xMax; start+= perX+1) {
            TextureFinder a = new TextureFinder(start,start+perX, mode);
            a.start();
        }

    }


}
