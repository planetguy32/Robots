package me.planetguy.robots.world.gen;

import me.planetguy.robots.R;
import me.planetguy.robots.misc.Side;
import me.planetguy.robots.robot.Robot;
import me.planetguy.robots.tile.TileUtil;
import me.planetguy.robots.world.World;
import android.content.Context;
import android.content.res.Resources;

public class WgenSimpleMaze extends WorldProvider{

	public WgenSimpleMaze() {
		super(R.drawable.lava);
	}

	@Override
	public String getName() {
		return "Simple maze";
	}

	@Override
	public String getDescription() {
		return "A very simple maze";
	}

	@Override
	public World generate(Context con){
		World w=new World(10,11);
		for(int x=0; x<10; x++){
			for(int y=0; y<11; y++){
				w.tiles[x][y]=TileUtil.tiles.get("ore");
			}
		}
		for(int col=1; col<11; col+=2){
			for(int row=1; row<9; row++){
				w.tiles[row][col]=TileUtil.tiles.get("ground");
			}
		}
		for(int i=2; i<10; i+=2){
			w.tiles[1+(int)(Math.random()*8)][i]=TileUtil.tiles.get("ground");
		}
		Robot theRobot=new Robot(w, Side.RED,con);
		w.robots.add(theRobot);
		theRobot.x=1;
		theRobot.y=1;
		w.tiles[8][9]=TileUtil.tiles.get("win");
		return w;
	}

}