package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DisplayManager.createDisplay();

		Loader loader = new Loader();
		Renderer renderer = new Renderer();

		float[] vertices = { 
				-0.5f, 0.5f, 0f,	// V0
				-0.5f, -0.5f, 0f,	// V1
				0.5f, -0.5f, 0f,	// V2
				0.5f, 0.5f, 0f		// V3
		};
		
		int[] indices = {
			0, 1, 3,	// Top left triangle (V0, V1, V3)
			3, 1, 2		// Bottom right triangle (V3, V1, V2)
		};

		RawModel model = loader.loadToVao(vertices, indices);

		while (!Display.isCloseRequested()) {
			renderer.prepare();
			// game logic
			// render
			renderer.render(model);
			DisplayManager.updateDisplay();
		}

		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
