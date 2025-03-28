import texture.TextureProvider;

import java.util.ArrayList;
import java.util.List;


public class TextureFinder extends Thread {

    public static final ArrayList<RotationInfo> formation = new ArrayList<>();
    private static final List<RotationInfo> topsAndBottoms = new ArrayList<>();
    private static final List<RotationInfo> sides = new ArrayList<>();

    //search parameters are in the Main class

    static {
        //-1s
//        formation.add(new RotationInfo(2, 0, -1, 2, true));
//        formation.add(new RotationInfo(3, 0, -1, 0, true));
//        formation.add(new RotationInfo(5, 0, -1, 3, true));

        //0s
        formation.add(new RotationInfo(0, 0, 0, 1, true));
        formation.add(new RotationInfo(1, 0, 0, 3, true));
        formation.add(new RotationInfo(2, 0, 0, 3, true));
//        formation.add(new RotationInfo(3, 0, 0, 2, true));
//        formation.add(new RotationInfo(4, 0, 0, 3, true));
//        formation.add(new RotationInfo(5, 0, 0, 1, true));
//        formation.add(new RotationInfo(6, 0, 0, 2, true));
//        formation.add(new RotationInfo(7, 0, 0, 0, true));
//        formation.add(new RotationInfo(8, 0, 0, 1, true));

        //1s
        formation.add(new RotationInfo(0, 0, 1, 2, true));
        formation.add(new RotationInfo(1, 0, 1, 3, true));
        formation.add(new RotationInfo(2,0, 1, 3, true));
        formation.add(new RotationInfo(3, 0, 1, 3, true));
        formation.add(new RotationInfo(4, 0, 1, 0, true));
//        formation.add(new RotationInfo(5, 0, 1, 0, true));
//        formation.add(new RotationInfo(6, 0, 1, 1, true));
//        formation.add(new RotationInfo(7, 0, 1, 2, true));
//        formation.add(new RotationInfo(8, 0, 1, 0, true));
        //2s
        formation.add(new RotationInfo(0, 0, 2, 2, true));
        formation.add(new RotationInfo(1, 0, 2, 3, true));
        formation.add(new RotationInfo(2, 0, 2, 2, true));
        formation.add(new RotationInfo(3, 0, 2, 0, true));
        formation.add(new RotationInfo(4, 0, 2, 3, true));
        formation.add(new RotationInfo(5, 0, 2, 0, true));
        formation.add(new RotationInfo(6, 0, 2, 1, true));
//        formation.add(new RotationInfo(7, 0, 2, 0, true));
//        formation.add(new RotationInfo(8, 0, 2, 2, true));
        //3s
        formation.add(new RotationInfo(0, 0, 3, 0, true));
        formation.add(new RotationInfo(1, 0, 3, 2, true));
        formation.add(new RotationInfo(2, 0, 3, 3, true));
        formation.add(new RotationInfo(3, 0, 3, 1, true));
        formation.add(new RotationInfo(4, 0, 3, 1, true));
        formation.add(new RotationInfo(5, 0, 3, 0, true));
        formation.add(new RotationInfo(6, 0, 3, 0, true));
        //4s
        formation.add(new RotationInfo(0, 0, 4, 0, true));
        formation.add(new RotationInfo(1, 0, 4, 3, true));
        formation.add(new RotationInfo(2, 0, 4, 3, true));
        formation.add(new RotationInfo(3, 0, 4, 2, true));
        formation.add(new RotationInfo(4, 0, 4, 0, true));
        formation.add(new RotationInfo(5, 0, 4, 0, true));
        formation.add(new RotationInfo(6, 0, 4, 0, true));

        for (RotationInfo info : formation) {
            if(info.isSide) {
                sides.add(info);
            } else {
                topsAndBottoms.add(info);
            }
        }
    }

    private final int startX;
    private final int endX;
    private final TextureProvider textureProvider;

    TextureFinder(int startX, int endX, TextureProvider textureProvider) {
        this.startX = startX;
        this.endX = endX;
        this.textureProvider = textureProvider;
    }

    public void run() {
        long first=System.currentTimeMillis();

        for(int x = startX; x <= endX; x++) {
            for (int z = Main.zMin; z <= Main.zMax; z++) {
                nextAttempt:
                for (int y = Main.yMin; y <= Main.yMax; y++) {
                    for (RotationInfo b : topsAndBottoms) {
                        if(b.rotation != textureProvider.getTexture(x + b.x, y+b.y, z+b.z, 4)) {
                            continue nextAttempt;
                        }
                    }
                    for (RotationInfo b : sides) {
                        if(b.rotation != textureProvider.getTexture(x + b.x, y+b.y, z+b.z, 2)) {
                            continue nextAttempt;
                        }
                    }

                    System.out.println("/tp @p " + x + " " + y + " " + z);
                }
            }
        }
        System.out.println(((System.currentTimeMillis()-first)/1000) + " seconds");
    }
}
