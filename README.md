# Texture Rotation Reverser Java
- for vanilla and sodium texture rotations.
- only works on 1.13+
- multithreaded
- no netherrack support

## Getting texture rotations

### Datapack downloads

to get texture rotations you can install these two recourse packs:\
[Manual texture rotations](https://cdn.discordapp.com/attachments/766084065795244092/825795329290534923/Manual_texture_rotations.zip) \
[Textures to numbers](https://cdn.discordapp.com/attachments/766084065795244092/825795334885998602/Textures_to_numbers.zip)

### Usage
Manual texture rotations reskins blocks with block states to blocks with texture rotations. \
When you change the blockstate via debugstick these blocks will then change their rotation. 

Here is a list of the rotating blocks and thier replacement: 

<pre>
Bedrock:        Beehive fill level
Stone:          Bee nest fill level
Path block:     Orange glazed terracotta orientation
Dirt:           Brown glazed terracotta orientation
Red Sand:       Red glazed terracotta orientation
Grass block:    Lime glazed terracotta orientation
Mycelium:       Purple glazed terracotta orientation
Sand:           Yellow glazed terracotta orientation
Concrete powder:White glazed terracotta orientation
Podzol:         Cyan glazed terracotta orientation
Lily pad:       Iron trapdoor orientation
</pre>
#### before the manual texture rotation resource pack:
![image couldnt load](https://cdn.discordapp.com/attachments/766084065795244092/825795612887744532/pack.png)
#### after the manual texture rotation resource pack:
![image couldnt load](https://cdn.discordapp.com/attachments/766084065795244092/825795892669186058/2021-03-28_19.06.16.png)
Just rotate the blocks in your recreation as they are in the footage of your "vicitm" \
Pay attention that you got the direction of your recreation right. This tool doesnt support rotating cause im lazy. \
An easy way to get the direction is looking at the texture of blocks that dont have texture rotations.

## Numbering texture rotations

Now you can overlay the textures to numbers resource pack. \
It converts your textures to numbers that the program can use (who could have guessed)
#### after the textures to numbers resource pack:
![image couldnt load](https://cdn.discordapp.com/attachments/766084065795244092/825795905457750107/2021-03-28_19.06.53.png)

## How to input data
In the TextureFinder class you can find an example on how the input data.
<pre>
formation.add(new RotationInfo(1, 0, 0, 1, true));
</pre>
The first 3 numbers are the relative coorinates to an origin block ingame that you have to pick.

This example shows rotation info about a block that is positioned 1 block in positive X direction from the origin. \
All blocks that you include need to have a relative postition to this origin block.

The fourth number is simply the rotation. Just plug in the number from the textures to numbers resource pack.

The boolean value should be set to false. \
Bedrock and stone have 2 possible side rotations. (acctually not rotations, the texture is flipped) \
If you only know the side rotation then you need to set this to true. \
All other blocks only rotate tops and bottoms.  (except netherrack, which I dont support)

## Search parameters
Configure them in the main class
- xMin / xMax: range of the scanned X coords
- zMin / zMax: range of the scanned Z coords
- yMin / yMax: range of the scanned Y coords
- threads: number of threads (between 4 and 16 for average pcs)

## Sodium texture rotations
go to the run() method in TextureFinder

comment the vanilla part \
uncomment the sodium part






